package com.program.module_wenda.utils;

import com.program.module_wenda.presenter.IWendaAnswerPresenter;
import com.program.module_wenda.presenter.IWendaDetailPresenter;
import com.program.module_wenda.presenter.Impl.WendaAnswerPresenterImpl;
import com.program.module_wenda.presenter.Impl.WendaDetailPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private IWendaDetailPresenter mWendaDetailPresenter;
    private final IWendaAnswerPresenter mWendaAnswerPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IWendaDetailPresenter getWendaDetailPresenter() {
        return mWendaDetailPresenter;
    }

    public IWendaAnswerPresenter getWendaAnswerPresenter() {
        return mWendaAnswerPresenter;
    }

    private PresenterManager(){
        mWendaDetailPresenter = new WendaDetailPresenterImpl();
        mWendaAnswerPresenter = new WendaAnswerPresenterImpl();
    }
}
