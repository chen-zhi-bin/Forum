package com.program.module_search.ui.fragment;

import android.view.View;

import com.program.module_search.R;
import com.program.moudle_base.base.BaseFragment;

public class SearchListFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.modulesearch_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.NONE);

    }
}
