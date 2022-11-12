package com.program.lib_common.service.moyu.wrap;

import android.os.Parcelable;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.lib_common.service.moyu.IMoyuService;

public class MoyuServiceWrap {

    @Autowired(name = RoutePath.Moyu.SERVICE_MOYU)
    public IMoyuService mMoyuService;

    private static final HomeServiceWrap instance;

    static {
        instance = HomeServiceWrap.Singletion.INSTANCE.getHolder();
        Log.d("MoyuServiceWrap","mMoyuService static");
    }

    public Fragment getFragment(){
        Log.d("HomeServiceWrap","tess");
        return mMoyuService.getFragment();
    }

    public void launchDetailComment(String commentId, Parcelable data){
        ARouter.getInstance()
                .build(RoutePath.Moyu.PAGE_DETAIL_COMMENT)
                .withString(RoutePath.Moyu.MOYU_DETAIL_ID,commentId)
                .withParcelable(RoutePath.Moyu.COMMENT,data)
                .navigation();

    }

    public void launchDetail(String id){
        ARouter.getInstance()
                .build(RoutePath.Moyu.PAGE_DETAIL)
                .withString(RoutePath.Moyu.MOYU_ID,id)
                .navigation();
    }

    public void launchPutFish(){
        ARouter.getInstance()
                .build(RoutePath.Moyu.PAGE_PUT_FISH)
                .navigation();
    }

    private MoyuServiceWrap(){
        ARouter.getInstance().inject(this);
        Object navigation = ARouter.getInstance().build(RoutePath.Moyu.SERVICE_MOYU).navigation();
        mMoyuService = (IMoyuService) navigation;
    }

    public static final class Singletion{
        private static final MoyuServiceWrap holder;
        public static final MoyuServiceWrap.Singletion INSTANCE;
        public final MoyuServiceWrap getHolder(){
            return holder;
        }
        private Singletion(){

        }
        static {
            Log.d("HomeServiceWrap","HomeServiceWrap Singletion static");
            Singletion singletion =new Singletion();
            INSTANCE = singletion;
            holder = new MoyuServiceWrap();
        }
    }






}
