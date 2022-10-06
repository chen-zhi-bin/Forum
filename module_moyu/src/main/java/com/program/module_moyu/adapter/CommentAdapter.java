 package com.program.module_moyu.adapter;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_common.Constants;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_moyu.R;
import com.program.module_moyu.model.bean.MomentCommentBean;
import com.program.module_moyu.model.bean.MomentSubCommentBean;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.TitleMultiBean;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommentAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private ForegroundColorSpan yourForegroundColorSpan =
            new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.getAppContext(), R.color.colorPrimary));

    private ForegroundColorSpan beForegroundColorSpan =
            new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.getAppContext(), R.color.colorPrimary));

    {
        addItemType(Constants.MultiItemType.TYPE_TITLE, R.layout.modulemoyu_common_adapter_title);
        addItemType(Constants.MultiItemType.TYPE_COMMENT, R.layout.modulemoyu_common_adapter_comment);
        addItemType(Constants.MultiItemType.TYPE_SUB_COMMENT, R.layout.modulemoyu_common_adapter_sub_comment);
        //最好在这设置能点击的id，在convert中设置可能会导致第一个item无法点击
        addChildClickViewIds(R.id.tv_comment_nickname, R.id.iv_comment_avatar,R.id.iv_comment_reply);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {

        switch (viewHolder.getItemViewType()) {
            case Constants.MultiItemType.TYPE_TITLE:
                    if (multiItemEntity instanceof TitleMultiBean){
                        String title = ((TitleMultiBean) multiItemEntity).getTitle();
                        viewHolder.setText(R.id.tv_title,title);
                    }
                break;
            case Constants.MultiItemType.TYPE_COMMENT:
                if (multiItemEntity instanceof MomentCommentBean.DataBean.ListBean){
                    MomentCommentBean.DataBean.ListBean comment = (MomentCommentBean.DataBean.ListBean) multiItemEntity;
                    viewHolder.setText(R.id.tv_comment_nickname,comment.getNickname());
                    viewHolder.setText(R.id.tv_publishTime,comment.getCreateTime());
                    viewHolder.setText(R.id.tv_comment,comment.getContent());
                    RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_comment_avatar);
                    Glide.with(ivAvatar.getContext())
                            .load(comment.getAvatar())
                            .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                            .circleCrop()       //圆角
                            .into(ivAvatar);
                }
//                addChildClickViewIds(R.id.tv_comment_nickname, R.id.iv_comment_avatar,R.id.iv_comment_reply);
                break;
            case Constants.MultiItemType.TYPE_SUB_COMMENT:
                if (multiItemEntity instanceof MomentSubCommentBean){
                    MomentSubCommentBean subComment = (MomentSubCommentBean) multiItemEntity;
                    String yourNickname = subComment.getNickname();
                    String beNickname = subComment.getTargetUserNickname();
                    String str = yourNickname + "回复 @" + beNickname + " " + subComment.getContent();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(str);
                    spannableStringBuilder.setSpan(
                            getClickSpanListener(subComment.getUserId()),
                            0,
                            yourNickname.length(),
                            Spanned.SPAN_INCLUSIVE_INCLUSIVE
                    );
                    spannableStringBuilder.setSpan(
                            yourForegroundColorSpan,0,yourNickname.length(),
                            Spanned.SPAN_INCLUSIVE_INCLUSIVE
                    );

                    int index2 = str.indexOf("@");
                    if (!TextUtils.isEmpty(subComment.getTargetUserId())) {
                        spannableStringBuilder.setSpan(
                                getClickSpanListener(subComment.getTargetUserId()),
                                index2,
                                index2+beNickname.length()+1,
                                Spanned.SPAN_INCLUSIVE_INCLUSIVE
                        );
                    }
                    TextView tvSubComment = viewHolder.getView(R.id.tv_sub_comment);
                    tvSubComment.setText(spannableStringBuilder);
                    tvSubComment.setMovementMethod(LinkMovementMethod.getInstance());
                }
                break;
        }
    }

    private HashMap<String, ClickableSpan> clickableSpans = new HashMap<String, ClickableSpan>();
    private ClickableSpan getClickSpanListener(String userId) {
        ClickableSpan clickableSpan = clickableSpans.get(userId);
        if (clickableSpan == null){
            clickableSpan = new  ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(userId);
                }
            };
            clickableSpans.put(userId,clickableSpan);
        }
        return clickableSpan;
    }
}
