package com.program.module_ucenter.serivce;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.ucenter.IUcenterService;
import com.program.module_ucenter.ui.fragment.UserFragment;

@Route(path = RoutePath.Ucenter.SERVICE_UCENTER)
public class UcenterServiceImpl implements IUcenterService {
    @Override
    public Fragment getFragment() {
        return new UserFragment();
    }

    @Override
    public void init(Context context) {

    }
}
