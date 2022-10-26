package com.program.module_home.presenter;

import com.program.module_home.callback.IPriseListActivityCallback;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IPriseListActivityPresenter extends IBasePresenter<IPriseListActivityCallback> {

    void getPriseList(String articleId);

}
