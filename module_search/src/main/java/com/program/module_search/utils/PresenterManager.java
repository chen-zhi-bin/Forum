package com.program.module_search.utils;

import com.program.module_search.presenter.ISearchListFragmentPresenter;
import com.program.module_search.presenter.Impl.SearchListFragmentPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final ISearchListFragmentPresenter mSearchListFragmentPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public ISearchListFragmentPresenter getSearchListFragmentPresenter() {
        return mSearchListFragmentPresenter;
    }

    private PresenterManager(){
        mSearchListFragmentPresenter = new SearchListFragmentPresenterImpl();
    }
}
