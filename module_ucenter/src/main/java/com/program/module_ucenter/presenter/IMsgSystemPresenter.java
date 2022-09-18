package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IMsgSystemCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IMsgSystemPresenter extends IBasePresenter<IMsgSystemCallback> {

    void getMsgSystem();

    void getloadmoreMsgSystem();
}
