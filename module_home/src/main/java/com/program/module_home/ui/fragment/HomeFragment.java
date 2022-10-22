package com.program.module_home.ui.fragment;

import android.view.View;

import com.program.module_home.R;
import com.program.moudle_base.base.BaseFragment;

public class HomeFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.modulehome_fragment_recomend;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
    }
}
