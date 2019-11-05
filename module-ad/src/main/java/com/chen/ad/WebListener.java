package com.chen.ad;

import android.net.Uri;
import android.webkit.ValueCallback;

import com.tencent.smtt.sdk.WebChromeClient;

/**
 * Created by chenbin
 * 2019-7-30
 **/
public interface WebListener {

    void onUploadListener(ValueCallback<Uri> uploadMsg);

    void onUploadListener(ValueCallback<Uri[]> uploadMsg, WebChromeClient.FileChooserParams fileChooserParams);

    void setTitle(String title);

    void onProgressChanged(int newProgress);
}
