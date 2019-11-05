package com.chen.music.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chen.base.base.BaseViewModel;
import com.chen.base.bean.music.PlayListDetail;
import com.chen.base.network.HttpClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenbin
 * 2019-9-26
 **/
public class DetailViewModel extends BaseViewModel {
    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<PlayListDetail> requestPlayListDetail(String id) {
        MutableLiveData<PlayListDetail> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getMusicService().requestPlayListDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PlayListDetail>() {
                    @Override
                    public void accept(PlayListDetail playListDetail) throws Exception {
                        if (playListDetail != null && playListDetail.getResult() != null && playListDetail.getResult().getTracks().size() > 0) {
                            data.setValue(playListDetail);
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
