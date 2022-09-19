package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IMsgListCallback extends IBaseCallback {

    void setMsgAtList(MsgAtBean data);

    void setMoreMsgAtList(MsgAtBean data);

    void setNotMore(String msg);

    LifecycleTransformer<Object> getBindLifecycle();

    void setError(String s);
}
