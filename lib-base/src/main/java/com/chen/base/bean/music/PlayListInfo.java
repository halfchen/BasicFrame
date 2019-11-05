package com.chen.base.bean.music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-5-16
 **/
public class PlayListInfo {

    /**
     * hasTaste : false
     * code : 200
     * category : 0
     * result : [{"id":560609382,"type":0,"name":"『加州公路』皮卡夕阳与微风，生活不止苟且","copywriter":"编辑推荐：背起行囊，去寻找你心中的那人那景。","picUrl":"https://p2.music.126.net/kzrUM6_p8N0wDXGW71GX3g==/18965476068109008.jpg","canDislike":false,"playCount":4649801.5,"trackCount":59,"highQuality":true,"alg":"featured"},{"id":2166603997,"type":0,"name":"愿你经历生活苦乐，仍笑看云卷云舒","copywriter":"编辑推荐：等你听懂了这些歌，或许也就读懂了生活。","picUrl":"https://p2.music.126.net/x-vpep4mzaCNvXeDJZTmjg==/109951164070128535.jpg","canDislike":false,"playCount":1297878.6,"trackCount":69,"highQuality":false,"alg":"featured"},{"id":2769468932,"type":0,"name":"总有一天 你会遇到这世上唯一契合灵魂","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/N2OZ0Ztt9TMlZFQ8g3GK2Q==/109951164022932280.jpg","canDislike":true,"playCount":6109965,"trackCount":32,"highQuality":false,"alg":"cityLevel_unknow"},{"id":1997190595,"type":0,"name":"法语爵士|红酒与玫瑰浪漫邂逅","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/_ddoPSdEpCMnmb4cGEzPXw==/109951164051374801.jpg","canDislike":true,"playCount":568577.75,"trackCount":28,"highQuality":false,"alg":"cityLevel_unknow"},{"id":2788431035,"type":0,"name":"总有一个人教会你成长 然后悄无声息的离开","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/0Va8l3RBAZdyeTlvpLQw2A==/109951164058561958.jpg","canDislike":true,"playCount":8232786.5,"trackCount":40,"highQuality":false,"alg":"cityLevel_unknow"},{"id":863744119,"type":0,"name":"100首好听的翻唱","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/p8UsKXA-qjfYuicFEZ_bbw==/109951163822176249.jpg","canDislike":true,"playCount":12717619,"trackCount":123,"highQuality":false,"alg":"cityLevel_unknow"}]
     */

    private boolean hasTaste;
    private int code;
    private int category;
    private List<ResultBean> result;

    public boolean isHasTaste() {
        return hasTaste;
    }

    public void setHasTaste(boolean hasTaste) {
        this.hasTaste = hasTaste;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<ResultBean> getResult() {
        if (result == null) {
            return new ArrayList<>();
        }
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 560609382
         * type : 0
         * name : 『加州公路』皮卡夕阳与微风，生活不止苟且
         * copywriter : 编辑推荐：背起行囊，去寻找你心中的那人那景。
         * picUrl : https://p2.music.126.net/kzrUM6_p8N0wDXGW71GX3g==/18965476068109008.jpg
         * canDislike : false
         * playCount : 4649801.5
         * trackCount : 59
         * highQuality : true
         * alg : featured
         */

        private String id;
        private String type;
        private String name;
        private String copywriter;
        private String picUrl;
        private boolean canDislike;
        private double playCount;
        private int trackCount;
        private boolean highQuality;
        private String alg;

        public String getId() {
            return id == null ? "" : id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type == null ? "" : type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCopywriter() {
            return copywriter == null ? "" : copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getPicUrl() {
            return picUrl == null ? "" : picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public boolean isCanDislike() {
            return canDislike;
        }

        public void setCanDislike(boolean canDislike) {
            this.canDislike = canDislike;
        }

        public double getPlayCount() {
            return playCount;
        }

        public void setPlayCount(double playCount) {
            this.playCount = playCount;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public String getAlg() {
            return alg == null ? "" : alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }
}
