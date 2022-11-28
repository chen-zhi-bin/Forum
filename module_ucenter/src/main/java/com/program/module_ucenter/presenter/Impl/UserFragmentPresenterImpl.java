package com.program.module_ucenter.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.program.lib_base.LogUtils;
import com.program.module_ucenter.callback.IUserFragmentCallback;
import com.program.module_ucenter.model.UcenterApi;
import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.AvaTarBean;
import com.program.module_ucenter.model.domain.UnreadMsgBean;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.module_ucenter.presenter.IUserFragmentPresenter;
import com.program.module_ucenter.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.rxlifecycle4.android.RxLifecycleAndroid;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserFragmentPresenterImpl implements IUserFragmentPresenter {
    private IUserFragmentCallback mCallback = null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private final UcenterApi mApi;

    private final static int REQUEST_SUCCESS=10000;
    private final static int RETURN_AVATAR = 0;
    private final static int ERROR = 1;
    private final static int RETURN_USER_MSG = 2;
    private final static int RETURN_USER_ACHIEVEMENT = 3;
    private final static int RETURN_USER_UNREADCOUNT = 4;
    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case RETURN_AVATAR:
                    LogUtils.d("getAvatat","data="+(AvaTarBean)msg.obj);
                    LogUtils.d("getAvatat","data="+((AvaTarBean) msg.obj).getData());
                    mCallback.setAvatar(((AvaTarBean) msg.obj).getData());
                    break;
                case RETURN_USER_MSG:
                    mCallback.setMsg((UserMessageBean) msg.obj);
                    break;
                case RETURN_USER_ACHIEVEMENT:
                    mCallback.setUserAchievement((AchievementBean) msg.obj);
                    break;
                case RETURN_USER_UNREADCOUNT:
                    UnreadMsgBean data = (UnreadMsgBean) msg.obj;
                    UnreadMsgBean.DataBean dataBean = data.getData();
                    int count = dataBean.getArticleMsgCount()+dataBean.getAtMsgCount()+dataBean.getMomentCommentCount()+dataBean.getShareMsgCount()
                            +dataBean.getSystemMsgCount()+dataBean.getThumbUpMsgCount()+dataBean.getWendaMsgCount();
                    mCallback.setUnreadMsgCount(count+"");
                    break;
                case ERROR:
                    mCallback.onErrorMessage(msg.obj.toString());
                    break;
            }

        }
    };

    public UserFragmentPresenterImpl() {
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void registerViewCallback(IUserFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IUserFragmentCallback callback) {
        mCallback = null;
    }

    @Override
    public void getAvatar() {
        //test
        String string = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_PHONE);
        LogUtils.d("getAvatar","phone = "+string+"===="+string.length());
        mApi.getAvatar(string)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
//                .compose(mCallback.getBindToLifecycle().<AvaTarBean>bindToLifecycle())
                .subscribe(new Observer<AvaTarBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AvaTarBean avaTarBean) {
                        Message message=new Message();
                        LogUtils.d("getAvatar","AvaTarBean = "+avaTarBean.toString());
                        if (avaTarBean.getCode()==10000){
                            message.what = RETURN_AVATAR;
                            message.obj = avaTarBean;
                            mHandler.sendMessage(message);
                        }else {
                            message.what = ERROR;
                            message.obj = avaTarBean.getMessage();
                            mHandler.sendMessage(message);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        toHandlerError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void toHandlerError(@NonNull Throwable e) {
        Message message=new Message();
        message.what = ERROR;
        message.obj = e.getMessage();
        mHandler.sendMessage(message);
    }

    @Override
    public void getUserMsg() {
        String id = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_ID);
        mApi.getUserMessage(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<UserMessageBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserMessageBean userMessageBean) {
                        Message message = new Message();
                        if (userMessageBean.getCode()==10000){
                            LogUtils.d("test","usermsg = "+userMessageBean.toString());
                            message.what = RETURN_USER_MSG;
                            message.obj = userMessageBean;
                        }else {
                            message.what = ERROR;
                            message.obj = userMessageBean.getMessage();
                        }
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        ToastUtils.showToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserAchievement() {
        String id = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_ID);
        mApi.getUserAchievementBean(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<AchievementBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AchievementBean achievementBean) {
                        LogUtils.d("getUserAchievement","achievementBean = "+achievementBean);
                        Message message = new Message();
                        if (achievementBean.getCode()==10000){
                            message.what = RETURN_USER_ACHIEVEMENT;
                            message.obj = achievementBean;
                        }else {
                            message.what = ERROR;
                            message.obj = achievementBean;
                        }
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        toHandlerError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getUnreadMsg() {
        String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        mApi.getUnreadBean(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<UnreadMsgBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UnreadMsgBean unreadMsgBean) {
                        LogUtils.d("bean","UnreadMsgBean = "+unreadMsgBean.toString());
                        Message message = new Message();
                        if (unreadMsgBean.getCode()==REQUEST_SUCCESS){
                            message.what=RETURN_USER_UNREADCOUNT;
                            message.obj = unreadMsgBean;
                        }else {
                            message.what=  ERROR;
                            message.obj = unreadMsgBean.getMessage();
                        }
                        mHandler.sendMessage(message);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        toHandlerError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}
