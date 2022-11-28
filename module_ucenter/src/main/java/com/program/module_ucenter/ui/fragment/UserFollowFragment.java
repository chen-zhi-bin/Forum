package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.FollowAdapter;
import com.program.module_ucenter.callback.IUserFollowFragmentCallback;
import com.program.module_ucenter.callback.IUserFragmentCallback;
import com.program.module_ucenter.model.domain.FollowListBean;
import com.program.module_ucenter.presenter.IUserFollowFragmentPresenter;
import com.program.module_ucenter.presenter.IUserFragmentPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import kotlin.collections.CollectionsKt;

public class UserFollowFragment extends BaseFragment implements IUserFollowFragmentCallback {

    private String mUserId;
    private int mPageType;
    private FollowAdapter mAdapter;
    private IUserFollowFragmentPresenter mUsrFollowFragmentPresenter;
    private SmartRefreshLayout mRefreshLayout;


    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        onLoading();
        mUserId = requireArguments().getString("userId");
        mPageType = requireArguments().getInt(Constants.Ucenter.PAGE_TYPE);
        mAdapter = new FollowAdapter(CollectionsKt.mutableListOf());
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initPresenter() {
        mUsrFollowFragmentPresenter = PresenterManager.getInstance().getUsrFollowFragmentPresenter();
        mUsrFollowFragmentPresenter.registerViewCallback(this);
        switch (mPageType){
            case Constants.Ucenter.PAGE_FOLLOW:
                mUsrFollowFragmentPresenter.getFollowList(mUserId);
                break;
            case Constants.Ucenter.PAGE_FANS:
                mUsrFollowFragmentPresenter.getFansList(mUserId);
                break;
        }
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                if (item instanceof FollowListBean.DataBean.ListBean) {
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((FollowListBean.DataBean.ListBean) item).getUserId());
                }
            }
        });
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                switch (mPageType){
                    case Constants.Ucenter.PAGE_FOLLOW:
                        mUsrFollowFragmentPresenter.getFollowList(mUserId);
                        break;
                    case Constants.Ucenter.PAGE_FANS:
                        mUsrFollowFragmentPresenter.getFansList(mUserId);
                        break;
                }
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                switch (mPageType){
                    case Constants.Ucenter.PAGE_FOLLOW:
                        mUsrFollowFragmentPresenter.getMoreFollowList(mUserId);
                        break;
                        case Constants.Ucenter.PAGE_FANS:
                            mUsrFollowFragmentPresenter.getMoreFansList(mUserId);
                            break;
                }
            }
        });
    }

    private void finishRefresh(){
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    private void finishLoadMore(){
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void setFollowList(FollowListBean data) {
        setupState(State.SUCCESS);
        finishRefresh();
        List<FollowListBean.DataBean.ListBean> list = data.getData().getList();
        if (list!=null){
            mAdapter.getData().clear();
            mAdapter.addData(list);
        }
        if (!data.getData().getHasNext()){
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    public void setMoreFollowList(FollowListBean data) {
        finishLoadMore();
        List<FollowListBean.DataBean.ListBean> list = data.getData().getList();
        if (list!=null&&list.size()>0){
            mAdapter.addData(list);
        }else {
            ToastUtils.showToast("暂无数据");
        }
    }

    @Override
    public void setFansList(FollowListBean data) {
        setupState(State.SUCCESS);
        finishRefresh();
        List<FollowListBean.DataBean.ListBean> list = data.getData().getList();
        if (list != null) {
            mAdapter.getData().clear();
            mAdapter.addData(list);
        }
        if (!data.getData().getHasNext()) {
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    public void setMoreFansList(FollowListBean data) {
        finishLoadMore();
        List<FollowListBean.DataBean.ListBean> list = data.getData().getList();
        if (list != null) {
            mAdapter.addData(list);
        }else {
            ToastUtils.showToast("暂无更多");
        }
    }

    @Override
    public void onMsgError(String error) {
        onError();
        ToastUtils.showToast(error);
    }

    @Override
    protected void onRetryClick() {
        switch (mPageType){
            case Constants.Ucenter.PAGE_FOLLOW:
                mUsrFollowFragmentPresenter.getFollowList(mUserId);
                break;
            case Constants.Ucenter.PAGE_FANS:
                mUsrFollowFragmentPresenter.getFansList(mUserId);
                break;
        }
    }

    @Override
    protected void relese() {
        super.relese();
        mUsrFollowFragmentPresenter.unregisterViewCallback(this);
    }

    @Override
    public LifecycleTransformer<Object> getBindLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return  RxLifecycle.bind(objectBehaviorSubject);
    }

    @Override
    public void onError() {
        setupState(State.ERROR);
    }

    @Override
    public void onLoading() {
        setupState(State.LOADING);
    }

    @Override
    public void onEmpty() {
        setupState(State.EMPTY);
    }
}
