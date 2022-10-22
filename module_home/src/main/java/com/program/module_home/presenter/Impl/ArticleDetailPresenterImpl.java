package com.program.module_home.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_common.Constants;
import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.model.HomeApi;
import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.utils.RetrofitManager;
import com.program.moudle_base.model.PriseQrCodeBean;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ArticleDetailPresenterImpl implements IArticleDetailPresenter {


    private IArticleDetailCallback mCallback = null;
    private final HomeApi mApi;

    private static final int ERROR = -1;        //能请求，但是错误
    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_ARTICLE_DETAIL = 1;
    private static final int RETURN_QR_CODE = 2;
    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            switch (msg.what) {
                case ERROR:
                    mCallback.setRequestError("请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.setRequestError("网络错误");
                    break;
                case RETURN_ARTICLE_DETAIL:
                    mCallback.setArticleDetail(((ArticleDetailBean) msg.obj).getData());
                    break;
                case RETURN_QR_CODE:
                    if (((PriseQrCodeBean)msg.obj).getCode()== Constants.SUCCESS) {
                        mCallback.setPriseQrCode((PriseQrCodeBean)msg.obj);
                    }else {
                        mCallback.setRequestError(((PriseQrCodeBean)msg.obj).getMessage());
                    }
                    break;
            }
        }
    };

    public ArticleDetailPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getArticleDetail(String articleId) {
        mApi.geetArticleDetail(articleId)
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
                        message.what = ((ArticleDetailBean) o).getCode() == Constants.SUCCESS ? RETURN_ARTICLE_DETAIL : ERROR;
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
    public void getPriseQrCode(String userId) {
        mApi.getPriseQrCode(userId)
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
                        message.what = RETURN_QR_CODE;
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
    public void registerViewCallback(IArticleDetailCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {

    }
}
