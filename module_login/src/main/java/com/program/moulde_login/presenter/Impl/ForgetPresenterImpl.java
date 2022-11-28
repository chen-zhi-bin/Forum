package com.program.moulde_login.presenter.Impl;

import com.program.lib_base.LogUtils;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moulde_login.model.LoginApi;
import com.program.moulde_login.model.bean.SendSmsVo;
import com.program.moulde_login.model.bean.UserVo;
import com.program.moulde_login.presenter.IForgetPresenter;
import com.program.moulde_login.utils.RetrofitManager;
import com.program.moulde_login.view.IForgetCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPresenterImpl implements IForgetPresenter {

    private IForgetCallback mCallback =null;
    private final LoginApi mApi;


    public ForgetPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void registerViewCallback(IForgetCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IForgetCallback callback) {
        mCallback = null;
    }

    @Override
    public void toSendSms(SendSmsVo sendSmsVo,String key) {
        mApi.getForgetSms(sendSmsVo, key)
            .enqueue(new Callback<BaseResponseBean>() {
                @Override
                public void onResponse(Call<BaseResponseBean> call, Response<BaseResponseBean> response) {
                    mCallback.setForget(response.body());
                }

                @Override
                public void onFailure(Call<BaseResponseBean> call, Throwable t) {

                }
            });
    }

    @Override
    public void toForget(UserVo userVo, String sms) {
        mApi.getForget(userVo,sms)
                .enqueue(new Callback<BaseResponseBean>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean> call, Response<BaseResponseBean> response) {
                        mCallback.setForget(response.body());
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean> call, Throwable t) {
//                        ToastUtils.showToast(t.getMessage());
                    }
                });
    }
}
