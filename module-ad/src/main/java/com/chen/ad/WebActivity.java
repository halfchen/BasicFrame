package com.chen.ad;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chen.ad.databinding.ActivityWebBinding;
import com.chen.base.Constants;
import com.chen.base.base.BaseActivity;
import com.chen.base.base.BaseViewModel;
import com.chen.base.dialog.dialog.AnimHelper;
import com.chen.base.dialog.dialog.AnyLayer;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.FileUtils;
import com.chen.base.utils.StringUtils;
import com.chen.base.utils.ToastUtils;
import com.chen.base.utils.Utils;
import com.chen.base.utils.WxShareUtils;
import com.chen.base.utils.ZpImageUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.smtt.sdk.WebChromeClient;

import java.io.File;

@Route(path = RouterActivityPath.AdWeb.PAGER_WEB)
public class WebActivity extends BaseActivity<ActivityWebBinding, BaseViewModel> implements View.OnClickListener {

    @Autowired
    String url;
    @Autowired
    String title;
    @Autowired
    String from;

//    private MyX5WebView webView;
    private String imageUrl = "";
    private String description = "点击查看详情";

    public static final int REQUEST_SELECT_FILE_CODE = 100;
    private static final int REQUEST_FILE_CHOOSER_CODE = 101;
    private static final int REQUEST_FILE_CAMERA_CODE = 102;
    // 默认图片压缩大小（单位：K）
    public static final int IMAGE_COMPRESS_SIZE_DEFAULT = 400;
    // 压缩图片最小高度
    public static final int COMPRESS_MIN_HEIGHT = 900;
    // 压缩图片最小宽度
    public static final int COMPRESS_MIN_WIDTH = 675;

    private ValueCallback<Uri> mUploadMsg;
    private ValueCallback<Uri[]> mUploadMsgs;
    // 相机拍照返回的图片文件
    private File mFileFromCamera;
    private BottomSheetDialog selectPicDialog;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_web;
    }

    @Override
    protected void initData() {
        if (!StringUtils.isEmpty(title)) {
            binding.title.setText(title);
        }
        binding.title.setSelected(true);
//        webView = new MyX5WebView(this);
//        binding.webviewContain.addView(webView);
        binding.webView.setWebListener(mWebListener);

        binding.webView.addJavascriptInterface(new JSObject(), "jsAndroid");
        binding.webView.loadUrl(url);

        binding.back.setOnClickListener(this);
        binding.close.setOnClickListener(this);
        binding.share.setOnClickListener(this);
    }

    @Override
    public void initParam() {
        // 调用 inject 方法，如果传递过来的参数含有，这样使用 @Autowired 的会自动解析
        ARouter.getInstance().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (binding.webView != null) {
            binding.webView.resumeTimers();
            binding.webView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (binding.webView != null) {
            binding.webView.onPause();
            binding.webView.pauseTimers();
        }
    }

    @Override
    protected void onDestroy() {
        if (binding.webView != null) {
//            webView.removeAllViews();
//            webView.destroy();
//            binding.webviewContain.removeView(webView);
//            mWebListener = null;
//            webView = null;

            ViewParent parent = binding.webView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(binding.webView);
            }
            mWebListener = null;
            binding.webView.stopLoading();
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            binding.webView.getSettings().setJavaScriptEnabled(false);
            binding.webView.clearHistory();
            binding.webView.clearView();
            binding.webView.removeAllViews();
            binding.webView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.back) {
            onBackPressed();
        } else if (id == R.id.close) {
            if (!StringUtils.isEmpty(from) && from.equals("ad")) {
                ARouter.getInstance()
                        .build(RouterActivityPath.Main.PAGER_MAIN)
                        .navigation();
            }
            finish();
        } else if (id == R.id.share) {
            share(binding.webView.getUrl(), binding.title.getText().toString().trim());
        }
    }

    private void share(String url, String t) {
        if (!StringUtils.isEmpty(t)) {
            title = t;
        }
        AnyLayer.target(findViewById(R.id.dialog_bottom))
                .direction(AnyLayer.Direction.TOP)
                .contentView(R.layout.dialog_share)
                .backgroundColorRes(R.color.dialog_bg)
                .gravity(Gravity.BOTTOM)
                .cancelableOnTouchOutside(true)
                .cancelableOnClickKeyBack(true)
                .contentAnim(new AnyLayer.IAnim() {
                    @Override
                    public long inAnim(View content) {
                        AnimHelper.startBottomInAnim(content, Constants.ANIM_DURATION);
                        return Constants.ANIM_DURATION;
                    }

                    @Override
                    public long outAnim(View content) {
                        AnimHelper.startBottomOutAnim(content, Constants.ANIM_DURATION);
                        return Constants.ANIM_DURATION;
                    }
                })
                .onClick(R.id.wechat, new AnyLayer.OnLayerClickListener() {
                    @Override
                    public void onClick(AnyLayer anyLayer, View v) {
                        loadBitmap(SendMessageToWX.Req.WXSceneSession, url, title, imageUrl);
                        anyLayer.dismiss();
                    }
                })
                .onClick(R.id.moments, new AnyLayer.OnLayerClickListener() {
                    @Override
                    public void onClick(AnyLayer anyLayer, View v) {
                        loadBitmap(SendMessageToWX.Req.WXSceneTimeline, url, title, imageUrl);
                        anyLayer.dismiss();
                    }
                })
                .setVisibility(R.id.download, View.GONE)
                .show();
    }

    private void loadBitmap(int targetScene, String url, String title, String bitmapUrl) {
        AnyLayer anyLayer = AnyLayer.with(this);
        anyLayer.contentView(R.layout.dialog_loading)
                .backgroundColorRes(R.color.dialog_bg)
                .cancelableOnTouchOutside(false)
                .cancelableOnClickKeyBack(true)
                .show();
        Glide.with(this).asBitmap().load(bitmapUrl).into(new SimpleTarget<Bitmap>() {
            /**
             * 成功的回调
             */
            @Override
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                // 下面这句代码是一个过度dialog，因为是获取网络图片，需要等待时间
                anyLayer.dismiss();
                // 调用方法
                WxShareUtils.shareWeb(WebActivity.this, targetScene, url, title, description, bitmap);
            }

            /**
             * 失败的回调
             */
            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                anyLayer.dismiss();
                WxShareUtils.shareWeb(WebActivity.this, targetScene, url, title, description, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack();//返回上个页面
            return;
        }
        if (!StringUtils.isEmpty(from) && from.equals("ad")) {
            ARouter.getInstance()
                    .build(RouterActivityPath.Main.PAGER_MAIN)
                    .navigation();
        }
        super.onBackPressed();
    }

    class JSObject {
        @JavascriptInterface
        public void onShowImage(String src) {
            imageUrl = src;
        }
    }

    /**
     * 选择图片弹框
     */
    private void showSelectPictrueDialog(final int tag, final com.tencent.smtt.sdk.WebChromeClient.FileChooserParams fileChooserParams) {
        selectPicDialog = new BottomSheetDialog(this, R.style.Dialog_NoTitle);
        selectPicDialog.setCanceledOnTouchOutside(false);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_select_pictrue, null);
        // 相册
        TextView album = view.findViewById(R.id.tv_select_pictrue_album);
        // 相机
        TextView camera = view.findViewById(R.id.tv_select_pictrue_camera);
        // 取消
        TextView cancel = view.findViewById(R.id.tv_select_pictrue_cancel);

        album.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (tag == 0) {
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("*/*");
                    startActivityForResult(Intent.createChooser(i, "File Browser"), REQUEST_FILE_CHOOSER_CODE);
                } else {
                    try {
                        Intent intent = fileChooserParams.createIntent();
                        startActivityForResult(intent, REQUEST_SELECT_FILE_CODE);
                    } catch (ActivityNotFoundException e) {
                        mUploadMsgs = null;
                    }
                }
                selectPicDialog.dismiss();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeCameraPhoto();
                selectPicDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUploadMsgs.onReceiveValue(null);
                mUploadMsgs = null;
                selectPicDialog.dismiss();
            }
        });

        selectPicDialog.setContentView(view);
        selectPicDialog.show();
    }

    public void takeCameraPhoto() {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            ToastUtils.showShort("设备无摄像头");
            return;
        }
        // 拍照
        mFileFromCamera = new File(FileUtils.createRootPath(this) + "/" + System.currentTimeMillis() + ".jpg");
        FileUtils.createFile(mFileFromCamera);
        Uri imageUri = FileProvider.getUriForFile(this, Utils.getpackageNames(this) + ".fileprovider", mFileFromCamera);//通过FileProvider创建一个content类型的Uri
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
        startActivityForResult(intent, REQUEST_FILE_CAMERA_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_SELECT_FILE_CODE:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (mUploadMsgs == null) {
                        return;
                    }
                    mUploadMsgs.onReceiveValue(android.webkit.WebChromeClient.FileChooserParams.parseResult(resultCode, data));
                    mUploadMsgs = null;
                }
                break;
            case REQUEST_FILE_CHOOSER_CODE:
                if (mUploadMsg == null) {
                    return;
                }
                Uri result = data == null || resultCode != RESULT_OK ? null : data.getData();
                mUploadMsg.onReceiveValue(result);
                mUploadMsg = null;
                break;
            case REQUEST_FILE_CAMERA_CODE:
                if (resultCode == RESULT_OK) {
                    takePictureFromCamera();
                } else {
                    if (mUploadMsg != null) {
                        mUploadMsg.onReceiveValue(null);
                        mUploadMsg = null;
                    }
                    if (mUploadMsgs != null) {
                        mUploadMsgs.onReceiveValue(null);
                        mUploadMsgs = null;
                    }
                }
                break;
        }
    }

    /**
     * 处理相机返回的图片
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void takePictureFromCamera() {
        if (mFileFromCamera != null && mFileFromCamera.exists()) {
            String filePath = mFileFromCamera.getAbsolutePath();
            // 压缩图片到指定大小
            File imgFile = ZpImageUtils.compressImage(this, filePath, COMPRESS_MIN_WIDTH, COMPRESS_MIN_HEIGHT, IMAGE_COMPRESS_SIZE_DEFAULT);

            Uri localUri = Uri.fromFile(imgFile);
            Intent localIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, localUri);
            sendBroadcast(localIntent);
            Uri result = Uri.fromFile(imgFile);

            if (mUploadMsg != null) {
                mUploadMsg.onReceiveValue(Uri.parse(filePath));
                mUploadMsg = null;
            }
            if (mUploadMsgs != null) {
                mUploadMsgs.onReceiveValue(new Uri[]{result});
                mUploadMsgs = null;
            }
        } else {
            if (mUploadMsg != null) {
                mUploadMsg.onReceiveValue(null);
                mUploadMsg = null;
            }
            if (mUploadMsgs != null) {
                mUploadMsgs.onReceiveValue(null);
                mUploadMsgs = null;
            }
        }
    }

    WebListener mWebListener = new WebListener() {
        @Override
        public void onUploadListener(ValueCallback<Uri> uploadMsg) {
            mUploadMsg = uploadMsg;
            showSelectPictrueDialog(0, null);
        }

        @Override
        public void onUploadListener(ValueCallback<Uri[]> uploadMsg, WebChromeClient.FileChooserParams fileChooserParams) {
            if (mUploadMsgs != null) {
                mUploadMsgs.onReceiveValue(null);
            }
            mUploadMsgs = uploadMsg;
            showSelectPictrueDialog(1, fileChooserParams);
        }

        @Override
        public void setTitle(String title) {
            binding.title.setText(title);
        }

        @Override
        public void onProgressChanged(int newProgress) {
            if (binding.progressBar != null) {
                if (newProgress == 100) {
                    binding.progressBar.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    if (!description.equals("点击查看更多")) {
                        description = "点击查看更多";
                    }
                    binding.progressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    binding.progressBar.setProgress(newProgress);//设置进度值
                }
            }
        }
    };
}
