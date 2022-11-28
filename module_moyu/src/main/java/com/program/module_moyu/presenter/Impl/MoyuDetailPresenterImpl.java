package com.program.module_moyu.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_moyu.callback.IMoyuDetailCallback;
import com.program.module_moyu.model.bean.MomentComment;
import com.program.module_moyu.model.MoyuApi;
import com.program.module_moyu.model.bean.MomentCommentBean;
import com.program.module_moyu.model.bean.MomentSubComment;
import com.program.moudle_base.model.MoyuRequestBean;
import com.program.module_moyu.presenter.IMoyuDetailPresenter;
import com.program.module_moyu.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoyuDetailPresenterImpl implements IMoyuDetailPresenter {
    private IMoyuDetailCallback mCallback = null;
    private final MoyuApi mApi;

    private static final int ERROR = -1;
    private static final int RETURN_ERROR = 0;
    private static final int RETURN_MOYU_DETAIL = 1;
    private static final int RETURN_MOYU_DETAIL_ERROR = 2;
    private static final int RETURN_MOYU_COMMENT = 3;
    private static final int RETURN_MOYU_COMMENT_ERROR = 4;
    private static final int RETURN_MOYU_THUMB = 5;
    private static final int RETURN_MOYU_THUMB_ERROR = 6;
    private static final int RETURN_USER_FOLLOW_STATE = 7;
    private static final int RETURN_USER_ADD_FOLLOW = 8;
    private static final int RETURN_USER_UN_FOLLOW = 9;
    private static final int RETURN_COMMENT = 10;
    private static final int RETURN_SUB_COMMENT = 11;
    private static final int RETURN_COMMENT_MORE = 12;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case RETURN_MOYU_DETAIL:
                    mCallback.setMoyuDetailData((MoyuRequestBean) msg.obj);
                    break;
                case RETURN_MOYU_DETAIL_ERROR:
                    mCallback.setRequestError(((MoyuRequestBean) msg.obj).getMessage());
                    break;
                case RETURN_ERROR:
                    mCallback.setRequestError("网络错误，请稍后重试");
                    break;
                case RETURN_MOYU_COMMENT:
                    mCallback.setMoyuCommentData(((MomentCommentBean) msg.obj));
                    page++;
                    break;
                case RETURN_COMMENT_MORE:
                    mCallback.setMoyuCommentDataMore(((MomentCommentBean) msg.obj));
                    page++;
                    break;
                case RETURN_MOYU_COMMENT_ERROR:
                    mCallback.setRequestError(((MomentCommentBean) msg.obj).getMessage());
                    break;
                case RETURN_MOYU_THUMB:
                    mCallback.setThumb();
                    break;
                case RETURN_MOYU_THUMB_ERROR:
                    mCallback.setRequestError(((BaseResponseBean) msg.obj).getMessage());
                    break;
                case RETURN_USER_FOLLOW_STATE:
                    mCallback.setMoyuUserFollowState((int) Double.parseDouble(((BaseResponseBean) msg.obj).getData() + ""));
                    break;
                case RETURN_USER_ADD_FOLLOW:
                    mCallback.returnAddFollowData((BaseResponseBean) msg.obj);
                    break;
                case RETURN_USER_UN_FOLLOW:
                    mCallback.returnUnFollowData((BaseResponseBean)msg.obj);
                    break;
                case RETURN_COMMENT:
                    mCallback.returnComment((BaseResponseBean)msg.obj);
                    break;
                case RETURN_SUB_COMMENT:
                    mCallback.returnSubComment((BaseResponseBean)msg.obj);
                    page=1; //重置评论页码
                    break;
                case ERROR:
                    mCallback.setRequestError(((BaseResponseBean) msg.obj).getMessage());
                    break;
            }
        }
    };
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private String mToken;

    public MoyuDetailPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    @Override
    public void registerViewCallback(IMoyuDetailCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IMoyuDetailCallback callback) {
        mCallback = null;
    }

    @Override
    public void getMoyuDetail(String id) {
        LogUtils.d("getMoyuDetail", "id = " + id);
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.getMoyuDetail(id, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        MoyuRequestBean data = (MoyuRequestBean) o;
                        LogUtils.d("test", "data = " + o.toString());
                        Message message = new Message();
                        message.what = data.getCode() == Constants.SUCCESS ? RETURN_MOYU_DETAIL : RETURN_MOYU_DETAIL_ERROR;
                        message.obj = data;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void responseError() {
        Message message = new Message();
        message.what = RETURN_ERROR;
        mHandler.sendMessage(message);
    }

    //todo:加载更多还没做
    private int page = 1;

    @Override
    public void getMoyuComment(String id) {
        page = 1;
        mApi.getMomentComment(id, page, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        MomentCommentBean data = (MomentCommentBean) o;
                        LogUtils.d("test", "data = " + o.toString());
                        Message message = new Message();
                        message.what = data.getCode() == Constants.SUCCESS ? RETURN_MOYU_COMMENT : RETURN_MOYU_COMMENT_ERROR;
                        message.obj = data;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getMoyuCommentLoadMore(String id) {
        mApi.getMomentComment(id, page, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        MomentCommentBean data = (MomentCommentBean) o;
                        LogUtils.d("test", "data = " + o.toString());
                        Message message = new Message();
                        message.what = data.getCode() == Constants.SUCCESS ? RETURN_COMMENT_MORE : ERROR;
                        message.obj = data;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getThumbUp(String id) {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.giveThumb(id, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        BaseResponseBean data = (BaseResponseBean) o;
                        LogUtils.d("test", "data = " + data.toString());
                        Message message = new Message();
                        message.what = data.getCode() == Constants.SUCCESS ? RETURN_MOYU_THUMB : RETURN_MOYU_THUMB_ERROR;
                        message.obj = data;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFollowState(String uid) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.getFollowState(uid, mToken)
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
                        message.what = ((BaseResponseBean) o).getCode() == Constants.SUCCESS ? RETURN_USER_FOLLOW_STATE : ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void addFollow(String uid) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.addFollow(uid, mToken)
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
                        message.what = ((BaseResponseBean) o).getCode() == Constants.SUCCESS ? RETURN_USER_ADD_FOLLOW : ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void unFollow(String uid) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.unFollow(uid, mToken)
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
                        message.what = ((BaseResponseBean) o).getCode() == Constants.SUCCESS ? RETURN_USER_UN_FOLLOW : ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void toIssueComment(MomentComment momentComment) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.sendComment(mToken,momentComment)
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
                        message.what = ((BaseResponseBean)o).getCode()==Constants.SUCCESS?RETURN_COMMENT:ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void toIssueSubComment(MomentSubComment momentSubComment) {
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE,"");
        if (mToken.equals("")){
            ToastUtils.showToast("尚未登录");
            return;
        }
        mApi.sendSubComment(mToken,momentSubComment)
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
                        message.what = ((BaseResponseBean)o).getCode()==Constants.SUCCESS?RETURN_SUB_COMMENT:ERROR;
                        message.obj=o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        responseError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
