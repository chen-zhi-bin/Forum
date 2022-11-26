package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.RankingSobAdapter;
import com.program.module_ucenter.callback.IUserRankingFragmentCallback;
import com.program.module_ucenter.model.domain.RankingSobBean;
import com.program.module_ucenter.model.domain.UserWendaBean;
import com.program.module_ucenter.presenter.IUserRankingFragmentPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class UserRankingFragment extends BaseFragment implements IUserRankingFragmentCallback {

    private SmartRefreshLayout mRefreshLayout;
    private IUserRankingFragmentPresenter mUserRankingFragmentPresenter;
    private RankingSobAdapter mAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mAdapter = new RankingSobAdapter();
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        mRefreshLayout.setEnableLoadMore(false);
    }

    @Override
    protected void initPresenter() {
        mUserRankingFragmentPresenter = PresenterManager.getInstance().getUserRankingFragment();
        mUserRankingFragmentPresenter.registerViewCallback(this);
        mUserRankingFragmentPresenter.getRankingSob();
    }

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> mUserRankingFragmentPresenter.getRankingSob());
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                if (item instanceof RankingSobBean.DataBean){
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((RankingSobBean.DataBean) item).getUserId());
                }
            }
        });
    }

    @Override
    public void setRankingSob(RankingSobBean data) {
        setupState(State.SUCCESS);
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
        if (data.getData() != null) {
            mAdapter.getData().clear();
            mAdapter.addData(data.getData());
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
    protected void onRetryClick() {
        mUserRankingFragmentPresenter.getRankingSob();
    }

    @Override
    protected void relese() {
        super.relese();
        mUserRankingFragmentPresenter.unregisterViewCallback();
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
