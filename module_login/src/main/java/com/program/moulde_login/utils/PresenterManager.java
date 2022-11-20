package com.program.moulde_login.utils;

import com.program.moulde_login.presenter.IForgetPresenter;
import com.program.moulde_login.presenter.ILoginPresenter;
import com.program.moulde_login.presenter.IRegisterPresenter;
import com.program.moulde_login.presenter.Impl.ForgetPresenterImpl;
import com.program.moulde_login.presenter.Impl.LoginPresenterImpl;
import com.program.moulde_login.presenter.Impl.RegisterPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IRegisterPresenter mRegisterPresenter;
    private final IForgetPresenter mForgetPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    private PresenterManager(){
        mLoginPresenter = new LoginPresenterImpl();
        mRegisterPresenter = new RegisterPresenterImpl();
        mForgetPresenter = new ForgetPresenterImpl();
    }

    public IForgetPresenter getForgetPresenter() {
        return mForgetPresenter;
    }

    public IRegisterPresenter getRegisterPresenter() {
        return mRegisterPresenter;
    }

    private final ILoginPresenter mLoginPresenter;

    public ILoginPresenter getLoginPresenter() {
        return mLoginPresenter;
    }
}
