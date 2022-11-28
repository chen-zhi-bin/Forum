package com.program.module_moyu.presenter;

import com.program.module_moyu.callback.IMoyuListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IMoyuListFragmentPresenter extends IBasePresenter<IMoyuListFragmentCallback> {

    void getRecommendList(String key);

    void getRecommendListMore(String key);

    void getFollowList(String key);

    void getFollowListMore(String key);

    void getList(String topicId);

    void getListMore(String topicId);

    void getUpdateMoyuInfo(String key,String moyuid);

}
