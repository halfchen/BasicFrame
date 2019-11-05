package com.chen.base.bean.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取天气信息
 * Created by chenbin
 * 2019-7-17
 **/
public class WeatherData {

    /**
     * msg : success
     * result : [{"airCondition":"优","airQuality":{"aqi":20,"city":"厦门","district":"厦门","fetureData":[],"hourData":[{"aqi":20,"dateTime":"2019-07-17 15:00:00"},{"aqi":23,"dateTime":"2019-07-17 14:00:00"},{"aqi":26,"dateTime":"2019-07-17 13:00:00"},{"aqi":27,"dateTime":"2019-07-17 12:00:00"},{"aqi":28,"dateTime":"2019-07-17 11:00:00"},{"aqi":27,"dateTime":"2019-07-17 10:00:00"},{"aqi":28,"dateTime":"2019-07-17 09:00:00"},{"aqi":27,"dateTime":"2019-07-17 08:00:00"},{"aqi":33,"dateTime":"2019-07-17 07:00:00"},{"aqi":39,"dateTime":"2019-07-17 06:00:00"},{"aqi":36,"dateTime":"2019-07-17 05:00:00"},{"aqi":36,"dateTime":"2019-07-17 04:00:00"},{"aqi":35,"dateTime":"2019-07-17 03:00:00"},{"aqi":36,"dateTime":"2019-07-17 02:00:00"},{"aqi":35,"dateTime":"2019-07-17 01:00:00"},{"aqi":35,"dateTime":"2019-07-17 00:00:00"},{"aqi":30,"dateTime":"2019-07-16 23:00:00"},{"aqi":31,"dateTime":"2019-07-16 22:00:00"},{"aqi":32,"dateTime":"2019-07-16 21:00:00"},{"aqi":33,"dateTime":"2019-07-16 20:00:00"},{"aqi":35,"dateTime":"2019-07-16 19:00:00"},{"aqi":35,"dateTime":"2019-07-16 18:00:00"},{"aqi":32,"dateTime":"2019-07-16 17:00:00"},{"aqi":38,"dateTime":"2019-07-16 16:00:00"}],"no2":8,"pm10":20,"pm25":9,"province":"福建","quality":"优","so2":3,"updateTime":"2019-07-17 15:00:00"},"city":"厦门","coldIndex":"","date":"2019-07-17","distrct":"厦门","dressingIndex":"","exerciseIndex":"","future":[{"date":"2019-06-22","night":"雷雨","temperature":"25°C","week":"星期六","wind":"东南风 3级"}],"humidity":"湿度：48%","pollutionIndex":"20","province":"福建","sunrise":"06:11","sunset":"18:19","temperature":"34℃","time":"15:52","updateTime":"20190717161304","washIndex":"","weather":"多云","week":"周三","wind":"东北风3级"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode == null ? "" : retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
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
         * airCondition : 优
         * airQuality : {"aqi":20,"city":"厦门","district":"厦门","fetureData":[],"hourData":[{"aqi":20,"dateTime":"2019-07-17 15:00:00"},{"aqi":23,"dateTime":"2019-07-17 14:00:00"},{"aqi":26,"dateTime":"2019-07-17 13:00:00"},{"aqi":27,"dateTime":"2019-07-17 12:00:00"},{"aqi":28,"dateTime":"2019-07-17 11:00:00"},{"aqi":27,"dateTime":"2019-07-17 10:00:00"},{"aqi":28,"dateTime":"2019-07-17 09:00:00"},{"aqi":27,"dateTime":"2019-07-17 08:00:00"},{"aqi":33,"dateTime":"2019-07-17 07:00:00"},{"aqi":39,"dateTime":"2019-07-17 06:00:00"},{"aqi":36,"dateTime":"2019-07-17 05:00:00"},{"aqi":36,"dateTime":"2019-07-17 04:00:00"},{"aqi":35,"dateTime":"2019-07-17 03:00:00"},{"aqi":36,"dateTime":"2019-07-17 02:00:00"},{"aqi":35,"dateTime":"2019-07-17 01:00:00"},{"aqi":35,"dateTime":"2019-07-17 00:00:00"},{"aqi":30,"dateTime":"2019-07-16 23:00:00"},{"aqi":31,"dateTime":"2019-07-16 22:00:00"},{"aqi":32,"dateTime":"2019-07-16 21:00:00"},{"aqi":33,"dateTime":"2019-07-16 20:00:00"},{"aqi":35,"dateTime":"2019-07-16 19:00:00"},{"aqi":35,"dateTime":"2019-07-16 18:00:00"},{"aqi":32,"dateTime":"2019-07-16 17:00:00"},{"aqi":38,"dateTime":"2019-07-16 16:00:00"}],"no2":8,"pm10":20,"pm25":9,"province":"福建","quality":"优","so2":3,"updateTime":"2019-07-17 15:00:00"}
         * city : 厦门
         * coldIndex :
         * date : 2019-07-17
         * distrct : 厦门
         * dressingIndex :
         * exerciseIndex :
         * future : [{"date":"2019-06-22","night":"雷雨","temperature":"25°C","week":"星期六","wind":"东南风 3级"}]
         * humidity : 湿度：48%
         * pollutionIndex : 20
         * province : 福建
         * sunrise : 06:11
         * sunset : 18:19
         * temperature : 34℃
         * time : 15:52
         * updateTime : 20190717161304
         * washIndex :
         * weather : 多云
         * week : 周三
         * wind : 东北风3级
         */

        private String airCondition;
        private AirQualityBean airQuality;
        private String city;
        private String coldIndex;
        private String date;
        private String distrct;
        private String dressingIndex;
        private String exerciseIndex;
        private String humidity;
        private String pollutionIndex;
        private String province;
        private String sunrise;
        private String sunset;
        private String temperature;
        private String time;
        private String updateTime;
        private String washIndex;
        private String weather;
        private String week;
        private String wind;
        private List<FutureBean> future;

        public String getAirCondition() {
            return airCondition == null ? "" : airCondition;
        }

        public void setAirCondition(String airCondition) {
            this.airCondition = airCondition;
        }

        public AirQualityBean getAirQuality() {
            return airQuality;
        }

        public void setAirQuality(AirQualityBean airQuality) {
            this.airQuality = airQuality;
        }

        public String getCity() {
            return city == null ? "" : city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getColdIndex() {
            return coldIndex == null ? "" : coldIndex;
        }

        public void setColdIndex(String coldIndex) {
            this.coldIndex = coldIndex;
        }

        public String getDate() {
            return date == null ? "" : date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDistrct() {
            return distrct == null ? "" : distrct;
        }

        public void setDistrct(String distrct) {
            this.distrct = distrct;
        }

        public String getDressingIndex() {
            return dressingIndex == null ? "" : dressingIndex;
        }

        public void setDressingIndex(String dressingIndex) {
            this.dressingIndex = dressingIndex;
        }

        public String getExerciseIndex() {
            return exerciseIndex == null ? "" : exerciseIndex;
        }

        public void setExerciseIndex(String exerciseIndex) {
            this.exerciseIndex = exerciseIndex;
        }

        public String getHumidity() {
            return humidity == null ? "" : humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPollutionIndex() {
            return pollutionIndex == null ? "" : pollutionIndex;
        }

        public void setPollutionIndex(String pollutionIndex) {
            this.pollutionIndex = pollutionIndex;
        }

        public String getProvince() {
            return province == null ? "" : province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSunrise() {
            return sunrise == null ? "" : sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset == null ? "" : sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getTemperature() {
            return temperature == null ? "" : temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTime() {
            return time == null ? "" : time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUpdateTime() {
            return updateTime == null ? "" : updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWashIndex() {
            return washIndex == null ? "" : washIndex;
        }

        public void setWashIndex(String washIndex) {
            this.washIndex = washIndex;
        }

        public String getWeather() {
            return weather == null ? "" : weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week == null ? "" : week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWind() {
            return wind == null ? "" : wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public List<FutureBean> getFuture() {
            if (future == null) {
                return new ArrayList<>();
            }
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class AirQualityBean {
            /**
             * aqi : 20
             * city : 厦门
             * district : 厦门
             * fetureData : []
             * hourData : [{"aqi":20,"dateTime":"2019-07-17 15:00:00"},{"aqi":23,"dateTime":"2019-07-17 14:00:00"},{"aqi":26,"dateTime":"2019-07-17 13:00:00"},{"aqi":27,"dateTime":"2019-07-17 12:00:00"},{"aqi":28,"dateTime":"2019-07-17 11:00:00"},{"aqi":27,"dateTime":"2019-07-17 10:00:00"},{"aqi":28,"dateTime":"2019-07-17 09:00:00"},{"aqi":27,"dateTime":"2019-07-17 08:00:00"},{"aqi":33,"dateTime":"2019-07-17 07:00:00"},{"aqi":39,"dateTime":"2019-07-17 06:00:00"},{"aqi":36,"dateTime":"2019-07-17 05:00:00"},{"aqi":36,"dateTime":"2019-07-17 04:00:00"},{"aqi":35,"dateTime":"2019-07-17 03:00:00"},{"aqi":36,"dateTime":"2019-07-17 02:00:00"},{"aqi":35,"dateTime":"2019-07-17 01:00:00"},{"aqi":35,"dateTime":"2019-07-17 00:00:00"},{"aqi":30,"dateTime":"2019-07-16 23:00:00"},{"aqi":31,"dateTime":"2019-07-16 22:00:00"},{"aqi":32,"dateTime":"2019-07-16 21:00:00"},{"aqi":33,"dateTime":"2019-07-16 20:00:00"},{"aqi":35,"dateTime":"2019-07-16 19:00:00"},{"aqi":35,"dateTime":"2019-07-16 18:00:00"},{"aqi":32,"dateTime":"2019-07-16 17:00:00"},{"aqi":38,"dateTime":"2019-07-16 16:00:00"}]
             * no2 : 8
             * pm10 : 20
             * pm25 : 9
             * province : 福建
             * quality : 优
             * so2 : 3
             * updateTime : 2019-07-17 15:00:00
             */

            private int aqi;
            private String city;
            private String district;
            private int no2;
            private int pm10;
            private int pm25;
            private String province;
            private String quality;
            private int so2;
            private String updateTime;
            private List<HourDataBean> fetureData;
            private List<HourDataBean> hourData;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getCity() {
                return city == null ? "" : city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district == null ? "" : district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public int getNo2() {
                return no2;
            }

            public void setNo2(int no2) {
                this.no2 = no2;
            }

            public int getPm10() {
                return pm10;
            }

            public void setPm10(int pm10) {
                this.pm10 = pm10;
            }

            public int getPm25() {
                return pm25;
            }

            public void setPm25(int pm25) {
                this.pm25 = pm25;
            }

            public String getProvince() {
                return province == null ? "" : province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getQuality() {
                return quality == null ? "" : quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public int getSo2() {
                return so2;
            }

            public void setSo2(int so2) {
                this.so2 = so2;
            }

            public String getUpdateTime() {
                return updateTime == null ? "" : updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public List<HourDataBean> getFetureData() {
                if (fetureData == null) {
                    return new ArrayList<>();
                }
                return fetureData;
            }

            public void setFetureData(List<HourDataBean> fetureData) {
                this.fetureData = fetureData;
            }

            public List<HourDataBean> getHourData() {
                if (hourData == null) {
                    return new ArrayList<>();
                }
                return hourData;
            }

            public void setHourData(List<HourDataBean> hourData) {
                this.hourData = hourData;
            }

            public static class HourDataBean {
                /**
                 * aqi : 20
                 * dateTime : 2019-07-17 15:00:00
                 */

                private int aqi;
                private String dateTime;

                public int getAqi() {
                    return aqi;
                }

                public void setAqi(int aqi) {
                    this.aqi = aqi;
                }

                public String getDateTime() {
                    return dateTime == null ? "" : dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }
            }
        }

        public static class FutureBean {
            /**
             * date : 2019-06-22
             * night : 雷雨
             * temperature : 25°C
             * week : 星期六
             * wind : 东南风 3级
             */

            private String date;
            private String night;
            private String temperature;
            private String week;
            private String wind;

            public String getDate() {
                return date == null ? "" : date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getNight() {
                return night == null ? "" : night;
            }

            public void setNight(String night) {
                this.night = night;
            }

            public String getTemperature() {
                return temperature == null ? "" : temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeek() {
                return week == null ? "" : week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getWind() {
                return wind == null ? "" : wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }
        }
    }
}
