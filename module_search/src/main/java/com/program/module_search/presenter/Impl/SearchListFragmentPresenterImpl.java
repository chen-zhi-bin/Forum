package com.program.module_search.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.module_search.callback.ISearchListFragmentCallback;
import com.program.module_search.model.SearchApi;
import com.program.module_search.model.bean.SearchListBean;
import com.program.module_search.presenter.ISearchListFragmentPresenter;
import com.program.module_search.utils.RetrofitManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchListFragmentPresenterImpl implements ISearchListFragmentPresenter {

    private final SearchApi mApi;
    private ISearchListFragmentCallback mCallback = null;

    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_SEARCH_lIST = 1;
    private static final int RETURN_SEARCH_MORE_lIST = 2;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            switch (msg.what) {
                case RETURN_ERROR:
                    mCallback.serErrorMsg(msg.obj.toString());
                    break;
                case RETURN_SEARCH_lIST:
                    SearchListBean bean = (SearchListBean) msg.obj;
                    if (bean.getSuccess()) {
                        page++;
                    }
                    mCallback.setSearchResults(bean);
                    break;
                case RETURN_SEARCH_MORE_lIST:
                    SearchListBean searchListBean = (SearchListBean) msg.obj;
                    if (searchListBean.getSuccess()) {
                        page++;
                    }
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
        page = 1;
        mApi.search(keyword, type, page, null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_SEARCH_lIST;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSearchListMore(String keyword, String type) {
        mApi.search(keyword, type, page, null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_SEARCH_MORE_lIST;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void returnError(String e) {
        Message message = new Message();
        message.what = RETURN_ERROR;
        message.obj = e;
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(ISearchListFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mCallback = null;
    }
}
