package com.program.module_wenda.ui.fragment;

import android.view.View;

import com.program.module_wenda.R;
import com.program.moudle_base.base.BaseFragment;

public class WendaRankingFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.modulewenda_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        super.initView(rootView);
    }
}
