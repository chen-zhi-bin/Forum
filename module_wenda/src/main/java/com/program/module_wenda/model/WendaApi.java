package com.program.module_wenda.model;

import com.program.module_wenda.model.bean.Answer;
import com.program.module_wenda.model.bean.AnswerBean;
import com.program.module_wenda.model.bean.RelatedQuestionBean;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaContentBean;
import com.program.module_wenda.model.bean.WendaSubCommentInputBean;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.FollowBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WendaApi {

    @GET("/ct/wenda/{wendaId}")
    Observable<WendaContentBean> getWendaDetail(@Path("wendaId") String wendaId);

    @GET("/ct/wenda/comment/list/{wendaId}/{page}")
    Observable<AnswerBean> getAnswerList(@Path("wendaId")String wendaId,@Path("page")int page);

//    @GET("/ct/wenda/comment/thumb-up/check/{wendaId}")
//    Observable<BaseResponseBean> isThumbState(@Header("sob_token")String token,@Path("wendaId")String wendaId);

    /**
     * 发表答案
     */
    @POST("/ct/wenda/comment")
    Observable<BaseResponseBean> toAnswer(@Body Answer answer,@Header("sob_token")String token);

    /**
     * 评论答案
     */
    @POST("/ct/wenda/sub-comment")
    Observable<BaseResponseBean> replyAnswer(@Body WendaSubCommentInputBean data,@Header("sob_token")String token);

    /**
     * 点赞问题
     */
    @PUT("/ct/wenda/thumb-up/{wendaId}")
    Observable<BaseResponseBean> toWendaThumb(@Path("wendaId")String wendaId,@Header("sob_token")String token);

    /**
     * 点赞回答
     */
    @PUT("ct/wenda/comment/thumb-up/{wendaCommentId}")
    Observable<BaseResponseBean> tiWendaCommentThumb(@Path("wendaCommentId")String wendaCommentId,@Header("sob_token")String token);

    /**
     * 是否点赞某个问题
     */
    @GET("/ct/wenda/thumb-up/check/{wendaId}")
    Observable<BaseResponseBean> wendaThumbClick(@Path("wendaId")String wendaId,@Header("sob_token")String token);

    /**
     * 是否点赞某个回答
     */
    @GET("/ct/wenda/comment/thumb-up/check/{commentId}")
    Observable<BaseResponseBean> commentThumbCheck(@Path("commentId")String commentId,@Header("sob_token")String token);

    /**
     * 获取相关推荐
     * @param wendaId   问题id
     * @param size      需要的size
     * @return          bean
     */
    @GET("/ct/wenda/relative/{wendaId}/{size}")
    Observable<WendaBean> getRelatedQuestion(@Path("wendaId")String wendaId, @Path("size")int size);

    /**
     * 答案打赏
     */
    @PUT("/ct/wenda/comment/prise/{commentId}/{count}")
    Observable<BaseResponseBean> commentPrise(
            @Path("commentId")String commentId,
            @Path("count") int count,
            @Query("thumbUp")boolean thumbUp,
            @Header("sob_token")String token);

    /**
     * 设为最佳答案
     */
    @PUT("/ct/wenda/comment/best/{wendaId}/{wendaCommentId}")
    Observable<BaseResponseBean> setBestAsComment(@Path("wendaId")String wendaId,@Path("wendaCommentId")String wendaCommentId,@Header("sob_token")String token);

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
