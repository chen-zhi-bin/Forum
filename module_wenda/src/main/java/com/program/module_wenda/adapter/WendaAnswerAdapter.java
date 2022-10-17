package com.program.module_wenda.adapter;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_common.Constants;
import com.program.module_wenda.R;
import com.program.moudle_base.model.SubCommentBean;
import com.program.moudle_base.model.TitleMultiBean;

import org.jetbrains.annotations.NotNull;

public class WendaAnswerAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    {
        addItemType(Constants.MultiItemType.TYPE_TITLE, R.layout.modulewenda_common_adapter_title);
        addItemType(Constants.MultiItemType.TYPE_SUB_COMMENT,R.layout.modulewenda_wenda_adapter_comment);
        addChildClickViewIds(R.id.tv_your_nickname, R.id.iv_your_avatar,R.id.tv_be_nickname,R.id.iv_comment_reply);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {
        switch (viewHolder.getItemViewType()) {
            case Constants.MultiItemType.TYPE_TITLE:
                TitleMultiBean title = (TitleMultiBean) multiItemEntity;
                viewHolder.setText(R.id.tv_title,title.getTitle());
                break;
                case Constants.MultiItemType.TYPE_SUB_COMMENT:
                    SubCommentBean subConmment = (SubCommentBean) multiItemEntity;
                    viewHolder.setText(R.id.tv_your_nickname,subConmment.getYourNickname());
                    viewHolder.setText(R.id.tv_be_nickname,"@"+subConmment.getBeNickname());
                    viewHolder.setText(R.id.tv_publishTime,subConmment.getPublishTime());
                    viewHolder.setText(R.id.tv_comment,subConmment.getContent());
                    RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_your_avatar);
                    Glide.with(ivAvatar.getContext())
                            .load(subConmment.getYourAvatar())
                            .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                            .circleCrop()
                            .into(ivAvatar);
                    break;
        }
    }
}
