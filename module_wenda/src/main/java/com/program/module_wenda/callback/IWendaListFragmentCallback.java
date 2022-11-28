package com.program.module_wenda.callback;

import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaListBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IWendaListFragmentCallback extends IBaseCallback {

    String getWendaType();

    void setWendaList(WendaListBean data);

    void setWendaListMore(WendaListBean data);

    void setErrorMsg(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();
}
