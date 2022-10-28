package com.program.module_home.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.lib_common.DateUtils;
import com.program.lib_common.UIUtils;
import com.program.module_home.R;
import com.program.module_home.model.bean.HomeItemBean;
import com.program.moudle_base.adapter.ImageAdapter;
import com.program.moudle_base.utils.CommonViewUtils;
import com.youth.banner.util.BannerUtils;

import org.jetbrains.annotations.NotNull;

public class HomeAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private final static int w26dp = UIUtils.dp2px(26f);
    private final static int w50dp = UIUtils.dp2px(50f);
    private final static int w = (UIUtils.getScreenWidth() - UIUtils.dp2px(44f)) / 3;
    {
        addItemType(1, R.layout.modulehome_home_adapter);
        addItemType(2, R.layout.modulehome_home_multi_adapter);
        addChildClickViewIds(R.id.tv_content, R.id.iv_avatar, R.id.tv_nickName, R.id.iv_cover);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {
        if (multiItemEntity != null) {
            HomeItemBean.DataBean.ListBean bean = (HomeItemBean.DataBean.ListBean) multiItemEntity;
            viewHolder.setText(R.id.tv_content, bean.getTitle());
            viewHolder.setText(R.id.tv_nickName, bean.getNickName());
            viewHolder.setText(R.id.tv_viewCount, bean.getViewCount().toString());
            viewHolder.setText(R.id.tv_star, bean.getThumbUp().toString());
            viewHolder.setText(R.id.tv_time, DateUtils.timeFormat(bean.getCreateTime()));
            ImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(bean.getAvatar())
                    .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                    .circleCrop()       //圆角
                    .into(ivAvatar);
            if (viewHolder.getItemViewType() == 1) {
                ImageView ivCover = viewHolder.getView(R.id.iv_cover);
                BannerUtils.setBannerRound(ivCover,10f);
                Glide.with(ivCover.getContext()).load(bean.getCovers().get(0))
                        .placeholder(R.drawable.shape_grey_background)
                        .override(w50dp)
                        .thumbnail(0.3f)
                        .into(ivCover);
            }else {
                RecyclerView rvPic = viewHolder.getView(R.id.rv_pic);
                rvPic.setLayoutManager(new GridLayoutManager(getContext(),3));
                ImageAdapter imageAdapter = new ImageAdapter(1, bean.getCovers(), w);
                rvPic.setAdapter(imageAdapter);
                imageAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                        CommonViewUtils.showBigImage(rvPic,R.id.iv_image,bean.getCovers(),position);
                    }
                });
            }
        }
    }
}
