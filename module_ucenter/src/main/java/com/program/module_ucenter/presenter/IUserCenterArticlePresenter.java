package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserCenterArticleCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserCenterArticlePresenter extends IBasePresenter<IUserCenterArticleCallback> {

    void getArticleList(String userId);

    void getShareList(String userId);

    void getWendaList(String userId);

    void getArticleListMore(String userId);

    void getShareListMore(String userId);

    void getWendaListMore(String userId);

}
