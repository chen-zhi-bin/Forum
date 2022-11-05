package com.program.module_home.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.model.HomeApi;
import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.ArticleRecommendBean;
import com.program.module_home.model.bean.CommentBean;
import com.program.module_home.model.bean.CommentInputBean;
import com.program.module_home.model.bean.PriseArticleInputBean;
import com.program.module_home.model.bean.SubCommentInputBean;
import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.utils.RetrofitManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.CollectionBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.PriseQrCodeBean;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ArticleDetailPresenterImpl implements IArticleDetailPresenter {


    private IArticleDetailCallback mCallback = null;
    private final HomeApi mApi;

    private static final int ERROR = -1;        //能请求，但是错误
    private static final int RETURN_ERROR = 0;    //错误
    private static final int RETURN_ARTICLE_DETAIL = 1;
    private static final int RETURN_QR_CODE = 2;
    private static final int RETURN_FOLLOW = 3;
    private static final int RETURN_FOLLOW_ERROR = 4;
    private static final int RETURN_ADD_FOLLOW = 5;
    private static final int RETURN_ADD_FOLLOW_ERROR = 6;
    private static final int RETURN_UN_FOLLOW = 7;
    private static final int RETURN_UN_FOLLOW_ERROR = 8;
    private static final int RETURN_ARTICLE_COMMENT = 9;
    private static final int RETURN_ARTICLE_RECOMMEND = 10;
    private static final int RETURN_ARTICLE_COMMENT_SET = 11;   //评论文章
    private static final int RETURN_ARTICLE_SUB_COMMENT_SET = 12;   //回复文章评论
    private static final int RETURN_ARTICLE_THUMB_STATE = 13;   //文章是否点赞
    private static final int RETURN_ARTICLE_ADD_THUMB = 14;   //文章点赞
    private static final int RETURN_ARTICLE_PRISE = 15;   //打赏文章
    private static final int RETURN_ARTICLE_COLLECTION_STATE = 16;   //文章是否收藏
    private static final int RETURN_COLLECTION_LIST = 17;   //收藏列表
    private final Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            switch (msg.what) {
                case ERROR:
                    mCallback.setRequestError("连接超时,请稍后重试");
                    break;
                case RETURN_ERROR:
                    mCallback.setRequestError("网络错误");
                    break;
                case RETURN_ARTICLE_DETAIL:
                    mCallback.setArticleDetail(((ArticleDetailBean) msg.obj).getData());
                    break;
                case RETURN_QR_CODE:
                    if (((PriseQrCodeBean) msg.obj).getCode() == Constants.SUCCESS) {
                        mCallback.setPriseQrCode((PriseQrCodeBean) msg.obj);
                    } else {
                        mCallback.setRequestError(((PriseQrCodeBean) msg.obj).getMessage());
                    }
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
                case RETURN_ARTICLE_COMMENT:
                    mCallback.setArticleComment((CommentBean) msg.obj);
                    break;
                case RETURN_ARTICLE_RECOMMEND:
                    mCallback.setArticleRecommend((ArticleRecommendBean) msg.obj);
                    break;
                case RETURN_ARTICLE_COMMENT_SET:
                    mCallback.setReturnCommentArticle((BaseResponseBean) msg.obj);
                    break;
                case RETURN_ARTICLE_SUB_COMMENT_SET:
                    mCallback.setReturnSubCommentArticle((BaseResponseBean) msg.obj);
                    break;
                case RETURN_ARTICLE_THUMB_STATE:
                    mCallback.setArticleThumbUpState((BaseResponseBean) msg.obj);
                    break;
                case RETURN_ARTICLE_ADD_THUMB:
                    mCallback.setArticleThumbUp((BaseResponseBean) msg.obj);
                    break;
                case RETURN_ARTICLE_PRISE:
                    mCallback.setReturnPriseArticle((BaseResponseBean) msg.obj);
                    break;
                case RETURN_ARTICLE_COLLECTION_STATE:
                    mCallback.setCheckCollectionState((BaseResponseBean) msg.obj);
                    break;
                case RETURN_COLLECTION_LIST:
                    mCallback.setCollectionList((CollectionBean)msg.obj);
                    break;
            }
        }
    };
    private final String mToken;

    public ArticleDetailPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mToken = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

    @Override
    public void getArticleDetail(String articleId) {
        mApi.getArticleDetail(articleId)
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
                        message.what = ((ArticleDetailBean) o).getCode() == Constants.SUCCESS ? RETURN_ARTICLE_DETAIL : ERROR;
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
    public void getPriseQrCode(String userId) {
        mApi.getPriseQrCode(userId)
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
                        message.what = RETURN_QR_CODE;
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

    private int page = 1;

    @Override
    public void getArticleComment(String articleId) {
        page = 1;
        mApi.getArticleCommentList(articleId, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = ((CommentBean) o).getCode() == Constants.SUCCESS ? RETURN_ARTICLE_COMMENT : ERROR;
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
    public void getArticleRecommend(String articleId) {
        mApi.getArticleRecommend(articleId, 10)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = ((ArticleRecommendBean) o).getCode() == Constants.SUCCESS ? RETURN_ARTICLE_RECOMMEND : ERROR;
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
    public void commentArticle(CommentInputBean data) {
        mApi.commentArticle(data, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test", "data o =" + ((BaseResponseBean) o).toString());
                        Message message = new Message();
                        message.what = RETURN_ARTICLE_COMMENT_SET;
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
    public void replyComment(SubCommentInputBean data) {
        LogUtils.d("test", "data  bean= " + data.toString());
        mApi.replyComment(data, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtils.d("test", "return asd " + ((BaseResponseBean) o).toString());
                        Message message = new Message();
                        message.what = RETURN_ARTICLE_SUB_COMMENT_SET;
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
    public void getArticleThumbUpState(String articleId) {
        mApi.checkArticleThumbUp(articleId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_ARTICLE_THUMB_STATE;
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
    public void addArticleThumbUp(String articleId) {
        mApi.articleThumbUp(articleId, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_ARTICLE_ADD_THUMB;
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
    public void priseArticle(PriseArticleInputBean data) {
        mApi.priseArticle(data, mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_ARTICLE_PRISE;
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
    public void getCheckCollectionState(String articleId) {
        mApi.checkCollected(Constants.WEBSITE_URL + articleId,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what = RETURN_ARTICLE_COLLECTION_STATE;
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
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object followBean) {
                        Message message = new Message();
                        message.what = ((FollowBean) followBean).getCode() == Constants.SUCCESS ? RETURN_FOLLOW : RETURN_FOLLOW_ERROR;
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
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object addFollowBean) {
                        Message message = new Message();
                        message.what = ((AddOrUnFollowBean) addFollowBean).getCode() == Constants.SUCCESS ? RETURN_ADD_FOLLOW : RETURN_ADD_FOLLOW_ERROR;
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
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object addOrUnFollowBean) {
                        Message message = new Message();
                        message.what = ((AddOrUnFollowBean) addOrUnFollowBean).getCode() == Constants.SUCCESS ? RETURN_UN_FOLLOW : RETURN_UN_FOLLOW_ERROR;
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

    private int pageCollection = -1;
    @Override
    public void getCollectionList() {
        pageCollection = 1;
        mApi.getCollectionList(pageCollection,mToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(mCallback.TobindToLifecycle())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Message message = new Message();
                        message.what= RETURN_COLLECTION_LIST;
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
    public void registerViewCallback(IArticleDetailCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {

    }
}
