package com.program.moulde_login.presenter.Impl;

import com.program.lib_base.LogUtils;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moulde_login.model.LoginApi;
import com.program.moulde_login.model.bean.SendSmsVo;
import com.program.moulde_login.model.bean.UserR;
import com.program.moulde_login.presenter.IRegisterPresenter;
import com.program.moulde_login.utils.RetrofitManager;
import com.program.moulde_login.view.IRegisterCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenterImpl implements IRegisterPresenter {

    private final LoginApi mApi;
    private IRegisterCallback mCallback = null;

    public RegisterPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void registerViewCallback(IRegisterCallback callback) {
        this.mCallback =callback;
    }

    @Override
    public void unregisterViewCallback(IRegisterCallback callback) {
        mCallback = null;
    }

    @Override
    public void getSmsCode(SendSmsVo sendSmsVo,String key) {
        LogUtils.d("test",sendSmsVo.toString()+"=="+key);
        mApi.getSms(sendSmsVo,key)
                .enqueue(new Callback<BaseResponseBean>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean> call, Response<BaseResponseBean> response) {
                        LogUtils.d("test","respone  = "+response.body());
                        mCallback.setSmsCode((BaseResponseBean) response.body());
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean> call, Throwable t) {

                    }
                });
    }

    @Override
    public void postRegister(UserR user, String sms) {
        LogUtils.d("test","user = "+user.toString()+"==sms = "+sms);
        mApi.getRegister(user,sms)
                .enqueue(new Callback<BaseResponseBean>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean> call, Response<BaseResponseBean> response) {
                        LogUtils.d("test","respone  = "+response.body());
                        if (response.code()==200){
                            mCallback.setRegister((BaseResponseBean) response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean> call, Throwable t) {

                    }
                });
    }
}
