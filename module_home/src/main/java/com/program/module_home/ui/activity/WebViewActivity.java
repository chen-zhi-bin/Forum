package com.program.module_home.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.RoutePath;
import com.program.module_home.R;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

@Route(path = RoutePath.Home.PAGE_WEBVIEW)
public class WebViewActivity extends AppCompatActivity {

    @Autowired(name = "url")
    public String mUrl;
    private WebView mX5webView;
    private ProgressBar mProgressBar;
    private TextView mTvTitle;
    private RelativeLayout mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulehome_activity_web_view);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        LogUtils.d("test","url = "+mUrl);
        initView();
    }

    private void initView() {
        RelativeLayout includeBar = this.findViewById(R.id.include_bar);
        includeBar.findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTvTitle = includeBar.findViewById(R.id.tv_title);
        mX5webView = this.findViewById(R.id.x5webview);
        mProgressBar = this.findViewById(R.id.progressBar);
        mToolbar = this.findViewById(R.id.toolbar);
        initX5WebView();
    }

    private void initX5WebView() {
        WebSettings webSetting = mX5webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setAllowContentAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setSupportMultipleWindows(true);

        webSetting.setAppCacheEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
        );
        mX5webView.loadUrl(mUrl);
        mX5webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                //这里可以对特殊scheme进行拦截处理
                if (mUrl != null) {
                    if (mUrl.startsWith("http")||mUrl.startsWith("https")) {
                        mX5webView.loadUrl(mUrl);
                    }
                }
                return true ;//要返回true否则内核会继续处理
            }
        });
        mX5webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView, int i) {
                if (i<100){
                    //WebView加载没有完成 就显示我们自定义的加载图
                    mProgressBar.setProgress(i);
                    mProgressBar.setVisibility(View.VISIBLE);
                }else {
                    //WebView加载完成 就隐藏进度条,显示WebView
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onReceivedTitle(WebView webView, String s) {
                if (TextUtils.isEmpty(s)){
                    return;
                }
                mTvTitle.setText(s);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK&&mX5webView.canGoBack()){
            mX5webView.goBack();    //goBack()表示返回上一页
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}