package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.style.AbsoluteSizeSpan;

import com.program.lib_base.LogUtils;
import com.program.module_ucenter.UcenterApplication;
import com.program.module_ucenter.callback.ISettingCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.AvaTarBean;
import com.program.module_ucenter.model.domain.LoginoutBean;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.module_ucenter.presenter.ISettingPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SettingPresenterImpl implements ISettingPresenter {
    private ISettingCallback mCallback=null;
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private UcenterApi mApi;
    private LifecycleTransformer<Object> mLifecycleTransformer;

    private static final int SUCCESS=10000;
    private static final int LOGINOUT_SUCCESS =1;
    private static final int LOGINOUT_ERROR =0;

    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case LOGINOUT_SUCCESS:
                    LoginoutBean data = (LoginoutBean) msg.obj;
                    removeToken();
                    mCallback.loginoutSuccess(data.getMessage());
                    break;
                case LOGINOUT_ERROR:
//                    String message = msg.obj.toString();

                    removeToken();
                    mCallback.getErrorMessage("网络或服务器异常，请稍后重试");
                    break;
            }

        }
    };

    private void removeToken() {
        mSharedPreferencesUtils.remove(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mSharedPreferencesUtils.remove(SharedPreferencesUtils.USER_PHONE);
        mSharedPreferencesUtils.remove(SharedPreferencesUtils.USER_ID);
    }


    @Override
    public void registerViewCallback(ISettingCallback callback) {

        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(UcenterApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback=null;
    }

    @Override
    public void loginout() {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.loginout(token)
                .compose(mLifecycleTransformer)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object loginoutBean) {
                        LoginoutBean data = (LoginoutBean) loginoutBean;
                        LogUtils.d("test","LoginoutBean="+data.toString());
                        Message message = new Message();
                        if (data.getCode()==SUCCESS){
                            message.what=LOGINOUT_SUCCESS;
                        }else {
                            message.what = LOGINOUT_ERROR;
                        }
                        message.obj = data;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Message message = new Message();
                        message.what = LOGINOUT_ERROR;
//                        message.obj = e.getMessage();
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void registerLifecycleTransformer(LifecycleTransformer<Object> objectLifecycleTransformer) {
        this.mLifecycleTransformer=objectLifecycleTransformer;
    }
}
