package com.program.module_home.presenter;

import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.model.bean.CommentInputBean;
import com.program.module_home.model.bean.PriseArticleInputBean;
import com.program.module_home.model.bean.SubCommentInputBean;
import com.program.moudle_base.base.IBasePresenter;
import com.program.moudle_base.model.CollectInputBean;
import com.program.moudle_base.model.NewCollection;

import java.util.Map;

import okhttp3.MultipartBody;

public interface IArticleDetailPresenter extends IBasePresenter<IArticleDetailCallback> {

    void postNewCollection(NewCollection data);

    void postCollectionImage(MultipartBody.Part part);

    void getArticleDetail(String articleId);

    void getPriseQrCode(String userId);

    void getArticleComment(String articleId);

    void getArticleRecommend(String articleId);

    /**
     * 评论文章
     */
    void commentArticle(CommentInputBean data);

    /**
     * 回复文章评论
     */
    void replyComment(SubCommentInputBean data);

    /**
     * 文章是否点赞
     */
    void getArticleThumbUpState(String articleId);

    /**
     * 点赞文章
     */
    void addArticleThumbUp(String articleId);

    /**
     * 打赏文章
     */
    void priseArticle(PriseArticleInputBean data);

    /**
     * 查看文章是否收藏
     */
    void getCheckCollectionState(String articleId);

    /**
     * 得到与目标用户之间的关系
     * @param userId    id
     */
    void getUserFollowState(String userId);

    /**
     * 添加关注
     * @param userId    id
     */
    void addFollow(String userId);

    /**
     * 取消关注
     * @param userId    id
     */
    void unFollow(String userId);

    /**
     * 得到收藏列表
     */
    void getCollectionList();

    /**
     * 得到更多收藏列表
     */
    void getCollectionListMore();

    /**
     * 收藏
     */
    void favorite(CollectInputBean data);

    /**
     * 取消收藏
     */
    void unFavorite(String favoriteId);
}
