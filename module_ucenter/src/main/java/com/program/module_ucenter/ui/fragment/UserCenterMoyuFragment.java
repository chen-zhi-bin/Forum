package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.module_ucenter.R;
import com.program.module_ucenter.callback.IMoyuCallback;
import com.program.module_ucenter.presenter.IMoyuPresentere;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.adapter.MoyuAdapter;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.MoyuItemBean;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;

import java.util.List;

public class UserCenterMoyuFragment extends BaseFragment implements IMoyuCallback{

    private RecyclerView mRvList;
    private String mUserId;
    private IMoyuPresentere mMoyuPreseenter;
    private MoyuAdapter mMoyuAdapter;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);

        mUserId = requireArguments().getString("userId");

//        mUserId = "1153952789488054272";
//        mUserId = "1382711465131241472";
        mRvList = rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mMoyuAdapter = new MoyuAdapter(1);
//        mMoyuAdapter.setOnItemChildClickListener();
        mRvList.setAdapter(mMoyuAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mMoyuPreseenter.getMoyuList(mUserId);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mMoyuPreseenter.getMoyuListMore();
        });
    }

    @Override
    protected void initPresenter() {

        mMoyuPreseenter = PresenterManager.getInstance().getMoyuPreseenter();
        mMoyuPreseenter.registerViewCallback(this);
        mMoyuPreseenter.getMoyuList(mUserId);

    }

    @Override
    public void setMoyuList(List<MoyuItemBean> data) {

//        mMoyuAdapter.addData(data);
        mMoyuAdapter.setNewInstance(data);
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
        setupState(State.SUCCESS);
    }

    //todo:摸鱼更多返回
    @Override
    public void setMoyuListMore(List<MoyuItemBean> data) {
        mMoyuAdapter.addData(data);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void setErrorMsg(String msg) {
        ToastUtils.showToast(msg);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
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
