package com.program.moulde_login.ui.fragment;

import android.view.View;
import android.widget.Button;

import com.program.lib_base.Md5Utils;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.User;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.LoginEditView;
import com.program.moulde_login.R;
import com.program.moulde_login.presenter.ILoginPresenter;
import com.program.moulde_login.ui.view.CodeEditView;
import com.program.moulde_login.utils.PresenterManager;
import com.program.moulde_login.view.ILoginCallback;


public class LoginFragment extends BaseFragment implements ILoginCallback {


    private LoginEditView mEditPhone;
    private LoginEditView mEditPsw;
    private CodeEditView mEditCode;
    private Button mBtnLogin;
    private ILoginPresenter mLoginPresenter;
    private LoginFragmentListener loginFragmentListener=null;

    @Override
    protected int getRootViewResId() {
        return R.layout.moudlelogin_fragment_login;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
        mEditPhone = rootView.findViewById(R.id.edit_phone);
        mEditPsw = rootView.findViewById(R.id.edit_password);
        mEditCode = rootView.findViewById(R.id.edit_turing_code);
        mBtnLogin = rootView.findViewById(R.id.btn_login);
    }

    @Override
    protected void initPresenter() {
        mLoginPresenter = PresenterManager.getInstance().getLoginPresenter();
        mLoginPresenter.registerViewCallback(this);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = mEditCode.getKeyCode();
                String code = mEditCode.getValue();
                String phone = mEditPhone.getValue();
                String psw = mEditPsw.getValue();
                if (phone.length()!=11){
                    ToastUtils.showToast("手机号错误");
                    return;
                }else if (psw.isEmpty()){
                    ToastUtils.showToast("请输入密码");
                    return;
                }else if (code.isEmpty()){
                    ToastUtils.showToast("请输入密码");
                    return;
                }

                User user = new User(mEditPhone.getValue().toString(), Md5Utils.md5(mEditPsw.getValue().toString()));
                mLoginPresenter.getLogin(code,user,key);
            }
        });

    }

    @Override
    public void onResultLoginSuccess(String message) {
        loginFragmentListener.onCallbackBack();
        ToastUtils.showToast("Success");
//        getActivity().onBackPressed();
    }

    @Override
    public void onLoginError(String message) {
        ToastUtils.showToast("Error");
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    public void setLoginFragmentListener(LoginFragmentListener loginFragmentListener){
        this.loginFragmentListener = loginFragmentListener;
    }

    public interface LoginFragmentListener{
        void onCallbackBack();
    }
}
