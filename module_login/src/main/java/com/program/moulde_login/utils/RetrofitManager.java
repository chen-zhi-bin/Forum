package com.program.moulde_login.utils;

import com.program.lib_common.Constants;
import com.program.moulde_login.model.LoginApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private LoginApi mApi;
    private static RetrofitManager sApiManager;

    public static RetrofitManager getInstence() {
        if (sApiManager == null) {
            synchronized (RetrofitManager.class) {
                if (sApiManager == null) {
                    sApiManager = new RetrofitManager();
                }
            }
        }
        return sApiManager;
    }

    public LoginApi getApi() {
        if (mApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApi =  retrofit.create(LoginApi.class);
        }
        return mApi;
    }

//    private static final RetrofitManager outInstance = new RetrofitManager();
//    private Retrofit mRetrofit;
//
//    public static RetrofitManager getInstance(){
//
//        return outInstance;
//    }
//
//    private RetrofitManager(){
//        LogUtils.d("DEBUG","RetrofitManager");
//            mRetrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        LogUtils.d("DEBUG","new Retrofit");
//
//
//    }
//
//    public Retrofit getRetrofit(){
//        return mRetrofit;
//    }
}
