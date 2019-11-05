package com.chen.eye.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.Constants;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.MultiTypeSupport;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseFragment;
import com.chen.base.bean.video.AllRec;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.utils.DimensUtils;
import com.chen.base.utils.StringUtils;
import com.chen.base.utils.TimeUtils;
import com.chen.base.utils.Utils;
import com.chen.eye.BR;
import com.chen.eye.R;
import com.chen.eye.databinding.FragmentRecommendBinding;
import com.chen.eye.viewmodel.RecommendViewModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐
 * Created by chenbin
 * 2019-9-18
 **/
@Route(path = RouterFragmentPath.Video.PAGER_RECOMMEND)
public class RecommendFragment extends BaseFragment<FragmentRecommendBinding, RecommendViewModel> {

    private int page = 0;
    private List<AllRec.ItemListBeanX> mList = new ArrayList<>();
    private CommonRecyclerAdapter<AllRec.ItemListBeanX> adapter;
    private int screenWidth;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_recommend;
    }

    @Override
    public void loadData() {
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(outMetrics);
            screenWidth = outMetrics.widthPixels;
        }
        //请求数据
        requestValue();
        initAdapter();
        binding.refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                requestValue();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 0;
                requestValue();
            }
        });
    }

    /**
     * 请求数据
     */
    private void requestValue() {
        viewModel.requestRecommend(page).observe(this, new Observer<AllRec>() {
            @Override
            public void onChanged(AllRec allRec) {
                binding.refreshLayout.finishRefresh();
                binding.refreshLayout.finishLoadMore();
                if (allRec != null) {
                    if (page == 0) {
                        mList.clear();
                    }
                    mList.addAll(allRec.getItemList());
                    adapter.notifyDataSetChanged();
                } else {
                    binding.refreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
    }

    private void initAdapter() {
        MultiTypeSupport multiTypeSupport = new MultiTypeSupport() {
            @Override
            public int getLayoutId(Object item, int position) {
                if (mList.get(position).getData() != null) {
                    if (mList.get(position).getData().getDataType().equals(Constants.DataType.Banner)) {
                        return R.layout.item_banner;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.HorizontalScrollCard)) {
                        return R.layout.item_horizontal_scroll_card;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.ItemCollection)) {
                        if (mList.get(position).getType().equals(Constants.DataType.squareCardCollection)) {
                            return R.layout.allrec_item_collection;
                        } else {
                            return R.layout.find_item_collection;
                        }
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.VideoBeanForClient)) {
                        return R.layout.item_video_bean_for_client;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.TextCardWithRightAndLeftTitle)) {
                        return R.layout.item_text_card_with_right_and_left_title;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.TagBriefCard)) {
                        return R.layout.item_tag_brief_card;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.FollowCard)) {
                        return R.layout.item_follow_card;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.AutoPlayVideoAdDetail)) {
                        return R.layout.item_follow_card;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.TextCard)) {
                        if (mList.get(position).getData().getType().contains(Constants.DataType.footer)) {
                            return R.layout.item_text_card_with_tagid;
                        } else {
                            return R.layout.item_text_card;
                        }
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.TextCardWithTagId)) {
                        return R.layout.item_text_card_with_tagid;
                    } else {
                        return R.layout.item_horizontal_scroll_card;
                    }
                } else {
                    return R.layout.item_horizontal_scroll_card;
                }
            }
        };

        adapter = new CommonRecyclerAdapter<AllRec.ItemListBeanX>(getContext(), mList, multiTypeSupport) {
            @Override
            public void convert(ViewHolder holder, final AllRec.ItemListBeanX item, int position) {
                if (item.getData().getDataType().equals(Constants.DataType.Banner)) {
                    holder.setImageByGlide(R.id.banner, item.getData().getImage());
                } else if (item.getData().getDataType().equals(Constants.DataType.HorizontalScrollCard)) {
                    if (item.getData().getItemList().size() > 0) {
                        RecyclerView itemRecyclerView = holder.getView(R.id.item_recyclerView);
                        final int index = item.getData().getItemList().size();
                        CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_banner) {
                            @Override
                            public void convert(ViewHolder holder, final AllRec.ItemListBeanX.DataBeanXX.ItemListBean item, int position) {
                                ViewGroup.MarginLayoutParams params = null;
                                if (holder.getView(R.id.llBanner).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                                    params = (ViewGroup.MarginLayoutParams) holder.getView(R.id.llBanner).getLayoutParams();
                                } else {
                                    params = new ViewGroup.MarginLayoutParams(holder.getView(R.id.llBanner).getLayoutParams());
                                }
                                params.width = screenWidth - DimensUtils.dp2px(getContext(), 30);
                                if (position == 0) {
                                    params.leftMargin = DimensUtils.dp2px(getContext(), 15);
                                    params.rightMargin = DimensUtils.dp2px(getContext(), 3);
                                } else if (position == (index - 1)) {
                                    params.leftMargin = DimensUtils.dp2px(getContext(), 3);
                                    params.rightMargin = DimensUtils.dp2px(getContext(), 15);
                                } else {
                                    params.leftMargin = DimensUtils.dp2px(getContext(), 3);
                                    params.rightMargin = DimensUtils.dp2px(getContext(), 3);
                                }
                                holder.getView(R.id.llBanner).setLayoutParams(params);
                                if (item.getData() != null) {
                                    holder.setImageByGlide(R.id.banner, item.getData().getImage());
                                }
                                if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null && !StringUtils.isEmpty(item.getData().getContent().getData().getPlayUrl())) {
                                    holder.setOnIntemClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            jumpVideoPlay(item.getData().getContent().getData().getPlayUrl(), item.getData().getContent().getData().getTitle(), item.getData().getContent().getData().getId());
                                        }
                                    });
                                }
                            }
                        };
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        PagerSnapHelper snapHelper = new PagerSnapHelper();
                        itemRecyclerView.setOnFlingListener(null);
                        snapHelper.attachToRecyclerView(itemRecyclerView);
                        itemRecyclerView.setLayoutManager(linearLayoutManager);
                        itemRecyclerView.setAdapter(itemAdapter);
                    }
                } else if (item.getData().getDataType().equals(Constants.DataType.ItemCollection)) {
                    if (item.getType().equals(Constants.DataType.squareCardCollection)) {//推荐
                        if (item.getData().getHeader() != null) {
                            holder.setText(R.id.subTitle, item.getData().getHeader().getSubTitle());
                            holder.setText(R.id.title, item.getData().getHeader().getTitle());
                            holder.setText(R.id.rightText, item.getData().getHeader().getRightText());
                        }
                        if (item.getData().getItemList().size() > 0) {
                            RecyclerView itemRecyclerView = holder.getView(R.id.item_recyclerView);
                            final int index = item.getData().getItemList().size();
                            CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_follow_card2) {
                                @Override
                                public void convert(ViewHolder holder, final AllRec.ItemListBeanX.DataBeanXX.ItemListBean item, int position) {
                                    ViewGroup.MarginLayoutParams params = null;
                                    if (holder.getView(R.id.llFollowCard).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                                        params = (ViewGroup.MarginLayoutParams) holder.getView(R.id.llFollowCard).getLayoutParams();
                                    } else {
                                        params = new ViewGroup.MarginLayoutParams(holder.getView(R.id.llFollowCard).getLayoutParams());
                                    }
                                    params.width = screenWidth - DimensUtils.dp2px(getContext(), 30);
                                    if (position == 0) {
                                        params.leftMargin = DimensUtils.dp2px(getContext(), 15);
                                        params.rightMargin = DimensUtils.dp2px(getContext(), 3);
                                    } else if (position == (index - 1)) {
                                        params.leftMargin = DimensUtils.dp2px(getContext(), 3);
                                        params.rightMargin = DimensUtils.dp2px(getContext(), 15);
                                    } else {
                                        params.leftMargin = DimensUtils.dp2px(getContext(), 3);
                                        params.rightMargin = DimensUtils.dp2px(getContext(), 3);
                                    }
                                    holder.getView(R.id.llFollowCard).setLayoutParams(params);
                                    if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null) {
                                        if (item.getData().getContent().getData().getCover() != null) {
                                            holder.setImageByGlide(R.id.detail, item.getData().getContent().getData().getCover().getDetail());
                                        }
                                        if (item.getData().getContent().getData().getAuthor() != null) {
                                            holder.setCircleByGlide(R.id.icon, item.getData().getContent().getData().getAuthor().getIcon());
                                        }
                                        holder.setText(R.id.title, item.getData().getContent().getData().getTitle());
                                        holder.setText(R.id.slogan, item.getData().getContent().getData().getSlogan());
                                        holder.setText(R.id.duration, TimeUtils.formatVideoTime((long) item.getData().getContent().getData().getDuration()));

                                        if (!StringUtils.isEmpty(item.getData().getContent().getData().getPlayUrl())) {
                                            holder.setOnIntemClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    jumpVideoPlay(item.getData().getContent().getData().getPlayUrl(), item.getData().getContent().getData().getTitle(), item.getData().getContent().getData().getId());
                                                }
                                            });
                                        }
                                    }
                                }
                            };
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            PagerSnapHelper snapHelper = new PagerSnapHelper();
                            itemRecyclerView.setOnFlingListener(null);
                            snapHelper.attachToRecyclerView(itemRecyclerView);
                            itemRecyclerView.setLayoutManager(linearLayoutManager);
                            itemRecyclerView.setAdapter(itemAdapter);
                        }
                    } else if (item.getType().equals(Constants.DataType.specialSquareCardCollection)) {//发现热门分类
                        if (item.getData().getHeader() != null) {
                            holder.setText(R.id.title, item.getData().getHeader().getTitle());
                            holder.setText(R.id.rightText, item.getData().getHeader().getRightText());
                        }
                        if (item.getData().getItemList().size() > 0) {
                            RecyclerView itemRecyclerView = holder.getView(R.id.item_recyclerView);
                            CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_square_card) {
                                @Override
                                public void convert(ViewHolder holder, final AllRec.ItemListBeanX.DataBeanXX.ItemListBean item, int position) {
                                    if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null) {
                                        if (item.getData().getContent().getData().getCover() != null) {
                                            holder.setImageByGlide(R.id.image, item.getData().getImage());
                                        }
                                        holder.setText(R.id.title, item.getData().getTitle());
                                        if (!StringUtils.isEmpty(item.getData().getContent().getData().getPlayUrl())) {
                                            holder.setOnIntemClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    jumpVideoPlay(item.getData().getContent().getData().getPlayUrl(), item.getData().getContent().getData().getTitle(), item.getData().getContent().getData().getId());
                                                }
                                            });
                                        }
                                    }
                                }
                            };
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                            gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            itemRecyclerView.setLayoutManager(gridLayoutManager);
                            itemRecyclerView.setAdapter(itemAdapter);
                        }
                    } else {//发现专题策划
                        if (item.getData().getHeader() != null) {
                            holder.setText(R.id.title, item.getData().getHeader().getTitle());
                            holder.setText(R.id.rightText, item.getData().getHeader().getRightText());
                        }
                        if (item.getData().getItemList().size() > 0) {
                            RecyclerView itemRecyclerView = holder.getView(R.id.item_recyclerView);
                            CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<AllRec.ItemListBeanX.DataBeanXX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_square_card2) {
                                @Override
                                public void convert(ViewHolder holder, final AllRec.ItemListBeanX.DataBeanXX.ItemListBean item, int position) {
                                    if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null) {
                                        if (item.getData().getContent().getData().getCover() != null) {
                                            holder.setImageByGlide(R.id.image, item.getData().getImage());
                                        }
                                        holder.setText(R.id.title, item.getData().getTitle());
                                        if (!StringUtils.isEmpty(item.getData().getContent().getData().getPlayUrl())) {
                                            holder.setOnIntemClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    jumpVideoPlay(item.getData().getContent().getData().getPlayUrl(), item.getData().getContent().getData().getTitle(), item.getData().getContent().getData().getId());
                                                }
                                            });
                                        }
                                    }
                                }
                            };
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                            gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            itemRecyclerView.setLayoutManager(gridLayoutManager);
                            itemRecyclerView.setAdapter(itemAdapter);
                        }
                    }
                } else if (item.getData().getDataType().equals(Constants.DataType.VideoBeanForClient)) {
                    if (item.getData() != null) {
                        if (item.getData().getCover() != null) {
                            holder.setImageByGlide(R.id.detail, item.getData().getCover().getDetail());
                        }
                        holder.setText(R.id.title, item.getData().getTitle());
                        holder.setText(R.id.slogan, "#" + item.getData().getCategory());
                        holder.setText(R.id.duration, TimeUtils.formatVideoTime((long) item.getData().getDuration()));
                    }
                } else if (item.getData().getDataType().equals(Constants.DataType.TextCardWithRightAndLeftTitle)) {
                    holder.setText(R.id.text, item.getData().getText());
                    holder.setText(R.id.rightText, item.getData().getRightText());
                } else if (item.getData().getDataType().equals(Constants.DataType.TagBriefCard)) {
                    holder.setCircleByGlide(R.id.icon, item.getData().getIcon());
                    holder.setText(R.id.title, item.getData().getTitle());
                    holder.setText(R.id.description, item.getData().getDescription());
                } else if (item.getData().getDataType().equals(Constants.DataType.AutoPlayVideoAdDetail)) {
                    if (item.getData() != null && item.getData().getDetail() != null) {
                        holder.setImageByGlide(R.id.detail, item.getData().getDetail().getImageUrl());
                        holder.setCircleByGlide(R.id.icon, item.getData().getDetail().getIcon());
                        holder.setText(R.id.title, item.getData().getDetail().getTitle());
                        holder.setText(R.id.slogan, item.getData().getDetail().getDescription());
                        holder.setText(R.id.duration, "#广告");
                    }
                } else if (item.getData().getDataType().equals(Constants.DataType.FollowCard)) {
                    if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null) {
                        if (item.getData().getContent().getData().getCover() != null) {
                            holder.setImageByGlide(R.id.detail, item.getData().getContent().getData().getCover().getDetail());
                        }
                        if (item.getData().getContent().getData().getAuthor() != null) {
                            holder.setCircleByGlide(R.id.icon, item.getData().getContent().getData().getAuthor().getIcon());
                        }
                        holder.setText(R.id.title, item.getData().getContent().getData().getTitle());
                        if (StringUtils.isEmpty(item.getData().getContent().getData().getSlogan())) {
                            holder.setText(R.id.slogan, item.getData().getContent().getData().getCategory());
                        } else {
                            holder.setText(R.id.slogan, item.getData().getContent().getData().getSlogan());
                        }
                        holder.setText(R.id.duration, TimeUtils.formatVideoTime((long) item.getData().getContent().getData().getDuration()));
                    }
                } else if (item.getData().getDataType().equals(Constants.DataType.TextCard)) {
                    if (item.getData() != null) {
                        holder.setText(R.id.text, item.getData().getText());
                    }
                } else if (item.getData().getDataType().equals(Constants.DataType.TextCardWithTagId)) {
                    holder.setText(R.id.text, item.getText());
                }

                holder.setOnIntemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null && !StringUtils.isEmpty(item.getData().getContent().getData().getPlayUrl())) {
                            jumpVideoPlay(item.getData().getContent().getData().getPlayUrl(), item.getData().getContent().getData().getTitle(), item.getData().getContent().getData().getId());
                        } else if (item.getData() != null && !StringUtils.isEmpty(item.getData().getPlayUrl())) {
                            jumpVideoPlay(item.getData().getPlayUrl(), item.getData().getTitle(), item.getData().getId());
                        } else if (item.getData() != null && !StringUtils.isEmpty(item.getData().getActionUrl())) {
                            if (item.getData().getActionUrl().contains("http")) {
                                String actionUrl = item.getData().getActionUrl();
                                jump2WebActivity(Utils.decode(actionUrl.substring(actionUrl.indexOf("&url=") + 5)));
                            }
                        }
                    }
                });
            }
        };
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void jumpVideoPlay(String url, String title, String id) {
        ARouter.getInstance()
                .build(RouterActivityPath.EyeVideo.PAGER_PLAY)
                .withString("url", url)
                .withString("title", title)
                .withString("id", id)
                .navigation();
    }

    private void jump2WebActivity(String url) {
        ARouter.getInstance()
                .build(RouterActivityPath.AdWeb.PAGER_ADDETAIL)
                .withString(Constants.JUMP_KEY_ADURL, url)
                .navigation();
    }
}
