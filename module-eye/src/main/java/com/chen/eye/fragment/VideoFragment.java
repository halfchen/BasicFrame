package com.chen.eye.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.base.BaseFragment;
import com.chen.base.base.BaseFragmentPagerAdapter;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.eye.R;
import com.chen.eye.databinding.FragmentVideoBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-9-18
 **/
@Route(path = RouterFragmentPath.Video.PAGER_VIDEO)
public class VideoFragment extends BaseFragment<FragmentVideoBinding, NoViewModel> implements View.OnClickListener {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_video;
    }

    @Override
    public void loadData() {
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getChildFragmentManager(), pagerFragment(), pagerTitleString());
        binding.viewPager.setAdapter(adapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.tabs.getTabAt(1).select();
        binding.rank.setOnClickListener(this);
        binding.search.setOnClickListener(this);
    }

    protected List<Fragment> pagerFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add((Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_FIND).navigation());
        list.add((Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_RECOMMEND).navigation());
        list.add((Fragment) ARouter.getInstance().build(RouterFragmentPath.Video.PAGER_DAILY).navigation());
        return list;
    }

    protected List<String> pagerTitleString() {
        List<String> list = new ArrayList<>();
        list.add("发现");
        list.add("推荐");
        list.add("日报");
        return list;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.rank) {
            ARouter.getInstance()
                    .build(RouterActivityPath.EyeVideo.PAGER_RANK)
                    .navigation();
        } else if (id == R.id.search) {
            ARouter.getInstance()
                    .build(RouterActivityPath.EyeVideo.PAGER_SEARCH)
                    .navigation();
        }
    }
}
