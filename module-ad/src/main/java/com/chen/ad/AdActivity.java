package com.chen.ad;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.ad.databinding.ActivityAdBinding;
import com.chen.base.Constants;
import com.chen.base.base.BaseActivity;
import com.chen.base.base.BaseViewModel;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.StringUtils;

@Route(path = RouterActivityPath.AdWeb.PAGER_ADDETAIL)
public class AdActivity extends BaseActivity<ActivityAdBinding, BaseViewModel> {

    @Autowired
    String from;

    @Autowired
    String adUrl;

    @Override
    public void initParam() {
        // 调用 inject 方法，如果传递过来的参数含有，这样使用 @Autowired 的会自动解析
        ARouter.getInstance().inject(this);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_ad;
    }

    @Override
    public void initData() {
        WebSettings webSetting = binding.webview.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setAllowContentAccess(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setDisplayZoomControls(false);//不显示webview缩放按钮
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setSupportMultipleWindows(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setPluginState(WebSettings.PluginState.ON);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //android 默认是可以打开_bank的，是因为它默认设置了WebSettings.setSupportMultipleWindows(false)
        //在false状态下，_bank也会在当前页面打开……
        //而x5浏览器，默认开启了WebSettings.setSupportMultipleWindows(true)，
        // 所以打不开……主动设置成false就可以打开了
        //需要支持多窗体还需要重写WebChromeClient.onCreateWindow
        webSetting.setSupportMultipleWindows(false);
        webSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        binding.webview.setWebChromeClient(new MyWebChromeClient());
        binding.webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        binding.webview.loadUrl(adUrl);
    }

    @Override
    public void onBackPressed() {
        if (binding.webview.canGoBack()) {
            binding.webview.goBack();
        } else {
            if (!StringUtils.isEmpty(from)) {
                switch (from) {
                    case Constants.JUMP_VALUE_SPLASH_AD:
                        ARouter.getInstance()
                                .build(RouterActivityPath.Main.PAGER_MAIN)
                                .navigation();
                        finish();
                        break;
                    default:
                        finish();
                        break;
                }
            }
        }
    }

    public class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100) {
                binding.progressBar.setVisibility(View.GONE);
            } else {
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.progressBar.setProgress(newProgress);
            }
        }
    }
}
