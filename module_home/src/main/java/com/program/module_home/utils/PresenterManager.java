package com.program.module_home.utils;

import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.presenter.Impl.ArticleDetailPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IArticleDetailPresenter mArticleDetailPresenter;


    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IArticleDetailPresenter getArticleDetailPresenter() {
        return mArticleDetailPresenter;
    }

    private PresenterManager(){
        mArticleDetailPresenter = new ArticleDetailPresenterImpl();
    }
}
