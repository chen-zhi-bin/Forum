package com.program.module_wenda.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.lib_common.service.wenda.wrap.WendaServiceWrap;
import com.program.module_wenda.R;
import com.program.module_wenda.adapter.WendaAdapter;
import com.program.module_wenda.callback.IWendaListFragmentCallback;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaListBean;
import com.program.module_wenda.presenter.IWendaListFragmentPresenter;
import com.program.module_wenda.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class WendaListFragment extends BaseFragment implements IWendaListFragmentCallback {

    private String mWendaType;
    private IWendaListFragmentPresenter mWendaListFragmentPresenter;
    private WendaAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulewenda_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mWendaType = requireArguments().getString(Constants.Wenda.WENDA_TYPE, Constants.Wenda.WENDA_LASTEST);
        LogUtils.d(WendaListFragment.class,"wendaType = "+mWendaType);
        mAdapter = new WendaAdapter();
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);

    }

    @Override
    protected void initPresenter() {
        mWendaListFragmentPresenter = PresenterManager.getInstance().getWendaListFragmentPresenter();
        mWendaListFragmentPresenter.registerViewCallback(this);
        mWendaListFragmentPresenter.getWendaList(mWendaType);
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            WendaListBean.DataBean.ListBean item = (WendaListBean.DataBean.ListBean) adapter.getItem(position);
            int id = view.getId();
            if (id == R.id.iv_avatar||id==R.id.tv_nickname){
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getUserId());
            }

        });
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            WendaListBean.DataBean.ListBean item = (WendaListBean.DataBean.ListBean) adapter.getItem(position);
            WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getId());
        });
        mRefreshLayout.setOnRefreshListener(refreshLayout -> mWendaListFragmentPresenter.getWendaList(mWendaType));
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> mWendaListFragmentPresenter.getWendaListMore(mWendaType));
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
    public void setWendaList(WendaListBean data) {
        setupState(State.SUCCESS);
        finishRefresh();
        List<WendaListBean.DataBean.ListBean> list = data.getData().getList();
        if (list != null) {
            mAdapter.getData().clear();
            mAdapter.addData(list);
        }
    }

    @Override
    public void setWendaListMore(WendaListBean data) {
        finishLoadMore();
        List<WendaListBean.DataBean.ListBean> list = data.getData().getList();
        if (list != null) {
            mAdapter.addData(list);
        }
    }

    @Override
    public void setErrorMsg(String msg) {
        onError();
        ToastUtils.showToast(msg);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
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
