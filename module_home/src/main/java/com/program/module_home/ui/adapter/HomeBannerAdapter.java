package com.program.module_home.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.program.module_home.model.bean.BannerBean;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

public class HomeBannerAdapter extends BannerAdapter<BannerBean.DataBean,HomeBannerAdapter.ImageHolder> {
    public HomeBannerAdapter(List<BannerBean.DataBean> datas) {
        super(datas);
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //通过裁剪实现圆角
        BannerUtils.setBannerRound(imageView,20f);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, BannerBean.DataBean data, int position, int size) {
        Glide.with(holder.itemView)
            .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .load(data.getPicUrl())
                .into(holder.getImageView());
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView;
        }

        public ImageView getImageView() {
            return mImageView;
        }
    }
}
