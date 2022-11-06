package com.program.module_home.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.module_home.R;
import com.program.moudle_base.model.CollectionBean;

import org.jetbrains.annotations.NotNull;

public class CollectFolderAdapter extends BaseQuickAdapter<CollectionBean.DataBean.ContentBean, BaseViewHolder> {
    public CollectFolderAdapter() {
        super(R.layout.modulehome_home_dialog_adapter_collection_folder);
    }

    {
        addChildClickViewIds(R.id.tv_collect);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, CollectionBean.DataBean.ContentBean contentBean) {
        if (contentBean != null) {
            ImageView ivCover = viewHolder.getView(R.id.iv_cover);
            Glide.with(ivCover.getContext())
                    .load(contentBean.getCover())
                    .placeholder(R.drawable.shape_grey_background)
                    .into(ivCover);
            viewHolder.setText(R.id.tv_title,contentBean.getName());
            viewHolder.setText(R.id.ed_desc,contentBean.getFavoriteCount()+"篇文章 • "+contentBean.getFollowCount()+"篇订阅");

        }
    }
}
