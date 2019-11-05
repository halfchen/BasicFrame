package com.chen.eye.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.chen.base.bean.video.FindBean;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.router.RouterFragmentPath;
import com.chen.base.utils.DimensUtils;
import com.chen.base.utils.StringUtils;
import com.chen.base.utils.TimeUtils;
import com.chen.base.utils.Utils;
import com.chen.eye.R;
import com.chen.eye.databinding.FragmentFindBinding;
import com.chen.eye.viewmodel.FindViewModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现
 * Created by chenbin
 * 2019-9-18
 **/
@Route(path = RouterFragmentPath.Video.PAGER_FIND)
public class FindFragment extends BaseFragment<FragmentFindBinding, FindViewModel> {

    private List<FindBean.ItemListBeanX> mList = new ArrayList<>();
    private CommonRecyclerAdapter<FindBean.ItemListBeanX> adapter;
    private int screenWidth;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_find;
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
        //初始化recyclerview
        initAdapter();

        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                requestValue();
            }
        });
    }

    /**
     * 请求数据
     */
    private void requestValue() {
        Log.e("======1", mList.size() + "  requestValue");
        viewModel.requestFind().observe(this, new Observer<FindBean>() {
            @Override
            public void onChanged(FindBean findBean) {
                binding.refreshLayout.finishRefresh();
                if (findBean != null) {
                    mList.addAll(findBean.getItemList());
                    adapter.notifyDataSetChanged();
                    Log.e("======", mList.size() + "  " + findBean.toString());
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
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.BriefCard)) {
                        return R.layout.item_tag_brief_card;
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
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.AutoPlayVideoAdDetail)) {
                        return R.layout.item_follow_card;
                    } else if (mList.get(position).getData().getDataType().equals(Constants.DataType.TextCard)) {
                        if (mList.get(position).getData().getType().contains(Constants.DataType.footer)) {
                            return R.layout.item_text_card_with_tagid;
                        } else {
                            return R.layout.item_text_card;
                        }
                    } else {
                        return R.layout.item_horizontal_scroll_card;
                    }
                } else {
                    return R.layout.item_horizontal_scroll_card;
                }
            }
        };

        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<FindBean.ItemListBeanX>(getContext(), mList, multiTypeSupport) {
                @Override
                public void convert(ViewHolder holder, final FindBean.ItemListBeanX item, int position) {
                    if (item.getData().getDataType().equals(Constants.DataType.Banner)) {
                        holder.setImageByGlide(R.id.banner, item.getData().getImage());
                    } else if (item.getData().getDataType().equals(Constants.DataType.HorizontalScrollCard)) {
                        if (item.getData().getItemList().size() > 0) {
                            RecyclerView itemRecyclerView = holder.getView(R.id.item_recyclerView);
                            final int index = item.getData().getItemList().size();
                            CommonRecyclerAdapter<FindBean.ItemListBeanX.DataBeanX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<FindBean.ItemListBeanX.DataBeanX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_banner_padding) {
                                @Override
                                public void convert(ViewHolder holder, final FindBean.ItemListBeanX.DataBeanX.ItemListBean item, int position) {
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

                                    holder.setOnIntemClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (item.getData() != null) {
                                                if (!StringUtils.isEmpty(item.getData().getUrl())) {
                                                    jumpVideoPlay(item.getData().getUrl(), item.getData().getTitle(), item.getData().getId());
                                                } else if (!StringUtils.isEmpty(item.getData().getActionUrl())) {
                                                    if (item.getData().getActionUrl().contains("http")) {
                                                        String actionUrl = item.getData().getActionUrl();
                                                        jump2WebActivity(Utils.decode(actionUrl.substring(actionUrl.indexOf("&url=") + 5)));
                                                    }
                                                }
                                            }
                                        }
                                    });
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
                    } else if (item.getData().getDataType().equals(Constants.DataType.BriefCard)) {
                        if (item.getData() != null) {
                            holder.setImageByGlide(R.id.icon, item.getData().getIcon());
                            holder.setText(R.id.title, item.getData().getTitle());
                            holder.setText(R.id.description, item.getData().getDescription());
                        }
                    } else if (item.getData().getDataType().equals(Constants.DataType.ItemCollection)) {
                        if (item.getType().equals(Constants.DataType.specialSquareCardCollection)) {//发现热门分类
                            if (item.getData().getHeader() != null) {
                                holder.setText(R.id.title, item.getData().getHeader().getTitle());
                                holder.setText(R.id.rightText, item.getData().getHeader().getRightText());
                            }
                            if (item.getData().getItemList().size() > 0) {
                                RecyclerView itemRecyclerView = holder.getView(R.id.item_recyclerView);
                                CommonRecyclerAdapter<FindBean.ItemListBeanX.DataBeanX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<FindBean.ItemListBeanX.DataBeanX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_square_card) {
                                    @Override
                                    public void convert(ViewHolder holder, final FindBean.ItemListBeanX.DataBeanX.ItemListBean item, int position) {
                                        if (item.getData() != null) {
                                            holder.setImageByGlide(R.id.image, item.getData().getImage());
                                            holder.setText(R.id.title, item.getData().getTitle());

                                            if (!StringUtils.isEmpty(item.getData().getUrl())) {
                                                holder.setOnIntemClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        jumpVideoPlay(item.getData().getUrl(), item.getData().getTitle(), item.getData().getId());
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
                                CommonRecyclerAdapter<FindBean.ItemListBeanX.DataBeanX.ItemListBean> itemAdapter = new CommonRecyclerAdapter<FindBean.ItemListBeanX.DataBeanX.ItemListBean>(getContext(), item.getData().getItemList(), R.layout.item_square_card2) {
                                    @Override
                                    public void convert(ViewHolder holder, final FindBean.ItemListBeanX.DataBeanX.ItemListBean item, int position) {
                                        ViewGroup.MarginLayoutParams params = null;
                                        if (holder.getView(R.id.llSquareCard).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                                            params = (ViewGroup.MarginLayoutParams) holder.getView(R.id.llSquareCard).getLayoutParams();
                                        } else {
                                            params = new ViewGroup.MarginLayoutParams(holder.getView(R.id.llSquareCard).getLayoutParams());
                                        }
                                        params.topMargin = DimensUtils.dp2px(getContext(), 5);
                                        if (position % 2 == 0) {
                                            params.leftMargin = DimensUtils.dp2px(getContext(), 15);
                                        } else {
                                            params.leftMargin = DimensUtils.dp2px(getContext(), 5);
                                            params.rightMargin = DimensUtils.dp2px(getContext(), 15);
                                        }
                                        holder.getView(R.id.llSquareCard).setLayoutParams(params);
                                        if (item.getData() != null) {
                                            holder.setImageByGlide(R.id.image, item.getData().getImage());
                                            holder.setText(R.id.title, item.getData().getTitle());

                                            holder.setOnIntemClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (!StringUtils.isEmpty(item.getData().getUrl())) {
                                                        jumpVideoPlay(item.getData().getUrl(), item.getData().getTitle(), item.getData().getId());
                                                    } else if (!StringUtils.isEmpty(item.getData().getActionUrl())) {
                                                        if (item.getData().getActionUrl().contains("http")) {
                                                            String actionUrl = item.getData().getActionUrl();
                                                            jump2WebActivity(Utils.decode(actionUrl.substring(actionUrl.indexOf("&url=") + 5)));
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                };
                                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                                gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
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
                        holder.setImageByGlide(R.id.icon, item.getData().getIcon());
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
                    } else if (item.getData().getDataType().equals(Constants.DataType.TextCard)) {
                        if (item.getData() != null) {
                            holder.setText(R.id.text, item.getData().getText());
                        }
                        holder.setOnIntemClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (item.getData() != null && item.getData().getType().contains(Constants.DataType.footer) && item.getData().getText().contains("分类")) {
                                    ARouter.getInstance()
                                            .build(RouterActivityPath.EyeVideo.PAGER_CLASSIFY)
                                            .navigation();
                                }
                            }
                        });
                    }

                    if (item.getData() != null && item.getData().getDetail() != null && !StringUtils.isEmpty(item.getData().getDetail().getUrl())) {
                        holder.setOnIntemClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                jumpVideoPlay(item.getData().getDetail().getUrl(), item.getData().getDetail().getTitle(), item.getData().getDetail().getId());
                            }
                        });
                    }
                }
            };
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                if (position == 0) {
                    outRect.top = DimensUtils.dp2px(getContext(), 10);
                }
            }
        });
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
