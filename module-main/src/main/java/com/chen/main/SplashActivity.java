package com.chen.main;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.Constants;
import com.chen.base.base.BaseActivity;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.ImageUtils;
import com.chen.base.utils.NetUtils;
import com.chen.base.utils.StringUtils;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.main.databinding.ActivitySplashBinding;
import com.chen.main.entity.AdMessageBean;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, NoViewModel> implements View.OnClickListener {

    int timeCount = 0;
    boolean continueCount = true;
    private int initTimeCount;
    private AdMessageBean mAdMessageBean;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        if (NetUtils.isConnected(SplashActivity.this)) {
            double random = Math.random();
            if (random < 0.25) {
                mAdMessageBean = new AdMessageBean(8, "http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg", "http://gank.io/api");
            } else if (random >= 0.25 && random < 0.5) {
                mAdMessageBean = new AdMessageBean(8, "https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg", "https://github.com/halfchen");
            } else if (random >= 0.5 && random <= 0.75) {
                mAdMessageBean = new AdMessageBean(8, "https://ww1.sinaimg.cn/large/0065oQSqly1ftdtot8zd3j30ju0pt137.jpg", "");
            } else {
                mAdMessageBean = new AdMessageBean(8, "https://ww1.sinaimg.cn/large/0065oQSqly1ftf1snjrjuj30se10r1kx.jpg", "");
            }
            ImageUtils.newInstance().load(mAdMessageBean.getAdPictureUrl(), binding.ivAdvertising);
        }
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_PHONE_STATE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        handler.sendMessageDelayed(handler.obtainMessage(-1), 1000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        binding.ivAdvertising.setOnClickListener(this);
        binding.layoutSkip.setOnClickListener(this);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (continueCount) {
                countNum();
                handler.sendMessageDelayed(handler.obtainMessage(-1), 1000);
            }
        }
    };

    public int countNum() {//数秒
        initTimeCount = mAdMessageBean.getAdTime();
        timeCount++;
        if (timeCount == 3) {//数秒，超过3秒后如果没有网络，则进入下一个页面
            if (!NetUtils.isConnected(SplashActivity.this)) {
                continueCount = false;
                jumpToMain();
            }
            if (StringUtils.isEmpty(mAdMessageBean.getAdPictureUrl())) {
                //如果无广告则进入下一页
                continueCount = false;
                jumpToMain();
            } else {
                //如果有网络，则显示广告图片
                binding.ivAdvertising.setVisibility(View.VISIBLE);
                binding.layoutSkip.setVisibility(View.VISIBLE);
            }
        }
        binding.tvSecond.setText((initTimeCount - timeCount) + " ");
        if (timeCount == initTimeCount) {
            continueCount = false;
            jumpToMain();
        }
        return timeCount;
    }

    private void jumpToMain() {
        ARouter.getInstance()
                .build(RouterActivityPath.Main.PAGER_MAIN)
                .navigation();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        continueCount = false;
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_advertising) {
            ARouter.getInstance()
                    .build(RouterActivityPath.AdWeb.PAGER_ADDETAIL)
                    .withString(Constants.JUMP_KEY_FROM, Constants.JUMP_VALUE_SPLASH_AD)
                    .withString(Constants.JUMP_KEY_ADURL, mAdMessageBean.getAdPictureUrl())
                    .navigation();
            finish();
        } else if (id == R.id.layout_skip) {
            ARouter.getInstance()
                    .build(RouterActivityPath.Main.PAGER_MAIN)
                    .navigation();
            finish();
        }
    }
}
