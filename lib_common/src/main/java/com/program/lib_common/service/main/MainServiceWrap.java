package com.program.lib_common.service.main;

import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.search.SearchServiceWrap;

public class MainServiceWrap {

    private static final MainServiceWrap instance;

    static  {
        instance = MainServiceWrap.Singletion.INSTANCE.getHolder();
    }


    public void launchMain(){
        ARouter.getInstance()
                .build(RoutePath.Main.PAGE_MAIN)
                .navigation();
    }



    public static final class Singletion{
        private static final MainServiceWrap holder;
        public static final MainServiceWrap.Singletion INSTANCE;
        public final MainServiceWrap getHolder(){
            return holder;
        }

        private Singletion(){

        }

        static {
            MainServiceWrap.Singletion singletion = new MainServiceWrap.Singletion();
            INSTANCE = singletion;
            holder = new MainServiceWrap();
        }

    }

}
