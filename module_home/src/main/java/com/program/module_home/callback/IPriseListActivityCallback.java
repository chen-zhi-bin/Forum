package com.program.module_home.callback;

import com.program.module_home.model.bean.PriseArticleBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IPriseListActivityCallback extends IBaseCallback {

    void setPriseList(PriseArticleBean data);

    void serErrorMsg(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();
}
