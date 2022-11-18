package com.program.module_search.ui.adapter;


import android.text.Html;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.lib_common.Constants;
import com.program.module_search.R;
import com.program.module_search.model.bean.SearchListBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SearchListAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    {
        addItemType(Constants.Search.SEARCH_INT_ARTICLE, R.layout.modulesearch_adapter_article);
        addItemType(Constants.Search.SEARCH_INT_WENDA, R.layout.modulesearch_adapter_list);
        addItemType(Constants.Search.SEARCH_INT_SHAPE,R.layout.modulesearch_adapter_list);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, MultiItemEntity multiItemEntity) {
        SearchListBean.DataBean.ListBean item = (SearchListBean.DataBean.ListBean) multiItemEntity;
        String labels="";
        List<String> itemLabels = item.getLabels();
        switch (multiItemEntity.getItemType()) {
            case Constants.Search.SEARCH_INT_ARTICLE:
                viewHolder.setText(R.id.tv_a_title, Html.fromHtml(item.getTitle()));
                viewHolder.setText(R.id.tv_desc,Html.fromHtml(item.getContent()));
                if (itemLabels.size()>2){
                    labels = "["+itemLabels.get(0)+itemLabels.get(1)+"..]";
                }else if (itemLabels.size()==2){
                    labels = "["+itemLabels.get(0)+itemLabels.get(1)+"]";
                }else if (itemLabels.size()==1){
                    labels = "["+itemLabels.get(0)+"]";
                }
                viewHolder.setText(R.id.tv_labels,labels);
                viewHolder.setText(R.id.tv_publishTime,item.getPublishTime());
                ImageView ivCover = viewHolder.getView(R.id.iv_cover);
                Glide.with(ivCover.getContext())
                        .load(item.getCover())
                        .into(ivCover);
                break;
                case Constants.Search.SEARCH_INT_WENDA:
                case Constants.Search.SEARCH_INT_SHAPE:
                    viewHolder.setText(R.id.tv_qa_title,Html.fromHtml(item.getTitle()));
                    viewHolder.setText(R.id.tv_desc,Html.fromHtml(item.getContent()));
                    if (itemLabels.size()>2){
                        labels = "["+itemLabels.get(0)+itemLabels.get(1)+"..]";
                    }else if (itemLabels.size()==2){
                        labels = "["+itemLabels.get(0)+itemLabels.get(1)+"]";
                    }else if (itemLabels.size()==1){
                        labels = "["+itemLabels.get(0)+"]";
                    }
                    viewHolder.setText(R.id.tv_labels,labels);
                    viewHolder.setText(R.id.tv_publishTime,item.getPublishTime());
                    break;
        }
    }
}
