package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IUserCollectionListFragmentCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.presenter.IUserCollectionListFragmentPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.CollectionBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserCollectionListFragmentPresenterImpl implements IUserCollectionListFragmentPresenter {
    private IUserCollectionListFragmentCallback mCallback=null;
    private final UcenterApi mApi;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_COLLECTION_LIST = 1;
    private static final int RETURN_MORE_COLLECTION_LIST = 2;
    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.onMsgError("错误，请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.onMsgError(((CollectionBean)msg.obj).getMessage());
                    break;
                case RETURN_COLLECTION_LIST:
                    page++;
                    mCallback.setCollectionList((CollectionBean)msg.obj);
                    break;
                case RETURN_MORE_COLLECTION_LIST:
                    page++;
                    mCallback.setMoreCollectionList((CollectionBean)msg.obj);
                    break;
            }
        }
    };
    private final String mToken;

    public UserCollectionListFragmentPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mToken = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    private int page = -1;
    @Override
    public void getCollectionList() {
        page = 1;
        mApi.getCollectionList(page,mToken)
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
                        message.what = ((CollectionBean)o).getCode()== Constants.SUCCESS?RETURN_COLLECTION_LIST:RETURN_ERROR;
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
    public void getMoreCollectionList() {
        mApi.getCollectionList(page,mToken)
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
                        message.what = ((CollectionBean)o).getCode()==Constants.SUCCESS?RETURN_MORE_COLLECTION_LIST:RETURN_ERROR;
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
    public void registerViewCallback(IUserCollectionListFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IUserCollectionListFragmentCallback callback) {
        mCallback = null;
    }
}
