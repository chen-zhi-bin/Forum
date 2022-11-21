package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserInfoActivityCallback;
import com.program.module_ucenter.model.domain.PersonCenterInfo;
import com.program.moudle_base.base.IBasePresenter;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IUserInfoActivityPresenter extends IBasePresenter<IUserInfoActivityCallback> {

    void getUserInfo();

    void modifyUserInfo(PersonCenterInfo personCenterInfo);

}
