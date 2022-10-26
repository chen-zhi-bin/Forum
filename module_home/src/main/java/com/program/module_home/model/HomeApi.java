package com.program.module_home.model;

import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.ArticleRecommendBean;
import com.program.module_home.model.bean.CommentBean;
import com.program.module_home.model.bean.CommentInputBean;
import com.program.module_home.model.bean.PriseArticleBean;
import com.program.module_home.model.bean.PriseArticleInputBean;
import com.program.module_home.model.bean.SubCommentInputBean;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.PriseQrCodeBean;

import org.jsoup.Connection;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface HomeApi {

    @GET("/ct/article/detail/{articleId}")
    Observable<ArticleDetailBean> geetArticleDetail(@Path("articleId")String articleId);

    /**
     * 得到打赏二维码
     */
    @GET("ast/prise-qr-code/{userId}")
    Observable<PriseQrCodeBean> getPriseQrCode(@Path("userId")String userId);

    /**
     * 评论列表
     */
    @GET("/ct/article/comment/{articleId}/{page}")
    Observable<CommentBean> getArticleCommentList(@Path("articleId")String articleId,@Path("page")int page);

    /**
     *获取文章的相关推荐
     */
    @GET("/ct/article/recommend/{articleId}/{size}")
    Observable<ArticleRecommendBean> getArticleRecommend(@Path("articleId")String articleId, @Path("size")int size);

    /**
     * 评论文章
     */
    @POST("/ct/article/comment")
    Observable<BaseResponseBean> commentArticle(@Body CommentInputBean comment,@Header("sob_token")String token);

    /**
     * 回复文章评论
     */
    @POST("/ct/article/sub-comment")
    Observable<BaseResponseBean> replyComment(@Body SubCommentInputBean comment,@Header("sob_token") String token);

    /**
     * 文章是否点赞
     */
    @GET("/ct/article/check-thumb-up/{articleId}")
    Observable<BaseResponseBean> checkArticleThumbUp(@Path("articleId")String articleId,@Header("sob_token")String token);

    /**
     * 点赞文章
     */
    @PUT("/ct/article/thumb-up/{articleId}")
    Observable<BaseResponseBean> articleThumbUp(@Path("articleId") String articleId,@Header("sob_token")String token);

    /**
     * 打赏文章
     */
    @POST("/ast/prise/article")
    Observable<BaseResponseBean> priseArticle(@Body PriseArticleInputBean data,@Header("sob_token")String token);

    /**
     * 打赏文章列表
     */
    @GET("/ast/prise/article/{articleId}")
    Observable<PriseArticleBean> getPriseArticleList(@Path("articleId")String articleId);

    /**
     * 查看受否关注
     * @param userId    对象id
     * @param token     自己token
     * @return          bean
     */
    @GET("/uc/fans/state/{userId}")
    Observable<FollowBean> getFollowState(@Path("userId")String userId, @Header("sob_token")String token);

    /**
     * 添加关注
     * @param userId    用户id
     * @param token     自己token
     * @return
     */
    @POST("/uc/fans/{userId}")
    Observable<AddOrUnFollowBean> addFollow(@Path("userId")String userId, @Header("sob_token")String token);

    @DELETE("/uc/fans/{userId}")
    Observable<AddOrUnFollowBean> unFollow(@Path("userId")String userId, @Header("sob_token")String token);

}
