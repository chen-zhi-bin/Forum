package com.program.module_ucenter.callback;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.MoyuItemBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

import java.util.List;

import io.reactivex.rxjava3.core.ObservableTransformer;

public interface IMoyuCallback extends IBaseCallback {
    void setMoyuList(List<MoyuItemBean> data);
    void setMoyuListMore(List<MoyuItemBean> data);
    void setErrorMsg(String msg);


    LifecycleTransformer<Object> TobindToLifecycle();
}
