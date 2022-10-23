package com.program.module_home.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.util.DebugUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.DateUtils;
import com.program.lib_common.RoutePath;
import com.program.lib_common.UIUtils;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_home.R;
import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.ArticleRecommendBean;
import com.program.module_home.model.bean.CommentBean;
import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.ui.adapter.HomeDetailAdapter;
import com.program.module_home.utils.PresenterManager;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.PriseQrCodeBean;
import com.program.moudle_base.model.TitleMultiBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.FixedHeightBottomSheetDialog;
import com.program.moudle_base.view.MyCodeViewJava;
import com.program.moudle_base.view.ReplyBottomSheetDialog;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.loader.glide.GlideImageLoader;
import net.mikaelzero.mojito.view.sketch.SketchImageLoadFactory;

import java.util.List;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMutableList;

@Route(path = RoutePath.Home.PAGE_ARTICLE)
public class ArticleDetailActivity extends RxAppCompatActivity implements IArticleDetailCallback {

    @Autowired(name = "articleId")
    public String mArticleId;

    @Autowired(name = "articleTitle")
    public String mArticleTitle;

    //记录当前RecycleView 滚动的距离
    private int scrollY = 0;
    private int switchScrollY = 0;

    private ImageView mIvSwitch;
    private TextView mTvReplyNum;
    private TextView mTvStarNum;
    private HomeDetailAdapter mAdapter;
    private FixedHeightBottomSheetDialog mBottomSheetDialog;
    private ReplyBottomSheetDialog mReplyDialog;
    private MyCodeViewJava mCodeView;
    private RoundedImageView mIvHeaderAvatar;
    private IArticleDetailPresenter mArticleDetailPresenter;
    private ArticleDetailBean.DataBean mArticle;
    private TextView mTvTitle;
    private RoundedImageView mIvAvatar;
    private TextView mTvNickname;
    private TextView mTvPublishTime;
    private TextView mTvViewCount;
    private TextView mTvLabels;
    private TextView mTvPriseList;
    private TextView mTvHeaderNickname;
    private ImageView mIvQrUrl;
    private TextView mTvPriseTips;
    private RecyclerView mRvContent;
    private View mContentBinding;
    private ConstraintLayout mLayoutHeaderAvatar;
    private ConstraintLayout mLayoutHeader;
    private ArticleDetailActivity thisActivity = null;
    private TextView mTvHeaderFollow;
    private TextView mTvFollow;

    private  List<MultiItemEntity> mCommentList = CollectionsKt.mutableListOf();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulehome_activity_article_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        Mojito.initialize(GlideImageLoader.Companion.with(this), new SketchImageLoadFactory()); //没有这个图片不会显示
        LogUtils.d("test", "id =" + mArticleId);
        LogUtils.d("test", "title =" + mArticleTitle);
        thisActivity = this;
        initView();
        initPresenter();
        initListener();
    }

    private void initPresenter() {
        mArticleDetailPresenter = PresenterManager.getInstance().getArticleDetailPresenter();
        mArticleDetailPresenter.registerViewCallback(this);
        mArticleDetailPresenter.getArticleDetail(mArticleId);
    }

    private void initListener() {
        mTvFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0) || view.getTag().equals(1)) {
                    follow(mArticle.getUserId());
                } else {
                    unfollow(mArticle.getUserId());
                }
            }
        });

        mTvHeaderFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0) || view.getTag().equals(1)) {
                    follow(mArticle.getUserId());
                } else {
                    unfollow(mArticle.getUserId());
                }
            }
        });

        mRvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY += dy;
                // 标题栏显示头像，隐藏标题
                if (scrollY >= mLayoutHeader.getHeight()) {
                    mLayoutHeaderAvatar.setVisibility(View.VISIBLE);
                    mTvTitle.setVisibility(View.GONE);
                    mLayoutHeaderAvatar.setAlpha(
                            1f * (scrollY - mLayoutHeader.getHeight()) / mLayoutHeader.getHeight()
                    );
                } else {
                    mLayoutHeaderAvatar.setVisibility(View.GONE);
                    mTvTitle.setVisibility(View.VISIBLE);
                    mTvTitle.setAlpha(
                            1f * (mLayoutHeader.getHeight() - scrollY) / mLayoutHeader.getHeight()
                    );
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        //处于静止状态时，继续加载图片
                        if (!((thisActivity.isDestroyed())) && !(thisActivity.isFinishing())) {
                            Glide.with(getApplicationContext()).resumeRequests();
                        }
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        //处于滑动状态时，停止加载图片，保证操作界面流畅
                        if (!(thisActivity.isDestroyed()) && !(thisActivity).isFinishing()) {
                            Glide.with(getApplicationContext()).pauseRequests();
                        }
                        break;
                }
                super.onScrollStateChanged(recyclerView, newState);

            }
        });
    }

    private void unfollow(String userId) {
        mArticleDetailPresenter.unFollow(userId);
    }

    private void follow(String userId) {
        mArticleDetailPresenter.addFollow(userId);
    }

    private void initView() {
        RelativeLayout includeBar = this.findViewById(R.id.include_bar);
        includeBar.findViewById(R.id.tvSearch).setVisibility(View.GONE);
        includeBar.findViewById(R.id.ivBack).setOnClickListener(view -> finish());
        mTvTitle = includeBar.findViewById(R.id.tv_title);

        mIvSwitch = this.findViewById(R.id.iv_switch);
        mIvSwitch.setTag(0);
        mTvReplyNum = this.findViewById(R.id.tv_reply_num);
        mTvStarNum = this.findViewById(R.id.tv_star_num);
        mTvReplyNum.setVisibility(View.GONE);
        mTvStarNum.setVisibility(View.GONE);

        mIvHeaderAvatar = this.findViewById(R.id.iv_header_avatar);
        mTvHeaderNickname = this.findViewById(R.id.tv_header_nickname);
        mLayoutHeaderAvatar = this.findViewById(R.id.layout_header_avatar);

        LayoutInflater inflater = LayoutInflater.from(this);
        mContentBinding = inflater.inflate(R.layout.modulehome_home_detail_content_layout, null);
        mCodeView = mContentBinding.findViewById(R.id.codeView);
        mIvAvatar = mContentBinding.findViewById(R.id.iv_avatar);
        mTvNickname = mContentBinding.findViewById(R.id.tv_nickname);
        mTvPublishTime = mContentBinding.findViewById(R.id.tv_publishTime);
        mTvViewCount = mContentBinding.findViewById(R.id.tv_viewCount);
        mTvLabels = mContentBinding.findViewById(R.id.tv_labels);
        mTvPriseList = mContentBinding.findViewById(R.id.tv_prise_list);
        mIvQrUrl = mContentBinding.findViewById(R.id.iv_qrcUrl);
        mTvPriseTips = mContentBinding.findViewById(R.id.tv_prise_tips);
        mLayoutHeader = mContentBinding.findViewById(R.id.layout_header);
        mTvFollow = mContentBinding.findViewById(R.id.tv_follow);

        mAdapter = new HomeDetailAdapter();
        mRvContent = this.findViewById(R.id.rv_content);
        mTvHeaderFollow = this.findViewById(R.id.tv_header_follow);
        mRvContent.setHasFixedSize(true);
        mRvContent.setAdapter(mAdapter);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.addHeaderView(mContentBinding);
        mBottomSheetDialog = new FixedHeightBottomSheetDialog(
                this,
                R.style.BottomSheetDialog,
                UIUtils.getScreenHeeight() * 2 / 3
        );
        mReplyDialog = new ReplyBottomSheetDialog(
                this,
                R.style.BottomSheetDialog
        );
        initWebView();
    }

    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        mCodeView.addJavascriptInterface(this, "native");
        mCodeView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                CommonViewUtils.toWebView(request.getUrl().toString());
                LogUtils.d("test","url ="+request.getUrl());
                return true;
            }
        });
    }

//    @SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void showBigImage(int index) {
        LogUtils.d("test","123");
        CommonViewUtils.showBigImage(this, mCodeView.getImageList(), index);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setArticleDetail(ArticleDetailBean.DataBean data) {
        mArticle = data;
        mArticleTitle = mArticle.getTitle();
        mTvTitle.setText(mArticleTitle);
        //这里的CODE 为需要显示的代码，类型为String，使用的时候替换。
        mCodeView.showCode(data.getContent());

        Glide.with(mIvAvatar.getContext())
                .load(data.getAvatar())
                .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                .circleCrop()
                .into(mIvAvatar);

        mTvNickname.setText(data.getNickname());
        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(data.getUserId());
            }
        });
        mTvPublishTime.setText("发表于" + DateUtils.timeFormat(data.getCreateTime()));
        mTvViewCount.setText("热度" + data.getViewCount());
        mTvLabels.setText(data.getLabels().toString());

        mTvPriseList.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        mTvHeaderNickname.setText(data.getNickname());

        Glide.with(mIvHeaderAvatar.getContext())
                .load(data.getAvatar())
                .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                .circleCrop()
                .into(mIvHeaderAvatar);
        if (data.getThumbUp() > 0) {
            mTvStarNum.setVisibility(View.VISIBLE);
            mTvStarNum.setText(data.getThumbUp().toString());
        }
        mArticleDetailPresenter.getPriseQrCode(data.getUserId());
        mArticleDetailPresenter.getUserFollowState(data.getUserId());
        mArticleDetailPresenter.getArticleComment(data.getId());
    }

    @Override
    public void setRequestError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setPriseQrCode(PriseQrCodeBean data) {
        if (data.getData() != null) {
            mIvQrUrl.setVisibility(View.VISIBLE);
            PriseQrCodeBean.DataBean dataBean = data.getData();
            Glide.with(this)
                    .load(dataBean.getQrcUrl())
                    .placeholder(R.drawable.shape_grey_background)
                    .override(UIUtils.dp2px(100f), UIUtils.dp2px(100f))
                    .thumbnail(0.1f)
                    .into(mIvQrUrl);
            mTvPriseTips.setText(dataBean.getTips());
        } else {
            mIvQrUrl.setVisibility(View.GONE);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setArticleComment(CommentBean data) {
        mAdapter.getData().clear();
        mCommentList.clear();
        mCommentList.add(new TitleMultiBean("文章评论"));
        List<CommentBean.DataBean.ContentBean> content = data.getData().getContent();
        for (CommentBean.DataBean.ContentBean contentBean : content) {
            mCommentList.add(contentBean);
            mCommentList.addAll(contentBean.getSubComments());
        }
        mAdapter.addData(0,mCommentList);
        if (mAdapter.getData().size()>mCommentList.size()){
            mAdapter.notifyItemChanged(mCommentList.size()+1);
        }
        mTvReplyNum.setVisibility(View.VISIBLE);
        mTvReplyNum.setText(data.getData().getContent().size()+"");
        mArticleDetailPresenter.getArticleRecommend(mArticleId);
    }

    @Override
    public void setArticleRecommend(ArticleRecommendBean data) {
        List<ArticleRecommendBean.DataBean> list = data.getData();
        mAdapter.addData(new TitleMultiBean("相关推荐"));
        mAdapter.addData(list);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        //        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
//        return  RxLifecycle.bind(objectBehaviorSubject);
        return this.bindToLifecycle();
    }

    @Override
    public void setFollowState(FollowBean data) {
        LogUtils.d("test","data data = "+data.toString());
        mTvHeaderFollow.setVisibility(View.VISIBLE);
        if (data.isSuccess()){
            CommonViewUtils.setFollowState(mTvFollow,data.getData());
            CommonViewUtils.setFollowState(mTvHeaderFollow,data.getData());
        }
    }

    @Override
    public void setFollowStateError(FollowBean data) {
        ToastUtils.showToast(data.getMessage());
    }

    @Override
    public void setAddFollowMsg(String msg) {
//        mTvHeaderFollow.setTag(2);
//        mTvHeaderFollow.setText("已关注");
        CommonViewUtils.setFollowState(mTvHeaderFollow,2);
//        mTvFollow.setTag(2);
//        mTvFollow.setText("已关注");
        CommonViewUtils.setFollowState(mTvFollow,2);
        ToastUtils.showToast(msg);
        mArticleDetailPresenter.getUserFollowState(mArticle.getUserId());
    }

    @Override
    public void setAddFollowMsgError(String message) {
        ToastUtils.showToast(message);
    }

    @Override
    public void setUnFollowMsg(String msg) {
//        mTvHeaderFollow.setTag(0);
//        mTvHeaderFollow.setText("+关注");
//        mTvFollow.setTag(0);
//        mTvFollow.setText("+关注");
        CommonViewUtils.setFollowState(mTvHeaderFollow,0);
        CommonViewUtils.setFollowState(mTvFollow,0);
        ToastUtils.showToast(msg);
        mArticleDetailPresenter.getUserFollowState(mArticle.getUserId());
    }

    @Override
    public void setUnFollowMsgError(String msg) {
        ToastUtils.showToast(msg);
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
}