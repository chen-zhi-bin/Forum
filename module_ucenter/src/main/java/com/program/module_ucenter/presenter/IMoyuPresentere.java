package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IMoyuCallback;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IMoyuPresentere extends IBasePresenter<IMoyuCallback> {

    void getMoyuYpdateInfo(String moyuId);

    void getMoyuList(String userId);

    void getMoyuListMore();
}
