package com.program.module_ucenter.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.DateUtils;
import com.program.lib_common.UIUtils;
import com.program.module_ucenter.R;
import com.program.module_ucenter.model.domain.ArticleBean;
import com.program.module_ucenter.model.domain.ShareBean;
import com.program.module_ucenter.model.domain.UserWendaBean;
import com.youth.banner.util.BannerUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UserCenterArticleAdapter extends BaseQuickAdapter<MultiItemEntity, BaseViewHolder> {


    public UserCenterArticleAdapter(int layoutResId, @Nullable List<MultiItemEntity> data) {
        super(layoutResId, data);
    }

    {
        addChildClickViewIds(R.id.wenda_layout);
    }
    private static final int w50dp = UIUtils.dp2px(50f);

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {
        if (multiItemEntity instanceof ArticleBean.DataBean.ListBean){
            ArticleBean.DataBean.ListBean articleData = (ArticleBean.DataBean.ListBean) multiItemEntity;
            viewHolder.setText(R.id.tv_star,articleData.getThumbUp().toString());
            viewHolder.setText(R.id.tv_time, DateUtils.timeFormat(articleData.getCreateTime()));
            viewHolder.setText(R.id.tv_labels,articleData.labels(true));
//            viewHolder.setText(R.id.tv_title,articleData.getTitle());
            TextView view = viewHolder.getView(R.id.tv_content);
            view.setText(articleData.getTitle());
            LogUtils.d("test","view = "+view+"==text  = "+articleData.getTitle());
            ImageView ivCover = viewHolder.getView(R.id.iv_cover);
            BannerUtils.setBannerRound(ivCover,10f);
            Glide.with(ivCover.getContext()).load(articleData.getCovers().get(0))
                    .placeholder(R.drawable.shape_grey_background)
                    .override(w50dp)
                    .thumbnail(0.3f)
                    .into(ivCover);
        }else if (multiItemEntity instanceof ShareBean.DataBean.ListBean){
            ShareBean.DataBean.ListBean shareData = (ShareBean.DataBean.ListBean) multiItemEntity;
            viewHolder.setText(R.id.tv_title,shareData.getTitle());
            viewHolder.setText(R.id.et_nickname,shareData.getNickname());
            viewHolder.setText(R.id.tv_time,DateUtils.timeFormat(shareData.getCreateTime()));
            viewHolder.setText(R.id.tv_labels,shareData.labels(false));
            viewHolder.setText(R.id.tv_star,shareData.getThumbUp().toString());
            viewHolder.setText(R.id.tv_viewCount,shareData.getViewCount().toString());
            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(shareData.getAvatar())
                    .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                    .circleCrop()       //圆角
                    .into(ivAvatar);

            ImageView ivCover = viewHolder.getView(R.id.iv_cover);
            Glide.with(ivCover.getContext()).load(shareData.getCover())
                    .placeholder(R.drawable.shape_grey_background)
                    .override(w50dp)
                    .thumbnail(0.3f)
                    .into(ivCover);
        }else if (multiItemEntity instanceof UserWendaBean.DataBean.ContentBean){
            UserWendaBean.DataBean.ContentBean wendaData = (UserWendaBean.DataBean.ContentBean) multiItemEntity;
            viewHolder.setText(R.id.tv_title,wendaData.getWendaTitle());
            viewHolder.setText(R.id.tv_time,DateUtils.timeFormat(wendaData.getWendaComment().getPublishTime()));
        }else {

        }

    }
}
