package com.chen.music.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chen.base.base.BaseViewModel;
import com.chen.base.bean.music.BannerInfo;
import com.chen.base.bean.music.HighQuality;
import com.chen.base.bean.music.PlayListInfo;
import com.chen.base.network.HttpClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenbin
 * 2019-9-25
 **/
public class MusicViewModel extends BaseViewModel {
    public MusicViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * banner
     *
     * @return
     */
    public MutableLiveData<BannerInfo> requestBanner() {
        MutableLiveData<BannerInfo> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getMusicService().requestBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerInfo>() {
                    @Override
                    public void accept(BannerInfo bannerInfo) throws Exception {
                        if (bannerInfo != null && bannerInfo.getBanners().size() > 0) {
                            data.setValue(bannerInfo);
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        addDisposable(disposable);
        return data;
    }

    /**
     * 精品推荐歌单
     *
     * @return
     */
    public MutableLiveData<HighQuality> requestHighQuality() {
        MutableLiveData<HighQuality> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getMusicService().requestHighQuality()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HighQuality>() {
                    @Override
                    public void accept(HighQuality highQuality) throws Exception {
                        if (highQuality != null && highQuality.getPlaylists().size() > 0) {
                            data.setValue(highQuality);
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        addDisposable(disposable);
        return data;
    }

    /**
     * 推荐歌单
     *
     * @return
     */
    public MutableLiveData<HighQuality> requestPlayList() {
        MutableLiveData<HighQuality> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getMusicService().requestPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HighQuality>() {
                    @Override
                    public void accept(HighQuality highQuality) throws Exception {
                        if (highQuality != null && highQuality.getPlaylists().size() > 0) {
                            data.setValue(highQuality);
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        addDisposable(disposable);
        return data;
    }

    /**
     * 个人推荐歌单
     *
     * @return
     */
    public MutableLiveData<PlayListInfo> requestPersonalized() {
        MutableLiveData<PlayListInfo> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getMusicService().requestPersonalized()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PlayListInfo>() {
                    @Override
                    public void accept(PlayListInfo playListInfo) throws Exception {
                        if (playListInfo != null && playListInfo.getResult().size() > 0) {
                            data.setValue(playListInfo);
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        addDisposable(disposable);
        return data;
    }
}
