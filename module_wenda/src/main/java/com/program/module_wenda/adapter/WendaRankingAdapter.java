package com.program.module_wenda.adapter;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.module_wenda.R;
import com.program.module_wenda.model.bean.WendaRankingBean;
import com.program.moudle_base.utils.CommonViewUtils;

import org.jetbrains.annotations.NotNull;

public class WendaRankingAdapter extends BaseQuickAdapter<WendaRankingBean.DataBean, BaseViewHolder> {
    public WendaRankingAdapter() {
        super(R.layout.modulewenda_adapter_ranking);
    }

    {
        addChildClickViewIds(R.id.tv_follow,R.id.iv_avatar);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, WendaRankingBean.DataBean dataBean) {
        if (dataBean != null) {
            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(dataBean.getAvatar())
                    .placeholder(R.mipmap.ic_default_avatar)
                    .error(R.mipmap.ic_default_avatar)
                    .circleCrop()
                    .into(ivAvatar);

            viewHolder.setText(R.id.tv_nickname,dataBean.getNickname());
            viewHolder.setText(R.id.tv_count,dataBean.getCount()+" 个回答");
            CommonViewUtils.setFollowState((TextView) viewHolder.getView(R.id.tv_follow),0);
            viewHolder.getView(R.id.tv_follow).setTag("-1");
        }
    }
}
