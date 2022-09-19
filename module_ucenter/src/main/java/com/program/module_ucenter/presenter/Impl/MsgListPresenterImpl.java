package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IMsgListCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.module_ucenter.model.domain.MsgSystemBean;
import com.program.module_ucenter.presenter.IMsgListPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MsgListPresenterImpl implements IMsgListPresenter {

    private IMsgListCallback mCallback= null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final UcenterApi mApi;
    private final String mToken;
    private int pageAt = 0;
    private int maxPage = 0;

    private static final int ERROR=0;
    private static final int RETRUN_MSG_LIST_AT=1;
    private static final int RETRUN_MORE_MSG_LIST_AT=2;
    private static final int NOT_MORE=10;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case RETRUN_MSG_LIST_AT:
                    MsgAtBean msgAtBean = (MsgAtBean) msg.obj;
                    maxPage = msgAtBean.getData().getTotalPages();
                    pageAt++;
                    mCallback.setMsgAtList(msgAtBean);
                    break;
                case RETRUN_MORE_MSG_LIST_AT:
                    MsgAtBean msgAtMoreBean = (MsgAtBean) msg.obj;
                    pageAt++;
                    mCallback.setMoreMsgAtList(msgAtMoreBean);
                    break;
                case NOT_MORE:
                    mCallback.setNotMore("暂时无更多");
                    break;
                case ERROR:
                    mCallback.setError("网络错误，请稍后重试");
                    break;
            }
        }
    };

    public MsgListPresenterImpl(){
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    @Override
    public void getMsgListAt() {
        LogUtils.d("test","getMsgListAt()");
        pageAt = 1;
        mApi.getMsgAtList(pageAt,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgAtBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgAtBean msgAtBean) {
                        LogUtils.d("getMsglist","msg data="+msgAtBean.getData().getContent().size());
                        Message message = new Message();
                        if (msgAtBean.getCode()== Constants.SUCCESS){
                            message.what = RETRUN_MSG_LIST_AT;
                            message.obj = msgAtBean;
                        }else {
                            message.what = ERROR;
                            message.obj="获取失败请检查网络并稍后重试";
                        }
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        networkError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void networkError() {
        Message message = new Message();
        message.what=ERROR;
        message.obj="获取失败，请稍后重试";
        mHandler.sendMessage(message);
    }

    @Override
    public void getMoreMsgListAt() {
        LogUtils.d("test","isLoadMore = "+(maxPage>=pageAt));
        if (maxPage>=pageAt){
            mApi.getMsgAtList(pageAt,mToken)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<MsgAtBean>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull MsgAtBean msgAtBean) {
                            Message message = new Message();
                            if (msgAtBean.getCode()==Constants.SUCCESS){
                                message.what = RETRUN_MORE_MSG_LIST_AT;
                                message.obj = msgAtBean;
                            }else {
                                message.what = ERROR;
                                message.obj = "获取失败请检查网络并稍后重试";
                            }
                            mHandler.sendMessage(message);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                                networkError();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        }else {
            Message message = new Message();
            message.what=NOT_MORE;
            message.obj="暂无更多";
            mHandler.sendMessage(message);
        }
    }

    @Override
    public void registerViewCallback(IMsgListCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
