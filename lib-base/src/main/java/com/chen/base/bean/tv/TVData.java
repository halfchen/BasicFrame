package com.chen.base.bean.tv;

/**
 * Created by chenbin
 * 2019-6-12
 **/
public class TVData {

    private String type;
    private String name;
    private String live;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLive() {
        return live == null ? "" : live;
    }

    public void setLive(String live) {
        this.live = live;
    }
}
