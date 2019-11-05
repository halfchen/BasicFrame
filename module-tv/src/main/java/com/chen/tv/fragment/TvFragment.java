package com.chen.tv.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.MultiTypeSupport;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseFragment;
import com.chen.base.bean.tv.TVData;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.utils.Utils;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.tv.R;
import com.chen.tv.databinding.FragmentTvBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-9-23
 **/
@Route(path = RouterFragmentPath.TV.PAGER_TV)
public class TvFragment extends BaseFragment<FragmentTvBinding, NoViewModel> {

    private List<TVData> mList = new ArrayList<>();
    private CommonRecyclerAdapter<TVData> adapter;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tv;
    }

    @Override
    public void loadData() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String tvInfo = Utils.getFromAssets(getContext(), "live.txt");
        Type type = new TypeToken<List<TVData>>() {
        }.getType();
        List<TVData> list = gson.fromJson(tvInfo, type);
        mList.clear();
        mList.addAll(list);
        initAdapter();
    }

    private void initAdapter() {
        MultiTypeSupport multiTypeSupport = new MultiTypeSupport() {

            @Override
            public int getLayoutId(Object item, int position) {
                if (mList.get(position).getType().equals("title")) {
                    return R.layout.item_tv_title;
                } else {
                    return R.layout.item_tv;
                }
            }
        };
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<TVData>(getContext(), mList, multiTypeSupport) {
                @Override
                public void convert(ViewHolder holder, TVData item, int position) {
                    if (mList.get(position).getType().equals("title")) {
                        holder.setText(R.id.name, item.getName());
                    } else {
                        RelativeLayout rl_bg = holder.getView(R.id.rl_bg);
                        if (position % 7 == 0) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_01);
                        } else if (position % 7 == 1) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_02);
                        } else if (position % 7 == 2) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_03);
                        } else if (position % 7 == 3) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_04);
                        } else if (position % 7 == 4) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_05);
                        } else if (position % 7 == 5) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_06);
                        } else if (position % 7 == 6) {
                            rl_bg.setBackgroundResource(R.drawable.tv_shape_07);
                        }
                        holder.setText(R.id.name, item.getName());
                        holder.setOnIntemClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ARouter.getInstance()
                                        .build(RouterActivityPath.TV.PAGER_TV)
                                        .withString("url", item.getLive())
                                        .withString("title", item.getName())
                                        .navigation();
                            }
                        });
                    }
                }
            };
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                if (mList.get(i).getType().equals("title")) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(adapter);
    }
}
