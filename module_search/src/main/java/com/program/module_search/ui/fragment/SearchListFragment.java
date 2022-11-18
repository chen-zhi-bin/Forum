package com.program.module_search.ui.fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.event.UpdateItemEvent;
import com.program.module_search.R;
import com.program.module_search.callback.ISearchListFragmentCallback;
import com.program.module_search.model.bean.SearchListBean;
import com.program.module_search.presenter.ISearchListFragmentPresenter;
import com.program.module_search.ui.adapter.SearchListAdapter;
import com.program.module_search.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.EventBusUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class SearchListFragment extends BaseFragment implements ISearchListFragmentCallback {

    private String mType;
    private RecyclerView mRvList;
    private SmartRefreshLayout mRefreshLayout;
    private ISearchListFragmentPresenter mSearchListFragmentPresenter;
    private String mKeyword;
    private SearchListAdapter mAdapter;

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.transparent, R.color.colorPrimary);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.modulesearch_fragment_list;
    }

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mSearchListFragmentPresenter.getSearchList(mKeyword,mType);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSearchListFragmentPresenter.getSearchListMore(mKeyword,mType);
            }
        });
    }

    @Override
    protected void initPresenter() {
        mSearchListFragmentPresenter = PresenterManager.getInstance().getSearchListFragmentPresenter();
        mSearchListFragmentPresenter.registerViewCallback(this);
    }

    @Subscribe
    @Override
    public void initView(View rootView) {
        setupState(State.SUCCESS);
        mType = getArguments().getString(Constants.Search.SEARCH_TYPE);
        LogUtils.d("test","type = "+mType);
        mAdapter = new SearchListAdapter();
        mRvList = rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        if (!EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.register(this);
        }
    }

    /**
     * SearchActivity 输入框改变是通知这
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshSearch(String s){
        if (s!=null&&!s.equals("")){
            mKeyword = s;
            LogUtils.d(SearchListFragment.class,"keyword = "+s);
            mSearchListFragmentPresenter.getSearchList(mKeyword,mType);
        }
    }

    @Override
    public void setSearchResults(SearchListBean data) {
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
        LogUtils.d("test","data = "+data.toString());
        if (data.getSuccess()){
            mAdapter.getData().clear();
            mAdapter.addData(data.getData().getList());
        }else {
            ToastUtils.showToast(data.getMessage());
            setupState(State.EMPTY);
        }

        if (!data.getData().getHasNext()){
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    public void setSearchMoreResults(SearchListBean data) {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
        LogUtils.d("test","load more = "+data.toString());
        if (data.getSuccess()){
            mAdapter.addData(data.getData().getList());
        }
    }

    @Override
    public void serErrorMsg(String msg) {
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

    @Override
    public void onDestroy() {
        if (EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.unRegister(this);
        }
        super.onDestroy();
    }
}
