package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.UcenterInfo;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IUserInfoActivityCallback extends IBaseCallback {

    void setUserInfo(UcenterInfo data);

    void setErrorMsg(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();
}
