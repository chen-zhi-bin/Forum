package com.program.moulde_login.utils;

import com.program.moulde_login.presenter.ILoginPresenter;
import com.program.moulde_login.presenter.Impl.LoginPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    private PresenterManager(){
        mLoginPresenter = new LoginPresenterImpl();
    }

    private final ILoginPresenter mLoginPresenter;

    public ILoginPresenter getLoginPresenter() {
        return mLoginPresenter;
    }
}
