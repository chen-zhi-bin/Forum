package com.program.module_moyu.utils;

import com.program.module_moyu.presenter.IMoyuDetailPresenter;
import com.program.module_moyu.presenter.Impl.MoyuDetailPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IMoyuDetailPresenter mMoyuDetailPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IMoyuDetailPresenter getMoyuDetailPresenter() {
        return mMoyuDetailPresenter;
    }

    private PresenterManager(){
        mMoyuDetailPresenter = new MoyuDetailPresenterImpl();
    }
}
