package com.program.module_wenda.service;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.wenda.IWendaService;
import com.program.module_wenda.ui.fragment.WendaMainFragment;

@Route(path = RoutePath.Wenda.SERVICE_WENDA)
public class WendaServiceImpl implements IWendaService {
    @Override
    public Fragment getFragment() {
        return new WendaMainFragment();
    }

    @Override
    public void init(Context context) {

    }
}
