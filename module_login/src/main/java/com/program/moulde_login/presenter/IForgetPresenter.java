package com.program.moulde_login.presenter;

import com.program.moudle_base.base.IBasePresenter;
import com.program.moulde_login.model.bean.SendSmsVo;
import com.program.moulde_login.model.bean.UserVo;
import com.program.moulde_login.view.IForgetCallback;

public interface IForgetPresenter extends IBasePresenter<IForgetCallback> {

    void toSendSms(SendSmsVo sendSmsVo,String key);

    void toForget(UserVo userVo,String sms);
}
