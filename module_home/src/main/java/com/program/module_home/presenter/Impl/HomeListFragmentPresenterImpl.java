package com.program.module_home.presenter.Impl;

import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeListFragmentPresenterImpl implements IHomeListFragmentPresenter {
    private IHomeListFragmentCallback mCallback = null;
    private List<IHomeListFragmentCallback> mCallbacks = new ArrayList<>();
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
            String key = msg.getData().getString("key");
            for (IHomeListFragmentCallback callback : mCallbacks) {
                if (callback.getKey().equals(key)) {
                    mCallback = callback;
                }
            }
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
    public void getUpdateArticleInfo(String key,String id) {
        for (IHomeListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(id)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
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
                        message.setData(bundle);
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
    public void getRecommend(String key,String id) {
        for (IHomeListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(id)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
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
                            message.setData(bundle);
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
                            message.setData(bundle);
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
                            message.setData(bundle);
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

        for (IHomeListFragmentCallback callback : mCallbacks) {
            if (callback.getKey().equals(id)) {
                mCallback = callback;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key",id);
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
                            message.setData(bundle);
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
                            message.setData(bundle);
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
//        this.mCallback = callback;
        if (!mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }
    }

    @Override
    public void unregisterViewCallback(IHomeListFragmentCallback callback) {
        mCallbacks.remove(callback);
    }

}
