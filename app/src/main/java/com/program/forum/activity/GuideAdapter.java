package com.program.forum.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.forum.GuideBean;
import com.program.forum.R;

import org.jetbrains.annotations.NotNull;

public class GuideAdapter extends BaseQuickAdapter<GuideBean, BaseViewHolder> {


    public GuideAdapter() {
        super(R.layout.adapter_guide);
    }

    {
        addChildClickViewIds(R.id.tv_hello);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, GuideBean guideBean) {
        viewHolder.setText(R.id.tv_title,guideBean.getTitle());
        viewHolder.setText(R.id.tv_desc,guideBean.getDesc());
        viewHolder.setImageResource(R.id.iv_guide,guideBean.getResId());
        TextView tvHello = viewHolder.getView(R.id.tv_hello);
        if (getData().indexOf(guideBean)==2){
            tvHello.setVisibility(View.VISIBLE);
        }else {
            tvHello.setVisibility(View.GONE);
        }
    }
}