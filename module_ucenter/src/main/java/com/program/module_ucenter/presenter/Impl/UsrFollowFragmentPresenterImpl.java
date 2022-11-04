package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IUserFollowFragmentCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.FollowListBean;
import com.program.module_ucenter.presenter.IUserFollowFragmentPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UsrFollowFragmentPresenterImpl implements IUserFollowFragmentPresenter {

    private final UcenterApi mApi;
    private IUserFollowFragmentCallback mCallback = null;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_FOLLOW_LIST=1;
    private static final int RETURN_MORE_FOLLOW_LIST=2;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.onMsgError("网络错误");
                    break;
                case RETURN_ERROR:
                    if (msg.obj instanceof FollowListBean){
                        mCallback.onMsgError(((FollowListBean) msg.obj).getMessage());
                    }
                    break;
                case RETURN_FOLLOW_LIST:
                    pageFollow++;
                    mCallback.setFollowList((FollowListBean)msg.obj);
                    break;
                case RETURN_MORE_FOLLOW_LIST:
                    pageFollow++;
                    mCallback.setMoreFollowList((FollowListBean)msg.obj);
                    break;

            }
        }
    };
    private final String mToken;

    public UsrFollowFragmentPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mToken = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    private int pageFollow =0;
    @Override
    public void getFollowList(String userId) {
        pageFollow = 1;
        mApi.getFollowList(userId,pageFollow,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .compose(mCallback.getBindLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((FollowListBean)o).getCode()== Constants.SUCCESS?RETURN_FOLLOW_LIST:RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        requestFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMoreFollowList(String userId) {
        mApi.getFollowList(userId,pageFollow,mToken)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.getBindLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((FollowListBean)o).getCode()==Constants.SUCCESS?RETURN_MORE_FOLLOW_LIST:RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
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
    public void registerViewCallback(IUserFollowFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }


}
