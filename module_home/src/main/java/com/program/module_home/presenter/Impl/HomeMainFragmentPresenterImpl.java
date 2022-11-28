package com.program.module_home.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_base.LogUtils;
import com.program.module_home.callback.IHomeMainFragmentCallback;
import com.program.module_home.db.ChannelBaseHelper;
import com.program.module_home.db.ChannelDao;
import com.program.module_home.model.HomeApi;
import com.program.module_home.model.bean.CategoryBean;
import com.program.module_home.model.bean.CategoryDB;
import com.program.module_home.model.bean.InfoBean;
import com.program.module_home.presenter.IHomeMainFragmentPresenter;
import com.program.module_home.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeMainFragmentPresenterImpl implements IHomeMainFragmentPresenter {
    private IHomeMainFragmentCallback mCallback = null;


    private static final int ERROR = 0;
    private static final int IS_HAVE_LIST = 1;
    private static final int RETURN_CATEGORY_lIST = 2;
    private static final int RETURN_IS_LOGIN = 3;
    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    LogUtils.d("test","error");
                    break;
                case IS_HAVE_LIST:
                    List<CategoryDB> list = (List<CategoryDB>) msg.obj;
                    if (list.isEmpty()||list.size()==0) {
                        getCategoryListByNetWork();
                    }else {
                        mCallback.setCategoryList(list);
                    }
                    break;
                case RETURN_CATEGORY_lIST:
                    CategoryBean bean = (CategoryBean) msg.obj;
                    List<CategoryBean.DataBean> data = bean.getData();
                    List<CategoryDB> categoryDBS = new ArrayList<>();
                    for (CategoryBean.DataBean datum : data) {
                        CategoryDB categoryDB = new CategoryDB();
                        categoryDB.setId(datum.getId());
                        categoryDB.setCategoryName(datum.getCategoryName());
                        categoryDB.setOrder(datum.getOrder());
                        categoryDB.setDescription(datum.getDescription());
                        categoryDB.setCreateTime(datum.getCreateTime());
                        categoryDB.setPyName(datum.getPyName());
                        categoryDB.setMy(false);
                        categoryDBS.add(categoryDB);
                    }
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            mDao.insertList(categoryDBS);
                        }
                    }.start();
                    mCallback.setCategoryList(categoryDBS);
                    break;
                case RETURN_IS_LOGIN:
                    mCallback.setUserIsLogin(msg.obj.toString());
                    break;
            }
        }
    };
    private final HomeApi mApi;
    private final ChannelDao mDao;
    private final SharedPreferencesUtils mSharedPreferencesUtils;

    public HomeMainFragmentPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mDao = new ChannelBaseHelper().getDb().getChannelDao();
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    //数据库里查
    @Override
    public void getCategoryList() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Object> emitter) throws Throwable {
                List<CategoryDB> channels = mDao.getChannels();
                emitter.onNext(channels);
            }
        }) .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what=IS_HAVE_LIST;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserIsLogin() {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE, "");
        Message message = new Message();
        message.what=RETURN_IS_LOGIN;
        if (token.equals("")){
            message.obj="用户未登录";
            mHandler.sendMessage(message);
            return;
        }
        mApi.getUserIsLogin(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        InfoBean bean = (InfoBean) o;
                        if (!bean.getSuccess()){
                            message.obj="用户未登录";
                            mSharedPreferencesUtils.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
                            mHandler.sendMessage(message);
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
//                        mSharedPreferencesUtils.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //网络请求
    private void getCategoryListByNetWork(){
        mApi.getCategoryList()
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
                        message.what = RETURN_CATEGORY_lIST;
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
    public void registerViewCallback(IHomeMainFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IHomeMainFragmentCallback callback) {
        this.mCallback = null;
    }


}
