package com.program.module_home.utils;

import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.presenter.IPriseListActivityPresenter;
import com.program.module_home.presenter.Impl.ArticleDetailPresenterImpl;
import com.program.module_home.presenter.Impl.PriseListActivityPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IArticleDetailPresenter mArticleDetailPresenter;
    private final IPriseListActivityPresenter mPriseListActivityPresenter;


    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IArticleDetailPresenter getArticleDetailPresenter() {
        return mArticleDetailPresenter;
    }

    public IPriseListActivityPresenter getPriseListActivityPresenter() {
        return mPriseListActivityPresenter;
    }

    private PresenterManager(){
        mArticleDetailPresenter = new ArticleDetailPresenterImpl();
        mPriseListActivityPresenter = new PriseListActivityPresenterImpl();
    }
}
