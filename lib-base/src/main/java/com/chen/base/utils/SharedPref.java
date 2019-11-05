package com.chen.base.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.chen.base.bean.music.PlayListDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SharedPref implements ICache {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    static final String SP_NAME = XDroidConf.CACHE_SP_NAME;

    private static SharedPref instance;

    private SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPref getInstance(Context context) {
        if (instance == null) {
            synchronized (SharedPref.class) {
                if (instance == null) {
                    instance = new SharedPref(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    @Override
    public void remove(String key) {
        editor.remove(key);
        editor.apply();
    }


    @Override
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    @Override
    public void clear() {
        editor.clear().apply();
    }


    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putLong(String key, Long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }


    public void putBoolean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putLists(String key, List<PlayListDetail.ResultBean.TracksBean> list) {
        Gson gson = new Gson();
        editor.putString(key, gson.toJson(list));
        editor.apply();
    }

    public List<PlayListDetail.ResultBean.TracksBean> getLists(String key) {
        String value = sharedPreferences.getString(key, "");
        Gson gson = new Gson();
        List<PlayListDetail.ResultBean.TracksBean> list = gson.fromJson(value, new TypeToken<List<PlayListDetail.ResultBean.TracksBean>>() {
        }.getType());
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void put(String key, Object value) {

    }
}
