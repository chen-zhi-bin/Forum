package com.program.module_ucenter.presenter.Impl;

import com.program.module_ucenter.callback.IFavoriteListCallback;
import com.program.module_ucenter.presenter.IFavoriteListPresenter;

public class FavoriteListPresenterImpl implements IFavoriteListPresenter {

    private IFavoriteListCallback mCallback = null;

    @Override
    public void getFavoriteList(String collectionId) {
        
    }

    @Override
    public void registerViewCallback(IFavoriteListCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
