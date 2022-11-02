package com.program.module_wenda.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_wenda.callback.IWendaListFragmentCallback;
import com.program.module_wenda.model.WendaApi;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaListBean;
import com.program.module_wenda.presenter.IWendaListFragmentPresenter;
import com.program.module_wenda.utils.RetrofitManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WendaListFragmentPresenterImpl implements IWendaListFragmentPresenter {

    private final WendaApi mApi;
    private IWendaListFragmentCallback mCallback = null;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_WENDA_LIST = 1;
    private static final int RETURN_WENDA_LIST_MORE = 2;
    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case ERROR:
                    mCallback.setErrorMsg("错误,请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.setErrorMsg(((WendaListBean)msg.obj).getMessage());
                    break;
                case RETURN_WENDA_LIST:
                    page++;
                    mCallback.setWendaList((WendaListBean) msg.obj);
                    break;
                case RETURN_WENDA_LIST_MORE:
                    page++;
                    mCallback.setWendaListMore((WendaListBean)msg.obj);
                    break;
            }
        }
    };

    public WendaListFragmentPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    private int page;

    @Override
    public void getWendaList(String wendaType) {
        page = 1;
        mApi.getWendaList(page, wendaType, -2)
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
                        message.what = ((WendaListBean) o).getCode() == Constants.SUCCESS ? RETURN_WENDA_LIST : RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        requestFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getWendaListMore(String wendaType) {
        mApi.getWendaList(page, wendaType, -2)
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
                        message.what = ((WendaListBean) o).getCode() == Constants.SUCCESS ? RETURN_WENDA_LIST_MORE : RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        requestFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void requestFailed() {
        Message message = new Message();
        message.what = ERROR;
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(IWendaListFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
