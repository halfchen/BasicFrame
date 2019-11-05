package com.chen.eye.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chen.base.base.BaseViewModel;
import com.chen.base.bean.video.FindBean;
import com.chen.base.network.HttpClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenbin
 * 2019-9-19
 **/
public class FindViewModel extends BaseViewModel {
    public FindViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<FindBean> requestFind() {
        final MutableLiveData<FindBean> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getEyeService().getFind()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FindBean>() {
                    @Override
                    public void accept(FindBean findBean) throws Exception {
                        if (findBean != null && findBean.getItemList().size() > 0) {
                            Log.e("======2", "accept  requestValue");
                            data.setValue(findBean);
                        } else {
                            Log.e("======3", "null  requestValue");
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("======4", throwable.toString());
                        data.setValue(null);
                    }
                });
        addDisposable(disposable);
        return data;
    }
}
