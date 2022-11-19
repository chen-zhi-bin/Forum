package com.program.moulde_login.model;

import com.program.moudle_base.model.BaseResponseBean;

import com.program.moudle_base.model.User;
import com.program.moulde_login.model.bean.LoginBean;
import com.program.moulde_login.model.bean.SendSmsVo;
import com.program.moulde_login.model.bean.TokenBean;
import com.program.moulde_login.model.bean.UserR;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginApi {

    @POST("/uc/user/register/{smsCode}")
    Call<BaseResponseBean> getRegister(@Body UserR user, @Path("smsCode")String sms);

    @POST("/uc/ut/join/send-sms")
    Call<BaseResponseBean> getSms(@Body SendSmsVo sendSmsVo,@Header("l_c_i")String key);

    @POST("/uc/user/login/{captcha}")
    Call<LoginBean> tologin(@Path("captcha") String captcha, @Body User user, @Header("l_c_i")String key);

    @GET("/uc/user/checkToken")
    Call<TokenBean> getTokeMesage(@Header("sob_token")String l_c_i);
}
