package com.program.module_search.ui.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_search.R;
import com.program.module_search.callback.ISearchListFragmentCallback;
import com.program.module_search.model.bean.SearchListBean;
import com.program.module_search.presenter.ISearchListFragmentPresenter;
import com.program.module_search.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class SearchListFragment extends BaseFragment implements ISearchListFragmentCallback {

    private String mType;
    private RecyclerView mRvList;
    private SmartRefreshLayout mRefreshLayout;
    private ISearchListFragmentPresenter mSearchListFragmentPresenter;


    @Override
    protected int getRootViewResId() {
        return R.layout.modulesearch_fragment_list;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initPresenter() {
        mSearchListFragmentPresenter = PresenterManager.getInstance().getSearchListFragmentPresenter();
        mSearchListFragmentPresenter.registerViewCallback(this);
        mSearchListFragmentPresenter.getSearchList("android",mType);
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        mType = getArguments().getString(Constants.Search.SEARCH_TYPE);
        LogUtils.d("test","type = "+mType);
        mRvList = rootView.findViewById(R.id.rv_list);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);

    }

    @Override
    public void setSearchResults(SearchListBean data) {
        LogUtils.d("test","data = "+data.toString());
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
}
