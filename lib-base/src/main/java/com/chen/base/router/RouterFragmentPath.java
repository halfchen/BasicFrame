package com.chen.base.router;

/**
 * 用于组件开发中，ARouter多Fragment跳转的统一路径注册
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 * Created by goldze on 2018/6/21
 */

public class RouterFragmentPath {
    /**
     * 首页组件
     */
    public static class Home {
        private static final String HOME = "/home";
        /*首页*/
        public static final String PAGER_HOME = HOME + "/Home";
    }

    /**
     * 开眼视频
     */
    public static class Video {
        private static final String VIDEO = "/video";
        /*首页*/
        public static final String PAGER_VIDEO = VIDEO + "/Video";
        /*推荐*/
        public static final String PAGER_RECOMMEND = VIDEO + "/Recommend";
        /*发现*/
        public static final String PAGER_FIND = VIDEO + "/Find";
        /*日报*/
        public static final String PAGER_DAILY = VIDEO + "/Daily";
        /*周排行*/
        public static final String PAGER_WEEKLY = VIDEO + "/Weekly";
        /*月排行*/
        public static final String PAGER_MONTHLY = VIDEO + "/Monthly";
        /*总排行*/
        public static final String PAGER_HISTORICAL = VIDEO + "/Historical";
    }

    /**
     * 直播
     */
    public static class TV {
        private static final String TV = "/tv";
        /*直播*/
        public static final String PAGER_TV = TV + "/Tv";
    }

    /**
     * 音乐
     */
    public static class Music {
        private static final String MUSIC = "/music";
        /*音乐*/
        public static final String PAGER_MUSIC = MUSIC + "/Music";
    }

    /**
     * gank
     */
    public static class Gank{
        private static final String GANK = "/gank";
        /*gank*/
        public static final String PAGER_GANK = GANK + "/Gank";
    }

    /**
     * 工作组件
     */
    public static class Work {
        private static final String WORK = "/work";
        /*工作*/
        public static final String PAGER_WORK = WORK + "/Work";
    }

    /**
     * 消息组件
     */
    public static class Msg {
        private static final String MSG = "/msg";
        /*消息*/
        public static final String PAGER_MSG = MSG + "/msg/Msg";
    }

    /**
     * 用户组件
     */
    public static class User {
        private static final String USER = "/user";
        /*我的*/
        public static final String PAGER_ME = USER + "/Me";
    }
}
