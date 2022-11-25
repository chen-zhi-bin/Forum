package com.program.forum.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.program.forum.R;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.service.main.MainServiceWrap;
import com.program.moudle_base.utils.SharedPreferencesUtils;

import java.io.IOException;
import java.nio.CharBuffer;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
        SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance(this);

        boolean isFirst = instance.getBoolean(SharedPreferencesUtils.IS_FIRST_LAUNCHER, true);
        if (isFirst){
            mRunnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);
                    instance.putBoolean(SharedPreferencesUtils.IS_FIRST_LAUNCHER,false);
                    finish();
                }
            };
            mHandler.postDelayed(mRunnable,500);
        }else {
            mRunnable = new Runnable() {
                @Override
                public void run() {
                    toMain();
                }
            };
            mHandler.postDelayed(mRunnable,500);
        }
    }

    private void toMain() {
        if (!this.isDestroyed()&&!this.isFinishing()) {
            mHandler.removeCallbacks(mRunnable);
            MainServiceWrap.Singletion.INSTANCE.getHolder().launchMain();
            finish();
        }
    }
}