package com.chen.tv;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.base.BaseActivity;
import com.chen.base.ijkplayer.IMediaController;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.viewmodel.NoViewModel;
import com.chen.tv.databinding.ActivityTvPlayBinding;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by chenbin
 * 2019-9-23
 **/
@Route(path = RouterActivityPath.TV.PAGER_TV)
public class TvPlayActivity extends BaseActivity<ActivityTvPlayBinding, NoViewModel> implements View.OnClickListener {

    @Autowired
    String url;
    @Autowired
    String title;

    private boolean isFirst = true;
    private int mRetryTimes = 0;
    private static final int CONNECTION_TIMES = 5;

    @Override
    public void initParam() {
        // 调用 inject 方法，如果传递过来的参数含有，这样使用 @Autowired 的会自动解析
        ARouter.getInstance().inject(this);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_tv_play;
    }

    @Override
    public void initData() {
//        //设置状态栏颜色为黑色
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.text_0));
        //初始化播放器
        initVideo();
        binding.title.setText(title);
        binding.back.setOnClickListener(this);
    }

    /**
     * 初始化播放器
     */
    public void initVideo() {
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        binding.videoview.setVideoURI(Uri.parse(url));
        binding.videoview.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {
                binding.videoview.start();
            }
        });

        binding.videoview.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(IMediaPlayer mp, int what, int extra) {
                switch (what) {
                    case IjkMediaPlayer.MEDIA_INFO_BUFFERING_START:
                        binding.rlLoading.setVisibility(View.VISIBLE);
                        break;
                    case IjkMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                    case IjkMediaPlayer.MEDIA_INFO_BUFFERING_END:
                        binding.rlLoading.setVisibility(View.GONE);
                        if (isFirst) {
                            handler.postDelayed(runnable, 1500);
                            isFirst = false;
                        }
                        break;
                }
                return false;
            }
        });

        binding.videoview.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer mp) {
                binding.rlLoading.setVisibility(View.VISIBLE);
                binding.videoview.stopPlayback();
                binding.videoview.release(true);
                binding.videoview.setVideoURI(Uri.parse(url));
            }
        });

        binding.videoview.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer mp, int what, int extra) {
                if (mRetryTimes > CONNECTION_TIMES) {
                    new AlertDialog.Builder(TvPlayActivity.this)
                            .setMessage("节目暂时不能播放")
                            .setPositiveButton(R.string.VideoView_error_button,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            TvPlayActivity.this.finish();
                                        }
                                    })
                            .setCancelable(false)
                            .show();
                } else {
                    binding.videoview.stopPlayback();
                    binding.videoview.release(true);
                    binding.videoview.setVideoURI(Uri.parse(url));
                }
                return false;
            }
        });

        binding.videoview.setMediaController(new IMediaController() {
            @Override
            public void hide() {
                binding.rlBack.setVisibility(View.VISIBLE);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public boolean isShowing() {
                if (binding.rlBack.getVisibility() == View.GONE) {
                    return true;//true调用hide（）
                } else {
                    return false;//false调用show（）
                }
            }

            @Override
            public void setAnchorView(View view) {
            }

            @Override
            public void setEnabled(boolean enabled) {
            }

            @Override
            public void setMediaPlayer(MediaController.MediaPlayerControl player) {
            }

            @Override
            public void show(int timeout) {
            }

            @Override
            public void show() {
                handler.removeCallbacks(runnable);
                binding.rlBack.setVisibility(View.GONE);
            }

            @Override
            public void showOnce(View view) {
            }
        });
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            binding.rlBack.setVisibility(View.GONE);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!binding.videoview.isBackgroundPlayEnabled()) {
            binding.videoview.stopPlayback();
            binding.videoview.release(true);
            binding.videoview.stopBackgroundPlay();
        }
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.back) {
            onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("======", newConfig.orientation + "");
    }
}
