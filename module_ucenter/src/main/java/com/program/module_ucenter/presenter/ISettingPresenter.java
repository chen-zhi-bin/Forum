package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.ISettingCallback;
import com.program.moudle_base.base.IBasePresenter;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface ISettingPresenter extends IBasePresenter<ISettingCallback> {
    void loginout();


    void registerLifecycleTransformer(LifecycleTransformer<Object> objectLifecycleTransformer);
}
