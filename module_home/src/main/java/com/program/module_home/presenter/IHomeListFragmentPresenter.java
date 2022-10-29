package com.program.module_home.presenter;

import com.program.module_home.callback.IHomeListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IHomeListFragmentPresenter extends IBasePresenter<IHomeListFragmentCallback> {

    void getRecommend(String id);

    void getRecommendMore(String id);
}
