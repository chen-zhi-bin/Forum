package com.program.moulde_login.ui;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_base.LogUtils;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.moudle_base.base.BaseActivity;
import com.program.moudle_base.base.BaseFragment;

import com.program.moudle_base.utils.ToastUtils;
import com.program.moulde_login.R;
import com.program.moulde_login.ui.fragment.*;
import com.program.moulde_login.view.ILoginCallback;


@Route(path=RoutePath.Login.PATH_lOGIN)
public class MainActivity extends BaseActivity {

//    @BindView(R2.id.tv_register)
    public TextView mRegisterOrLoginTv;
    private boolean isLogin = false;

    //    @BindView(R2.id.tv_forget)
    public TextView mForgetOrLoginTv;
    private boolean isForget = false;

    //    @BindView(R2.id.tv_logo)
    public TextView mTextView;

    private FragmentManager mFm;
    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;
    private ForgetFragment mForgetFragment;


    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        initFragments();
        mForgetOrLoginTv = this.findViewById(R.id.tv_forget);
        mTextView=findViewById(R.id.tv_logo);
        mRegisterOrLoginTv=findViewById(R.id.tv_register);

        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.moudlelogin_activity_main;
    }

    @Override
    protected void initEvent() {
        initListener();
    }

    private void initListener() {
        mRegisterOrLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLogin) {
                    isLogin = false;
                    mRegisterOrLoginTv.setText("注册账号");
                    mForgetOrLoginTv.setText("忘记密码");
                    mTextView.setText("登录");
                    switchFragment(mLoginFragment);
                }else {
                    isLogin = true;
                    mTextView.setText("注册");
                    mRegisterOrLoginTv.setText("已注册，登录");
                    mForgetOrLoginTv.setText("忘记密码");
                    switchFragment(mRegisterFragment);
                }
                isForget = false;
            }
        });
        mForgetOrLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isForget){
                    isForget=false;
                    mTextView.setText("登录");
                    mForgetOrLoginTv.setText("忘记密码");
                    mRegisterOrLoginTv.setText("注册账号");
                    switchFragment(mLoginFragment);
                }else {
                    isForget=true;
                    mTextView.setText("忘记密码");
                    mForgetOrLoginTv.setText("已记起，登录");
                    mRegisterOrLoginTv.setText("注册账号");
                    switchFragment(mForgetFragment);
                }
                isLogin=false;
            }
        });
        mLoginFragment.setLoginFragmentListener(new LoginFragment.LoginFragmentListener() {
            @Override
            public void onCallbackBack() {
                LogUtils.d("onCallbackBack","back");
                finish();
            }
        });
    }

    private void initFragments() {
        mFm = getSupportFragmentManager();
        mLoginFragment = new LoginFragment();
        mRegisterFragment = new RegisterFragment();
        mForgetFragment = new ForgetFragment();
        switchFragment(mLoginFragment);
    }



    /**
     * 上一次显示的Fragment
     */
    private BaseFragment lastOneFragment = null;
    public void switchFragment(BaseFragment fragment) {
        //如果上一个Fragment和当前要切换的fragment是同一个，那么不需要切换
        if (lastOneFragment == fragment){
            return;
        }
        //修改成add和hide的方式来控制Fragment
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        if (!fragment.isAdded()){
            fragmentTransaction.add(R.id.layout,fragment);
        }else {
            fragmentTransaction.show(fragment);
        }
        if (lastOneFragment!=null){
            fragmentTransaction.hide(lastOneFragment);
        }
        fragmentTransaction.commit();
        lastOneFragment = fragment;
    }
}