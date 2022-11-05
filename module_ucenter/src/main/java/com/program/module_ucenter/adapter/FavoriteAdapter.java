package com.program.module_ucenter.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.module_ucenter.R;
import com.program.moudle_base.model.FavoriteBean;

import org.jetbrains.annotations.NotNull;

public class FavoriteAdapter extends BaseQuickAdapter<FavoriteBean.DataBean.ContentBean, BaseViewHolder> {

    public FavoriteAdapter() {
        super(R.layout.moduleucenter_adapter_favorite);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, FavoriteBean.DataBean.ContentBean contentBean) {
        if (contentBean != null) {
            viewHolder.setText(R.id.tv_content,contentBean.getTitle());
            viewHolder.setText(R.id.tv_addTime,contentBean.getAddTime());
            if (contentBean.getType().equals("0")) {
                viewHolder.setText(R.id.tv_type,"文章");
            }
        }
    }
}
