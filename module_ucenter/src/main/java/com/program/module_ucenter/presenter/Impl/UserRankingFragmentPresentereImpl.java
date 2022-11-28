package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IUserRankingFragmentCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.RankingSobBean;
import com.program.module_ucenter.presenter.IUserRankingFragmentPresenter;
import com.program.module_ucenter.utils.RetrofitManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserRankingFragmentPresentereImpl implements IUserRankingFragmentPresenter {


    private IUserRankingFragmentCallback mCallback = null;


    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_RANKING_LIST = 1;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.onMsgError("网络错误，请稍后重试");
                    break;
                case RETURN_ERROR:
                    if (msg.obj instanceof RankingSobBean){
                        mCallback.onMsgError(((RankingSobBean) msg.obj).getMessage());
                    }
                    break;
                case RETURN_RANKING_LIST:
                    mCallback.setRankingSob((RankingSobBean) msg.obj);
                    break;
            }
        }
    };
    private final UcenterApi mApi;

    public UserRankingFragmentPresentereImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getRankingSob() {
        mApi.getRankingSob(10)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.getBindLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((RankingSobBean)o).getCode() == Constants.SUCCESS?RETURN_RANKING_LIST:RETURN_ERROR;
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
    public void registerViewCallback(IUserRankingFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IUserRankingFragmentCallback callback) {
            mCallback = null;
    }

}
