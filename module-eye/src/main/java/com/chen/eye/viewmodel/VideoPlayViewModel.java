package com.chen.eye.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chen.base.base.BaseViewModel;
import com.chen.base.bean.video.AllRec;
import com.chen.base.network.HttpClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenbin
 * 2019-9-19
 **/
public class VideoPlayViewModel extends BaseViewModel {
    public VideoPlayViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<AllRec> requestRelated(String id) {
        MutableLiveData<AllRec> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getEyeService().getRelated(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AllRec>() {
                    @Override
                    public void accept(AllRec allRec) throws Exception {
                        if (allRec != null && allRec.getItemList().size() > 0) {
                            data.setValue(allRec);
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
