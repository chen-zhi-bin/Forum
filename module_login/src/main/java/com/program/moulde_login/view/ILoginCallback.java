package com.program.moulde_login.view;

import com.program.moudle_base.base.IBaseCallback;

public interface ILoginCallback extends IBaseCallback {

    void onResultLoginSuccess(String message);

    void onLoginError(String message);
}
