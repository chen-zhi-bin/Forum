package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserFollowFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserFollowFragmentPresenter extends IBasePresenter<IUserFollowFragmentCallback> {

    void getFollowList(String userId);

    void getMoreFollowList(String userId);

}
