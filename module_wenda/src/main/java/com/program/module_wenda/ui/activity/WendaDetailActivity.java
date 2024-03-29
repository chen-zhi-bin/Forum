package com.program.module_wenda.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.Constants;
import com.program.lib_common.DateUtils;
import com.program.lib_common.RoutePath;
import com.program.lib_common.UIUtils;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.lib_common.service.wenda.wrap.WendaServiceWrap;
import com.program.module_wenda.R;
import com.program.module_wenda.adapter.WendaDetailAdapter;
import com.program.module_wenda.callback.IWendaDetailCallback;
import com.program.module_wenda.model.bean.Answer;
import com.program.module_wenda.model.bean.AnswerBean;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaContentBean;
import com.program.module_wenda.presenter.IWendaDetailPresenter;
import com.program.module_wenda.utils.PresenterManager;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.TitleMultiBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.MyCodeViewJava;
import com.program.moudle_base.view.ReplyBottomSheetDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.loader.glide.GlideImageLoader;
import net.mikaelzero.mojito.view.sketch.SketchImageLoadFactory;

import java.util.List;

import kotlin.collections.CollectionsKt;

@Route(path = RoutePath.Wenda.PAGE_DETAIL)
public class WendaDetailActivity extends RxAppCompatActivity implements IWendaDetailCallback {

    @Autowired(name = RoutePath.Wenda.WENDA_ID)
    String mWendaId;
    private TextView mTvSearch;
    private ImageView mIvBack;
    private IWendaDetailPresenter mWendaDetailPresenter;
    private WendaDetailAdapter mAdapter;
    private RecyclerView mRvContent;
    private SmartRefreshLayout mRefreshLayout;
    private ReplyBottomSheetDialog mReplyDialog;
    private WendaContentBean.DataBean mWendaContent = null;
    private TextView mTvTitle;
    private MyCodeViewJava mCodeView;
    private TextView mTvThumb;
    private TextView mTvSob;
    private TextView mTvView;
    private TextView mTvPublishTime;
    private TextView mTvQuestioner;
    private TextView mTvLabels;
    private TextView mTvHeaderNickName;
    private RoundedImageView mIvHeaderAvatar;
    private TextView mTvHeaderFollow;
    private List<MultiItemEntity> answerList = CollectionsKt.mutableListOf();
    private List<MultiItemEntity> mRelatedQuestionList = CollectionsKt.mutableListOf();
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private AnswerBean mPresentData = null;
    private boolean isAddRelatedQuestionHeader = false;
    private TextView mTvInvite;
    private TextView mTvReply;
    private boolean mIsLogin;
    private boolean isJustCreate = true;
    private RelativeLayout mIncludeBar;
    private ConstraintLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulewenda_activity_wenda_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        LogUtils.d("test", "wendaId = " + mWendaId);
        Mojito.initialize(GlideImageLoader.Companion.with(this), new SketchImageLoadFactory()); //没有这个图片不会显示
        Mojito.initialize(GlideImageLoader.Companion.with(this), new SketchImageLoadFactory()); //没有这个图片不会显示
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(this);
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mIsLogin = token != null && !token.equals("");
        initView();
        initPresenter();
        initListener();
        initStatusBar();
    }

    private void initStatusBar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
        StatusBarUtil.setPaddingSmart(this,mIncludeBar);
        StatusBarUtil.setPaddingSmart(this,mLayout );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mWendaDetailPresenter.getWendaAnswerList(mWendaId);
    }

    private void initPresenter() {
        mWendaDetailPresenter = PresenterManager.getInstance().getWendaDetailPresenter();
        mWendaDetailPresenter.registerViewCallback(this);
        mWendaDetailPresenter.getWendaDetail(mWendaId);
        mWendaDetailPresenter.getWendaAnswerList(mWendaId);
        mRefreshLayout.setEnableLoadMore(false);
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        if (token != null && token != "") {
//            mWendaDetailPresenter.isThumb(token);
            mWendaDetailPresenter.isWendaThumbClick(mWendaId);
        }
    }

    private void initListener() {
        mIvBack.setOnClickListener(view -> finish());
        mTvInvite.setOnClickListener(view -> ToastUtils.showToast("开发中"));
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mWendaDetailPresenter.getWendaDetail(mWendaId);
                mWendaDetailPresenter.getWendaAnswerList(mWendaId);
            }
        });
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                if (view.getId() == R.id.tv_comment_nickname || view.getId() == R.id.iv_comment_avatar) {
                    if (item instanceof WendaBean.DataBean) {
                        WendaBean.DataBean wendaData = (WendaBean.DataBean) adapter.getItem(position);
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(wendaData.getUserId());
                    } else if (item instanceof AnswerBean.DataBean) {
                        AnswerBean.DataBean dataBean = (AnswerBean.DataBean) item;
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(dataBean.getUid());
                    }
                } else if (view.getId() == R.id.tv_comment || view.getId() == R.id.tv_more) {
                    if (item instanceof WendaBean.DataBean) {
                        WendaBean.DataBean wenda = (WendaBean.DataBean) item;
                        WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(wenda.getId());
                    } else if (item instanceof AnswerBean.DataBean) {
                        AnswerBean.DataBean dataBean = (AnswerBean.DataBean) item;
                        LogUtils.d("answer test", "answer data = " + dataBean.toString());
                        LogUtils.d("test", "data = " + mWendaContent.toString());
                        WendaServiceWrap.Singletion.INSTANCE.getHolder().launchAnswerDetail(mWendaContent, dataBean);
                    }
                }
            }
        });
        mTvReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsLogin) {
                    showReplyDialog();
                }
            }
        });
        mTvThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTvThumb.getTag()==null){
                    mWendaDetailPresenter.toWendaThumb(mWendaId);
                }
            }
        });
        mTvHeaderFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0) || view.getTag().equals(1)) {
                    if (mWendaContent!=null){
                        mWendaDetailPresenter.addFollow(mWendaContent.getUserId());
                    }
                } else {
                  if (mWendaContent!=null){
                      mWendaDetailPresenter.unFollow(mWendaContent.getUserId());
                  }
                }
            }
        });
    }

    private void showReplyDialog() {
        mReplyDialog.show();
        if (mWendaContent != null) {
            String name = mWendaContent.getNickname() != null ? mWendaContent.getNickname() : "";
            mReplyDialog.setReplyTitle("回答 @" + name);
        }
        mReplyDialog.sendListener(new ReplyBottomSheetDialog.OnSendListener() {
            @Override
            public void onSend(String v) {
                //提交回答
                mWendaDetailPresenter.sendComment(new Answer(mWendaId, v));
                mReplyDialog.dismiss();
            }
        });
    }

    private void initView() {
        mLayout = this.findViewById(R.id.layout_header_avatar);
        mIncludeBar = this.findViewById(R.id.include_bar);
        mTvSearch = mIncludeBar.findViewById(R.id.tvSearch);
        mIvBack = mIncludeBar.findViewById(R.id.ivBack);
        mTvSearch.setVisibility(View.GONE);
        LayoutInflater inflater = LayoutInflater.from(this);
        View inflate = inflater.inflate(R.layout.modulewenda_wenda_detail_header, null);
        mTvTitle = inflate.findViewById(R.id.tv_title);
        mCodeView = inflate.findViewById(R.id.codeView);
        mTvView = inflate.findViewById(R.id.tv_view);
        mTvPublishTime = inflate.findViewById(R.id.tv_publishTime);
        mTvQuestioner = inflate.findViewById(R.id.tv_questioner);
        mTvLabels = inflate.findViewById(R.id.tv_labels);

        mAdapter = new WendaDetailAdapter();
        mRvContent = this.findViewById(R.id.rv_content);
        mRefreshLayout = this.findViewById(R.id.refreshLayout);
        mTvThumb = this.findViewById(R.id.tv_thumb);
        mTvSob = this.findViewById(R.id.tv_sob);
        mTvHeaderNickName = this.findViewById(R.id.tv_header_nickname);
        mIvHeaderAvatar = this.findViewById(R.id.iv_header_avatar);
        mTvHeaderFollow = this.findViewById(R.id.tv_header_follow);
        mTvHeaderFollow.setTag(-1);
        mTvInvite = this.findViewById(R.id.tv_invite);
        mTvReply = this.findViewById(R.id.tv_reply);

        mRvContent.setHasFixedSize(true);   //设置为true让RecyclerView避免重新计算大小。
        mRvContent.setAdapter(mAdapter);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.addHeaderView(inflate);
        mReplyDialog = new ReplyBottomSheetDialog(this, R.style.BottomSheetDialog);
    }


    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void setRequestError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setWendaDetail(WendaContentBean data) {
        mWendaContent = data.getData();
//        LogUtils.d("test","data = "+data.toString());
        setContentData(data.getData());
        if (mWendaContent.getUserId().equals(SharedPreferencesUtils.getInstance(this).getString(SharedPreferencesUtils.USER_ID))) {
            mTvHeaderFollow.setVisibility(View.GONE);
        } else {
            mWendaDetailPresenter.getUserFollowState(mWendaContent.getUserId());
        }
    }


    @Override
    public void setAnswerList(AnswerBean data) {
        //评论返回布局
        List<AnswerBean.DataBean> aList = data.getData();
        if (aList != null && !aList.isEmpty()) {
            LogUtils.d("test", "data  = = = = = " + aList.toString());
//            for (MultiItemEntity multiItemEntity : answerList) {
//                mAdapter.getData().remove(multiItemEntity);
//            }
            answerList.clear();

        }
        mAdapter.getData().clear();
        answerList.add(new TitleMultiBean("回答(" + aList.size() + ")"));
        answerList.addAll(aList);
        mAdapter.addData(answerList);
        mPresentData = data;
        mWendaDetailPresenter.getRelatedQuestion(mWendaId);
        if (mRefreshLayout != null && mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void setRelatedQuestionList(WendaBean data) {
        if (mRelatedQuestionList!=null&&!mRelatedQuestionList.isEmpty()){
//            for (MultiItemEntity multiItemEntity : mRelatedQuestionList) {
//                mAdapter.getData().remove(multiItemEntity);
//            }
//            mAdapter.getData().clear();
            mRelatedQuestionList.clear();
        }
//        if (!isAddRelatedQuestionHeader) {
            mRelatedQuestionList.add(new TitleMultiBean("相关问题"));
//        }
        mRelatedQuestionList.addAll(data.getData());
        mAdapter.addData(mRelatedQuestionList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setSendCommentReturn(BaseResponseBean data) {
        if (data.getCode() == Constants.SUCCESS) {
            ToastUtils.showToast("评论成功");
            mWendaDetailPresenter.getWendaAnswerList(mWendaId);
        }
    }

    @Override
    public void setReturnThumbCheck(BaseResponseBean data) {
        if (data.getSuccess()&&Integer.parseInt(data.getData()+"")!=0){
            mTvThumb.setTag(true);
            CommonViewUtils.setThumbStyle(mTvThumb,true);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setReturnThumb(BaseResponseBean data) {
        if (data.getSuccess()){
            mTvThumb.setTag(true);
            mTvThumb.setText(mWendaContent.getThumbUp()+1+"好问题");
            CommonViewUtils.setThumbStyle(mTvThumb,true);
        }
    }

/*    @Override
    public void setThumbState(BaseResponseBean data) {
        if (data.getSuccess()&&Integer.parseInt(data.getData()+"")!=0){
            mTvThumb.setTag(true);
            CommonViewUtils.setThumbStyle(mTvThumb,true);
        }
    }*/

    @Override
    public void setFollowState(FollowBean data) {
        mTvHeaderFollow.setVisibility(View.VISIBLE);
        CommonViewUtils.setFollowState(mTvHeaderFollow, data.getData());
    }

    @Override
    public void setFollowStateError(FollowBean data) {
        ToastUtils.showToast(data.getMessage());
    }

    @Override
    public void setAddFollowMsg(String msg) {
        mTvHeaderFollow.setTag(2);
        mTvHeaderFollow.setText("已关注");
        ToastUtils.showToast(msg);
        mWendaDetailPresenter.getUserFollowState(mWendaContent.getUserId());
    }

    @Override
    public void setAddFollowMsgError(String message) {
        ToastUtils.showToast(message);
    }

    @Override
    public void setUnFollowMsg(String msg) {
        mTvHeaderFollow.setTag(0);
        mTvHeaderFollow.setText("+关注");
        ToastUtils.showToast(msg);
        mWendaDetailPresenter.getUserFollowState(mWendaContent.getUserId());
    }

    @Override
    public void setUnFollowMsgError(String msg) {

    }

    @SuppressLint({"JavascriptInterface", "SetTextI18n"})
    private void setContentData(WendaContentBean.DataBean wenda) {
        if (wenda.getIsResolve().equals("1")) {
            String title = "【已解决】" + wenda.getTitle();
            mTvTitle.setText(UIUtils.setTextViewContentStyle(
                    title,
                    new AbsoluteSizeSpan(UIUtils.dp2px(14f)),
                    new ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorSuccess)),
                    0, 5
            ));
        } else {
            mTvTitle.setText(wenda.getTitle());
        }
        mCodeView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                CommonViewUtils.toWebView(request.getUrl().toString());
                return true;
            }
        });
        //这里的CODE 为需要显示的代码，类型为String，使用的时候替换下。
        mCodeView.showCode(wenda.getDescription());
        mCodeView.addJavascriptInterface(this, "native");
        mTvThumb.setText(wenda.getThumbUp() + "好问题");
        mTvView.setText(wenda.getViewCount() + "浏览");
        mTvPublishTime.setText("发表于" + DateUtils.timeFormat(wenda.getCreateTime()));
        mTvQuestioner.setVisibility(View.GONE);
        mTvLabels.setText(wenda.getLabels().toString());
        mTvHeaderNickName.setText(wenda.getNickname());
        Glide.with(this).load(wenda.getAvatar()).circleCrop().into(mIvHeaderAvatar);
    }

    @JavascriptInterface
    public void showBigImage(int index){
        CommonViewUtils.showBigImage(this,mCodeView.getImageList(), index);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWendaDetailPresenter.unregisterViewCallback(this);
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