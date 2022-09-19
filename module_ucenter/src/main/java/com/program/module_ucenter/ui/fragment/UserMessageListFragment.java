package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.MsgListAdapter;
import com.program.module_ucenter.callback.IMsgListCallback;
import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.module_ucenter.model.domain.MsgBean;
import com.program.module_ucenter.presenter.IMsgListPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;

import java.util.ArrayList;
import java.util.List;

public class UserMessageListFragment extends BaseFragment implements IMsgListCallback {

    private int pageType = 0;
    private RecyclerView mRvList;
    private SmartRefreshLayout mRefreshLayout;
    private MsgListAdapter mAdapter;
    private IMsgListPresenter mMsgListPresenter;
    private List<MsgBean> mMsgAtList = new ArrayList<>();

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
        pageType = requireArguments().getInt("pageType");
        mRvList = rootView.findViewById(R.id.rv_list);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        mAdapter = new MsgListAdapter(R.layout.moduleucenter_adapter_msg_list, mMsgAtList);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mRvList.setAdapter(mAdapter);

    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                switch (pageType){
                    case Constants.Ucenter.PAGE_MSG_AT:
                        mMsgListPresenter.getMsgListAt();
                        break;
                }
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                switch (pageType){
                    case Constants.Ucenter.PAGE_MSG_AT:
                        mMsgListPresenter.getMoreMsgListAt();
                        break;
                }
            }
        });

        mAdapter.addChildClickViewIds(R.id.iv_avatar);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.iv_avatar){
                    String uId;
                    Object item = adapter.getItem(position);
                    if (item instanceof MsgAtBean.DataBean.ContentBean){
                        uId = ((MsgAtBean.DataBean.ContentBean) item).getUid();
                        ToastUtils.showToast(uId);
                    }
                }
            }
        });
    }

    @Override
    protected void initPresenter() {
        mMsgListPresenter = PresenterManager.getInstance().getMsgListPresenter();
        mMsgListPresenter.registerViewCallback(this);
        switch (pageType){
            case Constants.Ucenter.PAGE_MSG_AT:
                    mMsgListPresenter.getMsgListAt();
                break;
        }
    }

    @Override
    public void setMsgAtList(MsgAtBean data) {
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
        LogUtils.d("test","data size = "+data.getData().getContent().size());
        mMsgAtList.clear();
        mMsgAtList.addAll(data.getData().getContent());
       mAdapter.addData(mMsgAtList);
       mAdapter.notifyDataSetChanged();
       
    }

    @Override
    public void setMoreMsgAtList(MsgAtBean data) {
        List<MsgBean> msgBeanList = new ArrayList<>();
        msgBeanList.addAll(data.getData().getContent());
        mAdapter.addData(msgBeanList);
        if (mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void setNotMore(String msg) {
        ToastUtils.showToast(msg);
        if (mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public LifecycleTransformer<Object> getBindLifecycle() {
        return null;
    }

    @Override
    public void setError(String s) {
        ToastUtils.showToast(s);
        if (mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
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

    public interface onMessageListListener{
        LifecycleTransformer<Object> getBindLifecycle();
    }
}
