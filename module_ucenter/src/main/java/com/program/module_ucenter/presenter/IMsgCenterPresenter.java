package com.program.module_ucenter.presenter;


import androidx.lifecycle.Lifecycle;

import com.program.module_ucenter.callback.IMsgCenterCallback;
import com.program.moudle_base.base.IBasePresenter;
import com.trello.rxlifecycle3.LifecycleProvider;

public interface IMsgCenterPresenter extends IBasePresenter<IMsgCenterCallback> {

    void getMsg();

    void readAllMsg();
}
