package com.program.lib_common.service.wenda.wrap;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.ucenter.IUcenterService;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.lib_common.service.wenda.IWendaService;

public class WendaServiceWrap {
    @Autowired(name = RoutePath.Wenda.SERVICE_WENDA)
    public IWendaService mService;

    private static final WendaServiceWrap instance;

    static  {
        instance = WendaServiceWrap.Singletion.INSTANCE.getHolder();
    }
    private WendaServiceWrap() {
        ARouter.getInstance().inject(this);
        Object navigation = ARouter.getInstance().build(RoutePath.Wenda.SERVICE_WENDA).navigation();
        mService = (IWendaService) navigation;
    }

    public void launchDetail(String wendaId){
     ARouter.getInstance()
     .build(RoutePath.Wenda.PAGE_DETAIL)
     .withString(RoutePath.Wenda.WENDA_ID,wendaId)
     .navigation();
    }


    public static final class Singletion{
        private static final WendaServiceWrap holder;
        public static final WendaServiceWrap.Singletion INSTANCE;
        public final WendaServiceWrap getHolder(){
            return holder;
        }

        private Singletion(){

        }

        static {
            WendaServiceWrap.Singletion singletion = new WendaServiceWrap.Singletion();
            INSTANCE = singletion;
            holder = new WendaServiceWrap();
        }

    }

}
