package com.program.moudle_base.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.lib_base.LogUtils;
import com.program.moudle_base.R;
import com.program.moudle_base.model.PriseSobBean;

import org.jetbrains.annotations.NotNull;

public class CommonPriseAdapter extends BaseQuickAdapter<PriseSobBean, BaseViewHolder> {
    public CommonPriseAdapter() {
        super(R.layout.modulebase_common_adapter_prise);
        for (int i = 1; i <=6; i++) {
            if (i<=3){
                this.getData().add(new PriseSobBean(i*2+"币",i*2));
            }else if (i==4){
                this.getData().add(new PriseSobBean(10+"币",10));
            }else if (i==5){
                this.getData().add(new PriseSobBean(15+"币",15));
            }else if (i==6){
                this.getData().add(new PriseSobBean(20+"币",20,true));
            }
        }
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, PriseSobBean priseSobBean) {
        if (priseSobBean != null) {
            viewHolder.setText(R.id.tv_sob_value,priseSobBean.getLabel());
            viewHolder.itemView.setBackgroundResource(
                    priseSobBean.isChecked()?R.drawable.blue_hollow_btn_normal:R.drawable.shape_grey_background
            );
        }
    }
}
