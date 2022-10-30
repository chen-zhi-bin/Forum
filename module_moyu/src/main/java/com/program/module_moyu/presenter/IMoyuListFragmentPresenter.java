package com.program.module_moyu.presenter;

import com.program.module_moyu.callback.IMoyuListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IMoyuListFragmentPresenter extends IBasePresenter<IMoyuListFragmentCallback> {

    void getRecommendList();

    void getRecommendListMore();

    void getFollowList();

    void getFollowListMore();

    void getList(String topicId);

    void getListMore(String topicId);

    void getUpdateMoyuInfo(String moyuid);

}