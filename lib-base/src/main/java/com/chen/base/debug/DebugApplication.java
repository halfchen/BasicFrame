package com.chen.base.debug;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.utils.ToastUtils;
import com.chen.base.utils.Utils;
import com.example.http.HttpUtils;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.squareup.leakcanary.LeakCanary;

import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;

/**
 * Created by goldze on 2018/6/25 0025.
 * debug包下的代码不参与编译，仅作为独立模块运行时初始化数据
 */

public class DebugApplication extends MultiDexApplication {

    private static DebugApplication debugApplication;

    public static DebugApplication getInstance(){
        return debugApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        debugApplication = this;
        Utils.init(this);
        ARouter.init(this);
        PlayerFactory.setPlayManager(Exo2PlayerManager.class);//EXO模式
        //http初始化
        HttpUtils.getInstance().init(this);
        //方法数大于65536
        MultiDex.install(this);
        //内存泄漏检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
