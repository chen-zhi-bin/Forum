package com.program.module_moyu.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_common.Constants;
import com.program.module_moyu.callback.IMoyuListFragmentCallback;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.MoyuListBean;
import com.program.module_moyu.presenter.IMoyuListFragmentPresenter;
import com.program.module_moyu.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoyuListPresenterImpl implements IMoyuListFragmentPresenter {

    private final MoyuApi mApi;
    private IMoyuListFragmentCallback mCallback = null;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_RECOMMEND_LIST = 1;
    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case ERROR:
                    mCallback.setErrorMsg("错误，请稍后重试");
                    mCallback.onError();
                    break;
                case RETURN_ERROR:
                    mCallback.setErrorMsg(((MoyuListBean)msg.obj).getMessage());
                    break;
                case RETURN_RECOMMEND_LIST:
                    mCallback.setList(((MoyuListBean) msg.obj).getData().getList());
                    break;
            }
        }
    };
    private final String mToken;

    public MoyuListPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mToken = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    private int page = 0;

    @Override
    public void getRecommendList() {
        page = 1;
        mApi.getRecommendList(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((MoyuListBean) o).getCode() == Constants.SUCCESS ? RETURN_RECOMMEND_LIST : RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFollowList() {
        mApi.getFollowList(page, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((MoyuListBean) o).getCode() == Constants.SUCCESS ? RETURN_RECOMMEND_LIST : RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getList(String topicId) {
        mApi.getList(topicId,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((MoyuListBean)o).getCode()==Constants.SUCCESS?RETURN_RECOMMEND_LIST:RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void responseError() {
        Message message = new Message();
        message.what = ERROR;
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(IMoyuListFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {

    }
}
