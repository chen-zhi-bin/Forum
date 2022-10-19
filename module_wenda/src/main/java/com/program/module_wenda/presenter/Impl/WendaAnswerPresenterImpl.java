package com.program.module_wenda.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_wenda.callback.IWendaAnswerCallback;
import com.program.module_wenda.model.WendaApi;
import com.program.module_wenda.model.bean.WendaSubCommentInputBean;
import com.program.module_wenda.presenter.IWendaAnswerPresenter;
import com.program.module_wenda.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WendaAnswerPresenterImpl implements IWendaAnswerPresenter {
    private IWendaAnswerCallback mCallback = null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private String mToken;
    private final WendaApi mApi;

    private static final int ERROR = -1;        //能请求，但是错误
    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_REPLY = 1;
    private static final int RETURN_THUMB = 2;
    private static final int RETURN_CLCIK_THUMB = 3;
    private static final int RETURN_PRISE = 4;
    private static final int RETURN_FOLLOW = 5;
    private static final int RETURN_FOLLOW_ERROR = 6;
    private static final int RETURN_ADD_FOLLOW = 7;
    private static final int RETURN_ADD_FOLLOW_ERROR = 8;
    private static final int RETURN_UN_FOLLOW = 9;
    private static final int RETURN_UN_FOLLOW_ERROR = 10;
    private static final int RETURN_SET_BESTAS = 11;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ERROR:
                    mCallback.setRequestError("请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.setRequestError("网络错误");
                    break;
                case RETURN_REPLY:
                    mCallback.replyAnswerReturn((BaseResponseBean) msg.obj);
                    break;
                case RETURN_THUMB:
                    mCallback.setReturnThumbClick((BaseResponseBean) msg.obj);
                    break;
                case RETURN_CLCIK_THUMB:
                    mCallback.setReturnClickThumb((BaseResponseBean) msg.obj);
                    break;
                case RETURN_PRISE:
                    mCallback.setPriseResult((BaseResponseBean)msg.obj);
                    break;
                case RETURN_FOLLOW:
                    mCallback.setFollowState((FollowBean) msg.obj);
                    break;
                case RETURN_FOLLOW_ERROR:
                    mCallback.setFollowStateError((FollowBean) msg.obj);
                    break;
                case RETURN_ADD_FOLLOW:
                    mCallback.setAddFollowMsg(((AddOrUnFollowBean) msg.obj).getMessage());
                    break;
                case RETURN_ADD_FOLLOW_ERROR:
                    mCallback.setAddFollowMsgError(((AddOrUnFollowBean) msg.obj).getMessage());
                    break;
                case RETURN_UN_FOLLOW:
                    mCallback.setUnFollowMsg(((AddOrUnFollowBean) msg.obj).getMessage());
                    break;
                case RETURN_UN_FOLLOW_ERROR:
                    mCallback.setUnFollowMsgError(((AddOrUnFollowBean) msg.obj).getMessage());
                    break;
                case RETURN_SET_BESTAS:
                    mCallback.setReturnBestasAnswer((BaseResponseBean)msg.obj);
                    break;
            }
        }
    };

    public WendaAnswerPresenterImpl() {
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void replyAnswer(WendaSubCommentInputBean data) {
        mApi.replyAnswer(data, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test", "评论子评论 返回 = " + ((BaseResponseBean) o).toString());
                        Message message = new Message();
                        message.what = ((BaseResponseBean) o).getCode() == Constants.SUCCESS ? RETURN_REPLY : ERROR;
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
    public void isThumbCheck(String commentId) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.commentThumbCheck(commentId, mToken)
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
                        message.what = RETURN_THUMB;
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
    public void toWendaCommentThumb(String wendaCommentId) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.commentThumbCheck(wendaCommentId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test", "data thumb = " + ((BaseResponseBean) o).toString());
                        Message message = new Message();
                        message.what = ((BaseResponseBean) o).getCode() == Constants.SUCCESS ? RETURN_CLCIK_THUMB : ERROR;
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
    public void toCommentPrise(String commentId, int value) {
        mApi.commentPrise(commentId, value, false, mToken)
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
                        message.what = RETURN_PRISE;
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
    public void setBestAsAnswer(String wendaId, String wendaCommentId) {
        mApi.setBestAsComment(wendaId,wendaCommentId,mToken)
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
                        message.what =RETURN_SET_BESTAS;
                        message.obj=o;
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
    public void getUserFollowState(String userId) {
        mApi.getFollowState(userId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FollowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull FollowBean followBean) {
                        Message message = new Message();
                        message.what = followBean.getCode() == Constants.SUCCESS ? RETURN_FOLLOW : RETURN_FOLLOW_ERROR;
                        message.obj = followBean;
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
    public void addFollow(String userId) {
        mApi.addFollow(userId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddOrUnFollowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AddOrUnFollowBean addFollowBean) {
                        Message message = new Message();
                        message.what = addFollowBean.getCode() == Constants.SUCCESS ? RETURN_ADD_FOLLOW : RETURN_ADD_FOLLOW_ERROR;
                        message.obj = addFollowBean;
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
    public void unFollow(String userId) {
        mApi.unFollow(userId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddOrUnFollowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AddOrUnFollowBean addOrUnFollowBean) {
                        Message message = new Message();
                        message.what = addOrUnFollowBean.getCode() == Constants.SUCCESS ? RETURN_UN_FOLLOW : RETURN_UN_FOLLOW_ERROR;
                        message.obj = addOrUnFollowBean;
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
    public void registerViewCallback(IWendaAnswerCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
