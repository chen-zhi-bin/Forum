package com.program.module_ucenter.ui.fragment;

import android.view.View;

import com.program.module_ucenter.R;
import com.program.module_ucenter.callback.IUserCollectionListFragmentCallback;
import com.program.module_ucenter.presenter.IUserCollectionListFragmentPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;

public class UserCollectionListFragment extends BaseFragment implements IUserCollectionListFragmentCallback {

    private String mUserId;
    private IUserCollectionListFragmentPresenter mUserCollectionListFragmentPresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_collection_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mUserId = requireArguments().getString("userId");
    }

    @Override
    protected void initPresenter() {
        mUserCollectionListFragmentPresenter = PresenterManager.getInstance().getUserCollectionListFragmentPresenter();
        mUserCollectionListFragmentPresenter.registerViewCallback(this);
    }

    @Override
    protected void initListener() {

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
