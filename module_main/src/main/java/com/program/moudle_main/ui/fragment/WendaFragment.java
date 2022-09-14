package com.program.moudle_main.ui.fragment;

import android.view.View;

import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_main.R;

public class WendaFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.modulemain_fragment_wenda;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
    }
}
