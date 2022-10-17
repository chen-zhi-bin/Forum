package com.program.module_wenda.callback;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IWendaAnswerCallback extends IBaseCallback {

    void replyAnswerReturn(BaseResponseBean data);

    LifecycleTransformer<Object> TobindToLifecycle();

    void setRequestError(String msg);
}
