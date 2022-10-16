package com.program.module_wenda.adapter;

import android.view.View;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.DateUtils;
import com.program.lib_common.UIUtils;
import com.program.module_wenda.R;
import com.program.module_wenda.model.bean.AnswerBean;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaContentBean;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.TitleMultiBean;
import com.program.moudle_base.utils.CommonViewUtils;

import org.jetbrains.annotations.NotNull;

public class WendaDetailAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private int w26dp = UIUtils.dp2px(26f);

    {
        addItemType(Constants.MultiItemType.TYPE_TITLE, R.layout.modulewenda_common_adapter_title);
        addItemType(Constants.MultiItemType.TYPE_COMMENT, R.layout.modulewenda_wenda_detail_answer_adapter);
        addItemType(Constants.MultiItemType.TYPE_RECOMMEND, R.layout.modulewenda_wenda_detail_answer_adapter);
        addChildClickViewIds(R.id.tv_comment_nickname, R.id.iv_comment_avatar,R.id.tv_comment,R.id.tv_more);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {
        switch (viewHolder.getItemViewType()) {
            case Constants.MultiItemType.TYPE_TITLE:
                TitleMultiBean title = (TitleMultiBean) multiItemEntity;
                viewHolder.setText(R.id.tv_title, title.getTitle());
                break;
            case Constants.MultiItemType.TYPE_COMMENT:
                //回答item
                AnswerBean.DataBean comment = (AnswerBean.DataBean) multiItemEntity;
                //昵称
                viewHolder.setText(R.id.tv_comment_nickname, comment.getNickname());
                //发布时间
                viewHolder.setText(R.id.tv_publishTime, DateUtils.timeFormat(comment.getPublishTime()));
                // 回答内容（显示一部分）
                CommonViewUtils.setHtml(viewHolder.getView(R.id.tv_comment), comment.getContent());
                //隐藏浏览量
                View view = viewHolder.getView(R.id.tv_viewCount);
                view.setVisibility(View.GONE);
                //回答的点赞数
                viewHolder.setText(R.id.tv_thumb, comment.getThumbUp().toString());
                //回答的评论数
                viewHolder.setText(R.id.tv_reply, comment.getWendaSubComments().size() + "评论");
                RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_comment_avatar);
                Glide.with(ivAvatar.getContext())
                        .load(comment.getAvatar())
                        .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                        .circleCrop()
                        .into(ivAvatar);
                //是否是最近答案
                if (comment.getBestAs() == "1") {
                    viewHolder.getView(R.id.tv_solved).setVisibility(View.VISIBLE);
                } else {
                    viewHolder.getView(R.id.tv_solved).setVisibility(View.GONE);
                }
                break;
            case Constants.MultiItemType.TYPE_RECOMMEND:
                    //相关推荐item
//                WendaContentBean.DataBean wenda = (WendaContentBean.DataBean) multiItemEntity;
                WendaBean.DataBean wenda = (WendaBean.DataBean) multiItemEntity;
                //昵称
                viewHolder.setText(R.id.tv_comment_nickname,wenda.getNickname());
                //发布时间
                viewHolder.setText(R.id.tv_publishTime,DateUtils.timeFormat(wenda.getCreateTime()));
                //发布标题
                viewHolder.setText(R.id.tv_comment,wenda.getTitle());
                RoundedImageView ivAvatarView = viewHolder.getView(R.id.iv_comment_avatar);
                Glide.with(ivAvatarView.getContext())
                        .load(wenda.getAvatar())
                        .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                        .circleCrop()
                        .into(ivAvatarView);
                // 隐藏查看详情（和回答的item共有一个layout）
                viewHolder.getView(R.id.tv_more).setVisibility(View.GONE);
                //浏览量
                viewHolder.setText(R.id.tv_viewCount,wenda.getViewCount().toString());
                //隐藏问题的点赞数
                viewHolder.getView(R.id.tv_thumb).setVisibility(View.GONE);
                //回答数
                viewHolder.setText(R.id.tv_reply,wenda.getAnswerCount()+"回答");
                //是否已经解决
                if (wenda.getIsResolve().equals("1")){
                    viewHolder.setText(R.id.tv_solved,"已解决");
                    viewHolder.getView(R.id.tv_solved).setVisibility(View.VISIBLE);
                }else {
                    viewHolder.getView(R.id.tv_solved).setVisibility(View.GONE);
                }
                break;
        }
    }
}
