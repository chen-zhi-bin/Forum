package com.program.lib_common.service.ucenter;


import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IUcenterService extends IProvider {
        Fragment getFragment();
}
