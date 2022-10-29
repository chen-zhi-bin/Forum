package com.program.module_moyu.utils;

import com.program.module_moyu.presenter.IMoyuDetailPresenter;
import com.program.module_moyu.presenter.IMoyuListFragmentPresenter;
import com.program.module_moyu.presenter.IMoyuMainFragmentPresenter;
import com.program.module_moyu.presenter.Impl.MoyuDetailPresenterImpl;
import com.program.module_moyu.presenter.Impl.MoyuListPresenterImpl;
import com.program.module_moyu.presenter.Impl.MoyuMainFragmentPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IMoyuDetailPresenter mMoyuDetailPresenter;
    private final IMoyuMainFragmentPresenter mMoyuMainFragmentPresenter;
    private final IMoyuListFragmentPresenter mMoyuListPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IMoyuDetailPresenter getMoyuDetailPresenter() {
        return mMoyuDetailPresenter;
    }

    public IMoyuMainFragmentPresenter getMoyuMainFragmentPresenter() {
        return mMoyuMainFragmentPresenter;
    }

    public IMoyuListFragmentPresenter getMoyuListPresenter() {
        return mMoyuListPresenter;
    }

    private PresenterManager(){
        mMoyuDetailPresenter = new MoyuDetailPresenterImpl();
        mMoyuMainFragmentPresenter = new MoyuMainFragmentPresenterImpl();
        mMoyuListPresenter = new MoyuListPresenterImpl();
    }
}
