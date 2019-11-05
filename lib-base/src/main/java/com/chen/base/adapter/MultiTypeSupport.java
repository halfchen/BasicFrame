package com.chen.base.adapter;

/**
 * Created by chenbin on 2018/7/11.
 */

public interface MultiTypeSupport<T> {
    // 根据当前位置或者条目数据返回布局
    public int getLayoutId(T item, int position);
}
