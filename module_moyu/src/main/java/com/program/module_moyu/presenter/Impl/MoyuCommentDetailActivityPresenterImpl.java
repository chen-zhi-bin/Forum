package com.program.module_moyu.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.RoutePath;
import com.program.module_moyu.callback.IMoyuCommentDetailActivityCallback;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.MomentComment;
import com.program.module_moyu.model.bean.MomentSubComment;
import com.program.module_moyu.presenter.IMoyuCommentDetailActivityPresenter;
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

public class MoyuCommentDetailActivityPresenterImpl implements IMoyuCommentDetailActivityPresenter {

    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private IMoyuCommentDetailActivityCallback mCallback = null;
    private final MoyuApi mApi;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_COMMENT=1;

    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.setRequestError("错误，请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.setRequestError("有点小问题");
                    break;
                case RETURN_COMMENT:
                    mCallback.returnSubComment((BaseResponseBean)msg.obj);
                    break;
            }

        }
    };

    public MoyuCommentDetailActivityPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void registerViewCallback(IMoyuCommentDetailActivityCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }

    @Override
    public void toIssueComment(MomentSubComment momentSubComment) {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE, "");
        if (token.equals("")||token==null){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.sendSubComment(token,momentSubComment)
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
                        message.what = RETURN_COMMENT;
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
