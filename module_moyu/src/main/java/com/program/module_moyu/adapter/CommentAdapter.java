 package com.program.module_moyu.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
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
import java.util.List;

public class CommentAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private ForegroundColorSpan yourForegroundColorSpan =
            new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.getAppContext(), R.color.colorPrimary));

    private ForegroundColorSpan beForegroundColorSpan =
            new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.getAppContext(), R.color.colorPrimary));

    {
        addItemType(Constants.MultiItemType.TYPE_TITLE, R.layout.modulemoyu_common_adapter_title);
//        addItemType(Constants.MultiItemType.TYPE_COMMENT, R.layout.modulemoyu_common_adapter_comment_test);
        addItemType(Constants.MultiItemType.TYPE_COMMENT, R.layout.modulemoyu_common_adapter_comment);
//        addItemType(Constants.MultiItemType.TYPE_SUB_COMMENT, R.layout.modulemoyu_common_adapter_sub_comment);//子评论
        //最好在这设置能点击的id，在convert中设置可能会导致第一个item无法点击
//        addChildClickViewIds(R.id.tv_comment_nickname, R.id.iv_comment_avatar,R.id.iv_comment_reply);
        addChildClickViewIds(R.id.iv_fish_pond_avatar,R.id.cb_fish_pond_nick_name,R.id.iv_fish_pond_comment);
    }

    @SuppressLint("SetTextI18n")
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
//                    viewHolder.setText(R.id.tv_comment_nickname,comment.getNickname());
//                    viewHolder.setText(R.id.tv_publishTime,comment.getCreateTime());
//                    viewHolder.setText(R.id.tv_comment,comment.getContent());
//                    RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_comment_avatar);
//                    Glide.with(ivAvatar.getContext())
//                            .load(comment.getAvatar())
//                            .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
//                            .circleCrop()       //圆角
//                            .into(ivAvatar);

                    RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_fish_pond_avatar);
                    Glide.with(ivAvatar.getContext())
                            .load(comment.getAvatar())
                            .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)
                            .circleCrop()       //圆角
                            .into(ivAvatar);
                    viewHolder.setText(R.id.cb_fish_pond_nick_name,comment.getNickname());
                    String job ="";
                    if (comment.getPosition()==null){
                        job="游民";
                    }else {
                        job=comment.getPosition();
                    }
                    LinearLayout tvBuildReplyMsgContainer = viewHolder.getView(R.id.tv_build_reply_msg_container);
                    List<MomentSubCommentBean> subComments =comment.getSubComments();
                    int buildHeight = subComments.size();
                    if (subComments.isEmpty()){
                        tvBuildReplyMsgContainer.setVisibility(View.GONE);
                    }
                    viewHolder.setText(R.id.tv_fish_pond_desc,job+"  "+comment.getCreateTime());
                    viewHolder.setText(R.id.tv_reply_msg,comment.getContent());
                    TextView tvChildReplyMsg = viewHolder.getView(R.id.tv_child_reply_msg);
                    TextView tvChildReplyMsg1 = viewHolder.getView(R.id.tv_child_reply_msg1);
                    tvChildReplyMsg.setVisibility(View.GONE);
                    if (subComments.size()>=1&&subComments.get(0) != null) {
                        tvChildReplyMsg.setText(getBeautifiedFormat(subComments.get(0),comment));
                        tvChildReplyMsg.setVisibility(View.VISIBLE);
                        tvChildReplyMsg.setMovementMethod(LinkMovementMethod.getInstance());//使点击事件起作用
                    }
                    tvChildReplyMsg1.setVisibility(View.GONE);
                    if (subComments.size()>=2&&subComments.get(1) != null) {
                        tvChildReplyMsg1.setText(getBeautifiedFormat(subComments.get(1),comment));
                        tvChildReplyMsg1.setVisibility(View.VISIBLE);
                    }
                    // 如果是指示器，且该评论下盖楼的高度大于2则显示，否则隐藏
                    TextView tvChildReplyMsgAll = viewHolder.getView(R.id.tv_child_reply_msg_all);
                    tvChildReplyMsgAll.setText("查看全部"+buildHeight+"条回复");
                    tvChildReplyMsgAll.setVisibility(buildHeight>2?View.VISIBLE:View.GONE);
                }
//                addChildClickViewIds(R.id.tv_comment_nickname, R.id.iv_comment_avatar,R.id.iv_comment_reply);
                break;
            case Constants.MultiItemType.TYPE_SUB_COMMENT:
//                if (multiItemEntity instanceof MomentSubCommentBean){
//                    MomentSubCommentBean subComment = (MomentSubCommentBean) multiItemEntity;
//                    String yourNickname = subComment.getNickname();
//                    String beNickname = subComment.getTargetUserNickname();
//                    String str = yourNickname + "回复 @" + beNickname + " " + subComment.getContent();
//                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
//                    spannableStringBuilder.append(str);
//                    spannableStringBuilder.setSpan(
//                            getClickSpanListener(subComment.getUserId()),
//                            0,
//                            yourNickname.length(),
//                            Spanned.SPAN_INCLUSIVE_INCLUSIVE
//                    );
//                    spannableStringBuilder.setSpan(
//                            yourForegroundColorSpan,0,yourNickname.length(),
//                            Spanned.SPAN_INCLUSIVE_INCLUSIVE
//                    );
//
//                    int index2 = str.indexOf("@");
//                    if (!TextUtils.isEmpty(subComment.getTargetUserId())) {
//                        spannableStringBuilder.setSpan(
//                                getClickSpanListener(subComment.getTargetUserId()),
//                                index2,
//                                index2+beNickname.length()+1,
//                                Spanned.SPAN_INCLUSIVE_INCLUSIVE
//                        );
//                    }
//                    TextView tvSubComment = viewHolder.getView(R.id.tv_sub_comment);
//                    tvSubComment.setText(spannableStringBuilder);
//                    tvSubComment.setMovementMethod(LinkMovementMethod.getInstance());
//                }
                break;
        }
    }

     private Spanned getBeautifiedFormat(MomentSubCommentBean subComment, MomentCommentBean.DataBean.ListBean item) {
        //谁回复的
         String whoReplied = subComment.getNickname() + (subComment.getId().equals(item.getId())?"(作者)":"");
         //被回复的
         String wasReplied = subComment.getTargetUserNickname();
         String content = whoReplied + "回复" + wasReplied + "：" + subComment.getContent();
         int startIndex = whoReplied.length()+2;
         int color = Color.parseColor("#045FB2");
         SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
         spannableStringBuilder.append(content);
         spannableStringBuilder.setSpan(
//                 new ForegroundColorSpan(color),
                 getClickSpanListener(subComment.getUserId()),
                 content.indexOf(whoReplied),
                 content.indexOf("回复"),
                 Spanned.SPAN_INCLUSIVE_INCLUSIVE
         );
         spannableStringBuilder.setSpan(
                 new ForegroundColorSpan(color),
                 startIndex,
                 startIndex + wasReplied.length(),
                 Spanned.SPAN_INCLUSIVE_INCLUSIVE
         );
         return spannableStringBuilder;
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
