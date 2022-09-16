package com.program.module_ucenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_ucenter.R;
import com.program.module_ucenter.callback.ISettingCallback;
import com.program.module_ucenter.presenter.ISettingPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

public class SettingActivity extends RxAppCompatActivity implements ISettingCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_set_up);

        ISettingPresenter settingPresenter = PresenterManager.getInstance().getSettingPresenter();
        settingPresenter.registerViewCallback(this);
        settingPresenter.registerLifecycleTransformer(this.bindToLifecycle());

        Button btnLoginout = this.findViewById(R.id.btn_logout);

        btnLoginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance(getBaseContext());
//                instance.remove(SharedPreferencesUtils.USER_TOKEN_COOKIE);
//                instance.remove(SharedPreferencesUtils.USER_PHONE);
//                instance.remove(SharedPreferencesUtils.USER_ID);
//                Intent intent = new Intent();
//                intent.putExtra("return","toHome");
//                setResult(Constants.RETURN_TO_HMOE,intent);
//                finish();
                settingPresenter.loginout();
            }
        });
    }

    @Override
    public void loginoutSuccess(String msg) {
        back();
    }

    private void back() {
        Intent intent = new Intent();
        intent.putExtra("return", "toHome");
        setResult(Constants.RETURN_TO_HMOE, intent);
        finish();
    }

    @Override
    public void getErrorMessage(String msg) {
//        ToastUtils.showToast(msg);
        LogUtils.d("SettingActivity", "getErrorMessage() =" + msg);
        back();
    }

    @Override
    public LifecycleProvider<Lifecycle.Event> getBindToLifecycle() {
        LifecycleProvider<Lifecycle.Event> lifecycleProvider = AndroidLifecycle.createLifecycleProvider((LifecycleOwner) this);
        return lifecycleProvider;
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}