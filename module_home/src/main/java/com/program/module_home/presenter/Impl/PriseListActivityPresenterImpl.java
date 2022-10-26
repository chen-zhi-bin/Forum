package com.program.module_home.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.module_home.callback.IPriseListActivityCallback;
import com.program.module_home.model.HomeApi;
import com.program.module_home.model.bean.PriseArticleBean;
import com.program.module_home.presenter.IPriseListActivityPresenter;
import com.program.module_home.utils.RetrofitManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PriseListActivityPresenterImpl implements IPriseListActivityPresenter {


    private IPriseListActivityCallback mCallback = null;
    private final HomeApi mApi;

//    private static final int ERROR = -1;        //能请求，但是错误
    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_PRISE_lIST = 1;
    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
           switch (msg.what){
               case RETURN_ERROR:
                   mCallback.serErrorMsg(msg.obj.toString());
                   break;
               case RETURN_PRISE_lIST:
                   mCallback.setPriseList((PriseArticleBean)msg.obj);
                   break;
           }
        }
    };

    public PriseListActivityPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getPriseList(String articleId) {
        mApi.getPriseArticleList(articleId)
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
                        message.what = RETURN_PRISE_lIST;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Message message = new Message();
                        message.what = RETURN_ERROR;
                        message.obj = e.getMessage();
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void registerViewCallback(IPriseListActivityCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
