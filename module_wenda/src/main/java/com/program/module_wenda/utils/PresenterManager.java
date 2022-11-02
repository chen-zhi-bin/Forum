package com.program.module_wenda.utils;

import com.program.module_wenda.presenter.IWendaAnswerPresenter;
import com.program.module_wenda.presenter.IWendaDetailPresenter;
import com.program.module_wenda.presenter.IWendaListFragmentPresenter;
import com.program.module_wenda.presenter.IWendaRankingFragmentPresenter;
import com.program.module_wenda.presenter.Impl.WendaAnswerPresenterImpl;
import com.program.module_wenda.presenter.Impl.WendaDetailPresenterImpl;
import com.program.module_wenda.presenter.Impl.WendaListFragmentPresenterImpl;
import com.program.module_wenda.presenter.Impl.WendaRankingFragmentPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private IWendaDetailPresenter mWendaDetailPresenter;
    private final IWendaAnswerPresenter mWendaAnswerPresenter;
    private final IWendaListFragmentPresenter mWendaListFragmentPresenter;
    private final IWendaRankingFragmentPresenter mWendaRankingFragmentPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IWendaDetailPresenter getWendaDetailPresenter() {
        return mWendaDetailPresenter;
    }

    public IWendaAnswerPresenter getWendaAnswerPresenter() {
        return mWendaAnswerPresenter;
    }

    public IWendaListFragmentPresenter getWendaListFragmentPresenter() {
        return mWendaListFragmentPresenter;
    }

    public IWendaRankingFragmentPresenter getWendaRankingFragmentPresenter() {
        return mWendaRankingFragmentPresenter;
    }

    private PresenterManager(){
        mWendaDetailPresenter = new WendaDetailPresenterImpl();
        mWendaAnswerPresenter = new WendaAnswerPresenterImpl();
        mWendaListFragmentPresenter = new WendaListFragmentPresenterImpl();
        mWendaRankingFragmentPresenter = new WendaRankingFragmentPresenterImpl();
    }
}
