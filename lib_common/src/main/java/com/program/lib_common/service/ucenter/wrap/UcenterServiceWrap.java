package com.program.lib_common.service.ucenter.wrap;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.ucenter.IUcenterService;


public class UcenterServiceWrap{

    @Autowired(name = RoutePath.Ucenter.SERVICE_UCENTER)
    public IUcenterService mService;

    private static final UcenterServiceWrap instance;

    static  {
        instance = Singletion.INSTANCE.getHolder();
    }

    private UcenterServiceWrap() {
        Log.d("UcenterServiceWrap","onCreate");
        ARouter.getInstance().inject(this);
        Object navigation = ARouter.getInstance().build(RoutePath.Ucenter.SERVICE_UCENTER).navigation();
        mService = (IUcenterService) navigation;
        Log.d("UcenterServiceWrap","test mService = "+mService);
    }


    public Fragment getFragment(){

        return mService.getFragment();
    }


    public void launchMassage(){
        ARouter.getInstance()
                .build(RoutePath.Ucenter.PAGE_MESSAGE)
                .navigation();
    }

    public void launchMsgList(int pageType,String title){
        Log.d("test","title = "+title + "===pageType ="+pageType);
        ARouter.getInstance()
                .build(RoutePath.Ucenter.PAGE_MSG_LIST)
                .withInt(Constants.Ucenter.PAGE_TYPE,pageType)
                .withString("title",title)
                .navigation();
    }



    public static final class Singletion{
        private static final UcenterServiceWrap holder;
        public static final UcenterServiceWrap.Singletion INSTANCE;
        public final UcenterServiceWrap getHolder(){
            return holder;
        }

        private Singletion(){

        }

        static {
            Singletion singletion = new Singletion();
            INSTANCE = singletion;
            holder = new UcenterServiceWrap();
        }

    }

}
