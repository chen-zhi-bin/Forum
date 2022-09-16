package com.program.module_ucenter.model;

import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.AvaTarBean;
import com.program.module_ucenter.model.domain.LoginoutBean;
import com.program.module_ucenter.model.domain.UserMessageBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UcenterApi {

    @GET("/uc/user/avatar/{phoneNum}")
    Observable<AvaTarBean> getAvatar(@Path("phoneNum") String phoneNum);

    @GET("/uc/user-info/{userId}")
    Observable<UserMessageBean> getUserMessage(@Path("userId")String id);

    @GET("/ast/achievement")
    Observable<AchievementBean> getUserAchievementBean(@Header("sob_token")String token);

    @GET("/uc/user/logout")
    Observable<LoginoutBean> loginout(@Header("sob_token")String token);
}
