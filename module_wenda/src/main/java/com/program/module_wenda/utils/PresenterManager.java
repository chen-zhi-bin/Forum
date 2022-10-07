package com.program.module_wenda.utils;

import com.program.module_wenda.presenter.IWendaDetailPresenter;
import com.program.module_wenda.presenter.Impl.WendaDetailPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private IWendaDetailPresenter mWendaDetailPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IWendaDetailPresenter getWendaDetailPresenter() {
        return mWendaDetailPresenter;
    }

    private PresenterManager(){
        mWendaDetailPresenter = new WendaDetailPresenterImpl();
    }
}
