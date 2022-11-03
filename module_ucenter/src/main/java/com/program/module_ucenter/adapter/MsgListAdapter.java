package com.program.module_ucenter.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.module_ucenter.R;
import com.program.module_ucenter.model.domain.MsgArticleBean;
import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.module_ucenter.model.domain.MsgBean;
import com.program.module_ucenter.model.domain.MsgMomentBean;
import com.program.module_ucenter.model.domain.MsgThumbBean;
import com.program.module_ucenter.model.domain.MsgWendaBean;
import com.program.moudle_base.base.BaseApplication;

import java.util.ArrayList;
import java.util.List;

public class MsgListAdapter extends BaseQuickAdapter<MsgBean, BaseViewHolder> {

    private static final String TAG = "MsgListAdapter";

    /**
     * ；初始化适配器，但是要先拿到数据才可以初始化
     * @param layoutResId   UI的id
     * @param data
     */
    public MsgListAdapter(int layoutResId, List<MsgBean> data) {
        super(layoutResId, data);
    }

    {
        addChildClickViewIds(R.id.iv_avatar,R.id.tv_nickname,R.id.tv_reply_value);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MsgBean msgBean) {
        if (msgBean instanceof MsgAtBean.DataBean.ContentBean){
            setAtData(baseViewHolder,(MsgAtBean.DataBean.ContentBean)msgBean);
        }else if (msgBean instanceof MsgThumbBean.DataBean.ContentBean){
            setThumbData(baseViewHolder,(MsgThumbBean.DataBean.ContentBean)msgBean);
        }else if (msgBean instanceof MsgMomentBean.DataBean.ContentBean){
            setMomentData(baseViewHolder,(MsgMomentBean.DataBean.ContentBean)msgBean);
        }else if (msgBean instanceof MsgArticleBean.DataBean.ContentBean){
            setArticleData(baseViewHolder,(MsgArticleBean.DataBean.ContentBean)msgBean);
        }else if (msgBean instanceof MsgWendaBean.DataBean.ContentBean){
            setWendaData(baseViewHolder,(MsgWendaBean.DataBean.ContentBean)msgBean);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setWendaData(BaseViewHolder baseViewHolder, MsgWendaBean.DataBean.ContentBean msgBean) {
        RoundedImageView ivAvatar = baseViewHolder.itemView.findViewById(R.id.iv_avatar);
        Glide.with(BaseApplication.getAppContext())
                .load(msgBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(ivAvatar);
        baseViewHolder.setText(R.id.tv_nickname,msgBean.getNickname());
        baseViewHolder.setText(R.id.tv_createTime,msgBean.getCreateTime());
        baseViewHolder.setText(R.id.tv_reply_title, "评论了我的提问：");
        TextView tvReplyValue = (TextView)baseViewHolder.getView(R.id.tv_reply_value);
        tvReplyValue.setText("「"+msgBean.getTitle()+"」");
        setState(baseViewHolder.getView(R.id.tv_reply_state),msgBean.getHasRead());

    }

    private void setArticleData(BaseViewHolder baseViewHolder, MsgArticleBean.DataBean.ContentBean msgBean) {
        RoundedImageView ivAvatar = baseViewHolder.itemView.findViewById(R.id.iv_avatar);
        Glide.with(BaseApplication.getAppContext())
                .load(msgBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(ivAvatar);
        baseViewHolder.setText(R.id.tv_nickname,msgBean.getNickname());
        baseViewHolder.setText(R.id.tv_createTime,msgBean.getCreateTime());
        baseViewHolder.setText(R.id.tv_reply_title, "评论了我的文章：");
        baseViewHolder.setText(R.id.tv_reply_value, "「"+msgBean.getTitle()+"」");
        baseViewHolder.setText(R.id.tv_content, msgBean.getContent());
        setState(baseViewHolder.getView(R.id.tv_reply_state),msgBean.getHasRead());
    }

    private void setMomentData(BaseViewHolder baseViewHolder, MsgMomentBean.DataBean.ContentBean msgBean) {
        RoundedImageView ivAvatar = baseViewHolder.itemView.findViewById(R.id.iv_avatar);
        Glide.with(BaseApplication.getAppContext())
                .load(msgBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(ivAvatar);
        baseViewHolder.setText(R.id.tv_nickname,msgBean.getNickname());
        baseViewHolder.setText(R.id.tv_createTime,msgBean.getCreateTime());
        baseViewHolder.setText(R.id.tv_reply_title, "评论了我的文章：");
        baseViewHolder.setText(R.id.tv_reply_value, "「"+msgBean.getTitle()+"」");
        baseViewHolder.setText(R.id.tv_content, msgBean.getContent());
        setState(baseViewHolder.getView(R.id.tv_reply_state),msgBean.getHasRead());
    }

    private void setThumbData(BaseViewHolder baseViewHolder, MsgThumbBean.DataBean.ContentBean msgBean) {
        RoundedImageView ivAvatar = baseViewHolder.itemView.findViewById(R.id.iv_avatar);
        Glide.with(BaseApplication.getAppContext())
                .load(msgBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(ivAvatar);
        baseViewHolder.setText(R.id.tv_nickname,msgBean.getNickname());
        baseViewHolder.setText(R.id.tv_createTime,msgBean.getTimeText());
        baseViewHolder.setText(R.id.tv_reply_title, "给朕的内容点赞：");
        baseViewHolder.setText(R.id.tv_reply_value, "「"+msgBean.getTitle()+"」");
        baseViewHolder.getView(R.id.tv_content).setVisibility(View.GONE);
        baseViewHolder.getView(R.id.tv_reply_state).setVisibility(View.GONE);
    }

    private void setAtData(BaseViewHolder viewHolder, MsgAtBean.DataBean.ContentBean msgBean) {

        RoundedImageView ivAvatar = viewHolder.itemView.findViewById(R.id.iv_avatar);
        Glide.with(BaseApplication.getAppContext())
                .load(msgBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(ivAvatar);
        viewHolder.setText(R.id.tv_nickname,msgBean.getNickname());
        viewHolder.setText(R.id.tv_createTime,msgBean.getPublishTime());
        viewHolder.setText(R.id.tv_reply_title,"回复了我的评论");
        viewHolder.setText(R.id.tv_reply_value,"「点击查看详情」");
        viewHolder.setText(R.id.tv_content,msgBean.getContent());
        setState(viewHolder.getView(R.id.tv_reply_state),msgBean.getHasRead());
    }

    private void setState(TextView textView,String hasRead){
        if (hasRead.equals("0")){
            textView.setText("未读");
            textView.setTextColor(ContextCompat.getColor(BaseApplication.getAppContext(),R.color.colorAccent));
            textView.setBackgroundResource(R.drawable.blue_hollow_btn_normal);
        }else {
            textView.setText("已阅");
            textView.setTextColor(ContextCompat.getColor(BaseApplication.getAppContext(),R.color.white));
            textView.setBackgroundResource(R.drawable.green_solid_btn_normal);
        }
    }
}
