package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IMsgListCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IMsgListPresenter extends IBasePresenter<IMsgListCallback> {

    void getMsgListAt();

    void getMoreMsgListAt();

    void getMsgThumbList();

    void getMoreMsgThumbList();

    void getMsgMomentList();

    void getMoreMsgMomentList();

    void getMsgArticleList();

    void getMoreMsgArticleList();

    void getMsgWendaList();

    void getMoreMsgWendaList();
}
