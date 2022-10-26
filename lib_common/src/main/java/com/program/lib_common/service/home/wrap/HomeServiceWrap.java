package com.program.lib_common.service.home.wrap;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.home.IHomeService;

import java.util.function.LongUnaryOperator;

public class HomeServiceWrap {

   @Autowired(name = RoutePath.Home.SERVICE_HOME)
    public IHomeService mService;

   private static final HomeServiceWrap instance;

   static {
       instance = Singletion.INSTANCE.getHolder();
       Log.d("HomeServiceWrap","HomeServiceWrap static");
   }

   public Fragment getFragment(){
       Log.d("HomeServiceWrap","tess");
       return mService.getFragment();
   }

   public void launchDetail(String id,String title){
       ARouter.getInstance()
               .build(RoutePath.Home.PAGE_ARTICLE)
               .withString("articleId", id)
               .withString("articleTitle", title)
               .navigation();
   }

   public void launchWebView(String url){
       ARouter.getInstance()
               .build(RoutePath.Home.PAGE_WEBVIEW)
               .withString("url", url)
               .navigation();
   }

   public void launchPriseActivityList(String articleId){
       ARouter.getInstance()
               .build(RoutePath.Home.PAGE_PRISE_LIST)
               .withString(RoutePath.Home.ARTICLE_ID,articleId)
               .navigation();
   }


   private HomeServiceWrap(){
       ARouter.getInstance().inject(this);
       Object navigation = ARouter.getInstance().build(RoutePath.Home.SERVICE_HOME).navigation();
       mService = (IHomeService) navigation;
//       mService = (IHomeService) ARouter.getInstance().build(RoutePath.Home.SERVICE_HOME).navigation();
   }

   public static final class Singletion{
       private static final HomeServiceWrap holder;
       public static final HomeServiceWrap.Singletion INSTANCE;

       public final HomeServiceWrap getHolder(){
           return holder;
       }
       private Singletion(){

       }

       static {
        Log.d("HomeServiceWrap","HomeServiceWrap Singletion static");
        Singletion singletion = new Singletion();
        INSTANCE = singletion;
        holder = new HomeServiceWrap();
       }
   }

}
