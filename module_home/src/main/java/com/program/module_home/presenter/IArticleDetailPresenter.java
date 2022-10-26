package com.program.module_home.presenter;

import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.model.bean.CommentInputBean;
import com.program.module_home.model.bean.PriseArticleInputBean;
import com.program.module_home.model.bean.SubCommentInputBean;
import com.program.moudle_base.base.IBasePresenter;

public interface IArticleDetailPresenter extends IBasePresenter<IArticleDetailCallback> {

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
}
