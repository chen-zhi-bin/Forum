package com.program.module_ucenter.presenter.Impl;

import com.program.module_ucenter.callback.IUserCollectionListFragmentCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.presenter.IUserCollectionListFragmentPresenter;
import com.program.module_ucenter.utils.RetrofitManager;

public class UserCollectionListFragmentPresenterImpl implements IUserCollectionListFragmentPresenter {
    private IUserCollectionListFragmentCallback mCallback=null;
    private final UcenterApi mApi;

    public UserCollectionListFragmentPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void registerViewCallback(IUserCollectionListFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
