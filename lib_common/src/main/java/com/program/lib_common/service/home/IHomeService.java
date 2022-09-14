package com.program.lib_common.service.home;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IHomeService extends IProvider {
    Fragment getFragment();
}
