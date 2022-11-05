package com.program.module_ucenter.utils;

import com.program.module_ucenter.presenter.IFavoriteListPresenter;
import com.program.module_ucenter.presenter.IMoyuPresentere;
import com.program.module_ucenter.presenter.IMsgCenterPresenter;
import com.program.module_ucenter.presenter.IMsgListPresenter;
import com.program.module_ucenter.presenter.IMsgSystemPresenter;
import com.program.module_ucenter.presenter.ISettingPresenter;
import com.program.module_ucenter.presenter.IUserCenterArticlePresenter;
import com.program.module_ucenter.presenter.IUserCenterPresenter;
import com.program.module_ucenter.presenter.IUserCollectionListFragmentPresenter;
import com.program.module_ucenter.presenter.IUserFollowFragmentPresenter;
import com.program.module_ucenter.presenter.IUserFragmentPresenter;
import com.program.module_ucenter.presenter.IUserRankingFragmentPresenter;
import com.program.module_ucenter.presenter.Impl.FavoriteListPresenterImpl;
import com.program.module_ucenter.presenter.Impl.MoyuPreseenterImpl;
import com.program.module_ucenter.presenter.Impl.MsgCenterPresenterImpl;
import com.program.module_ucenter.presenter.Impl.MsgListPresenterImpl;
import com.program.module_ucenter.presenter.Impl.MsgSystemPresenterImpl;
import com.program.module_ucenter.presenter.Impl.SettingPresenterImpl;
import com.program.module_ucenter.presenter.Impl.UserCenterArticlePresenterImpl;
import com.program.module_ucenter.presenter.Impl.UserCenterPresenterImpl;
import com.program.module_ucenter.presenter.Impl.UserCollectionListFragmentPresenterImpl;
import com.program.module_ucenter.presenter.Impl.UserFragmentPresenterImpl;
import com.program.module_ucenter.presenter.Impl.UserRankingFragmentPresentereImpl;
import com.program.module_ucenter.presenter.Impl.UsrFollowFragmentPresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IUserFragmentPresenter mUserFragmentPresenter;
    private final ISettingPresenter mSettingPresenter;
    private final IMsgCenterPresenter mMsgCenterPresenter;
    private final IMsgSystemPresenter mMsgSystemPresenter;
    private final IMsgListPresenter mMsgListPresenter;
    private final IMoyuPresentere mMoyuPreseenter;
    private final IUserCenterPresenter mUserCenterPresenter;
    private final IUserCenterArticlePresenter mUserCenterArticlePresenter;
    private final IUserFollowFragmentPresenter mUsrFollowFragmentPresenter;
    private final IUserRankingFragmentPresenter mUserRankingFragment;
    private final IUserCollectionListFragmentPresenter mUserCollectionListFragmentPresenter;
    private final IFavoriteListPresenter mFavoriteListPresenter;

    public static PresenterManager getInstance(){
        return ourInstance;
    }

    public IUserFragmentPresenter getUserFragmentPresenter() {
        return mUserFragmentPresenter;
    }

    public ISettingPresenter getSettingPresenter() {
        return mSettingPresenter;
    }

    public IMsgCenterPresenter getMsgCenterPresenter() {
        return mMsgCenterPresenter;
    }

    public IMsgSystemPresenter getMsgSystemPresenter() {
        return mMsgSystemPresenter;
    }

    public IMsgListPresenter getMsgListPresenter() {
        return mMsgListPresenter;
    }

    public IMoyuPresentere getMoyuPreseenter() {
        return mMoyuPreseenter;
    }

    public IUserCenterPresenter getUserCenterPresenter() {
        return mUserCenterPresenter;
    }

    public IUserCenterArticlePresenter getUserCenterArticlePresenter() {
        return mUserCenterArticlePresenter;
    }

    public IUserFollowFragmentPresenter getUsrFollowFragmentPresenter() {
        return mUsrFollowFragmentPresenter;
    }

    public IUserRankingFragmentPresenter getUserRankingFragment() {
        return mUserRankingFragment;
    }

    public IUserCollectionListFragmentPresenter getUserCollectionListFragmentPresenter() {
        return mUserCollectionListFragmentPresenter;
    }

    public IFavoriteListPresenter getFavoriteListPresenter() {
        return mFavoriteListPresenter;
    }

    private PresenterManager(){
        mUserFragmentPresenter = new UserFragmentPresenterImpl();
        mSettingPresenter = new SettingPresenterImpl();
        mMsgCenterPresenter = new MsgCenterPresenterImpl();
        mMsgSystemPresenter = new MsgSystemPresenterImpl();
        mMsgListPresenter = new MsgListPresenterImpl();
        mMoyuPreseenter = new MoyuPreseenterImpl();
        mUserCenterPresenter = new UserCenterPresenterImpl();
        mUserCenterArticlePresenter = new UserCenterArticlePresenterImpl();
        mUsrFollowFragmentPresenter = new UsrFollowFragmentPresenterImpl();
        mUserRankingFragment = new UserRankingFragmentPresentereImpl();
        mUserCollectionListFragmentPresenter = new UserCollectionListFragmentPresenterImpl();
        mFavoriteListPresenter = new FavoriteListPresenterImpl();
    }
}
