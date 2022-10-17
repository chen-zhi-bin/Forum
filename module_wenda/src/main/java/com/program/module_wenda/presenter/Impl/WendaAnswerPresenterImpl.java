package com.program.module_wenda.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_wenda.callback.IWendaAnswerCallback;
import com.program.module_wenda.model.WendaApi;
import com.program.module_wenda.model.bean.WendaSubCommentInputBean;
import com.program.module_wenda.presenter.IWendaAnswerPresenter;
import com.program.module_wenda.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WendaAnswerPresenterImpl implements IWendaAnswerPresenter {
    private IWendaAnswerCallback mCalllback = null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final String mToken;
    private final WendaApi mApi;

    private static final int ERROR = -1;        //能请求，但是错误
    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_REPLY = 1;

    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case ERROR:
                    mCalllback.setRequestError("请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCalllback.setRequestError("网络错误");
                    break;
                case RETURN_REPLY:
                    mCalllback.replyAnswerReturn((BaseResponseBean)msg.obj);
                    break;
            }
        }
    };

    public WendaAnswerPresenterImpl(){
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void replyAnswer(WendaSubCommentInputBean data) {
        mApi.replyAnswer(data,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCalllback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test","评论子评论 返回 = "+((BaseResponseBean)o).toString());
                        Message message = new Message();
                        message.what = ((BaseResponseBean)o).getCode()== Constants.SUCCESS?RETURN_REPLY:ERROR;
                        message.obj=o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
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
    public void registerViewCallback(IWendaAnswerCallback callback) {
        this.mCalllback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCalllback = null;
    }
}
