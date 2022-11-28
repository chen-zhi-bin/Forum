package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.module_ucenter.callback.IUserInfoActivityCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.PersonCenterInfo;
import com.program.module_ucenter.model.domain.UcenterInfo;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.module_ucenter.presenter.IUserInfoActivityPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserInfoActivityPresenterImpl implements IUserInfoActivityPresenter {

    private IUserInfoActivityCallback mCallback=null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final UcenterApi mApi;


    private static final int ERROR=-1;
    private static final int RETURN_ERROR=0;
    private static final int RETURN_USERINFO=1;
    private static final int RETURN_PUT_USERINFO=2;

    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case ERROR:
                    mCallback.setErrorMsg("错误,请稍后重试");
                    break;
                case RETURN_ERROR:
                    break;
                case RETURN_USERINFO:
                    mCallback.setUserInfo((UcenterInfo)msg.obj);
                    break;
                case RETURN_PUT_USERINFO:
                    mCallback.setModifyUserInfo((BaseResponseBean)msg.obj);
                    break;
            }
        }
    };

    public UserInfoActivityPresenterImpl(){
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getUserInfo() {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        if (token.equals("")||token==null){
            mCallback.setErrorMsg("尚未登录");
            return;
        }
        mApi.getUcenterInfo(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_USERINFO;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void modifyUserInfo(PersonCenterInfo personCenterInfo) {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.modifyUserInfo(personCenterInfo,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_PUT_USERINFO;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void responseError() {
        Message message = new Message();
        message.what = ERROR;
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(IUserInfoActivityCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IUserInfoActivityCallback callback) {
        mCallback = null;
    }
}
