package com.program.module_moyu.presenter.Impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_moyu.callback.IMoyuListFragmentCallback;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.MoyuListBean;
import com.program.moudle_base.model.MoyuRequestBean;
import com.program.module_moyu.presenter.IMoyuListFragmentPresenter;
import com.program.module_moyu.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoyuListPresenterImpl implements IMoyuListFragmentPresenter {

    private final MoyuApi mApi;
    private IMoyuListFragmentCallback mCallback = null;
    private List<IMoyuListFragmentCallback> mCallbacks = new ArrayList<>();

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_LIST = 1;
    private static final int RETURN_UPDATE_MOYU = 2;
    private static final int RETURN_LIST_MORE = 3;
    private static final int RETURN_NOT_LOGIN = 4;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            String key = msg.getData().getString("key");
            for (IMoyuListFragmentCallback callback : mCallbacks) {
                if (callback.getKey().equals(key)) {
                    mCallback = callback;
                }
            }
            switch (msg.what) {
                case ERROR:
                    mCallback.setErrorMsg("错误，请稍后重试");
                    mCallback.onError();
                    break;
                case RETURN_ERROR:
                    mCallback.setErrorMsg(((MoyuListBean)msg.obj).getMessage());
                    break;
                case RETURN_LIST:
                    page++;
                    LogUtils.d("test","key data ==="+((MoyuListBean)msg.obj).getData().toString());
                    mCallback.setList(((MoyuListBean) msg.obj).getData().getList());
                    break;
                case RETURN_UPDATE_MOYU:
                    mCallback.setMoyuUpdate(((MoyuRequestBean)msg.obj).getData());
                    break;
                case RETURN_LIST_MORE:
                    page++;
                    mCallback.setListMore(((MoyuListBean)msg.obj).getData().getList());
                case RETURN_NOT_LOGIN:
                    mCallback.setErrorMsg(msg.obj.toString());
                    mCallback.onError();
                    break;
            }
        }
    };
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private String mToken;

    public MoyuListPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    private int page = 0;

    @Override
    public void getRecommendList(String key) {
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(key)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
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
                        message.what = ((MoyuListBean) o).getCode() == Constants.SUCCESS ? RETURN_LIST : RETURN_ERROR;
                        message.setData(bundle);
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(key);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRecommendListMore(String key) {
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(key)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
        mApi.getRecommendList(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what=((MoyuListBean)o).getCode()==Constants.SUCCESS? RETURN_LIST_MORE :RETURN_ERROR;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(key);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFollowList(String key) {
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(key)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE, "");
        if (mToken.equals("")) {
            Message message = new Message();
            message.what = RETURN_NOT_LOGIN;
            message.obj = "用户未登录";
            message.setData(bundle);
            mHandler.sendMessage(message);
            return;
        }
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
                        message.what = ((MoyuListBean) o).getCode() == Constants.SUCCESS ? RETURN_LIST : RETURN_ERROR;
                        LogUtils.d("test","test data = "+((MoyuListBean) o).toString());
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(key);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFollowListMore(String key) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(key)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
        mApi.getFollowList(page,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what=((MoyuListBean)o).getCode()==Constants.SUCCESS?RETURN_LIST_MORE:RETURN_ERROR;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(key);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void getList(String topicId) {
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(topicId)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",topicId);
        page = 1;
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
                        message.what = ((MoyuListBean)o).getCode()==Constants.SUCCESS? RETURN_LIST :RETURN_ERROR;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(topicId);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getListMore(String topicId) {
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(topicId)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",topicId);
        mApi.getList(topicId,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((MoyuListBean)o).getCode()==Constants.SUCCESS?RETURN_LIST_MORE:RETURN_ERROR;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(topicId);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUpdateMoyuInfo(String key,String moyuid) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        for (IMoyuListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(key)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
        mApi.getMoyuDetail(moyuid,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what=((MoyuRequestBean)o).getCode()==Constants.SUCCESS?RETURN_UPDATE_MOYU:RETURN_ERROR;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        responseError(key);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void responseError(String key) {
        Message message = new Message();
        message.what = ERROR;
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(IMoyuListFragmentCallback callback) {
//        this.mCallback = callback;
        if (!mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }
    }

    @Override
    public void unregisterViewCallback(IMoyuListFragmentCallback callback) {
        mCallbacks.remove(callback);
    }
}
