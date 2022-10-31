package com.program.module_moyu.ui.activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.DateUtils;
import com.program.lib_common.RoutePath;
import com.program.lib_common.UIUtils;
import com.program.lib_common.event.UpdateItemEvent;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_moyu.R;
import com.program.module_moyu.adapter.CommentAdapter;
import com.program.module_moyu.callback.IMoyuDetailCallback;
import com.program.module_moyu.model.bean.MomentComment;
import com.program.module_moyu.model.bean.MomentCommentBean;
import com.program.module_moyu.model.bean.MomentSubComment;
import com.program.moudle_base.model.MoyuRequestBean;
import com.program.module_moyu.presenter.IMoyuDetailPresenter;
import com.program.module_moyu.utils.PresenterManager;
import com.program.moudle_base.adapter.ImageAdapter;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.EventBusUtils;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.ReplyBottomSheetDialog;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.loader.glide.GlideImageLoader;
import net.mikaelzero.mojito.view.sketch.SketchImageLoadFactory;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

@Route(path = RoutePath.Moyu.PAGE_DETAIL)
public class MoyuDetailActivity extends RxAppCompatActivity implements IMoyuDetailCallback {

    @Autowired(name = RoutePath.Moyu.MOYU_ID)
    public String mId;
    private CommentAdapter mAdapter;
    private IMoyuDetailPresenter mMoyuDetailPresenter;
    private MoyuRequestBean.DataBean mMoyuInfo = null;
    private TextView mTvHeaderNickname;
    private RoundedImageView mIvHeaderAvatar;
    private SuperTextView mTvHeader;
    private TextView mTvContent;
    private SuperTextView mTvLink;
    private TextView mTvTopicName;
    private TextView mTvDetailStar;
    private TextView mTvReply;
    private RecyclerView mRvPic;
    private TextView mTvShare;
    private ReplyBottomSheetDialog mReplyBottomSheetDialog;
    private Button mTvHeaderFollow;
    private String mMyId;
    private ImageView mIvBack;
    private SmartRefreshLayout mRefreshLayout;

    static {
//        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.transparent, R.color.colorPrimary);//全局设置主题颜色
//                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }


    @Subscribe
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulemoyu_activity_moyu_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        Log.d("test", "moyu id = " + mId);
//        mId="1574789341320843265";    //没图
//        mId = "1572926596656926721"; //一张图
//        LogUtils.d("MoyuDetailActivity","loading dialog = "+mLoadingDialog);
        if (!EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.register(this);
        }
        Mojito.initialize(GlideImageLoader.Companion.with(this), new SketchImageLoadFactory()); //没有这个图片不会显示
        mMyId = SharedPreferencesUtils.getInstance(this).getString(SharedPreferencesUtils.USER_ID);
        initView();
        initListener();
        initPresenter();
    }

    private void initPresenter() {
        mMoyuDetailPresenter = PresenterManager.getInstance().getMoyuDetailPresenter();
        mMoyuDetailPresenter.registerViewCallback(this);
        mMoyuDetailPresenter.getMoyuDetail(mId);
        mMoyuDetailPresenter.getMoyuComment(mId);
    }

    private void initListener() {
        mTvDetailStar.setOnClickListener(view ->{
            mMoyuDetailPresenter.getThumbUp(mId);
            EventBusUtils.INSTANCE.postEvent(new UpdateItemEvent(UpdateItemEvent.Event.UPDATE_MOYU,mId));
        });

        mTvReply.setOnClickListener(view -> {
            showReplyDialog(null);
        });

        mTvShare.setOnClickListener(view -> ToastUtils.showToast("分享"));

        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (adapter.getItem(position) instanceof MomentCommentBean.DataBean.ListBean){
                    MomentCommentBean.DataBean.ListBean item = (MomentCommentBean.DataBean.ListBean) adapter.getItem(position);
                    if (view.getId() == R.id.tv_comment_nickname||view.getId()==R.id.iv_comment_avatar){
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getUserId());
                    }else if (view.getId() == R.id.iv_comment_reply){
                        showReplyDialog(item);
                    }
                }
//                ToastUtils.showToast("position = "+position);
            }
        });

        mTvHeaderFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Object tag = view.getTag();
                switch ((int)tag){
                    case 0:
                    case 1:
                        if (mMoyuInfo != null) {
                            mMoyuDetailPresenter.addFollow(mMoyuInfo.getUserId());
                        }
                        break;
                    case 2:
                    case 3:
                        if (mMoyuInfo != null) {
                            mMoyuDetailPresenter.unFollow(mMoyuInfo.getUserId());
                        }
                        break;
                }
            }
        });

        mIvBack.setOnClickListener(view -> finish());

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mMoyuDetailPresenter.getMoyuCommentLoadMore(mId);
            }
        });

    }

    private void initView() {
        RelativeLayout includeBar = this.findViewById(R.id.include_bar);
        TextView tvSearch = includeBar.findViewById(R.id.tvSearch);
        mIvBack = includeBar.findViewById(R.id.ivBack);
        tvSearch.setVisibility(View.GONE);
//        new CommentAdapter(this, CollectionsKt.mutableListOf());
        mAdapter = new CommentAdapter();
        LayoutInflater inflater = LayoutInflater.from(this);
        View inflateView = inflater.inflate(R.layout.modulemoyu_moyu_detail_header, null);

        mRefreshLayout = this.findViewById(R.id.refresh_layout);
        mRefreshLayout.setEnableRefresh(false);   //禁止刷新
        mTvHeaderNickname = this.findViewById(R.id.tv_header_nickname);//
        mIvHeaderAvatar = this.findViewById(R.id.iv_header_avatar);//
        mTvHeaderFollow = this.findViewById(R.id.tv_header_follow);
        mTvHeader = inflateView.findViewById(R.id.tv_header);
        mTvContent = inflateView.findViewById(R.id.tv_content);
        mTvLink = inflateView.findViewById(R.id.tv_link);
        mTvTopicName = inflateView.findViewById(R.id.tv_topic_name);
        mTvDetailStar = inflateView.findViewById(R.id.tv_detail_star);
        mTvReply = inflateView.findViewById(R.id.tv_reply);
        mRvPic = inflateView.findViewById(R.id.rv_pic);
        mTvShare = inflateView.findViewById(R.id.tv_share);



        RecyclerView rvContent = this.findViewById(R.id.rv_content);
        rvContent.setHasFixedSize(true);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(mAdapter);
        mAdapter.addHeaderView(inflateView);
        LogUtils.d("MoyuDetailActivity","init View ");

        mReplyBottomSheetDialog = new ReplyBottomSheetDialog(this, R.style.BottomSheetDialog);
    }

    private void showReplyDialog(MultiItemEntity momentComment) {
        mReplyBottomSheetDialog.show();
        if (momentComment != null&&momentComment instanceof MomentCommentBean.DataBean.ListBean) {
            mReplyBottomSheetDialog.setReplyTitle("回复 @"+((MomentCommentBean.DataBean.ListBean)momentComment).getNickname());
        }
        mReplyBottomSheetDialog.sendListener(new ReplyBottomSheetDialog.OnSendListener() {
            @Override
            public void onSend(String v) {
                if (momentComment == null){
                    //评论动态
//                    ToastUtils.showToast(v);
                    MomentComment momentComment1 = new MomentComment(mMoyuInfo.getId(), v);
                    mMoyuDetailPresenter.toIssueComment(momentComment1);
//                    ToastUtils.showToast("评论文章");
                }else {
                    //回复评论
//                    LogUtils.d("test","data = "+momentComment.toString());
                    MomentCommentBean.DataBean.ListBean data = (MomentCommentBean.DataBean.ListBean) momentComment;
                    mMoyuDetailPresenter.toIssueSubComment(new MomentSubComment(
                              mMoyuInfo.getId(),
                              v,
                              data.getUserId(),
                              data.getId()
                      ));
//                    ToastUtils.showToast("回复评论");
                }
                mReplyBottomSheetDialog.dismiss();
            }
        });
    }


    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        return this.bindToLifecycle();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setMoyuDetailData(MoyuRequestBean moyuDetailData) {
//        MoyuItemBean data = moyuDetailData.getData();
        this.mMoyuInfo = moyuDetailData.getData();
        mTvHeaderNickname.setText(mMoyuInfo.getNickname());
        Glide.with(this).load(mMoyuInfo.getAvatar()).circleCrop().into(mIvHeaderAvatar);
        String desc = (TextUtils.isEmpty(mMoyuInfo.getPosition())||mMoyuInfo.getPosition()==null) ? "" : mMoyuInfo.getPosition();
        desc = (TextUtils.isEmpty(mMoyuInfo.getCompany())||mMoyuInfo.getCompany()==null) ? desc : desc + "@" + mMoyuInfo.getCompany();
        mTvHeader.setLeftString(desc);
        mTvHeader.setRightString(DateUtils.timeFormat(mMoyuInfo.getCreateTime()));

        //内容
        CommonViewUtils.setHtml(mTvContent, mMoyuInfo.getContent());

        //链接
        if (!TextUtils.isEmpty(mMoyuInfo.getLinkTitle()) && !TextUtils.isEmpty(mMoyuInfo.getLinkUrl())) {
            mTvLink.setVisibility(View.VISIBLE);
            mTvLink.setLeftTopString(mMoyuInfo.getLinkTitle());
            mTvLink.setLeftString(mMoyuInfo.getLinkUrl());
            mTvLink.getLeftTextView().setTypeface(null, Typeface.ITALIC);
        } else {
            mTvLink.setVisibility(View.GONE);
        }

        if (mMoyuInfo.getImages()!=null){
            mRvPic.setVisibility(View.VISIBLE);
            setImageData(mMoyuInfo.getImages(),mRvPic);
        }else {
            mRvPic.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mMoyuInfo.getTopicName())) {
            mTvTopicName.setVisibility(View.VISIBLE);
            mTvTopicName.setText(mMoyuInfo.getTopicName());
        } else {
            mTvTopicName.setVisibility(View.GONE);
        }

        mTvDetailStar.setText(mMoyuInfo.getThumbUpList().size()+"");
        mTvReply.setText(mMoyuInfo.getCommentCount().toString());
        setThumbStyle(mMoyuInfo.getHasThumbUp());

        //查看关注情况
        if (mMyId.equals(mMoyuInfo.getUserId())){
            mTvHeaderFollow.setVisibility(View.GONE);
        }else {
            mMoyuDetailPresenter.getFollowState(mMoyuInfo.getUserId());
        }
    }

    /**
     * 点赞后样式
     *
     * @param hasThumbUp 是否点赞
     */
    private void setThumbStyle(Boolean hasThumbUp) {
        EventBusUtils.INSTANCE.postEvent(new UpdateItemEvent(UpdateItemEvent.Event.UPDATE_MOYU,mId));
        // 已经点赞后 标记tvDetailStar的tag为true
        mTvDetailStar.setTag(hasThumbUp);
        CommonViewUtils.setThumbStyle(mTvDetailStar, hasThumbUp);
    }

    private void setImageData(List<String> pics, RecyclerView rvPic){
        int width = (UIUtils.getScreenWidth() - UIUtils.dp2px(44f)) / 2;
        if (pics.size()>=1&&pics.size()<=2){
            width = (UIUtils.getScreenWidth() - UIUtils.dp2px(44f))/2;
            rvPic.setLayoutManager(new GridLayoutManager(this,2));
        }else if (pics.size()>=3){
            width = (UIUtils.getScreenWidth() - UIUtils.dp2px(44f))/3;
            rvPic.setLayoutManager(new GridLayoutManager(this,3));
        }
        ImageAdapter imageAdapter = new ImageAdapter(0, pics, width);
        rvPic.setAdapter(imageAdapter);
        imageAdapter.setOnItemClickListener((adapter, view, position) -> CommonViewUtils.showBigImage(rvPic,R.id.iv_image,pics,position));

    }

    @Override
    public void setRequestError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setMoyuCommentData(MomentCommentBean momentCommentBean) {
//        mAdapter.addData(momentCommentBean);
        mAdapter.getData().clear();
        for (MomentCommentBean.DataBean.ListBean listBean : momentCommentBean.getData().getList()) {
            mAdapter.addData(listBean);
            mAdapter.addData(listBean.getSubComments());
            LogUtils.d("test"," comments == "+ listBean.getContent());
            LogUtils.d("test","sub comments == "+listBean.getSubComments().toString());
        }
    }

    @Override
    public void setMoyuCommentDataMore(MomentCommentBean momentCommentBean) {
        if (mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
        for (MomentCommentBean.DataBean.ListBean listBean : momentCommentBean.getData().getList()) {
            mAdapter.addData(listBean);
            mAdapter.addData(listBean.getSubComments());
        }
        if (momentCommentBean.getData().getList().size()==0){
            ToastUtils.showToast("暂无更多评论");
        }else {
            ToastUtils.showToast(momentCommentBean.getMessage());
        }
    }

    @Override
    public void setMoyuUserFollowState(int i) {
        CommonViewUtils.setFollowState(mTvHeaderFollow,i);
    }

    @Override
    public void returnAddFollowData(BaseResponseBean data) {
//        CommonViewUtils.setFollowState(mTvHeaderFollow,);
        mMoyuDetailPresenter.getFollowState(mMoyuInfo.getUserId());
        ToastUtils.showToast(data.getMessage());
    }

    @Override
    public void returnUnFollowData(BaseResponseBean data) {
//        CommonViewUtils.setFollowState(mTvHeaderFollow,0);
        mMoyuDetailPresenter.getFollowState(mMoyuInfo.getUserId());
        ToastUtils.showToast(data.getMessage());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setThumb() {
        setThumbStyle(true);
        mTvDetailStar.setText(mMoyuInfo.getThumbUpList().size()+1+"");
    }

    @Override
    public void returnComment(BaseResponseBean data) {
        EventBusUtils.INSTANCE.postEvent(new UpdateItemEvent(UpdateItemEvent.Event.UPDATE_MOYU,mId));
        ToastUtils.showToast(data.getMessage());
        mMoyuDetailPresenter.getMoyuComment(mMoyuInfo.getId());
    }

    @Override
    public void returnSubComment(BaseResponseBean data) {
        ToastUtils.showToast(data.getMessage());
        mMoyuDetailPresenter.getMoyuComment(mMoyuInfo.getId());
    }

    @Override
    protected void onDestroy() {
        if (EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.unRegister(this);
        }
        super.onDestroy();
    }
}