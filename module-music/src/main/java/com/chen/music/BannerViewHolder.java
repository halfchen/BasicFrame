package com.chen.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chen.base.bean.music.BannerInfo;
import com.chen.base.mzbanner.holder.MZViewHolder;
import com.chen.base.utils.ImageUtils;

/**
 * Created by chenbin
 * 2019-9-24
 **/
public class BannerViewHolder implements MZViewHolder<BannerInfo.BannersBean> {
    private ImageView mImageView;

    @Override
    public View createView(Context context) {
        // 返回页面布局
        View view = LayoutInflater.from(context).inflate(R.layout.circular_banner_item, null);
        mImageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onBind(Context context, int position, BannerInfo.BannersBean data) {
        // 数据绑定
        ImageUtils.newInstance().load(data.getImageUrl(), mImageView);
    }
}
