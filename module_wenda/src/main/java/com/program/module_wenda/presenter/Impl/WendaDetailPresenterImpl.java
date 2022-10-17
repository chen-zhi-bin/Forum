package com.program.module_wenda.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_wenda.callback.IWendaDetailCallback;
import com.program.module_wenda.model.WendaApi;
import com.program.module_wenda.model.bean.Answer;
import com.program.module_wenda.model.bean.AnswerBean;
import com.program.module_wenda.model.bean.RelatedQuestionBean;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaContentBean;
import com.program.module_wenda.presenter.IWendaDetailPresenter;
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
import retrofit2.Retrofit;

public class WendaDetailPresenterImpl implements IWendaDetailPresenter {
    private IWendaDetailCallback mCallback = null;
    private final WendaApi mApi;

    private static final int ERROR = -1;        //能请求，但是错误
    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_WENDA_DETAIL = 1;
    private static final int RETURN_WENDA_DETAIL_ERROR = 2;
    private static final int RETURN_FOLLOW = 4;
    private static final int RETURN_FOLLOW_ERROR = 5;
    private static final int RETURN_ADD_FOLLOW = 6;
    private static final int RETURN_ADD_FOLLOW_ERROR = 7;
    private static final int RETURN_UN_FOLLOW = 8;
    private static final int RETURN_UN_FOLLOW_ERROR = 9;
    private static final int RETURN_ANSWER_LIST = 10;
    private static final int RETURN_ANSWER_LIST_EERROR = 11;
    private static final int RETURN_THUMBE = 12;
    private static final int RETURN_RELATEDQUESTION = 13;
    private static final int RETURN_RELATEDQUESTION_ERROR = 14;
    private static final int RETURN_SEND_COMMENT = 15;
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
                case RETURN_WENDA_DETAIL:
                    mCallback.setWendaDetail((WendaContentBean) msg.obj);
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
                case RETURN_ANSWER_LIST:
                    mCallback.setAnswerList((AnswerBean) msg.obj);
                    break;
                case RETURN_ANSWER_LIST_EERROR:
                    mCallback.setRequestError(((AnswerBean) msg.obj).getMessage());
                    break;
                case RETURN_THUMBE:
                    mCallback.setThumbState((BaseResponseBean)msg.obj);
                    break;
                case RETURN_RELATEDQUESTION:
                    mCallback.setRelatedQuestionList((WendaBean)msg.obj);
                    break;
                case RETURN_RELATEDQUESTION_ERROR:
                    mCallback.setRequestError(((WendaBean)msg.obj).getMessage());
                    break;
                case RETURN_SEND_COMMENT:
                    mCallback.setSendCommentReturn((BaseResponseBean)msg.obj);
                    break;
            }
        }
    };
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final String mToken;

    public WendaDetailPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mToken = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    @Override
    public void getWendaDetail(String wendaId) {
        mApi.getWendaDetail(wendaId)
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
                        message.what = ((WendaContentBean) o).getCode() == Constants.SUCCESS ? RETURN_WENDA_DETAIL : RETURN_WENDA_DETAIL_ERROR;
                        message.obj = o;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Message message = new Message();
                        message.what = RETURN_ERROR;
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private int page = 1;

    @Override
    public void getWendaAnswerList(String wendaId) {
        page = 1;
        mApi.getAnswerList(wendaId, page)
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
                        message.what = ((AnswerBean) o).getCode() == Constants.SUCCESS ? RETURN_ANSWER_LIST : RETURN_ANSWER_LIST_EERROR;
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
    public void getRelatedQuestion(String wendaId) {
        mApi.getRelatedQuestion(wendaId,10)
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
                        message.what = ((WendaBean)o).getCode()==Constants.SUCCESS?RETURN_RELATEDQUESTION:RETURN_RELATEDQUESTION_ERROR;
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
    public void sendComment(Answer answer) {
        mApi.toAnswer(answer,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test","send data = "+((BaseResponseBean)o).toString());
                        Message message = new Message();
                        message.what = ((BaseResponseBean)o).getCode()==Constants.SUCCESS?RETURN_SEND_COMMENT:ERROR;
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
    public void isThumb(String wendaId) {
        mApi.isThumbState(mToken, wendaId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test","data is Thumb = "+((BaseResponseBean)o).toString());
                        Message message = new Message();
                        message.what = ((BaseResponseBean) o).getCode() == Constants.SUCCESS ? RETURN_THUMBE : ERROR;
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
    public void registerViewCallback(IWendaDetailCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {

    }
}
