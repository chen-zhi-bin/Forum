package com.program.module_moyu.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.DateUtils;
import com.program.lib_common.RoutePath;
import com.program.module_moyu.R;
import com.program.module_moyu.adapter.FishCommentDetailListAdapter;
import com.program.module_moyu.model.bean.MomentCommentBean;

/**
 * 评论列表
 */
@Route(path = RoutePath.Moyu.PAGE_DETAIL_COMMENT)
public class MoyuCommentDetailActivity extends AppCompatActivity {

    @Autowired(name = RoutePath.Moyu.MOYU_DETAIL_ID)
    public String mId;

    @Autowired(name = RoutePath.Moyu.COMMENT)
    public MomentCommentBean.DataBean.ListBean mComment;
    private FishCommentDetailListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulemoyu_activity_moyu_comment_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        initView();
        initEvent();
        initPresenter();
    }

    private void initPresenter() {

    }

    private void initEvent() {

    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        TextView tvReplyAndGreat = this.findViewById(R.id.tv_reply_and_great);
        ConstraintLayout fishPondDetailComment =this.findViewById(R.id.fish_pond_detail_comment);
        RoundedImageView ivAvatar = fishPondDetailComment.findViewById(R.id.iv_fish_pond_avatar);
        TextView tvNickName = fishPondDetailComment.findViewById(R.id.cb_fish_pond_nick_name);
        ImageView ivFishPondComment= fishPondDetailComment.findViewById(R.id.iv_fish_pond_comment);
        TextView tvDesc= fishPondDetailComment.findViewById(R.id.tv_fish_pond_desc);
        TextView tvReply= fishPondDetailComment.findViewById(R.id.tv_reply_msg);
        LinearLayout tvBuildReplyMsgContainer= fishPondDetailComment.findViewById(R.id.tv_build_reply_msg_container);
        tvReplyAndGreat.setText(mComment.getSubComments().size()+"回复");
        ivFishPondComment.setVisibility(View.GONE);
        Glide.with(ivAvatar.getContext())
                .load(mComment.getAvatar())
                .placeholder(com.program.moudle_base.R.mipmap.ic_default_avatar)
                .circleCrop()       //圆角
                .into(ivAvatar);
        tvNickName.setText(mComment.getNickname());
        tvDesc.setText(mComment.getPosition()+" · "+ DateUtils.timeFormat(mComment.getCreateTime()));
        tvDesc.setMaxLines(Integer.MAX_VALUE);
        tvReply.setText(mComment.getContent());
        tvBuildReplyMsgContainer.setVisibility(View.GONE);
        RecyclerView rvFishCommentDetailList = this.findViewById(R.id.rv_fish_commend_detail_list);
        rvFishCommentDetailList.setLayoutManager(new LinearLayoutManager(this));
//        rvFishCommentDetailList.addItemDecoration();
        mAdapter = new FishCommentDetailListAdapter();
        rvFishCommentDetailList.setAdapter(mAdapter);
        mAdapter.addData(mComment.getSubComments());
    }
}