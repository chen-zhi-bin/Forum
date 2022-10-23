package com.program.module_home.ui.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_common.Constants;
import com.program.lib_common.UIUtils;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_home.R;
import com.program.module_home.model.bean.ArticleRecommendBean;
import com.program.module_home.model.bean.CommentBean;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.SubCommentBean;
import com.program.moudle_base.model.TitleMultiBean;
import com.youth.banner.util.BannerUtils;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import kotlin.jvm.internal.markers.KMutableList;

public class HomeDetailAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private int w13dp = UIUtils.dp2px(13f);
    private int w50dp = UIUtils.dp2px(50f);

    private ForegroundColorSpan yourForegroundColorSpan =
            new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.getAppContext(), R.color.colorPrimary));
    private ForegroundColorSpan beForegroundColorSpan =
            new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.getAppContext(), R.color.colorPrimary));

    {
        addItemType(Constants.MultiItemType.TYPE_TITLE,R.layout.modulebase_common_adapter_title);
        addItemType(Constants.MultiItemType.TYPE_COMMENT,R.layout.modulebase_common_adapter_comment);
        addItemType(Constants.MultiItemType.TYPE_SUB_COMMENT,R.layout.modulebase_common_adapter_sub_comment);
        addItemType(Constants.MultiItemType.TYPE_RECOMMEND,R.layout.modulehome_home_detail_adapter_related);
        addChildClickViewIds(R.id.tv_comment_nickname,R.id.iv_comment_avatar,R.id.iv_comment_reply);
        addChildClickViewIds(R.id.tv_related_nickname, R.id.iv_related_avatar);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {
        switch (multiItemEntity.getItemType()) {
            case Constants.MultiItemType.TYPE_TITLE:
                TitleMultiBean title = (TitleMultiBean) multiItemEntity;
                viewHolder.setText(R.id.tv_title,title.getTitle());
                break;
            case Constants.MultiItemType.TYPE_COMMENT:
                CommentBean.DataBean.ContentBean comment = (CommentBean.DataBean.ContentBean) multiItemEntity;
                viewHolder.setText(R.id.tv_comment_nickname,comment.getNickname());
                viewHolder.setText(R.id.tv_publishTime,comment.getPublishTime());
                viewHolder.setText(R.id.tv_comment,comment.getCommentContent());
                RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_comment_avatar);
                Glide.with(ivAvatar.getContext())
                        .load(comment.getAvatar())
                        .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                        .circleCrop()       //圆角
                        .into(ivAvatar);
                break;
            case Constants.MultiItemType.TYPE_SUB_COMMENT:
                SubCommentBean subComment = (SubCommentBean) multiItemEntity;
                String yourNickname = subComment.getYourNickname() + "";
                String beNickname = subComment.getBeNickname() + "";
                String str = yourNickname+"回复 @"+beNickname+" "+subComment.getContent();

                SpannableStringBuilder spannableBuilder = new SpannableStringBuilder();
                spannableBuilder.append(str);

                spannableBuilder.setSpan(
                        getClickSpanListener(subComment.getYourUid()),
                        0,
                        yourNickname.length(),
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                );
                spannableBuilder.setSpan(
                        yourForegroundColorSpan,0,yourNickname.length(),
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                );
                int index2 = str.indexOf("@");
                spannableBuilder.setSpan(
                        getClickSpanListener(subComment.getBeUid()),
                        index2,
                        index2+beNickname.length()+1,
                        Spanned.SPAN_INCLUSIVE_INCLUSIVE
                );
                spannableBuilder.setSpan(
                        beForegroundColorSpan,index2,index2+beNickname.length()+1,
                        Spanned.SPAN_INCLUSIVE_INCLUSIVE
                );

                TextView tvSubComment = viewHolder.getView(R.id.tv_sub_comment);
                tvSubComment.setText(spannableBuilder);
                tvSubComment.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case Constants.MultiItemType.TYPE_RECOMMEND:
                ArticleRecommendBean.DataBean recommend = (ArticleRecommendBean.DataBean) multiItemEntity;
                RoundedImageView ivRecommendAvatar = viewHolder.getView(R.id.iv_related_avatar);
                Glide.with(ivRecommendAvatar.getContext())
                        .load(recommend.getAvatar())
                        .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                        .circleCrop()       //圆角
                        .into(ivRecommendAvatar);
                ImageView ivCover = viewHolder.getView(R.id.iv_cover);
                BannerUtils.setBannerRound(ivCover,Float.parseFloat(w13dp+""));
                if (!recommend.getCovers().isEmpty()) {
                    Glide.with(ivCover)
                            .load(recommend.getCovers().get(0))
                            .placeholder(R.drawable.shape_grey_background)
                            .override(w50dp,w50dp)
                            .thumbnail(0.3f)
                            .into(ivCover);
                }
                viewHolder.setText(R.id.tv_content,recommend.getTitle());
                viewHolder.setText(R.id.tv_related_nickname,recommend.getNickname());
                break;
        }
    }

    private HashMap<String , ClickableSpan> clickableSpans = new HashMap<>();
    private ClickableSpan getClickSpanListener(String id) {
        ClickableSpan clickableSpan = clickableSpans.get(id);
        if (clickableSpan != null) {
            clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(id);
                }
            };
            clickableSpans.put(id,clickableSpan);
        }
        return clickableSpan;
    }
}
