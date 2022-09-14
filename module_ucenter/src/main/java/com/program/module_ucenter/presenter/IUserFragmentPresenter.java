package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserFragmentPresenter extends IBasePresenter<IUserFragmentCallback> {
    void getAvatar();

    void getUserMsg();

    void getUserAchievement();
}
