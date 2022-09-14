package com.program.module_home.serivce;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.home.IHomeService;
import com.program.module_home.fragment.HomeFragment;
import com.program.moudle_base.base.BaseFragment;

@Route(path = RoutePath.Home.SERVICE_HOME)
public class HomeServiceImpl implements IHomeService {

    private HomeFragment mHomeFragment;

    @Override
    public Fragment getFragment() {
        if (mHomeFragment==null){
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    @Override
    public void init(Context context) {

    }
}
