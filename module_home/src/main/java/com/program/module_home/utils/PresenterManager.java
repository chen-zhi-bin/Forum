package com.program.module_home.utils;

import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.presenter.IHomeMainFragmentPresenter;
import com.program.module_home.presenter.IPriseListActivityPresenter;
import com.program.module_home.presenter.Impl.ArticleDetailPresenterImpl;
import com.program.module_home.presenter.Impl.HomeListFragmentPresenterImpl;
import com.program.module_home.presenter.Impl.HomeMainFragmentPresenterImpl;
import com.program.module_home.presenter.Impl.PriseListActivityPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IArticleDetailPresenter mArticleDetailPresenter;
    private final IPriseListActivityPresenter mPriseListActivityPresenter;
    private final IHomeMainFragmentPresenter mHomeMainFragmentPresenter;
    private final HomeListFragmentPresenterImpl mHomeListFragmentPresenter;


    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IArticleDetailPresenter getArticleDetailPresenter() {
        return mArticleDetailPresenter;
    }

    public IPriseListActivityPresenter getPriseListActivityPresenter() {
        return mPriseListActivityPresenter;
    }

    public IHomeMainFragmentPresenter getHomeMainFragmentPresenter() {
        return mHomeMainFragmentPresenter;
    }

    public HomeListFragmentPresenterImpl getHomeListFragmentPresenter() {
        return mHomeListFragmentPresenter;
    }

    private PresenterManager(){
        mArticleDetailPresenter = new ArticleDetailPresenterImpl();
        mPriseListActivityPresenter = new PriseListActivityPresenterImpl();
        mHomeMainFragmentPresenter = new HomeMainFragmentPresenterImpl();
        mHomeListFragmentPresenter = new HomeListFragmentPresenterImpl();
    }
}
