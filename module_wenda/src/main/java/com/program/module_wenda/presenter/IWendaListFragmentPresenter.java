package com.program.module_wenda.presenter;

import com.program.module_wenda.callback.IWendaListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IWendaListFragmentPresenter extends IBasePresenter<IWendaListFragmentCallback> {
    void getWendaList(String wendaType);

    void getWendaListMore(String wendaType);
}
