package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.UnreadMsgBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;


public interface IMsgCenterCallback extends IBaseCallback {

    void setMsg(UnreadMsgBean data);

    void setReanReturn();

    void onMsgError(String error);


    LifecycleTransformer<Object> getBindLifecycle();
}
