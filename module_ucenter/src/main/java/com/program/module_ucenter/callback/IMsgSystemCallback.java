package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.MsgSystemBean;
import com.program.moudle_base.base.IBaseCallback;

public interface IMsgSystemCallback extends IBaseCallback {
    void setMsgSystem(MsgSystemBean data);

    void setLoadMoreMsgSysten(MsgSystemBean data);

    void setReturnErrorMsg(String msg);
}
