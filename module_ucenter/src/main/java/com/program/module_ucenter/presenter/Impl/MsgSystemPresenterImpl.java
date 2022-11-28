package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.program.lib_base.LogUtils;
import com.program.module_ucenter.callback.IMsgSystemCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.LoginoutBean;
import com.program.module_ucenter.model.domain.MsgSystemBean;
import com.program.module_ucenter.presenter.IMsgSystemPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MsgSystemPresenterImpl implements IMsgSystemPresenter {
    private IMsgSystemCallback mCallback = null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final UcenterApi mApi;

    private static final int SUCCESS=10000;
    private final static int ERROR = 0;
    private final static int RETURN_SYSTEM_MSG =1 ;
    private final static int RETURN_SYSTEM_MSG_MORE =2 ;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case RETURN_SYSTEM_MSG:
                    mCallback.setMsgSystem((MsgSystemBean) msg.obj);
                    break;
                case RETURN_SYSTEM_MSG_MORE:
                    mCallback.setLoadMoreMsgSysten((MsgSystemBean)msg.obj);
                    break;
                case ERROR:
                    mCallback.setReturnErrorMsg(msg.obj.toString());
                    break;
            }

        }
    };

    public MsgSystemPresenterImpl(){
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
    }

    private int page ;
    private int maxPage = -1;
    @Override
    public void getMsgSystem() {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        page=1;
        mApi.getSystemMsg(page,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgSystemBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgSystemBean msgSystemBean) {
                        LogUtils.d("test","msg = "+msgSystemBean);
                        Message message = new Message();
                        if (msgSystemBean.getCode()==SUCCESS){
                            message.what = RETURN_SYSTEM_MSG;
                            message.obj = msgSystemBean;
                            maxPage = msgSystemBean.getData().getTotalPages();
                            page++;
                        }else {
                            message.what=ERROR;
                            message.obj="请检查网络设置或登录情况";
                        }
                        mHandler.sendMessage(message);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Message message = new Message();
                        message.what=ERROR;
                        message.obj = "请检查网络设置或登录情况";
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getloadmoreMsgSystem() {
        LogUtils.d("test","title page = "+page);
        Message message = new Message();
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        if (page<=maxPage){
            mApi.getSystemMsg(page,token)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<MsgSystemBean>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull MsgSystemBean msgSystemBean) {
                            LogUtils.d("test","msg = "+msgSystemBean);
                            Message message = new Message();
                            if (msgSystemBean.getCode()==SUCCESS){
                                message.what = RETURN_SYSTEM_MSG_MORE;
                                message.obj = msgSystemBean;
                                page++;
                            }else {
                                message.what=ERROR;
                                message.obj="请检查网络设置或登录情况";
                            }
                            mHandler.sendMessage(message);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Message message = new Message();
                            message.what=ERROR;
                            message.obj = "请检查网络设置或登录情况";
                            mHandler.sendMessage(message);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            message.what=ERROR;
            message.obj="没有更多内容";
            mHandler.sendMessage(message);
        }
    }

    @Override
    public void registerViewCallback(IMsgSystemCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IMsgSystemCallback callback) {
        this.mCallback = null;
    }
}
