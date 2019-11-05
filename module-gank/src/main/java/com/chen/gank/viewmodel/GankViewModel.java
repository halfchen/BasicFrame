package com.chen.gank.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chen.base.base.BaseViewModel;
import com.chen.base.bean.gank.GankBean;
import com.chen.base.network.HttpClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenbin
 * 2019-10-8
 **/
public class GankViewModel extends BaseViewModel {
    public GankViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<GankBean> getGankData(String type, int count, int pageIndex) {
        final MutableLiveData data = new MutableLiveData();
        Disposable disposable = HttpClient.Builder.getGankService().getGankData(type, count, pageIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GankBean>() {
                    @Override
                    public void accept(GankBean gankBean) throws Exception {
                        if (gankBean != null && gankBean.getResults().size() > 0) {
                            data.setValue(gankBean);
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
