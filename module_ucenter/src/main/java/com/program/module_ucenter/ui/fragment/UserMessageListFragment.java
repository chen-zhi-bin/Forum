package com.program.module_ucenter.ui.fragment;

import android.view.View;

import com.program.module_ucenter.R;
import com.program.moudle_base.base.BaseFragment;

public class UserMessageListFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
    }
}
