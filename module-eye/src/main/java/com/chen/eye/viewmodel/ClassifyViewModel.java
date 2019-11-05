package com.chen.eye.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chen.base.base.BaseViewModel;
import com.chen.base.bean.video.CategoriesBean;
import com.chen.base.network.HttpClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenbin
 * 2019-9-19
 **/
public class ClassifyViewModel extends BaseViewModel {
    public ClassifyViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<CategoriesBean> requestCategories() {
        final MutableLiveData<CategoriesBean> data = new MutableLiveData<>();
        Disposable disposable = HttpClient.Builder.getEyeService().getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CategoriesBean>() {
                    @Override
                    public void accept(CategoriesBean categoriesBean) throws Exception {
                        if (categoriesBean != null && categoriesBean.getItemList().size() > 0) {
                            data.setValue(categoriesBean);
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
