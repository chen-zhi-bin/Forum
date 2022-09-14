package com.program.moulde_login.ui.fragment;

import android.view.View;

import com.program.moudle_base.base.BaseFragment;
import com.program.moulde_login.R;


public class RegisterFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.moudlelogin_fragment_register;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
    }
}
