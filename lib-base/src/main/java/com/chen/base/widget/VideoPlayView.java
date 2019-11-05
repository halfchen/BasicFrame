package com.chen.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.chen.base.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by chenbin
 * 2019-9-20
 **/
public class VideoPlayView extends StandardGSYVideoPlayer {

    private ImageView mShareImg;

    public VideoPlayView(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public VideoPlayView(Context context) {
        super(context);
    }

    public VideoPlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.my_video_layout_normal;
    }

    @Override
    protected void updateStartImage() {
        if (mStartButton instanceof ImageView) {
            ImageView imageView = (ImageView) mStartButton;
            if (mCurrentState == CURRENT_STATE_PLAYING) {
                imageView.setImageResource(R.drawable.my_video_click_pause_selector);
            } else if (mCurrentState == CURRENT_STATE_ERROR) {
                imageView.setImageResource(R.drawable.my_video_click_play_selector);
            } else {
                imageView.setImageResource(R.drawable.my_video_click_play_selector);
            }
        }
    }

    @Override
    protected void init(Context context) {
        super.init(context);
        mShareImg = findViewById(R.id.share);
    }

    /**
     * 获取分享按钮
     *
     * @return
     */
    public ImageView getShareButton() {
        return mShareImg;
    }
}
