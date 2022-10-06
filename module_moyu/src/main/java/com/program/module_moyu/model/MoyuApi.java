package com.program.module_moyu.model;

import com.program.module_moyu.model.bean.MomentComment;
import com.program.module_moyu.model.bean.MomentCommentBean;
import com.program.module_moyu.model.bean.MomentSubComment;
import com.program.module_moyu.model.bean.MoyuRequestBean;
import com.program.moudle_base.model.BaseResponseBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoyuApi {

    @GET("/ct/moyu/{moyuId}")
    Observable<MoyuRequestBean> getMoyuDetail(@Path("moyuId")String id,@Header("sob_token")String token);

    /**
     * 获取评论
     * @param id    动态id
     * @param page  页码
     * @param i     评论的顺序
     * @return      评论bean
     */
    @GET("/ct/moyu/comment/{momentId}/{page}")
    Observable<MomentCommentBean> getMomentComment(@Path("momentId")String id, @Path("page")int page, @Query("sort")int i);

    /**
     * 查看受否关注
     * @param userId    对象id
     * @param token     自己token
     * @return          bean
     */
    @GET("/uc/fans/state/{userId}")
    Observable<BaseResponseBean> getFollowState(@Path("userId")String userId,@Header("sob_token")String token);

    /**
     * 添加关注
     * @param userId    用户id
     * @param token     自己token
     * @return          bean
     */
    @POST("/uc/fans/{userId}")
    Observable<BaseResponseBean> addFollow(@Path("userId")String userId, @Header("sob_token")String token);

    @DELETE("/uc/fans/{userId}")
    Observable<BaseResponseBean> unFollow(@Path("userId")String userId, @Header("sob_token")String token);

    @PUT("/ct/moyu/thumb-up/{moyuId}")
    Observable<BaseResponseBean> giveThumb(@Path("moyuId")String id, @Header("sob_token")String token);

    @POST("/ct/moyu/comment")
    Observable<BaseResponseBean> sendComment(@Header("sob_token") String token, @Body MomentComment momentComment);

    @POST("/ct/moyu/sub-comment")
    Observable<BaseResponseBean> sendSubComment(@Header("sob_token")String token, @Body MomentSubComment momentSubComment);
}
