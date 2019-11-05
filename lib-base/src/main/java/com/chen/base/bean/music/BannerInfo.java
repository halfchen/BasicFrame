package com.chen.base.bean.music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-5-16
 **/
public class BannerInfo {

    /**
     * banners : [{"imageUrl":"http://p1.music.126.net/E97_bn-wRI3pxo8LP9bDfA==/109951164074519181.jpg","targetId":1365233944,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"VIP专享","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1365233944","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.453386.-1009775968.null"},{"imageUrl":"http://p1.music.126.net/syJ0t_Dzexg-WovGAmGrjw==/109951164076566805.jpg","targetId":10867469,"adid":null,"targetType":1004,"titleColor":"red","typeTitle":"独家专访","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"10867469","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.452410.937262642.null"},{"imageUrl":"http://p1.music.126.net/xwcy55S6wIOFKHSU2rsevQ==/109951164076560467.jpg","targetId":1365393542,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1365393542","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.452411.-1009600222.null"},{"imageUrl":"http://p1.music.126.net/g_JmoPxYwcpj1jF46De3gQ==/109951164077314526.jpg","targetId":2790812763,"adid":null,"targetType":1000,"titleColor":"red","typeTitle":"VIP专享","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"2790812763","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.453399.-1009740559.null"},{"imageUrl":"http://p1.music.126.net/x2ahWpIBZbILFtvgnC7HAw==/109951164076562694.jpg","targetId":79084500,"adid":null,"targetType":10,"titleColor":"red","typeTitle":"VIP专享","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"79084500","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.447379.-1009687677.null"},{"imageUrl":"http://p1.music.126.net/Fn3jELgeH1fLR2xS7uLUCg==/109951164074803639.jpg","targetId":1365209412,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1365209412","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.448408.-1009625149.null"},{"imageUrl":"http://p1.music.126.net/e7IO2R65hM1UFTPtr2-SrA==/109951164076545390.jpg","targetId":1365468238,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1365468238","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.447380.-1009563554.null"},{"imageUrl":"http://p1.music.126.net/RjAd14tFI6ehOhZdqXyI6Q==/109951164076541911.jpg","targetId":1365136571,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1365136571","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.447381.-1009711578.null"},{"imageUrl":"http://p1.music.126.net/F7f4tPRJjHzMHMb6zhFRjA==/109951164076535495.jpg","targetId":0,"adid":null,"targetType":3000,"titleColor":"blue","typeTitle":"活动","url":"https://music.163.com/#/topic?id=43343277&backend=true","exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"0","program":null,"event":null,"video":null,"song":null,"scm":"1.music-homepage.homepage_banner_force.banner.450406.-1009534720.null"}]
     * code : 200
     */

    private int code;
    private List<BannersBean> banners;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<BannersBean> getBanners() {
        if (banners == null) {
            return new ArrayList<>();
        }
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public static class BannersBean {
        /**
         * imageUrl : http://p1.music.126.net/E97_bn-wRI3pxo8LP9bDfA==/109951164074519181.jpg
         * targetId : 1365233944
         * adid : null
         * targetType : 1
         * titleColor : red
         * typeTitle : VIP专享
         * url : null
         * exclusive : false
         * monitorImpress : null
         * monitorClick : null
         * monitorType : null
         * monitorImpressList : null
         * monitorClickList : null
         * monitorBlackList : null
         * extMonitor : null
         * extMonitorInfo : null
         * adSource : null
         * adLocation : null
         * encodeId : 1365233944
         * program : null
         * event : null
         * video : null
         * song : null
         * scm : 1.music-homepage.homepage_banner_force.banner.453386.-1009775968.null
         */

        private String imageUrl;
        private String targetId;
        private int targetType; //1音乐  1004视频  10专辑   3000活动

        public String getImageUrl() {
            return imageUrl == null ? "" : imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTargetId() {
            return targetId == null ? "" : targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }

        public int getTargetType() {
            return targetType;
        }

        public void setTargetType(int targetType) {
            this.targetType = targetType;
        }
    }
}
