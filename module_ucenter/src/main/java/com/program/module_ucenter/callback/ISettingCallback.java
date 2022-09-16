package com.program.module_ucenter.callback;

import androidx.lifecycle.Lifecycle;

import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle3.LifecycleProvider;

public interface ISettingCallback extends IBaseCallback {

    void loginoutSuccess(String msg);

    void getErrorMessage(String msg);

    /**
     * 计划是绑定rxjava的生命周期使用
     * @return
     */
    LifecycleProvider<Lifecycle.Event> getBindToLifecycle();

}
