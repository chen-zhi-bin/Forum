package com.program.lib_common.service.wenda;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IWendaService extends IProvider {
    Fragment getFragment();
}
