package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserRankingFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserRankingFragmentPresenter extends IBasePresenter<IUserRankingFragmentCallback> {

    void getRankingSob();

}
