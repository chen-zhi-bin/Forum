package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IMoyuCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.MoyuBean;
import com.program.module_ucenter.presenter.IMoyuPresentere;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.MoyuRequestBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoyuPreseenterImpl implements IMoyuPresentere {

    private IMoyuCallback mCallback;
    private final UcenterApi mApi ;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private int page = 1;

    private static final int ERROR=0;
    private static final int SUCCESS=10000;
    private static final int RETURN_MOYU_LIST=1;
    private static final int RETURN_MOYU_LIST_MORE=2;
    private static final int RETURN_MOYU_LIST_MORE_ERROR=3;
    private static final int RETURN_MOYU_UPDATE_INFO=4;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case ERROR:
                    mCallback.setErrorMsg(msg.obj.toString());
                    break;
                case RETURN_MOYU_LIST:
                    page++;
                    MoyuBean data = (MoyuBean) msg.obj;
                    mCallback.setMoyuList(data.getData());
                    break;
                case RETURN_MOYU_LIST_MORE:
                    mCallback.setMoyuListMore(((MoyuBean)msg.obj).getData());
                    break;
                case RETURN_MOYU_LIST_MORE_ERROR:
                    mCallback.setErrorMsg(((MoyuBean)msg.obj).getMessage());
                    break;
                case RETURN_MOYU_UPDATE_INFO:
                    mCallback.setMoyuUpdate(((MoyuRequestBean)msg.obj).getData());
                    break;
            }
        }
    };
    private String userId;
    private final String mToken;

    public MoyuPreseenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    @Override
    public void getMoyuYpdateInfo(String moyuId) {
        mApi.getMoyuDetail(moyuId,mToken!=null&&(!mToken.equals(""))?mToken:"")
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
                        message.what=((MoyuRequestBean)o).getCode()== Constants.SUCCESS?RETURN_MOYU_UPDATE_INFO:ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Message message = new Message();
                        message.what=ERROR;
                        message.obj = e.getMessage();
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMoyuList(String userId) {
        this.userId = userId;
        page=1;
        mApi.getMoyuList(userId,page,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object data) {
                        MoyuBean moyuBean = (MoyuBean) data;
                        LogUtils.d("test","data ="+moyuBean);
                        Message message = new Message();
                        if (moyuBean.getCode()==SUCCESS){
                            message.what = RETURN_MOYU_LIST;
                            message.obj = moyuBean;
                        }else {
                            message.what=ERROR;
                            message.obj=moyuBean.getMessage();
                        }
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMoyuListMore() {
        mApi.getMoyuList(userId,page,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object data) {
                        MoyuBean moyuBean = (MoyuBean) data;
                        Message message = new Message();
                        message.what = moyuBean.getCode()==SUCCESS?RETURN_MOYU_LIST_MORE:RETURN_MOYU_LIST_MORE_ERROR;
                        message.obj = moyuBean;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void registerViewCallback(IMoyuCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IMoyuCallback callback) {
            mCallback =null;
    }
}
