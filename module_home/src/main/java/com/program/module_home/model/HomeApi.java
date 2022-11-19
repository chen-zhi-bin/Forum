package com.program.module_home.model;

import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.ArticleRecommendBean;
import com.program.module_home.model.bean.BannerBean;
import com.program.module_home.model.bean.CategoryBean;
import com.program.module_home.model.bean.CommentBean;
import com.program.module_home.model.bean.CommentInputBean;
import com.program.module_home.model.bean.HomeItemBean;
import com.program.module_home.model.bean.InfoBean;
import com.program.module_home.model.bean.PriseArticleBean;
import com.program.module_home.model.bean.PriseArticleInputBean;
import com.program.module_home.model.bean.SubCommentInputBean;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.CollectInputBean;
import com.program.moudle_base.model.CollectionBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.NewCollection;
import com.program.moudle_base.model.PriseQrCodeBean;

import org.jsoup.Connection;

import java.util.Map;
import java.util.logging.Handler;

import io.reactivex.rxjava3.core.Observable;
import kotlin.jvm.JvmSuppressWildcards;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HomeApi {

    /**
     * 检查是否登录
     */
    @GET("/uc/user/checkToken")
    Observable<InfoBean> getUserIsLogin(@Header("sob_token")String token);

    /**
     * 收藏集创建
     */
    @POST("/ct/ucenter/collection")
    Observable<BaseResponseBean> postNewCollection(@Body NewCollection data, @Header("sob_token")String token);

    /**
     * 首页分类列表
     */
    @GET("/ct/category/list")
    Observable<CategoryBean> getCategoryList();

    /**
     * 获取轮播图
     */
    @GET("/ast/home/loop/list")
    Observable<BannerBean> getBanner();

    static final String RECOMMEND_URL = "/ct/content/home/recommend";

    /**
     * 获取推荐
     */
    @GET(RECOMMEND_URL+"/{page}")
    Observable<HomeItemBean> getRecommend(@Path("page")int page);

    /**
     * 根据类获取推荐内容
     */
    @GET(RECOMMEND_URL+"/{categoryId}/{page}")
    Observable<HomeItemBean> getRecommendByCategoryId(@Path("categoryId")String categoryId,@Path("page")int page);

    @GET("/ct/article/detail/{articleId}")
    Observable<ArticleDetailBean> getArticleDetail(@Path("articleId")String articleId);

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
     * 是否收藏   返回值：{"success":true,"code":10000,"message":"操作成功","data":"972137212613230592"}  data="0" 未收藏
     */
    @GET("/ct/favorite/checkCollected")
    Observable<BaseResponseBean> checkCollected(@Query("url")String url,@Header("sob_token")String token);

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

    /**
     * 获取收藏夹
     */
    @GET("ct/collection/list/{page}")
    Observable<CollectionBean> getCollectionList(@Path("page") int page, @Header("sob_token") String token);

    /**
     * 收藏
     */
    @POST("/ct/favorite")
    Observable<BaseResponseBean> favorite(@Body CollectInputBean body,@Header("sob_token")String token);

    /**
     *取消收藏
     */
    @DELETE("/ct/favorite/{favoriteId}")
    Observable<BaseResponseBean> unFavorite(@Path("favoriteId")String favoriteId,@Header("sob_token")String token);
}
