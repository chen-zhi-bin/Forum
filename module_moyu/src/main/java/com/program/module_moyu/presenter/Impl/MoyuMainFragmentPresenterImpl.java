package com.program.module_moyu.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_common.Constants;
import com.program.module_moyu.callback.IMoyuMainFragmentCallback;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.TopicIndexBean;
import com.program.module_moyu.model.bean.TopicIndexReturnBean;
import com.program.module_moyu.presenter.IMoyuMainFragmentPresenter;
import com.program.module_moyu.utils.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoyuMainFragmentPresenterImpl implements IMoyuMainFragmentPresenter {
    private IMoyuMainFragmentCallback mCallback = null;

    private static final int ERROR=-1;
    private static final int RETURN_ERROR=0;
    private static final int RETURN_TOPIC_INDEX_LIST=1;
    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.setErrorMsg("错误，请稍后重试");
                    mCallback.onError();
                    break;
                case RETURN_ERROR:
                    mCallback.setErrorMsg(((TopicIndexReturnBean)msg.obj).getMessage());
                    mCallback.onError();
                    break;
                case RETURN_TOPIC_INDEX_LIST:
                    List<TopicIndexReturnBean.DataBean> data = ((TopicIndexReturnBean) msg.obj).getData();
                    List<TopicIndexBean> list=new ArrayList<>();
                    if (data!=null&&data.size()>0){
                        for (TopicIndexReturnBean.DataBean datum : data) {
                            list.add(new TopicIndexBean(datum.getId(),datum.getTopicName()));
                        }
                        mCallback.setTopicIndex(list);
                    }else {
                        mCallback.onEmpty();
                    }
                    break;
            }
        }
    };
    private final MoyuApi mApi;

    public MoyuMainFragmentPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getTopicIndex() {
        mApi.getTopicIndex()
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
                        message.what = ((TopicIndexReturnBean)o).getCode()== Constants.SUCCESS?RETURN_TOPIC_INDEX_LIST:RETURN_ERROR;
                        message.obj=o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Message message = new Message();
                        message.what=ERROR;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void registerViewCallback(IMoyuMainFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IMoyuMainFragmentCallback callback) {
        this.mCallback = callback;
    }
}
