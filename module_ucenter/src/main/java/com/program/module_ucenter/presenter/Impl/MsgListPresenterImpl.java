package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IMsgListCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.MsgArticleBean;
import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.module_ucenter.model.domain.MsgMomentBean;
import com.program.module_ucenter.model.domain.MsgThumbBean;
import com.program.module_ucenter.model.domain.MsgWendaBean;
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
    private static final int RETURN_MSG_LIST_AT =1;
    private static final int RETURN_MORE_MSG_LIST_AT =2;
    private static final int RETURN_MSG_LIST_THUMB =3;
    private static final int RETURN_MORE_MSG_LIST_THUMB =4;
    private static final int RETURN_MSG_LIST_MOMENT =5;
    private static final int RETURN_MORE_MSG_LIST_MOMENT =6;
    private static final int RETURN_MSG_LIST_ARTICLE =7;
    private static final int RETURN_MORE_MSG_LIST_ARTICLE =8;
    private static final int RETURN_MSG_LIST_WENDA =9;
    private static final int RETURN_MORE_MSG_LIST_WENDA =11;
    private static final int NOT_MORE=10;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case RETURN_MSG_LIST_AT:
                    MsgAtBean msgAtBean = (MsgAtBean) msg.obj;
                    maxPage = msgAtBean.getData().getTotalPages();
                    pageAt++;
                    mCallback.setMsgAtList(msgAtBean);
                    break;
                case RETURN_MORE_MSG_LIST_AT:
                    MsgAtBean msgAtMoreBean = (MsgAtBean) msg.obj;
                    pageAt++;
                    mCallback.setMoreMsgAtList(msgAtMoreBean);
                    break;
                case RETURN_MSG_LIST_THUMB:
                    pageThumb++;
                    mCallback.setMsgThumbList((MsgThumbBean) msg.obj);
                    break;
                case RETURN_MORE_MSG_LIST_THUMB:
                    pageThumb++;
                    mCallback.setMoreMsgThumbList((MsgThumbBean)msg.obj);
                    break;
                case RETURN_MSG_LIST_MOMENT:
                    pageMoment++;
                    mCallback.setMsgMomentList((MsgMomentBean)msg.obj);
                    break;
                case RETURN_MORE_MSG_LIST_MOMENT:
                    pageMoment++;
                    mCallback.setMoreMsgMomentList((MsgMomentBean)msg.obj);
                    break;
                case RETURN_MSG_LIST_ARTICLE:
                    pageArticle++;
                    mCallback.setMsgArticleList((MsgArticleBean)msg.obj);
                    break;
                case RETURN_MORE_MSG_LIST_ARTICLE:
                    pageArticle++;
                    mCallback.setMoreMsgArticleList((MsgArticleBean)msg.obj);
                    break;
                case RETURN_MSG_LIST_WENDA:
                    pageWenda++;
                    mCallback.setMsgWendaList((MsgWendaBean)msg.obj);
                    break;
                case RETURN_MORE_MSG_LIST_WENDA:
                    pageWenda++;
                    mCallback.setMoreMsgWendaList((MsgWendaBean)msg.obj);
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
                            message.what = RETURN_MSG_LIST_AT;
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
                                message.what = RETURN_MORE_MSG_LIST_AT;
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

    private int pageThumb = -1;

    @Override
    public void getMsgThumbList() {
        pageThumb = 1;
        mApi.getMsgThumb(pageThumb,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgThumbBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgThumbBean msgThumbBean) {
                        Message message = new Message();
                        message.what = RETURN_MSG_LIST_THUMB;
                        message.obj = msgThumbBean;
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

    @Override
    public void getMoreMsgThumbList() {
        mApi.getMsgThumb(pageThumb,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgThumbBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgThumbBean msgThumbBean) {
                        Message message = new Message();
                        message.what = RETURN_MORE_MSG_LIST_THUMB;
                        message.obj = msgThumbBean;
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

    private int pageMoment = -1;

    @Override
    public void getMsgMomentList() {
        pageMoment=1;
        mApi.getMsgMomentList(pageMoment,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgMomentBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgMomentBean msgMomentBean) {
                        Message message = new Message();
                        message.what = RETURN_MSG_LIST_MOMENT;
                        message.obj = msgMomentBean;
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

    @Override
    public void getMoreMsgMomentList() {
        mApi.getMsgMomentList(pageMoment,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgMomentBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgMomentBean msgMomentBean) {
                        Message message = new Message();
                        message.what = RETURN_MORE_MSG_LIST_MOMENT;
                        message.obj = msgMomentBean;
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


    private int pageArticle = -1;
    @Override
    public void getMsgArticleList() {
        pageArticle=1;
        mApi.getMsgArticleList(pageArticle,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgArticleBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgArticleBean msgArticleBean) {
                        Message message = new Message();
                        message.what = RETURN_MSG_LIST_ARTICLE;
                        message.obj = msgArticleBean;
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

    @Override
    public void getMoreMsgArticleList() {
        mApi.getMsgArticleList(pageArticle,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgArticleBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgArticleBean msgArticleBean) {
                        Message message = new Message();
                        message.what = RETURN_MORE_MSG_LIST_ARTICLE;
                        message.obj = msgArticleBean;
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

    private int pageWenda = -1;
    @Override
    public void getMsgWendaList() {
        pageWenda = 1;
        mApi.getMsgWenda(pageWenda,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgWendaBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgWendaBean msgWendaBean) {
                        Message message = new Message();
                        message.what = RETURN_MSG_LIST_WENDA;
                        message.obj = msgWendaBean;
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

    @Override
    public void getMoreMsgWendaList() {
        mApi.getMsgWenda(pageWenda,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MsgWendaBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgWendaBean msgWendaBean) {
                        Message message = new Message();
                        message.what = RETURN_MORE_MSG_LIST_WENDA;
                        message.obj = msgWendaBean;
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

    @Override
    public void registerViewCallback(IMsgListCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
