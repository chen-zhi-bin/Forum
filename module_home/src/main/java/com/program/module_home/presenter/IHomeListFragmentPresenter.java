package com.program.module_home.presenter;

import com.program.module_home.callback.IHomeListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IHomeListFragmentPresenter extends IBasePresenter<IHomeListFragmentCallback> {

    void getUpdateArticleInfo(String key,String id);

    void getRecommend(String key,String id);

    void getRecommendMore(String id);
}
