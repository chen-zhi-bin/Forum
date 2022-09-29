package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_common.Constants;
import com.program.module_ucenter.callback.IUserCenterCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.AddOrUnFollowBean;
import com.program.module_ucenter.model.domain.FollowBean;
import com.program.module_ucenter.model.domain.UserInfoBean;
import com.program.module_ucenter.presenter.IUserCenterPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserCenterPresenterImpl implements IUserCenterPresenter {

    private IUserCenterCallback mCallback = null;
    private final UcenterApi mApi;

    private static final int RETURN_INFO_ERROR = 0;
    private static final int RETURN_USER_INFO = 1;
    private static final int RETURN_USER_ACHIEVEMENT = 2;
    private static final int RETURN_ACHIEVEMENT_ERROR = 3;
    private static final int RETURN_FOLLOW = 4;
    private static final int RETURN_FOLLOW_ERROR = 5;
    private static final int RETURN_ADD_FOLLOW = 6;
    private static final int RETURN_ADD_FOLLOW_ERROR = 7;
    private static final int RETURN_UN_FOLLOW = 8;
    private static final int RETURN_UN_FOLLOW_ERROR = 9;
    private static final int ERROR = -1;

    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case RETURN_USER_INFO:
                    UserInfoBean infoBean = (UserInfoBean) msg.obj;
                    mCallback.initUserInfo(infoBean);
                    break;
                case RETURN_INFO_ERROR:
                    UserInfoBean userInfoBean = (UserInfoBean) msg.obj;
                    mCallback.returnError(userInfoBean.getMessage());
                    break;
                case RETURN_USER_ACHIEVEMENT:
                    mCallback.setAchievement((AchievementBean) msg.obj);
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
                case ERROR:
                    mCallback.onError();
                    break;
            }
        }
    };
    private final SharedPreferencesUtils mPreferencesUtils;

    public UserCenterPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void registerViewCallback(IUserCenterCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }

    @Override
    public void getUserInfo(String userId) {
        mApi.getUserInfo(userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserInfoBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserInfoBean userInfoBean) {
//                        LogUtils.d("test","userinfo =="+userInfoBean.toString());
                        Message message = new Message();
                        if (userInfoBean.getCode() == Constants.SUCCESS) {
                            message.what = RETURN_USER_INFO;
                            message.obj = userInfoBean;
                        } else {
                            message.obj = userInfoBean;
                            message.what = RETURN_INFO_ERROR;
                        }
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
    public void getUserAchievement(String userId) {
        mApi.getUserAchievementBean(userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AchievementBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AchievementBean achievementBean) {
                        Message message = new Message();
                        message.what = achievementBean.getCode() == Constants.SUCCESS ? RETURN_USER_ACHIEVEMENT : RETURN_ACHIEVEMENT_ERROR;
                        message.obj = achievementBean;
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
        String token = mPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.getFollowState(userId, token)
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
        String token = mPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.addFollow(userId, token)
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
        String token = mPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.unFollow(userId, token)
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
}
