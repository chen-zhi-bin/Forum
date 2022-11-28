package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.recyclerview.widget.RecyclerView;

import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IFavoriteListCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.presenter.IFavoriteListPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.FavoriteBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavoriteListPresenterImpl implements IFavoriteListPresenter {

    private IFavoriteListCallback mCallback = null;
    private final UcenterApi mApi;
    private final String mToken;

    private static final int ERROR=-1;
    private static final int RETURN_ERROR=0;
    private static final int RETURN_FAVORITE_LIST=1;
    private static final int RETURN_MORE_FAVORITE_LIST=2;
    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.onMsgError("错误，请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.onMsgError(((FavoriteBean)msg.obj).getMessage());
                    break;
                case RETURN_FAVORITE_LIST:
                    page++;
                    mCallback.setFavoriteList((FavoriteBean)msg.obj);
                    break;
                case RETURN_MORE_FAVORITE_LIST:
                    page++;
                    mCallback.setMoreFavoriteList((FavoriteBean)msg.obj);
                    break;
            }
        }
    };

    public FavoriteListPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mToken = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    private int page = -1;
    @Override
    public void getFavoriteList(String collectionId) {
        page = 1;
        mApi.getFavoriteList(collectionId,page,0,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.getBindLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = ((FavoriteBean)o).getCode()== Constants.SUCCESS?RETURN_FAVORITE_LIST:RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        requestFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMoreFavoriteList(String collectionId) {
        mApi.getFavoriteList(collectionId,page,0,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.getBindLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = ((FavoriteBean)o).getCode()== Constants.SUCCESS?RETURN_MORE_FAVORITE_LIST:RETURN_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
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
    public void registerViewCallback(IFavoriteListCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IFavoriteListCallback callback) {
        mCallback = null;
    }
}
