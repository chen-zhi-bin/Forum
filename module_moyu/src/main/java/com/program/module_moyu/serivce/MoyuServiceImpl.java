package com.program.module_moyu.serivce;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.moyu.IMoyuService;
import com.program.module_moyu.ui.fragment.MoyuMainFragment;

@Route(path = RoutePath.Moyu.SERVICE_MOYU)
public class MoyuServiceImpl implements IMoyuService {

    @Override
    public Fragment getFragment() {
        return new MoyuMainFragment();
    }

    @Override
    public void init(Context context) {

    }
}
