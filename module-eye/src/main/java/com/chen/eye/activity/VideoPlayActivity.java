package com.chen.eye.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chen.base.Constants;
import com.chen.base.adapter.CommonRecyclerAdapter;
import com.chen.base.adapter.MultiTypeSupport;
import com.chen.base.adapter.ViewHolder;
import com.chen.base.base.BaseActivity;
import com.chen.base.bean.video.AllRec;
import com.chen.base.router.RouterActivityPath;
import com.chen.base.utils.ImageUtils;
import com.chen.base.utils.StatusBarUtil;
import com.chen.base.utils.StringUtils;
import com.chen.base.utils.TimeUtils;
import com.chen.base.utils.ToastUtils;
import com.chen.eye.R;
import com.chen.eye.databinding.ActivityVideoPlayBinding;
import com.chen.eye.viewmodel.VideoPlayViewModel;
import com.google.android.exoplayer2.SeekParameters;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;

import static com.chen.base.utils.ImageLoader.loadCover;

/**
 * Created by chenbin
 * 2019-9-19
 **/
@Route(path = RouterActivityPath.EyeVideo.PAGER_PLAY)
public class VideoPlayActivity extends BaseActivity<ActivityVideoPlayBinding, VideoPlayViewModel> implements View.OnClickListener {

    @Autowired
    String title;
    @Autowired
    String url;
    @Autowired
    String id;

    private boolean isPlay;
    private boolean isPause;
    private OrientationUtils orientationUtils;

    private List<AllRec.ItemListBeanX> mList = new ArrayList<>();
    private CommonRecyclerAdapter<AllRec.ItemListBeanX> adapter;
    private GSYVideoOptionBuilder gsyVideoOption;
    private ImageView imageView;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_video_play;
    }

    @Override
    public void initParam() {
        // 调用 inject 方法，如果传递过来的参数含有，这样使用 @Autowired 的会自动解析
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initData() {
        //设置状态栏颜色为黑色
        StatusBarUtil.setColor(this, getResources().getColor(R.color.text_0));
        //初始化播放器
        initVideoPlayView();
        //初始化recyclerview
        initAdapter();
        //请求类似视频数据
        requestRelated();
    }

    /**
     * 请求类似视频数据
     */
    private void requestRelated() {
        viewModel.requestRelated(id).observe(this, new Observer<AllRec>() {
            @Override
            public void onChanged(AllRec allRec) {
                if (allRec != null) {
                    mList.clear();
                    mList.addAll(allRec.getItemList());
                    adapter.notifyDataSetChanged();
                    binding.recyclerView.scrollToPosition(0);
                }
            }
        });
    }

    private void initAdapter() {
        MultiTypeSupport multiTypeSupport = new MultiTypeSupport() {
            @Override
            public int getLayoutId(Object item, int position) {
                if (mList.get(position).getData() != null) {
                    if (mList.get(position).getData().getDataType().equals(Constants.DataType.TextCard)) {
                        if (mList.get(position).getData().getType().contains(Constants.DataType.footer)) {
                            return R.layout.item_text_card_with_tagid;
                        } else {
                            return R.layout.item_text_card;
                        }
                    } else {
                        return R.layout.item_video_bean_for_client;
                    }
                } else {
                    return R.layout.item_video_bean_for_client;
                }
            }
        };
        if (adapter == null) {
            adapter = new CommonRecyclerAdapter<AllRec.ItemListBeanX>(this, mList, multiTypeSupport) {
                @Override
                public void convert(ViewHolder holder, AllRec.ItemListBeanX item, int position) {
                    if (item.getData() != null) {
                        if (item.getData().getDataType().equals(Constants.DataType.VideoBeanForClient)) {
                            if (item.getData().getCover() != null) {
                                holder.setImageByGlide(R.id.detail, item.getData().getCover().getDetail());
                            }
                            holder.setText(R.id.title, item.getData().getTitle());
                            holder.setText(R.id.slogan, "#" + item.getData().getCategory());
                            holder.setText(R.id.duration, TimeUtils.formatVideoTime((long) item.getData().getDuration()));

                            holder.setOnIntemClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (item.getData() != null && item.getData().getContent() != null && item.getData().getContent().getData() != null && !StringUtils.isEmpty(item.getData().getContent().getData().getPlayUrl())) {
                                        url = item.getData().getContent().getData().getPlayUrl();
                                        title = item.getData().getContent().getData().getTitle();
                                        initPlay();
                                        if (item.getData().getCover() != null) {
                                            ImageUtils.newInstance().load(item.getData().getCover().getDetail(), imageView);
                                        } else {
                                            loadCover(imageView, item.getData().getContent().getData().getPlayUrl(), VideoPlayActivity.this);
                                        }
                                        //开始播放
                                        binding.videoPlayer.startPlayLogic();
                                        id = item.getData().getContent().getData().getId();
                                        requestRelated();
                                    } else if (item.getData() != null && !StringUtils.isEmpty(item.getData().getPlayUrl())) {
                                        url = item.getData().getPlayUrl();
                                        title = item.getData().getTitle();
                                        initPlay();
                                        if (item.getData().getCover() != null) {
                                            ImageUtils.newInstance().load(item.getData().getCover().getDetail(), imageView);
                                        } else {
                                            loadCover(imageView, item.getData().getPlayUrl(), VideoPlayActivity.this);
                                        }
                                        //开始播放
                                        binding.videoPlayer.startPlayLogic();
                                        id = item.getData().getId();
                                        requestRelated();
                                    }
                                }
                            });
                        } else {
                            if (item.getData() != null) {
                                holder.setText(R.id.text, item.getData().getText());
                            }
                        }
                    }
                }
            };
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    /**
     * 初始化播放器
     */
    private void initVideoPlayView() {
        //增加封面
        imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //设置加载时封面
        loadCover(imageView, url, this);

        //外部辅助的旋转，帮助全屏
        orientationUtils = new OrientationUtils(this, binding.videoPlayer);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);
        gsyVideoOption = new GSYVideoOptionBuilder();
        initPlay();
        binding.videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                binding.videoPlayer.startWindowFullscreen(VideoPlayActivity.this, true, true);
            }
        });
        binding.videoPlayer.getShareButton().setOnClickListener(this);
        binding.videoPlayer.getBackButton().setOnClickListener(this);
        binding.videoPlayer.startPlayLogic();
    }

    /**
     * 初始化播放数据
     */
    private void initPlay() {
        gsyVideoOption.setThumbImageView(imageView)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setUrl(url)
                .setCacheWithPlay(false)
                .setVideoTitle(title)
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        //开始播放了才能旋转和全屏
                        orientationUtils.setEnable(true);
                        isPlay = true;

                        //设置 seek 的临近帧。
                        if (binding.videoPlayer.getGSYVideoManager().getPlayer() instanceof Exo2PlayerManager) {
                            ((Exo2PlayerManager) binding.videoPlayer.getGSYVideoManager().getPlayer()).setSeekParameter(SeekParameters.NEXT_SYNC);
                        }
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                    }

                    @Override
                    public void onAutoComplete(String url, Object... objects) {
                        super.onAutoComplete(url, objects);
                    }

                    @Override
                    public void onClickStartError(String url, Object... objects) {
                        super.onClickStartError(url, objects);
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        if (orientationUtils != null) {
                            orientationUtils.backToProtVideo();
                        }
                    }
                })
                .setLockClickListener(new LockClickListener() {
                    @Override
                    public void onClick(View view, boolean lock) {
                        if (orientationUtils != null) {
                            //配合下方的onConfigurationChanged
                            orientationUtils.setEnable(!lock);
                        }
                    }
                })
                .setGSYVideoProgressListener(new GSYVideoProgressListener() {
                    @Override
                    public void onProgress(int progress, int secProgress, int currentPosition, int duration) {
                    }
                })
                .build(binding.videoPlayer);
    }

    @Override
    public void onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }

        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        getCurPlay().onVideoResume(false);
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onPause() {
        getCurPlay().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onDestroy() {
        if (isPlay) {
            getCurPlay().release();
        }
        //GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            binding.videoPlayer.onConfigurationChanged(this, newConfig, orientationUtils, true, true);
        }
    }

    private GSYVideoPlayer getCurPlay() {
        if (binding.videoPlayer.getFullWindowPlayer() != null) {
            return binding.videoPlayer.getFullWindowPlayer();
        }
        return binding.videoPlayer;
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.share) {
            ToastUtils.showShort("敬请期待~");
        } else if (viewId == R.id.back) {
            onBackPressed();
        }
    }
}
