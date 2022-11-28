package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.lifecycle.Lifecycle;

import com.program.lib_base.LogUtils;
import com.program.module_ucenter.callback.IMsgCenterCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.ReadAllBean;
import com.program.module_ucenter.model.domain.UnreadMsgBean;
import com.program.module_ucenter.presenter.IMsgCenterPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle3.LifecycleTransformer;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MsgCenterPresenterImpl implements IMsgCenterPresenter {
    private IMsgCenterCallback mCallback=null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final UcenterApi mApi;

    private static final int REQUEST_SUCCESS = 10000;
    private static final int ERROR = 0;
    private static final int RETURN_USER_UNREADCOUNT = 1;
    private static final int RETURN_USER_READ_ALL = 2;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case RETURN_USER_UNREADCOUNT:
                    mCallback.setMsg((UnreadMsgBean) msg.obj);
                    break;
                case RETURN_USER_READ_ALL:
                    mCallback.setReanReturn();
                    break;
                case ERROR:
                    mCallback.onMsgError(msg.obj.toString());
                    break;
            }

        }
    };
    private LifecycleProvider<Lifecycle.Event> mLifecycleTransformer=null;

    public MsgCenterPresenterImpl(){
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getMsg() {
        LogUtils.d("test","impl getMsg ");
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.getUnreadBean(token)
                .compose(mCallback.getBindLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object unreadMsgBean) {
                        UnreadMsgBean data = (UnreadMsgBean) unreadMsgBean;
                        LogUtils.d("bean","UnreadMsgBean = "+data.toString());
                        Message message = new Message();
                        if (data.getCode()==REQUEST_SUCCESS){
                            message.what=RETURN_USER_UNREADCOUNT;
                            message.obj = data;
                        }else {
                            message.what=  ERROR;
                            message.obj =  data.getMessage();
                        }
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Message message = new Message();
                        message.what=ERROR;
                        message.obj ="网络错误或服务器错误，请稍后重试";
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void readAllMsg() {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.readAllMsg(token)
                .compose(mCallback.getBindLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        ReadAllBean data = (ReadAllBean) o;
                        Message message = new Message();
                        if (data.getCode()==REQUEST_SUCCESS){
                            message.what=RETURN_USER_READ_ALL;
                        }else {
                            message.what=ERROR;
                            message.obj = "操作失败";
                        }
                        mHandler.sendMessage(message);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Message message = new Message();
                        message.what = ERROR;
                        message.obj = "操作失败";
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void registerViewCallback(IMsgCenterCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IMsgCenterCallback callback) {
        mCallback=null;
    }

}
