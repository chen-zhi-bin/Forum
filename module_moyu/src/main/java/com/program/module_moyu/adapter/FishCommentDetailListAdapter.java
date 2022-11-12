package com.program.module_moyu.adapter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.DateUtils;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_moyu.R;
import com.program.module_moyu.model.bean.MomentCommentBean;
import com.program.module_moyu.model.bean.MomentSubCommentBean;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * moyu评论列表适配器
 */
public class FishCommentDetailListAdapter extends BaseQuickAdapter<MomentSubCommentBean,BaseViewHolder>{


    public FishCommentDetailListAdapter() {
        super(R.layout.modulemoyu_common_adapter_comment);
    }

    {
        addChildClickViewIds(R.id.iv_fish_pond_comment,R.id.iv_fish_pond_avatar,R.id.ll_top_container);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MomentSubCommentBean subCommentBean) {
        if (subCommentBean != null) {
            View itemView = viewHolder.itemView;
            viewHolder.setText(R.id.cb_fish_pond_nick_name,subCommentBean.getNickname());
            String job=subCommentBean.getPosition() != null?(String) subCommentBean.getPosition():"游民";
            viewHolder.setText(R.id.tv_fish_pond_desc,job+" · "+ DateUtils.timeFormat(subCommentBean.getCreateTime()));
            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_fish_pond_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(subCommentBean.getAvatar())
                    .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)
                    .circleCrop()       //圆角
                    .into(ivAvatar);
            viewHolder.getView(R.id.tv_build_reply_msg_container).setVisibility(View.GONE);
            TextView tvReplyMsg = viewHolder.getView(R.id.tv_reply_msg);
            tvReplyMsg.setText(getBeautifiedFormat(subCommentBean));
            tvReplyMsg.setMovementMethod(LinkMovementMethod.getInstance());//使点击事件起作用
        }
    }

    private Spanned getBeautifiedFormat(MomentSubCommentBean subCommentBean) {
        String whoReplied = "";
        String wasReplied = subCommentBean.getTargetUserNickname();
        String content = whoReplied+"回复"+wasReplied+"："+subCommentBean.getContent();
        int color= Color.parseColor("#045FB2");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(content);
        spannableStringBuilder.setSpan(
                new ForegroundColorSpan(color),
                content.indexOf(whoReplied),
                content.indexOf("回复"),
                SpannableString.SPAN_INCLUSIVE_INCLUSIVE
        );
        spannableStringBuilder.setSpan(
                getClickSpanListener(subCommentBean.getTargetUserId()),
                content.indexOf(wasReplied),
                content.indexOf(wasReplied) + wasReplied.length(),
                SpannableString.SPAN_INCLUSIVE_INCLUSIVE
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
