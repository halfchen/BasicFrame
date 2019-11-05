package com.chen.ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-8-14
 **/
public class MyX5WebView extends WebView {

    private List<String> newList;
    private MyWebChromeClient chromeClient;
    private WebListener mWebListener;

    public MyX5WebView(Context context) {
        super(context);
        initUI();
    }

    public MyX5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public MyX5WebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initUI();
    }

    public void setWebListener(WebListener listener) {
        this.mWebListener = listener;
    }

    private void initUI() {
//        getX5WebViewExtension().setScrollBarFadingEnabled(false);
        setHorizontalScrollBarEnabled(false);//水平不显示小方块
        setVerticalScrollBarEnabled(false); //垂直不显示小方块

//      setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);//滚动条在WebView内侧显示
//      setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);//滚动条在WebView外侧显示

        initWebViewSettings();
    }

    //   基本的WebViewSetting
    public void initWebViewSettings() {
        setBackgroundColor(getResources().getColor(android.R.color.white));
        setWebViewClient(client);
        chromeClient = new MyWebChromeClient();
        setWebChromeClient(chromeClient);
        chromeClient.setOpenFileChooserCallBack(new OpenFileChooserCallBack() {
            @Override
            public void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType) {
                if (mWebListener!=null){
                    mWebListener.onUploadListener(uploadMsg);
                }
            }

            @Override
            public void showFileChooserCallBack(ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (mWebListener!=null){
                    mWebListener.onUploadListener(filePathCallback, fileChooserParams);
                }
            }
        });
        setDownloadListener(downloadListener);
        setClickable(true);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        WebSettings webSetting = getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setAllowContentAccess(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setSupportMultipleWindows(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //android 默认是可以打开_bank的，是因为它默认设置了WebSettings.setSupportMultipleWindows(false)
        //在false状态下，_bank也会在当前页面打开……
        //而x5浏览器，默认开启了WebSettings.setSupportMultipleWindows(true)，
        // 所以打不开……主动设置成false就可以打开了
        //需要支持多窗体还需要重写WebChromeClient.onCreateWindow
        webSetting.setSupportMultipleWindows(false);
        webSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.canGoBack()) {
            this.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (mWebListener != null) {
                mWebListener.setTitle(title);
            }
        }

        //监听进度
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (mWebListener != null) {
                mWebListener.onProgressChanged(newProgress);
            }
        }

        private OpenFileChooserCallBack mOpenFileChooserCallBack;

        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> valueCallback) {
            if (mOpenFileChooserCallBack != null) {
                mOpenFileChooserCallBack.openFileChooserCallBack(valueCallback, "");
            }
        }

        //For Android 3.0 - 4.0
        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> uploadMsg, String acceptType) {
            if (mOpenFileChooserCallBack != null) {
                mOpenFileChooserCallBack.openFileChooserCallBack(uploadMsg, acceptType);
            }
        }

        // For Android 4.0 - 5.0
        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            if (mOpenFileChooserCallBack != null) {
                mOpenFileChooserCallBack.openFileChooserCallBack(uploadMsg, acceptType);
            }
        }

        // For Android > 5.0
        public boolean onShowFileChooser(WebView webView, com.tencent.smtt.sdk.ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (mOpenFileChooserCallBack != null) {
                mOpenFileChooserCallBack.showFileChooserCallBack(filePathCallback, fileChooserParams);
            }
            return true;
        }

        public void setOpenFileChooserCallBack(OpenFileChooserCallBack callBack) {
            mOpenFileChooserCallBack = callBack;
        }
    }

    interface OpenFileChooserCallBack {

        void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType);

        void showFileChooserCallBack(ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams);
    }

    private WebViewClient client = new WebViewClient() {

        //当页面加载完成的时候
        @Override
        public void onPageFinished(WebView webView, String url) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                CookieSyncManager.getInstance().sync();//同步cookie
            } else {
                CookieManager.getInstance().flush();
            }

            if (mWebListener != null) {
                mWebListener.setTitle(webView.getTitle());
            }
            //添加js代码
            webView.loadUrl("javascript:function img(){" +
                    "var href=document.getElementsByTagName(\"img\");" +
                    "\t\t if(href.length>0){\n" +
                    "\t\t \t window.jsAndroid.onShowImage(href[0].src)" +
                    "\t\t }" +
                    "}");
            //执行js函数
            webView.loadUrl("javascript:img()");
            super.onPageFinished(webView, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //返回值是true的时候控制去WebView打开，
            // 为false调用系统浏览器或第三方浏览器
            if (url.startsWith("http") || url.startsWith("https") || url.startsWith("ftp")) {
                return false;
            } else {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    view.getContext().startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(view.getContext(), "手机还没有安装支持打开此网页的应用！", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            return super.shouldInterceptRequest(view, request);
        }

        @Override
        public void onLoadResource(WebView webView, String s) {
            super.onLoadResource(webView, s);
            String reUrl = webView.getUrl() + "";
            List<String> urlList = new ArrayList<>();
            urlList.add(reUrl);
            newList = new ArrayList();
            for (String cd : urlList) {
                if (!newList.contains(cd)) {
                    newList.add(cd);
                }
            }
        }
    };

    //删除Cookie
    public void removeCookie() {
        CookieSyncManager.createInstance(getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeSessionCookie();
        cookieManager.removeAllCookie();
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
    }

    DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            getContext().startActivity(intent);
        }
    };
}
