package com.chen.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.RecycleViewDivider;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseFragment;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.utils.ImageUtils;
import com.chen.base.utils.ToastUtils;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.user.databinding.FragmentUserBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-9-17
 **/
@Route(path = RouterFragmentPath.User.PAGER_ME)
public class UserFragment extends BaseFragment<FragmentUserBinding, NoViewModel> {

    private List<FunctionBean> mLists = new ArrayList<>();
    private CommonRecyclerAdapter<FunctionBean> adapter;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_user;
    }

    @Override
    public void loadData() {
        ImageUtils.newInstance().displayCircle("http://b-ssl.duitang.com/uploads/item/201410/20/20141020224133_Ur54c.jpeg", binding.ivHead);
        binding.tvName.setText("唐宋元明清");

        mLists.clear();
        mLists.add(new FunctionBean("01", "设置", R.drawable.ic_settings_24dp));
        mLists.add(new FunctionBean("02", "安全", R.drawable.ic_fingerprint_24dp));
        mLists.add(new FunctionBean("03", "评价", R.drawable.ic_sentiment_very_satisfied_24dp));

        initAdapter();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<FunctionBean>(getContext(), mLists, R.layout.function_item) {
                @Override
                public void convert(ViewHolder holder, final FunctionBean item, int position) {
                    holder.setImageResource(R.id.iv_resource, item.getResourceId());
                    holder.setText(R.id.tv_name, item.getName());
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ToastUtils.showShort(item.getName());
                        }
                    });
                }
            };
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL, 1, getResources().getColor(R.color.bg_f4)));
    }
}
