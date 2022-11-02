package com.program.module_wenda.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.lib_common.Constants;
import com.program.module_wenda.callback.IWendaRankingFragmentCallback;
import com.program.module_wenda.model.WendaApi;
import com.program.module_wenda.model.bean.WendaRankingBean;
import com.program.module_wenda.presenter.IWendaRankingFragmentPresenter;
import com.program.module_wenda.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WendaRankingFragmentPresenterImpl implements IWendaRankingFragmentPresenter {
    private IWendaRankingFragmentCallback mCallback = null;

    private static final int ERROR=-1;
    private static final int RETURN_ERROR=0;
    private static final int RETURN_RANKING_LIST=1;
    private static final int RETURN_FOLLOW_Header = 5;
    private static final int RETURN_FOLLOW_ERROR = 6;
    private static final int RETURN_ADD_FOLLOW = 7;
    private static final int RETURN_ADD_FOLLOW_ERROR = 8;
    private static final int RETURN_UN_FOLLOW = 9;
    private static final int RETURN_UN_FOLLOW_ERROR = 10;
    private static final int RETURN_FOLLOW_ELSE = 11;
    private static final int RETURN_ADD_FOLLOW_HEADER = 12;

    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case ERROR:
                    mCallback.setErrorMsg("错误,请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.setErrorMsg(((WendaRankingBean)msg.obj).getMessage());
                    break;
                case RETURN_RANKING_LIST:
                    mCallback.setRankingList((WendaRankingBean)msg.obj);
                    break;
                case RETURN_FOLLOW_Header:
                    mCallback.setFollowStateHeader((FollowBean) msg.obj);
                    break;
                case RETURN_FOLLOW_ERROR:
                    mCallback.setFollowStateError((FollowBean) msg.obj);
                    break;
                case RETURN_ADD_FOLLOW:
                    mCallback.setAddFollowMsg(((AddOrUnFollowBean) msg.obj));
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
                case RETURN_FOLLOW_ELSE:
                    mCallback.setFollowState((FollowBean) msg.obj);
                    break;
            }
        }
    };
    private final WendaApi mApi;
    private final String mToken;

    public WendaRankingFragmentPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mToken = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    @Override
    public void getRankingList() {
        mApi.getWendaRankingList(10)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                        Message message = new Message();
                        message.what = ((WendaRankingBean)o).getCode()== Constants.SUCCESS?RETURN_RANKING_LIST:RETURN_ERROR;
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

    /**
     *
     * @param userId    id
     * @param path    0为header,其他就是其他位置
     */
    @Override
    public void getUserFollowState(String userId,int path) {
        mApi.getFollowState(userId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FollowBean>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull FollowBean followBean) {
                        Message message = new Message();
                        message.what = followBean.getCode() == Constants.SUCCESS ? (path==0?RETURN_FOLLOW_Header:RETURN_FOLLOW_ELSE): RETURN_FOLLOW_ERROR;
                        message.obj = followBean;
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
    public void addFollow(String userId,int path) {
        mApi.addFollow(userId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddOrUnFollowBean>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull AddOrUnFollowBean addFollowBean) {
                        Message message = new Message();
                        message.what = addFollowBean.getCode() == Constants.SUCCESS ?(path == 0?RETURN_ADD_FOLLOW_HEADER: RETURN_ADD_FOLLOW ): RETURN_ADD_FOLLOW_ERROR;
                        message.obj = addFollowBean;
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
    public void unFollow(String userId) {
        mApi.unFollow(userId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddOrUnFollowBean>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull AddOrUnFollowBean addOrUnFollowBean) {
                        Message message = new Message();
                        message.what = addOrUnFollowBean.getCode() == Constants.SUCCESS ? RETURN_UN_FOLLOW : RETURN_UN_FOLLOW_ERROR;
                        message.obj = addOrUnFollowBean;
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

    private void requestFailed() {
        Message message = new Message();
        message.what = ERROR;
        mHandler.sendMessage(message);
    }

    @Override
    public void registerViewCallback(IWendaRankingFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
