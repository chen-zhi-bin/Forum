package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.MsgArticleBean;
import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.module_ucenter.model.domain.MsgMomentBean;
import com.program.module_ucenter.model.domain.MsgThumbBean;
import com.program.module_ucenter.model.domain.MsgWendaBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IMsgListCallback extends IBaseCallback {

    void setMsgAtList(MsgAtBean data);

    void setMoreMsgAtList(MsgAtBean data);

    void setNotMore(String msg);

    void setMsgThumbList(MsgThumbBean data);

    void setMoreMsgThumbList(MsgThumbBean data);

    void setMsgMomentList(MsgMomentBean data);

    void setMoreMsgMomentList(MsgMomentBean data);

    void setMsgArticleList(MsgArticleBean data);

    void setMoreMsgArticleList(MsgArticleBean data);

    void setMsgWendaList(MsgWendaBean data);

    void setMoreMsgWendaList(MsgWendaBean data);

    LifecycleTransformer<Object> getBindLifecycle();

    void setError(String s);
}
