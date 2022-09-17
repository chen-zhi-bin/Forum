package com.program.module_ucenter.utils;

import com.program.module_ucenter.presenter.IMsgCenterPresenter;
import com.program.module_ucenter.presenter.ISettingPresenter;
import com.program.module_ucenter.presenter.IUserFragmentPresenter;
import com.program.module_ucenter.presenter.Impl.MsgCenterPresenterImpl;
import com.program.module_ucenter.presenter.Impl.SettingPresenterImpl;
import com.program.module_ucenter.presenter.Impl.UserFragmentPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IUserFragmentPresenter mUserFragmentPresenter;
    private final ISettingPresenter mSettingPresenter;
    private final IMsgCenterPresenter mMsgCenterPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IUserFragmentPresenter getUserFragmentPresenter() {
        return mUserFragmentPresenter;
    }

    public ISettingPresenter getSettingPresenter() {
        return mSettingPresenter;
    }

    public IMsgCenterPresenter getMsgCenterPresenter() {
        return mMsgCenterPresenter;
    }

    private PresenterManager(){
        mUserFragmentPresenter = new UserFragmentPresenterImpl();
        mSettingPresenter = new SettingPresenterImpl();
        mMsgCenterPresenter = new MsgCenterPresenterImpl();
    }
}
