package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.MsgSystemAdapter;
import com.program.module_ucenter.callback.IMsgSystemCallback;
import com.program.module_ucenter.model.domain.MsgSystemBean;
import com.program.module_ucenter.presenter.IMsgSystemPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

public class UserMessageSystemFragment extends BaseFragment implements IMsgSystemCallback {

    private IMsgSystemPresenter mMsgSystemPresenter;
    private MsgSystemAdapter mAdapter;
    private RecyclerView mRvList;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
        mRvList = rootView.findViewById(R.id.rv_list);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initPresenter() {
        mMsgSystemPresenter = PresenterManager.getInstance().getMsgSystemPresenter();
        mMsgSystemPresenter.registerViewCallback(this);
        mMsgSystemPresenter.getMsgSystem();
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mMsgSystemPresenter.getMsgSystem();
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mMsgSystemPresenter.getloadmoreMsgSystem();
            }
        });
    }

    @Override
    public void setMsgSystem(MsgSystemBean data) {
        //MsgSystemAdapter初始化时需要数据
        mAdapter = new MsgSystemAdapter(data.getData().getContent());
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mRvList.setAdapter(mAdapter);

    }

    @Override
    public void setLoadMoreMsgSysten(MsgSystemBean data) {
        mAdapter.addData(data.getData().getContent());
        mRefreshLayout.finishLoadMore();
    }

    @Override
    public void setReturnErrorMsg(String msg) {
        ToastUtils.showToast(msg);
        if (mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    protected void relese() {
        super.relese();
        mMsgSystemPresenter.unregisterViewCallback(this);
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
