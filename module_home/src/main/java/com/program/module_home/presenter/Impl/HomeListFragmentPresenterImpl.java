package com.program.module_home.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_home.callback.IHomeListFragmentCallback;
import com.program.module_home.model.HomeApi;
import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.BannerBean;
import com.program.module_home.model.bean.HomeItemBean;
import com.program.module_home.presenter.IHomeListFragmentPresenter;
import com.program.module_home.utils.RetrofitManager;
import com.program.moudle_base.utils.ToastUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeListFragmentPresenterImpl implements IHomeListFragmentPresenter {
    private IHomeListFragmentCallback mCallback = null;
    private final HomeApi mApi;

    private static final int ERROR = -1;         //能请求，但是有错误
    private static final int RETURN_ERROR = 0;  //请求错误
    private static final int RETURN_HOME_ITEM_BEAN = 1;
    private static final int RETURN_BANNER = 2;
    private static final int RETURN_HOME_ITEM_BEAN_MORE = 3;
    private static final int RETURN_HOME_ITEM_UPDATE = 4;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case ERROR:
                    mCallback.setRequestError(((HomeItemBean) msg.obj).getMessage());
                    break;
                case RETURN_ERROR:
                    mCallback.setRequestError("错误，请稍后重试");
                    mCallback.onError();
                    break;
                case RETURN_HOME_ITEM_BEAN:
                    page++;
                    mCallback.setHomeItem((HomeItemBean) msg.obj);
                    break;
                case RETURN_BANNER:
                    mCallback.setBanner((BannerBean)msg.obj);
                    break;
                case RETURN_HOME_ITEM_BEAN_MORE:
                    page++;
                    mCallback.setHomeItemMore((HomeItemBean)msg.obj);
                    break;
                case RETURN_HOME_ITEM_UPDATE:
                    mCallback.setArticleUpdateInfo((ArticleDetailBean)msg.obj);
                    break;
            }

        }
    };

    public HomeListFragmentPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    private int page = 0;

    @Override
    public void getUpdateArticleInfo(String id) {
        mApi.getArticleDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        LogUtils.d("test","data = "+o.toString());
                        Message message = new Message();
                        message.what=((ArticleDetailBean)o).getCode()==Constants.SUCCESS?RETURN_HOME_ITEM_UPDATE:ERROR;
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
    public void getRecommend(String id) {
        page = 1;
        if (id.equals("1")) {
            //轮播图
            mApi.getBanner()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .compose(mCallback.TobindToLifecycle())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                            Message message = new Message();
                            message.what = RETURN_BANNER;
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
            //推荐文章
            mApi.getRecommend(page)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .compose(mCallback.TobindToLifecycle())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                            Message message = new Message();
                            message.what = ((HomeItemBean) o).getCode() == Constants.SUCCESS ? RETURN_HOME_ITEM_BEAN : ERROR;
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
        } else {
            mApi.getRecommendByCategoryId(id, page)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .compose(mCallback.TobindToLifecycle())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                            Message message = new Message();
                            message.what = ((HomeItemBean) o).getCode() == Constants.SUCCESS ? RETURN_HOME_ITEM_BEAN : ERROR;
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
    }

    @Override
    public void getRecommendMore(String id) {
        if (id.equals("1")){
            mApi.getRecommend(page)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .compose(mCallback.TobindToLifecycle())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                            Message message = new Message();
                            message.what = ((HomeItemBean)o).getCode()==Constants.SUCCESS?RETURN_HOME_ITEM_BEAN_MORE:ERROR;
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
        }else {
            mApi.getRecommendByCategoryId(id,page)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .compose(mCallback.TobindToLifecycle())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                            Message message = new Message();
                            message.what = ((HomeItemBean)o).getCode()==Constants.SUCCESS?RETURN_HOME_ITEM_BEAN_MORE:ERROR;
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
    }

    private void requestFailed() {
        Message message = new Message();
        message.what = RETURN_ERROR;
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(IHomeListFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {

    }

}
