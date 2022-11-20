package com.program.moulde_login.view;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;

public interface IForgetCallback extends IBaseCallback {

    void setForgetSmsCode(BaseResponseBean data);

    void setForget(BaseResponseBean data);

}
