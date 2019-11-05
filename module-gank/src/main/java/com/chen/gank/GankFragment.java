package com.chen.gank;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseFragment;
import com.chen.base.bean.gank.GankBean;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.utils.DimensUtils;
import com.chen.base.utils.ImageUtils;
import com.chen.gank.databinding.FragmentGankBinding;
import com.chen.gank.viewmodel.GankViewModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

/**
 * Created by chenbin
 * 2019-10-8
 **/
@Route(path = RouterFragmentPath.Gank.PAGER_GANK)
public class GankFragment extends BaseFragment<FragmentGankBinding, GankViewModel> {

    private ArrayList<GankBean.ResultsBean> mList = new ArrayList<>();
    private CommonRecyclerAdapter<GankBean.ResultsBean> adapter;
    private int page = 1;

    private String mType = "all";
    private int count = 15;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_gank;
    }

    @Override
    public void loadData() {
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
        binding.ivWelfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(RouterActivityPath.Gank.PAGER_WELFARE)
                        .navigation();
            }
        });
        initAdapter();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<GankBean.ResultsBean>(getContext(), mList, R.layout.item_gank_view) {
                @Override
                public void convert(ViewHolder holder, GankBean.ResultsBean item, int position) {
                    ImageView imageView = holder.getView(R.id.image);
                    if (item.getImages().size() == 0) {
                        imageView.setVisibility(View.GONE);
                    } else {
                        imageView.setVisibility(View.VISIBLE);
                        ImageUtils.newInstance().load(item.getImages().get(0), imageView);
                    }
                    holder.setText(R.id.title, item.getDesc());
                    holder.setText(R.id.type, item.getType());
                    holder.setText(R.id.author, item.getWho());
                    holder.setText(R.id.time, item.getPublishedAt().substring(0, 10));
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ARouter.getInstance()
                                    .build(RouterActivityPath.AdWeb.PAGER_WEB)
                                    .withString("title", item.getDesc())
                                    .withString("url", item.getUrl())
                                    .withString("from", "gank")
                                    .navigation();
                        }
                    });
                }
            };
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                outRect.left = DimensUtils.dp2px(getContext(), 15);
                outRect.right = DimensUtils.dp2px(getContext(), 15);
                if (position == 0) {
                    outRect.top = DimensUtils.dp2px(getContext(), 15);
                } else if (position == mList.size() - 1) {
                    outRect.bottom = DimensUtils.dp2px(getContext(), 15);
                    outRect.top = DimensUtils.dp2px(getContext(), 8);
                } else {
                    outRect.top = DimensUtils.dp2px(getContext(), 8);
                }
            }
        });

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
                        mList.addAll(gankBean.getResults());
                    } else {
                        mList.addAll(gankBean.getResults());
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
