package com.program.module_home.ui.adapter;

import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_common.DateUtils;
import com.program.lib_common.UIUtils;
import com.program.module_home.R;
import com.program.module_home.model.bean.PriseArticleBean;

import org.jetbrains.annotations.NotNull;

public class PriseAdapter extends BaseQuickAdapter<PriseArticleBean.DataBean, BaseViewHolder> {
    public PriseAdapter() {
        super(R.layout.modulehome_adapter_prise);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, PriseArticleBean.DataBean dataBean) {
        if (dataBean != null) {
            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(dataBean.getAvatar())
                    .placeholder(R.mipmap.ic_default_avatar)
                    .circleCrop()
                    .into(ivAvatar);
            viewHolder.setText(R.id.et_nickname,dataBean.getNickname());
            String str = "打赏 "+dataBean.getSob()+" Sob币";
            viewHolder.setText(R.id.tv_prise_value, UIUtils.setTextViewContentStyle(
                    str,
                    new AbsoluteSizeSpan(UIUtils.dp2px(16f)),
                    new ForegroundColorSpan(ContextCompat.getColor(getContext(),R.color.colorWarning)),
                    3,dataBean.getSob().toString().length()+3
            ));
            viewHolder.setText(R.id.tv_time, DateUtils.timeFormat(dataBean.getCreateTime()));
        }
    }
}
