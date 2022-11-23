package com.program.module_moyu.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.module_moyu.callback.IPutFishActivityCallback;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.Moment;
import com.program.module_moyu.presenter.IPutFishActivityPresenter;
import com.program.module_moyu.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MultipartBody;

public class PutFishActivityPresenterImpl implements IPutFishActivityPresenter {
    private IPutFishActivityCallback mCallback = null;
    private final MoyuApi mApi;
    private final SharedPreferencesUtils mInstance;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_IMAGE = 1;
    private static final int RETURN_MOYU = 2;

    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                case RETURN_ERROR:
                    mCallback.setRequestError("错误,请稍后重试");
                    break;
                case RETURN_IMAGE:
                    mCallback.setImageReturn((BaseResponseBean)msg.obj);
                    break;
                case RETURN_MOYU:
                    mCallback.setPutFishReturn((BaseResponseBean) msg.obj);
                    break;
            }
        }
    };

    public PutFishActivityPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mInstance = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void registerViewCallback(IPutFishActivityCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mCallback = null;
    }

    @Override
    public void postImage(MultipartBody.Part part) {
        String token = mInstance.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (token.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.postImage(part,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_IMAGE;
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
    public void postMoment(Moment moment) {
        String token = mInstance.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (token.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.postMoyu(moment,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_MOYU;
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
}
