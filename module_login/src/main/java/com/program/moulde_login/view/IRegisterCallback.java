package com.program.moulde_login.view;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;

public interface IRegisterCallback extends IBaseCallback {
    void setSmsCode(BaseResponseBean data);

    void setRegister(BaseResponseBean data);
}
