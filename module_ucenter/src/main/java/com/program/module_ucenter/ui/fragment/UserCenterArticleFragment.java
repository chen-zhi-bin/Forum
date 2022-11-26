package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.lib_common.service.wenda.wrap.WendaServiceWrap;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.UserCenterArticleAdapter;
import com.program.module_ucenter.callback.IUserCenterArticleCallback;
import com.program.module_ucenter.model.domain.ArticleBean;
import com.program.module_ucenter.model.domain.ShareBean;
import com.program.module_ucenter.model.domain.UserWendaBean;
import com.program.module_ucenter.presenter.IUserCenterArticlePresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import kotlin.collections.CollectionsKt;

public class UserCenterArticleFragment extends BaseFragment implements IUserCenterArticleCallback {

    private String mUserId;
    private String mDataType;
    private UserCenterArticleAdapter mAdapter;
    private IUserCenterArticlePresenter mCenterArticlePresenter;
    private RecyclerView mRvList;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mUserId = requireArguments().getString("userId");
        mDataType = requireArguments().getString(Constants.DATA_TYPE);
        LogUtils.d(UserCenterArticleFragment.class, "mUserId = " + mUserId);
        LogUtils.d(UserCenterArticleFragment.class, "mDataType = " + mDataType);

        switch (mDataType) {
            case Constants.DATA_TPTE_ARTICLE:
                mAdapter = new UserCenterArticleAdapter(R.layout.moduleucenter_adapter_article, CollectionsKt.mutableListOf());
                break;
            case Constants.DATA_TPTE_SHARA:
                mAdapter = new UserCenterArticleAdapter(R.layout.moduleucenter_adapter_share, CollectionsKt.mutableListOf());
                break;
            case Constants.DATA_TPTE_WENDA:
                mAdapter = new UserCenterArticleAdapter(R.layout.moduleucenter_adapter_wenda, CollectionsKt.mutableListOf());
                break;
        }
        mRvList = rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mRvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    /**
     * 1文章
     * 2分享
     * 3问答
     */
    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                MultiItemEntity item = mAdapter.getItem(0);
                switch (item.getItemType()) {
                    case 1:
                        mCenterArticlePresenter.getArticleList(mUserId);
                        break;
                    case 2:
                        mCenterArticlePresenter.getShareList(mUserId);
                        break;
                    case 3:
                        mCenterArticlePresenter.getWendaList(mUserId);
                        break;
                }
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                MultiItemEntity item = mAdapter.getItem(0);
                switch (item.getItemType()) {
                    case 1:
                        mCenterArticlePresenter.getArticleListMore(mUserId);
                        break;
                    case 2:
                        mCenterArticlePresenter.getShareListMore(mUserId);
                        break;
                    case 3:
                        mCenterArticlePresenter.getWendaListMore(mUserId);
                        break;
                }
            }
        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (adapter.getItem(position) instanceof UserWendaBean.DataBean.ContentBean){
                    UserWendaBean.DataBean.ContentBean wendaComment = (UserWendaBean.DataBean.ContentBean) adapter.getItem(position);
                    LogUtils.d("test"," asdasddata = "+wendaComment.getWendaComment().getWendaId());
                    WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(wendaComment.getWendaComment().getWendaId());
                }else if (adapter.getItem(position) instanceof ShareBean.DataBean.ListBean){
                    ShareBean.DataBean.ListBean shareItem = (ShareBean.DataBean.ListBean) adapter.getItem(position);
                    CommonViewUtils.toWebView(shareItem.getUrl());
                }else if (adapter.getItem(position) instanceof ArticleBean.DataBean.ListBean){
                    ArticleBean.DataBean.ListBean item = (ArticleBean.DataBean.ListBean) adapter.getItem(position);
                    HomeServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getId(),item.getTitle());
                }
            }
        });
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mCenterArticlePresenter = PresenterManager.getInstance().getUserCenterArticlePresenter();
        mCenterArticlePresenter.registerViewCallback(this);
        switch (mDataType) {
            case Constants.DATA_TPTE_ARTICLE:
                mCenterArticlePresenter.getArticleList(mUserId);
                break;
            case Constants.DATA_TPTE_SHARA:
                mCenterArticlePresenter.getShareList(mUserId);
                break;
            case Constants.DATA_TPTE_WENDA:
                mCenterArticlePresenter.getWendaList(mUserId);
                break;
        }
    }


    @Override
    public void setArticleData(ArticleBean data) {
        setupState(State.SUCCESS);
        LogUtils.d("ArticleData","ArticleData data success");
        LogUtils.d("test", "data == " + data.getData().getList());
        LogUtils.d("test", "data == " + mAdapter);
//        mAdapter.setList(data.getData().getList());
        mAdapter.addData(data.getData().getList());
        finishRefresh();
        if (!data.getData().getHasNext()) {
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    private void finishRefresh() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void setShareData(ShareBean data) {
        LogUtils.d("ShareData","ShareData data success");
        mAdapter.setList(data.getData().getList());
        finishRefresh();
        if (!data.getData().getHasNext()) {
            mRefreshLayout.setEnableLoadMore(false);
        }
        setupState(State.SUCCESS);
    }

    @Override
    public void setWendaData(UserWendaBean data) {
        setupState(State.SUCCESS);
        LogUtils.d("WendaData","WendaData data success");
        mAdapter.setList(data.getData().getContent());
        finishRefresh();
        if (data.getData().getLast()) {
            mRefreshLayout.setEnableLoadMore(false);
        }

    }

    @Override
    public void setArticleDataMore(ArticleBean data) {
        mAdapter.addData(data.getData().getList());
        finishLoading();
    }

    private void finishLoading() {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void setShareDataMore(ShareBean data) {
        mAdapter.addData(data.getData().getList());
        LogUtils.d(UserCenterArticleFragment.class,"setShareDataMore share data == "+data.toString());
        finishLoading();
    }

    @Override
    public void setWendaDataMore(UserWendaBean data) {
        mAdapter.addData(data.getData().getContent());
        finishLoading();
    }

    @Override
    protected void onRetryClick() {
        switch (mDataType) {
            case Constants.DATA_TPTE_ARTICLE:
                mCenterArticlePresenter.getArticleList(mUserId);
                break;
            case Constants.DATA_TPTE_SHARA:
                mCenterArticlePresenter.getShareList(mUserId);
                break;
            case Constants.DATA_TPTE_WENDA:
                mCenterArticlePresenter.getWendaList(mUserId);
                break;
        }
    }

    @Override
    protected void relese() {
        super.relese();
        mCenterArticlePresenter.unregisterViewCallback();
    }

    @Override
    public void ToastErrorMsg(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void onError() {
        setupState(State.ERROR);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {
        setupState(State.EMPTY);
    }
}
