package com.program.module_wenda.adapter;

import androidx.core.content.ContextCompat;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.module_wenda.R;
import com.program.module_wenda.model.bean.WendaListBean;

import org.jetbrains.annotations.NotNull;

public class WendaAdapter extends BaseQuickAdapter<WendaListBean.DataBean.ListBean, BaseViewHolder> {

    public WendaAdapter() {
        super(R.layout.modulewenda_wenda_adapter);

    }

    {
        addChildClickViewIds(R.id.iv_avatar,R.id.et_nickname);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, WendaListBean.DataBean.ListBean dataBean) {
        if (dataBean != null) {
            viewHolder.setText(R.id.tv_viewCount,dataBean.getViewCount()+"浏览");
            viewHolder.setText(R.id.tv_title,dataBean.getTitle());
            viewHolder.setText(R.id.et_nickname,dataBean.getNickname());
            viewHolder.setText(R.id.tv_sob,dataBean.getSob().toString());
            viewHolder.setText(R.id.tv_labels,dataBean.getLabels().toString());

            SuperTextView tvAnswerCount = viewHolder.getView(R.id.tv_answerCount);
            tvAnswerCount.setCenterTopString(dataBean.getAnswerCount().toString());
            if (dataBean.getIsResolve().equals("1")){
                tvAnswerCount.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.green_solid_btn_normal));
                tvAnswerCount.setCenterString("√");
                tvAnswerCount.setCenterTextColor(ContextCompat.getColor(getContext(),R.color.white));
                tvAnswerCount.setCenterTopTextColor(ContextCompat.getColor(getContext(),R.color.white));
            }else {
                tvAnswerCount.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.green_hollow_btn_normal));
                tvAnswerCount.setCenterString("回答");
                tvAnswerCount.setCenterTextColor(ContextCompat.getColor(getContext(),R.color.colorSuccess));
                tvAnswerCount.setCenterTopTextColor(ContextCompat.getColor(getContext(),R.color.colorSuccess));
            }

            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(dataBean.getAvatar())
                    .placeholder(R.mipmap.ic_default_avatar)
                    .error(R.mipmap.ic_default_avatar)
                    .circleCrop()
                    .into(ivAvatar);
        }
    }
}
