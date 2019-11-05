package com.chen.music.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.Constants;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.RecycleViewDivider;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseActivity;
import com.chen.base.bean.music.PlayListDetail;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.ImageUtils;
import com.chen.base.utils.SharedPref;
import com.chen.base.utils.StatusBarUtil;
import com.chen.music.R;
import com.chen.music.databinding.ActivityDetailBinding;
import com.chen.music.viewmodel.DetailViewModel;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-9-26
 **/
@Route(path = RouterActivityPath.Music.PAGER_MUSIC)
public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailViewModel> {

    @Autowired
    String imageUrl;
    @Autowired
    String id;

    private CommonRecyclerAdapter<PlayListDetail.ResultBean.TracksBean> adapter;
    private List<PlayListDetail.ResultBean.TracksBean> list = new ArrayList<>();
    private int[] darkColor;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_detail;
    }

    @Override
    public void initParam() {
        // 调用 inject 方法，如果传递过来的参数含有，这样使用 @Autowired 的会自动解析
        ARouter.getInstance().inject(this);
    }

    @Override
    protected void initData() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);

        ImageUtils.newInstance().load(imageUrl, binding.coverImgUrl);
        ImageUtils.newInstance().blurTransformation(imageUrl, binding.ivBackground);

        initAdapter();

        showLoading();
        requestPlayListDetail();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<PlayListDetail.ResultBean.TracksBean>(this, list, R.layout.music_detail_item) {
                @Override
                public void convert(ViewHolder holder, PlayListDetail.ResultBean.TracksBean item, int position) {
                    holder.setText(R.id.tv_num, (position + 1) + "");
                    holder.setText(R.id.tv_musicname, item.getName());
                    if (item.getArtists().size() > 0) {
                        if (item.getAlbum() != null) {
                            holder.setText(R.id.tv_author, item.getArtists().get(0).getName() + " - " + item.getAlbum().getName());
                        } else {
                            holder.setText(R.id.tv_author, item.getArtists().get(0).getName());
                        }
                    } else if (item.getAlbum() != null) {
                        holder.setText(R.id.tv_author, item.getAlbum().getName());
                    }
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (list.size() > 0) {
                                SharedPref.getInstance(DetailActivity.this).putLists(Constants.SAVE, list);
                            }
                        }
                    });
                    holder.getView(R.id.share_music).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            share(item.getSongUrl(), item.getSongName(), item.getArtist(), item.getSongCover());
                        }
                    });
                }
            };
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL, 1, getResources().getColor(R.color.bg_f4)));
    }

    private void requestPlayListDetail() {
        viewModel.requestPlayListDetail(id).observe(this, new Observer<PlayListDetail>() {
            @Override
            public void onChanged(PlayListDetail playListDetail) {
                hindLoading();
                binding.llPlayAll.setVisibility(View.VISIBLE);
                binding.llDetail.setVisibility(View.VISIBLE);
                if (playListDetail != null && playListDetail.getResult() != null) {
                    binding.title.setText(playListDetail.getResult().getName());
                    binding.name.setText(playListDetail.getResult().getName());
                    binding.description.setText(playListDetail.getResult().getDescription());
                    list.clear();
                    for (PlayListDetail.ResultBean.TracksBean tracksBean : playListDetail.getResult().getTracks()) {
                        list.add(tracksBean);
                    }
                    adapter.notifyDataSetChanged();
                    String number = list.size() + "";
                    binding.tvNumber.setText(String.format(getResources().getString(R.string.music_num), number));
                    if (playListDetail.getResult().getCreator() != null) {
                        binding.nickname.setText(playListDetail.getResult().getCreator().getNickname());
                        ImageUtils.newInstance().displayCircle(playListDetail.getResult().getCreator().getAvatarUrl(), binding.avatarUrl);
                    }
                    if (playListDetail.getResult().getCoverImgUrl() != null) {
                        ImageUtils.newInstance().load(playListDetail.getResult().getCoverImgUrl(), binding.coverImgUrl);
                        darkColor = ImageUtils.newInstance().loadPickColor(playListDetail.getResult().getCoverImgUrl(), binding.ivBackground);
                    }
                    binding.appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                        @Override
                        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                            if (i < -280) {
                                StatusBarUtil.setWindowStatusBarColor(DetailActivity.this, darkColor[0]);
                                binding.toolBar.setBackgroundColor(darkColor[0]);
                            } else {
                                float fraction = (float) Math.abs(i) / 280;
                                Integer barColor = ArgbEvaluatorCompat.getInstance().evaluate(fraction, getResources().getColor(R.color.transparent), darkColor[0]);
                                StatusBarUtil.setWindowStatusBarColor(DetailActivity.this, barColor);
                                binding.toolBar.setBackgroundColor(barColor);
                            }
                        }
                    });
                }
            }
        });
    }
}
