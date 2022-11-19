package com.program.moulde_login.presenter.Impl;

import com.program.lib_base.LogUtils;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moulde_login.model.bean.LoginBean;
import com.program.moulde_login.model.bean.TokenBean;
import com.program.moulde_login.utils.RetrofitManager;
import com.program.moudle_base.model.User;
import com.program.moulde_login.model.LoginApi;
import com.program.moulde_login.presenter.ILoginPresenter;
import com.program.moulde_login.view.ILoginCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImpl implements ILoginPresenter {

    private final LoginApi mApi;
    private ILoginCallback mLoginCallback = null;
    private final SharedPreferencesUtils mSharedPreferencesUtils;

    public LoginPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mSharedPreferencesUtils =SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void getLogin(String code, User user,String key) {
        LogUtils.d("test","code="+code+"||"+"user="+user+"||"+"key="+key);
//        Call task = mApi.tologin(code, user);
        Call<LoginBean> task = mApi.tologin(code, user, key);
        task.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                Log.d("test", "onResponse: respose="+response.body());
                LoginBean bean = response.body();
                if (response.code()==200){
                    if (bean.getCode()==10000){

                        String token = response.headers().get("sob_token");
//                        LogUtils.d("test","token ="+token);
                        mSharedPreferencesUtils.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE,token);
                        mSharedPreferencesUtils.putString(SharedPreferencesUtils.USER_PHONE,user.getPhoneNum());

                        getTokenMessage(token);

                    }else {
                        mLoginCallback.onLoginError(bean.getMessage());
                    }
                }else {
                    mLoginCallback.onLoginError("网络错误");
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                mLoginCallback.onLoginError("网络错误");
            }
        });


    }

    @Override
    public void getTokenMessage(String token) {
        Call<TokenBean> task = mApi.getTokeMesage(token);
        task.enqueue(new Callback<TokenBean>() {
            @Override
            public void onResponse(Call<TokenBean> call, Response<TokenBean> response) {
                TokenBean data = response.body();
                LogUtils.d("LoginPressenter","data ="+data.toString());
                if (response.code()==200) {
                    if (data.getCode() == 10000) {
                        String userId = data.getData().getId();
                        mSharedPreferencesUtils.putString(SharedPreferencesUtils.USER_ID,userId);

                        mLoginCallback.onResultLoginSuccess(data.getMessage());
                    } else {
                        mLoginCallback.onLoginError(data.getMessage());
                    }
                }else {
                    mLoginCallback.onLoginError(data.getMessage());
                }
            }

            @Override
            public void onFailure(Call<TokenBean> call, Throwable t) {
                mLoginCallback.onLoginError("网络错误");
            }
        });


    }


    @Override
    public void registerViewCallback(ILoginCallback callback) {
        mLoginCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mLoginCallback =null;
    }
}
