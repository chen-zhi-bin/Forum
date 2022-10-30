package com.program.moudle_base.adapter;


import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.lib_common.DateUtils;
import com.program.lib_common.UIUtils;
import com.program.moudle_base.R;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.MoyuItemBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import java.util.List;

public class MoyuAdapter extends BaseQuickAdapter<MoyuItemBean, BaseViewHolder> {


    /**
     * 注册
     * @param layoutResId   已经写死
     */
    public MoyuAdapter(int layoutResId) {
        super(R.layout.modulebase_common_moyu_adapter,null);
        addChildClickViewIds(R.id.iv_avatar,R.id.tv_nickname,R.id.tv_link);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MoyuItemBean moyuItemBean) {
        RoundedImageView ivAvatar = viewHolder.itemView.findViewById(R.id.iv_avatar);
        Glide.with(BaseApplication.getAppContext())
                .load(moyuItemBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(ivAvatar);
        viewHolder.setText(R.id.tv_nickname,moyuItemBean.getNickname());
        String desc;
        if (TextUtils.isEmpty(moyuItemBean.getPosition())){
            desc="";
        }else {
            desc = moyuItemBean.getPosition();
        }
        desc = TextUtils.isEmpty(moyuItemBean.getCompany()) ? desc : desc + '@' + moyuItemBean.getCompany();
        viewHolder.setText(R.id.tv_position,desc);
        viewHolder.setText(R.id.tv_publishTime, DateUtils.timeFormat(moyuItemBean.getCreateTime()));
        //vip设计   没做

        //内容
        CommonViewUtils.setHtml(viewHolder.getView(R.id.tv_content),moyuItemBean.getContent());

        //链接
        SuperTextView tvLink = viewHolder.getView(R.id.tv_link);
        if (!TextUtils.isEmpty(moyuItemBean.getLinkTitle())&&!TextUtils.isEmpty(moyuItemBean.getLinkUrl())){
            tvLink.setVisibility(View.VISIBLE);
            tvLink.setLeftTopString(moyuItemBean.getLinkTitle());
            tvLink.setLeftString(moyuItemBean.getLinkUrl());
            tvLink.getLeftTextView().setTypeface(null, Typeface.ITALIC);
        }else {
            tvLink.setVisibility(View.GONE);
        }

        RecyclerView rvPic = viewHolder.getView(R.id.rv_pic);
        if (!moyuItemBean.getImages().isEmpty()){
            rvPic.setVisibility(View.VISIBLE);
            setImageDate(moyuItemBean.getImages(),rvPic);
        }else {
            rvPic.setVisibility(View.GONE);
        }

        TextView tvTopicName = viewHolder.getView(R.id.tv_topic_name);
        if (!TextUtils.isEmpty(moyuItemBean.getTopicName())){
            tvTopicName.setVisibility(View.VISIBLE);
            tvTopicName.setText(moyuItemBean.getTopicName());
        }else {
            tvTopicName.setVisibility(View.GONE);
        }
        viewHolder.setText(R.id.tv_star,moyuItemBean.getThumbUpList().size()+"");
        viewHolder.setText(R.id.tv_reply,moyuItemBean.getCommentCount().toString());

        //是否点赞
        String id = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_ID,"");
        CommonViewUtils.setThumbStyle(viewHolder.getView(R.id.tv_star),moyuItemBean.getThumbUpList().contains(id));
    }

    private int width2 = UIUtils.getScreenWidth() - UIUtils.dp2px(44f) / 2;
    private int width3 = UIUtils.getScreenWidth() - UIUtils.dp2px(44f) / 3;

    private void setImageDate(List<String> images, RecyclerView rvPic) {
        int width = UIUtils.getScreenWidth();
        if (images.size()==1){
            rvPic.setLayoutManager(new GridLayoutManager(BaseApplication.getAppContext(),1));
        } else if (images.size()==2||images.size()==4){
            width = width2/2;
//            width = width/2;
            rvPic.setLayoutManager(new GridLayoutManager(BaseApplication.getAppContext(),2));
        }else if (images.size()>=3){
            width = width3/3;
//            width = width/3;
            rvPic.setLayoutManager(new GridLayoutManager(BaseApplication.getAppContext(),3));
        }
        LogUtils.d("test","width == "+width+"images = "+images.size());
        ImageAdapter imageAdapter = new ImageAdapter(1,images, width);
        rvPic.setAdapter(imageAdapter);

        imageAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                LogUtils.d("MoyuAdapter","show image");
                //查看图片
                CommonViewUtils.showBigImage(rvPic,R.id.iv_image,images,position);
            }
        });
    }

}
