package com.program.module_ucenter.presenter.Impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IUserCenterArticleCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.ArticleBean;
import com.program.module_ucenter.model.domain.ShareBean;
import com.program.module_ucenter.model.domain.UserWendaBean;
import com.program.module_ucenter.presenter.IUserCenterArticlePresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserCenterArticlePresenterImpl implements IUserCenterArticlePresenter {
    private IUserCenterArticleCallback mCallback = null;
    private List<IUserCenterArticleCallback> mCallbacks = new ArrayList<>();
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final UcenterApi mApi;

    private static final int ERROR = 0;
    private static final int RETURN_ARTICLE = 1;
    private static final int RETURN_ARTICLE_ERROR = 2;
    private static final int RETURN_SHARE = 3;
    private static final int RETURN_SHARE_ERROR = 4;
    private static final int RETURN_WENDA = 5;
    private static final int RETURN_WENDA_ERROR = 6;
    private static final int RETURN_ARTICLE_MORE = 7;
    private static final int RETURN_SHARE_MORE = 8;
    private static final int RETURN_WENDA_MORE = 9;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            String key = msg.getData().getString("key");
            for (IUserCenterArticleCallback callback : mCallbacks) {
                if (callback.getType().equals(key)) {
                    mCallback = callback;
                }
            }
            switch (msg.what) {
                case RETURN_ARTICLE:
                    if ((((ArticleBean) msg.obj).getData().getList() == null || ((ArticleBean) msg.obj).getData().getList().size() == 0)) {
                        mCallback.onEmpty();
                    }else {
                        if (((ArticleBean) msg.obj).getData().getHasNext()) {
                            mArticlePage++;
                        }
                        mCallback.setArticleData((ArticleBean) msg.obj);
                    }
//                    mCallback.setArticleData((ArticleBean) msg.obj);
                    break;
                case RETURN_ARTICLE_ERROR:
                    mCallback.ToastErrorMsg(((ArticleBean) msg.obj).getMessage());
//                        mCallback.ToastErrorMsg("暂无更多");
                    break;
                case RETURN_SHARE:
                    if ((((ShareBean) msg.obj).getData().getList() == null || ((ShareBean) msg.obj).getData().getList().size() == 0)) {
                        mCallback.onEmpty();
                    }else {
                        if (((ShareBean) msg.obj).getData().getHasNext()) {
                            mSharePage++;
                        }
                        mCallback.setShareData((ShareBean) msg.obj);
                    }
                    break;
                case RETURN_SHARE_ERROR:
                    mCallback.ToastErrorMsg(((ShareBean) msg.obj).getMessage());
//                        mCallback.ToastErrorMsg("暂无更多");
                    break;
                case RETURN_WENDA:
                     if ((((UserWendaBean) msg.obj).getData().getContent() == null || ((UserWendaBean) msg.obj).getData().getContent().size() == 0)) {
                        mCallback.onEmpty();
                    }else {
                         if (((UserWendaBean) msg.obj).getData().getTotalPages() >= mWendaPage) {
                             mWendaPage++;
                         }
                         mCallback.setWendaData((UserWendaBean) msg.obj);
                     }
                    break;
                case RETURN_WENDA_ERROR:
                    mCallback.ToastErrorMsg(((UserWendaBean) msg.obj).getMessage());
//                        mCallback.ToastErrorMsg("暂无更多");
                    break;
                case RETURN_ARTICLE_MORE:
                    if ((((ArticleBean) msg.obj).getData().getList() == null || ((ArticleBean) msg.obj).getData().getList().size() == 0)) {
                        mCallback.ToastErrorMsg("暂无更多");
                    }else {
                        mArticlePage++;
                        mCallback.setArticleDataMore((ArticleBean) msg.obj);
                    }
                    break;
                case RETURN_SHARE_MORE:
                    if (((ShareBean) msg.obj).getData().getHasNext()) {
                        mSharePage++;
                    }
                    mCallback.setShareDataMore((ShareBean) msg.obj);
                    break;
                case RETURN_WENDA_MORE:
                    if (((UserWendaBean) msg.obj).getData().getTotalPages() >= mWendaPage) {
                        mWendaPage++;
                    }
                    mCallback.setWendaDataMore((UserWendaBean) msg.obj);
                    break;
                case ERROR:
                    mCallback.onError();
                    break;
            }
        }
    };
    private final String mToken;

    public UserCenterArticlePresenterImpl() {
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    private int mArticlePage = 1;

    @Override
    public void getArticleList(String type,String userId) {
//        LogUtils.d(UserCenterArticlePresenterImpl.class,"getArticleList");
        mArticlePage = 1;
        for (IUserCenterArticleCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.getArticle(userId, mArticlePage,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ArticleBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ArticleBean articleBean) {
                        Message message = new Message();
                        message.what = articleBean.getCode() == Constants.SUCCESS ? RETURN_ARTICLE : RETURN_ARTICLE_ERROR;
                        message.obj = articleBean;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed(type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void requestFailed(String type) {
        Message message = new Message();
        message.what = ERROR;
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        message.setData(bundle);
        mHandler.sendMessage(message);
    }

    private int mSharePage = 1;

    @Override
    public void getShareList(String type,String userId) {
//        LogUtils.d(UserCenterArticlePresenterImpl.class,"getShareList");
        mSharePage = 1;
        for (IUserCenterArticleCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.getShare(userId, mSharePage,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShareBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ShareBean shareBean) {
                        Message message = new Message();
                        message.what = shareBean.getCode() == Constants.SUCCESS ? RETURN_SHARE : RETURN_SHARE_ERROR;
                        message.obj = shareBean;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed(type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private int mWendaPage = 1;

    @Override
    public void getWendaList(String type,String userId) {
//        LogUtils.d(UserCenterArticlePresenterImpl.class, "getWendaList");
        mWendaPage = 1;
        for (IUserCenterArticleCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.getWenda(userId, mWendaPage,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserWendaBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserWendaBean userWendaBean) {
                        LogUtils.d("test", "data = " + userWendaBean);
                        Message message = new Message();
                        message.what = userWendaBean.getCode() == Constants.SUCCESS ? RETURN_WENDA : RETURN_WENDA_ERROR;
                        message.obj = userWendaBean;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed(type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getArticleListMore(String type,String userId) {
        for (IUserCenterArticleCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.getArticle(userId, mArticlePage,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ArticleBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ArticleBean data) {
                        Message message = new Message();
                        message.what = data.getCode() == Constants.SUCCESS ? RETURN_ARTICLE_MORE : RETURN_ARTICLE_ERROR;
                        message.obj = data;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed(type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getShareListMore(String type,String userId) {
        for (IUserCenterArticleCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.getShare(userId, mSharePage,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShareBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ShareBean shareBean) {
                        LogUtils.d(UserCenterArticlePresenterImpl.class,"share data = "+shareBean);
                        Message message = new Message();
                        message.what = shareBean.getCode() == Constants.SUCCESS ? RETURN_SHARE_MORE : RETURN_SHARE_ERROR;
                        message.obj = shareBean;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed(type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getWendaListMore(String type,String userId) {
        for (IUserCenterArticleCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.getWenda(userId, mWendaPage,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserWendaBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserWendaBean userWendaBean) {
                        LogUtils.d("test", "data = " + userWendaBean);
                        Message message = new Message();
                        message.what = userWendaBean.getCode() == Constants.SUCCESS ? RETURN_WENDA_MORE : RETURN_WENDA_ERROR;
                        message.obj = userWendaBean;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed(type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void registerViewCallback(IUserCenterArticleCallback callback) {
        if (!mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }
    }

    @Override
    public void unregisterViewCallback(IUserCenterArticleCallback callback) {
        mCallbacks.remove(callback);
    }
}
