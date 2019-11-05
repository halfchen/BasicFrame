package com.chen.eye.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseActivity;
import com.chen.base.bean.video.CategoriesBean;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.DimensUtils;
import com.chen.eye.BR;
import com.chen.eye.R;
import com.chen.eye.databinding.ActivityClassifyBinding;
import com.chen.eye.viewmodel.ClassifyViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-9-19
 **/
@Route(path = RouterActivityPath.EyeVideo.PAGER_CLASSIFY)
public class ClassifyActivity extends BaseActivity<ActivityClassifyBinding, ClassifyViewModel> {

    private List<CategoriesBean.ItemListBean> mList = new ArrayList<>();
    private CommonRecyclerAdapter<CategoriesBean.ItemListBean> adapter;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_classify;
    }

    @Override
    public void initData() {
        initAdapter();
        viewModel.requestCategories().observe(this, new Observer<CategoriesBean>() {
            @Override
            public void onChanged(CategoriesBean categoriesBean) {
                mList.clear();
                if (categoriesBean != null) {
                    mList.addAll(categoriesBean.getItemList());
                }
                adapter.notifyDataSetChanged();
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<CategoriesBean.ItemListBean>(this, mList, R.layout.item_square_card2) {
                @Override
                public void convert(ViewHolder holder, final CategoriesBean.ItemListBean item, int position) {
                    if (item.getData() != null) {
                        holder.setImageByGlide(R.id.image, item.getData().getImage());
                        holder.setText(R.id.title, item.getData().getTitle());

                        holder.setOnIntemClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (item.getData().getActionUrl().contains("ranklist")) {
                                    ARouter.getInstance()
                                            .build(RouterActivityPath.EyeVideo.PAGER_RANK)
                                            .navigation();
                                }
                            }
                        });
                    }
                }
            };
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = DimensUtils.dp2px(ClassifyActivity.this, 3);
                int position = parent.getChildAdapterPosition(view);
                if (position % 2 == 0) {
                    outRect.left = DimensUtils.dp2px(ClassifyActivity.this, 15);
                } else {
                    outRect.left = DimensUtils.dp2px(ClassifyActivity.this, 3);
                    outRect.right = DimensUtils.dp2px(ClassifyActivity.this, 15);
                }
            }
        });
    }
}
