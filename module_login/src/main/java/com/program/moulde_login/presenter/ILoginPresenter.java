package com.program.moulde_login.presenter;

import com.program.moudle_base.base.IBasePresenter;
import com.program.moudle_base.model.User;
import com.program.moulde_login.view.ILoginCallback;

public interface ILoginPresenter extends IBasePresenter<ILoginCallback> {

    /**
     *
     * @param code      验证码
     * @param user
     * @param key       验证码图中的key
     */
    void getLogin(String code, User user,String key);


    void getTokenMessage(String token);
}
