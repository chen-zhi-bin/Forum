package com.program.module_moyu.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.module_moyu.callback.IFishPoneSelectionActivityCallback;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.TopicIndexReturnBean;
import com.program.module_moyu.presenter.IFishPoneSelectionActivityPresenter;
import com.program.module_moyu.utils.RetrofitManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FishPoneSelectionActivityPresenterImpl implements IFishPoneSelectionActivityPresenter {
    private IFishPoneSelectionActivityCallback mCallback = null;
    private final MoyuApi mApi;

    private static final int ERROR=-1;
    private static final int RETURN_ERROR=0;
    private static final int RETURN_FISH=1;
    private final Handler mHandler= new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                case RETURN_ERROR:
                    mCallback.setRequestError("网络错误，请稍后重试");
                    break;
                case RETURN_FISH:
                    mCallback.setFishPone((TopicIndexReturnBean)msg.obj);
                    break;
            }
        }
    };

    public FishPoneSelectionActivityPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void registerViewCallback(IFishPoneSelectionActivityCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IFishPoneSelectionActivityCallback callback) {
        mCallback = null;
    }

    @Override
    public void getFishPone() {
        mApi.getTopicList()
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
                        message.what=RETURN_FISH;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Message message = new Message();
                        message.what=RETURN_ERROR;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
