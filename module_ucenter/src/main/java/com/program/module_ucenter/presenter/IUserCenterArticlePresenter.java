package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserCenterArticleCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserCenterArticlePresenter extends IBasePresenter<IUserCenterArticleCallback> {

    void getArticleList(String type,String userId);

    void getShareList(String type,String userId);

    void getWendaList(String type,String userId);

    void getArticleListMore(String type,String userId);

    void getShareListMore(String type,String userId);

    void getWendaListMore(String type,String userId);

}
