package com.chen.music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseFragment;
import com.chen.base.bean.music.BannerInfo;
import com.chen.base.bean.music.HighQuality;
import com.chen.base.bean.music.PlayListInfo;
import com.chen.base.mzbanner.holder.MZHolderCreator;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.utils.ImageUtils;
import com.chen.base.utils.StringUtils;
import com.chen.music.BannerViewHolder;
import com.chen.music.R;
import com.chen.music.databinding.FragmentMusicBinding;
import com.chen.music.viewmodel.MusicViewModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = RouterFragmentPath.Music.PAGER_MUSIC)
public class MusicFragment extends BaseFragment<FragmentMusicBinding, MusicViewModel> {

    private List<BannerInfo.BannersBean> bannerList = new ArrayList<>();

    private List<HighQuality.PlaylistsBean> mList1 = new ArrayList<>();
    private List<HighQuality.PlaylistsBean> mList2 = new ArrayList<>();
    private List<PlayListInfo.ResultBean> mList3 = new ArrayList<>();
    private CommonRecyclerAdapter<HighQuality.PlaylistsBean> adapter1;
    private CommonRecyclerAdapter<HighQuality.PlaylistsBean> adapter2;
    private CommonRecyclerAdapter<PlayListInfo.ResultBean> adapter3;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_music;
    }

    @Override
    public void loadData() {
        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                requestData();
            }
        });
        initAdapter();
        //请求数据
        requestData();
    }

    private void requestData() {
        viewModel.requestBanner().observe(this, new Observer<BannerInfo>() {
            @Override
            public void onChanged(BannerInfo bannerInfo) {
                binding.refreshLayout.finishRefresh();
                if (bannerInfo != null) {
                    binding.refreshLayout.finishRefresh();
                    bannerList.clear();
                    bannerList.addAll(bannerInfo.getBanners());
                    // 设置数据
                    binding.banner.setPages(bannerList, new MZHolderCreator<BannerViewHolder>() {
                        @Override
                        public BannerViewHolder createViewHolder() {
                            return new BannerViewHolder();
                        }
                    });
                    binding.banner.start();
                }
            }
        });

        viewModel.requestHighQuality().observe(this, new Observer<HighQuality>() {
            @Override
            public void onChanged(HighQuality highQuality) {
                binding.refreshLayout.finishRefresh();
                if (highQuality != null) {
                    mList1.clear();
                    mList1.addAll(highQuality.getPlaylists());
                    adapter1.notifyDataSetChanged();
                    if (mList1.size() == 0) {
                        binding.llPlaylist1.setVisibility(View.GONE);
                    } else {
                        binding.llPlaylist1.setVisibility(View.VISIBLE);
                    }
                } else {
                    binding.llPlaylist1.setVisibility(View.GONE);
                }
            }
        });

        viewModel.requestPlayList().observe(this, new Observer<HighQuality>() {
            @Override
            public void onChanged(HighQuality highQuality) {
                binding.refreshLayout.finishRefresh();
                if (highQuality != null) {
                    mList2.clear();
                    mList2.addAll(highQuality.getPlaylists());
                    adapter2.notifyDataSetChanged();
                    if (mList2.size() == 0) {
                        binding.llPlaylist2.setVisibility(View.GONE);
                    } else {
                        binding.llPlaylist2.setVisibility(View.VISIBLE);
                    }
                } else {
                    binding.llPlaylist2.setVisibility(View.GONE);
                }
            }
        });

        viewModel.requestPersonalized().observe(this, new Observer<PlayListInfo>() {
            @Override
            public void onChanged(PlayListInfo playListInfo) {
                binding.refreshLayout.finishRefresh();
                if (playListInfo != null) {
                    mList3.clear();
                    mList3.addAll(playListInfo.getResult());
                    adapter3.notifyDataSetChanged();
                    if (mList3.size() == 0) {
                        binding.llPlaylist3.setVisibility(View.GONE);
                    } else {
                        binding.llPlaylist3.setVisibility(View.VISIBLE);
                    }
                } else {
                    binding.llPlaylist3.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initAdapter() {
        if (adapter1 == null) {
            adapter1 = new CommonRecyclerAdapter<HighQuality.PlaylistsBean>(getContext(), mList1, R.layout.songlist_item) {
                @Override
                public void convert(ViewHolder holder, HighQuality.PlaylistsBean item, int position) {
                    holder.setText(R.id.textView, item.getName());
                    if (!StringUtils.isEmpty(item.getCoverImgUrl())) {
                        ImageUtils.newInstance().load(item.getCoverImgUrl().trim(), holder.getView(R.id.imageView));
                    }
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            jumpToDetail(item.getCoverImgUrl().trim(), item.getId());
                        }
                    });
                }
            };
        }
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 3);
        binding.recyclerView1.setNestedScrollingEnabled(false);
        binding.recyclerView1.setLayoutManager(gridLayoutManager1);
        binding.recyclerView1.setAdapter(adapter1);

        if (adapter2 == null) {
            adapter2 = new CommonRecyclerAdapter<HighQuality.PlaylistsBean>(getContext(), mList2, R.layout.songlist_item) {
                @Override
                public void convert(ViewHolder holder, HighQuality.PlaylistsBean item, int position) {
                    holder.setText(R.id.textView, item.getName());
                    ImageUtils.newInstance().load(item.getCoverImgUrl(), holder.getView(R.id.imageView));
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            jumpToDetail(item.getCoverImgUrl(), item.getId());
                        }
                    });
                }
            };
        }
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 3);
        binding.recyclerView2.setNestedScrollingEnabled(false);
        binding.recyclerView2.setLayoutManager(gridLayoutManager2);
        binding.recyclerView2.setAdapter(adapter2);

        if (adapter3 == null) {
            adapter3 = new CommonRecyclerAdapter<PlayListInfo.ResultBean>(getContext(), mList3, R.layout.songlist_item) {
                @Override
                public void convert(ViewHolder holder, PlayListInfo.ResultBean item, int position) {
                    holder.setText(R.id.textView, item.getName());
                    ImageUtils.newInstance().load(item.getPicUrl(), holder.getView(R.id.imageView));
                    holder.setOnIntemClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            jumpToDetail(item.getPicUrl(), item.getId());
                        }
                    });
                }
            };
        }
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getContext(), 3);
        binding.recyclerView3.setNestedScrollingEnabled(false);
        binding.recyclerView3.setLayoutManager(gridLayoutManager3);
        binding.recyclerView3.setAdapter(adapter3);
    }

    private void jumpToDetail(String picUrl, String id) {
        ARouter.getInstance()
                .build(RouterActivityPath.Music.PAGER_MUSIC)
                .withString("imageUrl", picUrl)
                .withString("id", id)
                .navigation();
    }

    @Override
    public void onPause() {
        binding.banner.pause();
        super.onPause();
    }
}
