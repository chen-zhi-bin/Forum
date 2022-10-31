package com.program.module_wenda.ui.fragment;

import android.view.View;

import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_wenda.R;
import com.program.moudle_base.base.BaseFragment;

public class WendaListFragment extends BaseFragment {

    private String mWendaType;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulewenda_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mWendaType = requireArguments().getString(Constants.Wenda.WENDA_TYPE, Constants.Wenda.WENDA_LASTEST);
        LogUtils.d("test","wendaType = "+mWendaType);
    }
}
