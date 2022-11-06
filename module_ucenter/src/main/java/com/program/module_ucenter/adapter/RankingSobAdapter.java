package com.program.module_ucenter.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.module_ucenter.R;
import com.program.module_ucenter.model.domain.RankingSobBean;

import org.jetbrains.annotations.NotNull;

public class RankingSobAdapter extends BaseQuickAdapter<RankingSobBean.DataBean, BaseViewHolder> {
    public RankingSobAdapter() {
        super(R.layout.moduleucenter_adapter_ranking_sob);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, RankingSobBean.DataBean item) {
        if (item != null) {
            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(item.getAvatar())
                    .placeholder(R.mipmap.ic_default_avatar)
                    .error(R.mipmap.ic_default_avatar)
                    .circleCrop()
                    .into(ivAvatar);
            viewHolder.setText(R.id.et_nickname,item.getNickname());
            viewHolder.setText(R.id.tv_sob,"Sob币："+item.getSob());
            ImageView ivRanking = viewHolder.getView(R.id.iv_ranking);
            ivRanking.setVisibility(View.GONE);
            switch (getData().indexOf(item)){
                case 0:
                    ivRanking.setVisibility(View.VISIBLE);
                    ivRanking.setImageResource(R.mipmap.ic_gold);
                    break;
                case 1:
                    ivRanking.setVisibility(View.VISIBLE);
                    ivRanking.setImageResource(R.mipmap.ic_silver);
                    break;
                case 2:
                    ivRanking.setVisibility(View.VISIBLE);
                    ivRanking.setImageResource(R.mipmap.ic_copper);
                    break;
            }
        }
    }
}
