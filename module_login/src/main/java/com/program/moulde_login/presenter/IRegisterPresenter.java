package com.program.moulde_login.presenter;

import com.program.moudle_base.base.IBasePresenter;
import com.program.moulde_login.model.bean.SendSmsVo;
import com.program.moulde_login.model.bean.UserR;
import com.program.moulde_login.view.IRegisterCallback;

public interface IRegisterPresenter extends IBasePresenter<IRegisterCallback> {
    void getSmsCode(SendSmsVo sendSmsVo,String key);

    void postRegister(UserR user, String sms);
}
