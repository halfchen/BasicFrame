package com.chen.base.network;


import com.chen.base.Constants;
import com.chen.base.bean.gank.GankBean;
import com.chen.base.bean.music.BannerInfo;
import com.chen.base.bean.music.HighQuality;
import com.chen.base.bean.music.PlayListDetail;
import com.chen.base.bean.music.PlayListInfo;
import com.chen.base.bean.tools.ArticleData;
import com.chen.base.bean.tools.CalendarData;
import com.chen.base.bean.tools.CategoryData;
import com.chen.base.bean.tools.CityData;
import com.chen.base.bean.tools.DictionaryData;
import com.chen.base.bean.tools.HistoryData;
import com.chen.base.bean.tools.MobileData;
import com.chen.base.bean.tools.WeatherData;
import com.chen.base.bean.video.AllRec;
import com.chen.base.bean.video.CategoriesBean;
import com.chen.base.bean.video.FindBean;
import com.example.http.utils.BuildFactory;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by chenbin
 * 2019-5-16
 **/
public interface HttpClient {

    class Builder {
        /**
         * 开眼视频
         *
         * @return
         */
        public static HttpClient getEyeService() {
            return BuildFactory.getInstance().create(HttpClient.class, Constants.VideoUrl.base_url);
        }

        /**
         * 网易云音乐
         *
         * @return
         */
        public static HttpClient getMusicService() {
            return BuildFactory.getInstance().create(HttpClient.class, Constants.MusicUrl.BASE_URL);
        }

        /**
         * Gank
         * @return
         */
        public static HttpClient getGankService(){
            return BuildFactory.getInstance().create(HttpClient.class, Constants.GankUrl.base);
        }

        /**
         * Mob
         */
        public static HttpClient getMobService() {
            return BuildFactory.getInstance().create(HttpClient.class, Constants.Mob.MOB_BASE);
        }
    }

    /************************************* 网易云音乐api *****************************************/
    /**
     * 精品推荐
     *
     * @return
     */
    @GET(Constants.MusicUrl.HIGHQUALITY)
    Observable<HighQuality> requestHighQuality();

    /**
     * 推荐
     *
     * @return
     */
    @GET(Constants.MusicUrl.PLAYLIST)
    Observable<HighQuality> requestPlayList();

    /**
     * banner
     *
     * @return
     */
    @GET(Constants.MusicUrl.BANNER)
    Observable<BannerInfo> requestBanner();

    /**
     * 歌单详情
     *
     * @param id
     * @return
     */
    @GET(Constants.MusicUrl.PLAYLISTDETAIL)
    Observable<PlayListDetail> requestPlayListDetail(@Query("id") String id);

    /**
     * 个人推荐歌单
     *
     * @return
     */
    @GET(Constants.MusicUrl.PERSONALIZED)
    Observable<PlayListInfo> requestPersonalized();


    /************************************* 开眼api *****************************************/
    /**
     * 推荐
     *
     * @param page
     * @return
     */
    @GET(Constants.VideoUrl.allrec)
    Observable<AllRec> getAllRec(@Query("page") int page);

    /**
     * 发现
     *
     * @return
     */
    @GET(Constants.VideoUrl.discovery)
    Observable<FindBean> getFind();

    /**
     * 日报
     *
     * @return
     */
    @GET(Constants.VideoUrl.feed)
    Observable<AllRec> getDaily(@Query("date") String date,
                                @Query("num") int num);

    /**
     * 周排行
     *
     * @return
     */
    @GET(Constants.VideoUrl.weekly)
    Observable<AllRec> getWeekly(@Query("start") int start,
                                 @Query("num") int num);

    /**
     * 月排行
     *
     * @return
     */
    @GET(Constants.VideoUrl.monthly)
    Observable<AllRec> getMonthly(@Query("start") int start,
                                  @Query("num") int num);

    /**
     * 总排行
     *
     * @return
     */
    @GET(Constants.VideoUrl.historical)
    Observable<AllRec> getHistorical(@Query("start") int start,
                                     @Query("num") int num);

    /**
     * 全部分类
     *
     * @return
     */
    @GET(Constants.VideoUrl.categories)
    Observable<CategoriesBean> getCategories();

    /**
     * 相关推荐
     *
     * @param id
     * @return
     */
    @GET(Constants.VideoUrl.related)
    Observable<AllRec> getRelated(@Query("id") String id);

    /**
     * 搜索
     *
     * @return
     */
    @GET(Constants.VideoUrl.search)
    Observable<AllRec> getSearch(@Query("start") int start,
                                 @Query("num") int num,
                                 @Query("query") String query);


    /************************************* Gank api *****************************************/
    /**
     * Gank
     *
     * @return
     */
    @GET("data/{type}/{count}/{pageIndex}")
    Observable<GankBean> getGankData(@Path("type") String type,
                                     @Path("count") int count,
                                     @Path("pageIndex") int pageIndex);

    /**
     * Gank搜索
     *
     * @param input
     * @param type
     * @param pageIndex
     * @return
     */
    @GET("search/query/{input}/category/{type}/count/10/page/{pageIndex}")
    Observable<GankBean> gankSearch(@Path("input") String input,
                                    @Path("type") String type,
                                    @Path("pageIndex") int pageIndex);


    /************************************* Mob api *****************************************/
    /**
     * 城市列表查询接口
     *
     * @param key
     * @return
     */
    @GET(Constants.Mob.citys)
    Observable<CityData> getCitys(@Query("key") String key);

    /**
     * 获取天气信息
     *
     * @param key
     * @param city
     * @param province
     * @return
     */
    @GET(Constants.Mob.weather)
    Observable<WeatherData> getWeather(@Query("key") String key,
                                       @Query("district") String district,
                                       @Query("city") String city,
                                       @Query("province") String province);

    /**
     * 万年历查询
     *
     * @param key
     * @param date 2015-05-01
     * @return
     */
    @GET(Constants.Mob.calendar)
    Observable<CalendarData> getCalendar(@Query("key") String key,
                                         @Query("date") String date);

    /**
     * 历史上今天
     *
     * @param key
     * @param day 0716
     * @return
     */
    @GET(Constants.Mob.history)
    Observable<HistoryData> getHistory(@Query("key") String key,
                                       @Query("day") String day);

    /**
     * 手机号码归属地查询
     *
     * @param key
     * @param phone
     * @return
     */
    @GET(Constants.Mob.mobile)
    Observable<MobileData> getMobile(@Query("key") String key,
                                     @Query("phone") String phone);

    /**
     * 新华字典查询
     *
     * @param key
     * @param name
     * @return
     */
    @GET(Constants.Mob.dictionary)
    Observable<DictionaryData> getDictionary(@Query("key") String key,
                                             @Query("name") String name);

    /**
     * 微信精选分类查询
     *
     * @param key
     * @return
     */
    @GET(Constants.Mob.category)
    Observable<CategoryData> getCategory(@Query("key") String key);

    /**
     * 微信精选列表查询
     *
     * @param key
     * @param cid
     * @param page
     * @param size
     * @return
     */
    @GET(Constants.Mob.article)
    Observable<ArticleData> getArticle(@Query("key") String key,
                                       @Query("cid") String cid,
                                       @Query("page") int page,
                                       @Query("size") int size);
}
