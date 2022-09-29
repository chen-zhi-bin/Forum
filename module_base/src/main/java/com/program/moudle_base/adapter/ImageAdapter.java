package com.program.moudle_base.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.moudle_base.R;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.ImageUtils;
import com.youth.banner.util.BannerUtils;
import com.youth.banner.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int width;

    public ImageAdapter(int layoutResId,List<String> data, int width) {
        super(R.layout.modulebase_common_moyu_adapter_image, data);
        this.width = width;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, String s) {
        if (s != null) {
            LogUtils.d("ImageAdapter,loading");
            ImageView ivImage = viewHolder.getView(R.id.iv_image);
            ivImage = (ImageView) ImageUtils.setViewWidth(ivImage, width-10);
            ivImage = (ImageView) ImageUtils.setViewHeight(ivImage,width-10);
            BannerUtils.setBannerRound(ivImage, 10f);
            Glide.with(BaseApplication.getAppContext())
                    .load(s)
                    .placeholder(R.drawable.shape_grey_background)
                    .into(ivImage);
        }
    }
}