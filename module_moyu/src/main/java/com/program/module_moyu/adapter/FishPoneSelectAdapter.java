package com.program.module_moyu.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.module_moyu.R;
import com.program.module_moyu.model.bean.TopicIndexReturnBean;

import org.jetbrains.annotations.NotNull;

public class FishPoneSelectAdapter extends BaseQuickAdapter<TopicIndexReturnBean.DataBean, BaseViewHolder> {
    public FishPoneSelectAdapter() {
        super(R.layout.modulemoyu_fish_pond_selection_item);
    }

    {
        addChildClickViewIds(R.id.btn_choose);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, TopicIndexReturnBean.DataBean dataBean) {
        ImageView ivTopicCover = viewHolder.getView(R.id.iv_topic_cover);
        Glide.with(viewHolder.itemView.getContext()).load(dataBean.getCover()).into(ivTopicCover);
        viewHolder.setText(R.id.tv_topic_name,dataBean.getTopicName());
        viewHolder.setText(R.id.tv_topic_desc,dataBean.getDescription());

    }
}
