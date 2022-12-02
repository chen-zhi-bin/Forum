package com.program.forum.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.program.forum.GuideBean;
import com.program.forum.R;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.service.main.MainServiceWrap;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.ViewPagerIndicator;

import java.util.List;

import kotlin.collections.CollectionsKt;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
        initView();
    }

    private void initView() {
        List<GuideBean> list = CollectionsKt.mutableListOf();
        list.add(new GuideBean(R.mipmap.guide1,"我们的使命","让学习编程变得更加简单"));
        list.add(new GuideBean(R.mipmap.guide2,"我们的愿景","让热爱编程的年轻人成为优秀的工程师"));
        list.add(new GuideBean(R.mipmap.guide3,"我们的目标","赚钱的同时，顺便交朋友"));
        ViewPager2 vpGuide = this.findViewById(R.id.vp2_guide);
        GuideAdapter adapter = new GuideAdapter();
        adapter.addData(list);
        vpGuide.setOffscreenPageLimit(list.size());
        vpGuide.setAdapter(adapter);
        ViewPagerIndicator guideIndicator = this.findViewById(R.id.guide_indicator);
        guideIndicator.setViewPager2(vpGuide,list.size());
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId()==R.id.tv_hello){
                    MainServiceWrap.Singletion.INSTANCE.getHolder().launchMain();
                    SharedPreferencesUtils.getInstance(BaseApplication.getAppContext()).putBoolean(SharedPreferencesUtils.IS_FIRST_LAUNCHER,false);
                    finish();
                }
            }
        });
    }


}