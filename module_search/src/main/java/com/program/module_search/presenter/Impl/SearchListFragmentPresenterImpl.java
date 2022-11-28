package com.program.module_search.presenter.Impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.module_search.callback.ISearchListFragmentCallback;
import com.program.module_search.model.SearchApi;
import com.program.module_search.model.bean.SearchListBean;
import com.program.module_search.presenter.ISearchListFragmentPresenter;
import com.program.module_search.utils.RetrofitManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchListFragmentPresenterImpl implements ISearchListFragmentPresenter {

    private final SearchApi mApi;
    private List<ISearchListFragmentCallback> mCallbacks = new ArrayList<>();
    private ISearchListFragmentCallback mCallback = null;

    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_SEARCH_lIST = 1;
    private static final int RETURN_SEARCH_MORE_lIST = 2;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            String key = msg.getData().getString("key");
            for (ISearchListFragmentCallback callback : mCallbacks) {
                if (callback.getType().equals(key)) {
                    mCallback = callback;
                }
            }
            switch (msg.what) {
                case RETURN_ERROR:
//                    for (ISearchListFragmentCallback callback : mCallbacks) {
//                        callback.serErrorMsg(msg.obj.toString());
//                    }
//                    mCallbackMap.get(mKey).serErrorMsg(msg.obj.toString());
                    mCallback.serErrorMsg(msg.obj.toString());
                    break;
                case RETURN_SEARCH_lIST:
                    SearchListBean bean = (SearchListBean) msg.obj;
                    if (bean.getSuccess()) {
                        page++;
                    }
//                    for (ISearchListFragmentCallback callback : mCallbacks) {
//                        callback.setSearchResults(bean);
//                    }
//                    mCallbackMap.get(mKey).setSearchResults(bean);
                    mCallback.setSearchResults(bean);
                    break;
                case RETURN_SEARCH_MORE_lIST:
                    SearchListBean searchListBean = (SearchListBean) msg.obj;
                    if (searchListBean.getSuccess()) {
                        page++;
                    }
//                    for (ISearchListFragmentCallback callback : mCallbacks) {
//                        callback.setSearchMoreResults(searchListBean);
//                    }
//                    mCallbackMap.get(mKey).setSearchMoreResults(searchListBean);
                    mCallback.setSearchMoreResults(searchListBean);
                    break;
            }
        }
    };

    public SearchListFragmentPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    private int page = 1;

    @Override
    public void getSearchList(String keyword, String type) {
//        LogUtils.d("test","this = "+mCallbackMap.toString());
        for (ISearchListFragmentCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        page = 1;
        mApi.search(keyword, type, page, null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
//                .compose(mCallbackMap.get(mKey).TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_SEARCH_lIST;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        returnError(e.getMessage(),type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSearchListMore(String keyword, String type) {
        for (ISearchListFragmentCallback callback : mCallbacks) {
            if (callback.getType().equals(type)) {
                mCallback = callback;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mApi.search(keyword, type, page, null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
//                .compose(mCallbackMap.get(mKey).TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_SEARCH_MORE_lIST;
                        message.obj = o;
                        message.setData(bundle);
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        returnError(e.getMessage(),type);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void returnError(String e,String type) {
        Message message = new Message();
        message.what = RETURN_ERROR;
        message.obj = e;
        Bundle bundle = new Bundle();
        bundle.putString("key",type);
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(ISearchListFragmentCallback callback) {
        this.mCallback = callback;
        if (!mCallbacks.contains(callback)){
            mCallbacks.add(callback);
        }
    }

    @Override
    public void unregisterViewCallback(ISearchListFragmentCallback callback) {
        this.mCallback = null;
    }
}
