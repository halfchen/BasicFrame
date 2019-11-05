package com.chen.base.router;

/**
 * 用于组件开发中，ARouter单Activity跳转的统一路径注册
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 * Created by goldze on 2018/6/21
 */

public class RouterActivityPath {
    /**
     * 主业务组件
     */
    public static class Main {
        private static final String MAIN = "/main";
        /*主业务界面*/
        public static final String PAGER_MAIN = MAIN + "/Main";
    }

    /**
     * 开眼视频组件
     */
    public static class EyeVideo {
        private static final String EYEVIDEO = "/eyeVideo";
        /*排行榜*/
        public static final String PAGER_RANK = EYEVIDEO + "/Rank";
        /*搜索*/
        public static final String PAGER_SEARCH = EYEVIDEO + "/Search";
        /*分类*/
        public static final String PAGER_CLASSIFY = EYEVIDEO + "/Classify";
        /*视频播放页*/
        public static final String PAGER_PLAY = EYEVIDEO + "/Play";
    }

    /**
     * 直播
     */
    public static class TV {
        private static final String TV = "/tv";
        /*直播*/
        public static final String PAGER_TV = TV + "/TvActivity";
    }

    /**
     * 音乐
     */
    public static class Music {
        private static final String MUSIC = "/music";
        /*音乐*/
        public static final String PAGER_MUSIC = MUSIC + "/MusicDetail";
    }

    /**
     * gank
     */
    public static class Gank{
        private static final String GANK = "/gank";
        /*gank*/
        public static final String PAGER_WELFARE = GANK + "/welfare";
    }

    /**
     * 身份验证组件
     */
    public static class Sign {
        private static final String SIGN = "/sign";
        /*登录界面*/
        public static final String PAGER_LOGIN = SIGN + "/Login";
    }

    /**
     * 用户组件
     */
    public static class User {
        private static final String USER = "/user";
        /*用户详情*/
        public static final String PAGER_USERDETAIL = USER + "/UserDetail";
    }

    /**
     * 广告组件
     */
    public static class AdWeb {
        private static final String ADWEB = "/AdWeb";
        /*广告详情*/
        public static final String PAGER_ADDETAIL = ADWEB + "/AdDetail";
        /*webview activity*/
        public static final String PAGER_WEB = ADWEB + "/Web";
    }
}
