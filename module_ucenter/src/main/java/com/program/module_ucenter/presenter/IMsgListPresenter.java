package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IMsgListCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IMsgListPresenter extends IBasePresenter<IMsgListCallback> {

    void getMsgListAt();

    void getMoreMsgListAt();
}
