package com.chen.base.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.chen.base.R;
import com.chen.base.dialog.dialog.AnyLayer;
import com.chen.base.utils.ClassUtil;

/**
 * Created by chenbin
 * 2019-9-26
 **/
public abstract class BaseActivity<V extends ViewDataBinding, VM extends AndroidViewModel> extends AppCompatActivity {

    protected V binding;
    protected VM viewModel;
    private AnyLayer anyLayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //页面接受的参数方法
        initParam();
        //私有的初始化Databinding和ViewModel方法
        initViewDataBinding(savedInstanceState);
        //初始化ViewModel
        initViewModel();
        initData();
    }

    private void initViewDataBinding(Bundle savedInstanceState) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        binding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.viewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

    public abstract int initContentView(Bundle savedInstanceState);

    public void initParam() {
    }

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binding != null) {
            binding.unbind();
        }
    }

    public void showLoading(){
        anyLayer = AnyLayer.with(this);
        anyLayer.contentView(R.layout.dialog_loading)
                .backgroundColorRes(R.color.dialog_bg)
                .cancelableOnTouchOutside(false)
                .cancelableOnClickKeyBack(true)
                .show();
    }

    public void hindLoading(){
        anyLayer.dismiss();
    }
}
