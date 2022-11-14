package com.program.module_moyu.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.module_moyu.R;
import com.program.moudle_base.model.ImageItem;

import org.jetbrains.annotations.NotNull;

public class ImagePreviewAdapter extends BaseQuickAdapter<ImageItem, BaseViewHolder> {

    public ImagePreviewAdapter() {
        super(R.layout.modulemoyu_image_choose_item);
    }
    {
        addChildClickViewIds(R.id.iv_clear);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, ImageItem s) {
        if (s==null||s.getPath().equals("")){
            return;
        }
        ImageView ivPhoto =viewHolder.getView(R.id.iv_photo);
        ImageView ivClear =viewHolder.getView(R.id.iv_clear);
        Glide.with(ivPhoto.getContext())
                .load(s.getPath())
                .into(ivPhoto);
        Glide.with(ivClear.getContext())
                .load(R.mipmap.ic_clear)
                .into(ivClear);
    }
}
