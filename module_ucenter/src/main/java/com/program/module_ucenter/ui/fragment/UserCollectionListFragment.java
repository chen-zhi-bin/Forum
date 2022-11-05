package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.CollectionFolderAdapter;
import com.program.module_ucenter.callback.IUserCollectionListFragmentCallback;
import com.program.module_ucenter.presenter.IUserCollectionListFragmentPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.CollectionBean;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class UserCollectionListFragment extends BaseFragment implements IUserCollectionListFragmentCallback {

    private String mUserId;
    private IUserCollectionListFragmentPresenter mUserCollectionListFragmentPresenter;
    private CollectionFolderAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_collection_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mUserId = requireArguments().getString("userId");
        mAdapter = new CollectionFolderAdapter();
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initPresenter() {
        mUserCollectionListFragmentPresenter = PresenterManager.getInstance().getUserCollectionListFragmentPresenter();
        mUserCollectionListFragmentPresenter.registerViewCallback(this);
        mUserCollectionListFragmentPresenter.getCollectionList();
    }

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> mUserCollectionListFragmentPresenter.getCollectionList());
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> mUserCollectionListFragmentPresenter.getMoreCollectionList());
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                if (item instanceof CollectionBean.DataBean.ContentBean){
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchFavoriteList((CollectionBean.DataBean.ContentBean)item);
                }
            }
        });
    }

    @Override
    public void setCollectionList(CollectionBean data) {
        setupState(State.SUCCESS);
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
        if (data.getData().getContent()!=null){
            mAdapter.getData().clear();
            mAdapter.addData(data.getData().getContent());
        }
        if (data.getData().getLast()){
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    public void setMoreCollectionList(CollectionBean data) {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
        if (data.getData().getContent()!=null){
            mAdapter.addData(data.getData().getContent());
        }
        if (data.getData().getLast()){
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    public void onMsgError(String error) {
        onError();
        ToastUtils.showToast(error);
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
