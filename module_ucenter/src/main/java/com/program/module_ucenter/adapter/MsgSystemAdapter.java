package com.program.module_ucenter.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.lib_common.CommonViewUtils;
import com.program.module_ucenter.R;
import com.program.module_ucenter.model.domain.MsgSystemBean;

import java.util.List;

public class MsgSystemAdapter extends BaseQuickAdapter<MsgSystemBean.DataBean.ContentBean,BaseViewHolder> {


    public MsgSystemAdapter(List<MsgSystemBean.DataBean.ContentBean> data) {
        super(R.layout.moduleucenter_adapter_system_list,data);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, MsgSystemBean.DataBean.ContentBean dataBean) {
        baseViewHolder.setText(R.id.tv_title,dataBean.getTitle());
        baseViewHolder.setText(R.id.tv_createTime,dataBean.getPublishTime());
        CommonViewUtils.setHtml(baseViewHolder.getView(R.id.tv_content),dataBean.getContent());
    }
}
