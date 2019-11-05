package com.chen.base.bean.tools;

/**
 * 万年历查询
 * Created by chenbin
 * 2019-7-17
 **/
public class CalendarData {

    /**
     * msg : success
     * result : {"avoid":"诉讼 诉讼 ","date":"2019-07-17","lunar":"六月十五","lunarYear":"己亥","suit":"入学 开市 入学 嫁娶 上官 赴任 婚礼 造作 动土 旅行 ","weekday":"星期三","zodiac":"猪"}
     * retCode : 200
     */

    private String msg;
    private ResultBean result;
    private String retCode;

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getRetCode() {
        return retCode == null ? "" : retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public static class ResultBean {
        /**
         * avoid : 诉讼 诉讼
         * date : 2019-07-17
         * lunar : 六月十五
         * lunarYear : 己亥
         * suit : 入学 开市 入学 嫁娶 上官 赴任 婚礼 造作 动土 旅行
         * weekday : 星期三
         * zodiac : 猪
         */

        private String avoid;
        private String date;
        private String lunar;
        private String lunarYear;
        private String suit;
        private String weekday;
        private String zodiac;

        public String getAvoid() {
            return avoid == null ? "" : avoid;
        }

        public void setAvoid(String avoid) {
            this.avoid = avoid;
        }

        public String getDate() {
            return date == null ? "" : date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLunar() {
            return lunar == null ? "" : lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }

        public String getLunarYear() {
            return lunarYear == null ? "" : lunarYear;
        }

        public void setLunarYear(String lunarYear) {
            this.lunarYear = lunarYear;
        }

        public String getSuit() {
            return suit == null ? "" : suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public String getWeekday() {
            return weekday == null ? "" : weekday;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        public String getZodiac() {
            return zodiac == null ? "" : zodiac;
        }

        public void setZodiac(String zodiac) {
            this.zodiac = zodiac;
        }
    }
}
