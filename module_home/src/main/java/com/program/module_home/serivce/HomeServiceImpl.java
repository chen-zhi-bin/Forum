package com.program.module_home.serivce;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.home.IHomeService;
import com.program.module_home.ui.fragment.HomeMainFragment;

@Route(path = RoutePath.Home.SERVICE_HOME)
public class HomeServiceImpl implements IHomeService {

    private HomeMainFragment mHomeFragment;

    @Override
    public Fragment getFragment() {
        if (mHomeFragment==null){
            mHomeFragment = new HomeMainFragment();
        }
        return mHomeFragment;
    }

    @Override
    public void init(Context context) {

    }
}
