package com.chen.eye.activity;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.base.BaseActivity;
import com.chen.base.base.BaseFragmentPagerAdapter;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.eye.R;
import com.chen.eye.databinding.ActivityRankBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-9-19
 **/
@Route(path = RouterActivityPath.EyeVideo.PAGER_RANK)
public class RankActivity extends BaseActivity<ActivityRankBinding, NoViewModel> implements View.OnClickListener {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_rank;
    }

    @Override
    public void initData() {
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), pagerFragment(), pagerTitleString());
        binding.viewPager.setAdapter(adapter);
        binding.tabs.setupWithViewPager(binding.viewPager);

        binding.back.setOnClickListener(this);
        binding.search.setOnClickListener(this);
    }

    protected List<Fragment> pagerFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add((Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_WEEKLY).navigation());
        list.add((Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_MONTHLY).navigation());
        list.add((Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_HISTORICAL).navigation());
        return list;
    }

    protected List<String> pagerTitleString() {
        List<String> list = new ArrayList<>();
        list.add("周排行");
        list.add("月排行");
        list.add("总排行");
        return list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back) {
            finish();
        } else if (v.getId() == R.id.search) {
            ARouter.getInstance()
                    .build(RouterActivityPath.EyeVideo.PAGER_SEARCH)
                    .navigation();
        }
    }
}
