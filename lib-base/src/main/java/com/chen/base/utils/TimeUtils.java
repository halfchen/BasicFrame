package com.chen.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenbin
 * 2019-5-21
 **/
public class TimeUtils {

    public static String formatMusicTime(Long duration) {
        String time = "";
        long minute = duration / 60000;
        long seconds = duration % 60000;
        long second = Math.round((seconds / 1000));
        if (minute < 10) {
            time += "0";
        }
        time = time + minute + ":";
        if (second < 10) {
            time += "0";
        }
        time += second;
        return time;
    }

    public static String formatVideoTime(Long duration) {
        String time = "";
        long minute = duration / 60;
        long second = duration % 60;
        if (minute < 10) {
            time += "0";
        }
        time = time + minute + ":";
        if (second < 10) {
            time += "0";
        }
        time += second;
        return time;
    }

    /**
     * 日期格式字符串转换时间戳(毫秒)
     *
     * @param beginDate
     * @param format
     * @return
     */
    public static String date2TimeStamp(Date beginDate, int distanceDay, String format) {
        String date = getOldDateByDay(beginDate, distanceDay);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date).getTime()); // 毫秒
//            return String.valueOf(sdf.parse(date).getTime() / 1000); // 秒
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取某个日期前后N天的日期
     * 返回时间格式 yyyy-MM-dd HH:mm:ss
     *
     * @param beginDate
     * @param distanceDay 前后几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDateByDay(Date beginDate, int distanceDay) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat dft = new SimpleDateFormat(format);
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dft.format(endDate) + " 09:00:00";
    }

    /**
     * 获取某个日期前后N天的日期
     * 返回时间格式 yyyy-MM-dd
     *
     * @param beginDate
     * @param distanceDay 前后几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDateByDay2(Date beginDate, int distanceDay) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat dft = new SimpleDateFormat(format);
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dft.format(endDate);
    }

    /**
     * 获取历史上的今天的日期
     *
     * @param data
     * @return
     */
    public static String getMobHistoryDate(Date data) {
        SimpleDateFormat dft = new SimpleDateFormat("MMdd");
        return dft.format(data);
    }

    /**
     * 获取小时
     *
     * @param data
     * @return
     */
    public static String getHour(Date data) {
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm");
        return dft.format(data);
    }

    public static boolean timeCompare(String time, String end) {
        SimpleDateFormat CurrentTime = new SimpleDateFormat("HH:mm");
        try {
            Date beginTime = CurrentTime.parse(end);
            Date compareTime = CurrentTime.parse(time);
            //判断是否大于18:00
            if ((compareTime.getTime() - beginTime.getTime()) > 0) {
                return true;//大于
            } else {
                return false;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
