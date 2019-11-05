package com.chen.gank.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseActivity;
import com.chen.base.base.ImageBrowserActivity;
import com.chen.base.bean.gank.GankBean;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.ImageUtils;
import com.chen.base.widget.photoview.PreviewPositionListener;
import com.chen.gank.R;
import com.chen.gank.databinding.ActivityWelfareBinding;
import com.chen.gank.viewmodel.WelfareViewModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

/**
 * Created by chenbin
 * 2019-10-9
 **/
@Route(path = RouterActivityPath.Gank.PAGER_WELFARE)
public class WelfareActivity extends BaseActivity<ActivityWelfareBinding, WelfareViewModel> implements PreviewPositionListener {

    private String mType = "福利";
    private int count = 20;
    private int page = 1;

    private ArrayList<String> mList = new ArrayList<>();
    private CommonRecyclerAdapter<String> adapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_welfare;
    }

    @Override
    protected void initData() {
        requestGankData(page);
        binding.refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                requestGankData(page);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                requestGankData(page);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initAdapter();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<String>(this, mList, R.layout.item_welfare) {
                @Override
                public void convert(ViewHolder holder, String item, int position) {
                    ImageView ivWelfare = holder.getView(R.id.ivWelfare);
                    ImageUtils.newInstance().load(item, ivWelfare);
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageBrowserActivity.showImageBrowser(WelfareActivity.this, v, position, mList, WelfareActivity.this);
                        }
                    });
                }
            };
        }
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(adapter);

    }

    private void requestGankData(int page) {
        viewModel.getGankData(mType, count, page).observe(this, new Observer<GankBean>() {
            @Override
            public void onChanged(GankBean gankBean) {
                binding.refreshLayout.finishRefresh();
                binding.refreshLayout.finishLoadMore();
                if (gankBean != null) {
                    if (page == 1) {
                        mList.clear();
                        for (GankBean.ResultsBean bean : gankBean.getResults()) {
                            mList.add(bean.getUrl());
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        int start = mList.size();
                        for (GankBean.ResultsBean bean : gankBean.getResults()) {
                            mList.add(bean.getUrl());
                        }
                        adapter.notifyItemRangeInserted(start, mList.size());
                    }
                }
            }
        });
    }

    @Override
    public void scrollToPosition(int position) {
        staggeredGridLayoutManager.scrollToPositionWithOffset(position, 20);
    }
}
