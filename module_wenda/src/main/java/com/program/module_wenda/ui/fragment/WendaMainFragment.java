package com.program.module_wenda.ui.fragment;

import android.view.View;

import com.program.moudle_base.base.BaseFragment;

public class WendaMainFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return 0;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
    }
}
