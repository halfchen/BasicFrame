package com.example.http.utils;

import com.example.http.HttpUtils;

/**
 * @author jingbin
 * @data 2018/2/9
 * @Description
 */

public class BuildFactory {

    private static BuildFactory instance;
    private Object videoHttps;
    private Object musicHttps;
    private Object gankHttps;
    private Object mobHttps;

    public static final String MUSIC = "https://music.163.com/api/";
    public static final String VIDEO = "http://baobab.kaiyanapp.com/api/";
    public static final String GANK = "http://gank.io/api/";
    public static final String MOB = "http://apicloud.mob.com/";

    public static BuildFactory getInstance() {
        if (instance == null) {
            synchronized (BuildFactory.class) {
                if (instance == null) {
                    instance = new BuildFactory();
                }
            }
        }
        return instance;
    }

    public <T> T create(Class<T> a, String type) {
        switch (type) {
            case VIDEO:
                if (videoHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (videoHttps == null) {
                            videoHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) videoHttps;
            case MUSIC:
                if (musicHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (musicHttps == null) {
                            musicHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) musicHttps;
            case GANK:
                if (gankHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (gankHttps == null) {
                            gankHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) gankHttps;
            case MOB:
                if (mobHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (mobHttps == null) {
                            mobHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) mobHttps;
            default:
                if (videoHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (videoHttps == null) {
                            videoHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) videoHttps;
        }
    }
}
