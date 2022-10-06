package com.program.module_wenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.RoutePath;
import com.program.module_wenda.R;

@Route(path = RoutePath.Wenda.PAGE_DETAIL)
public class WendaDetailActivity extends AppCompatActivity {

    @Autowired(name = RoutePath.Wenda.WENDA_ID)
    String wendaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulewenda_activity_wenda_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        LogUtils.d("test","wendaId = "+wendaId);
    }
}