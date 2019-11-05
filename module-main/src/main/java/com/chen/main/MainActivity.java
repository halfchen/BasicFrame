package com.chen.main;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.base.BaseActivity;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.main.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding, NoViewModel> {

    private List<Fragment> mFragments;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }

    private void initFragment() {
        //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_VIDEO).navigation();
        Fragment tvFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.TV.PAGER_TV).navigation();
        Fragment gankFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Gank.PAGER_GANK).navigation();
        Fragment userFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.User.PAGER_ME).navigation();
        mFragments = new ArrayList<>();
        mFragments.add(homeFragment);
        mFragments.add(tvFragment);
        mFragments.add(gankFragment);
        mFragments.add(userFragment);
        if (homeFragment != null) {
            //默认选中第一个
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, homeFragment);
            transaction.commitAllowingStateLoss();
        }
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pageNavigationView.material()
                .addItem(R.drawable.ic_home, "首页")
                .addItem(R.drawable.ic_live_tv, "电视台")
                .addItem(R.drawable.ic_gank_24dp, "Gank")
                .addItem(R.drawable.ic_person, "我的")
                .setDefaultColor(ContextCompat.getColor(this, R.color.text_9))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Fragment currentFragment = mFragments.get(index);
                if (currentFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, currentFragment);
                    transaction.commitAllowingStateLoss();
                }
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }
}
