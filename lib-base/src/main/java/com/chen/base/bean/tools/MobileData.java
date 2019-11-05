package com.chen.base.bean.tools;

/**
 * 手机号码归属地查询
 * Created by chenbin
 * 2019-7-17
 **/
public class MobileData {

    /**
     * msg : success
     * result : {"city":"厦门市","cityCode":"0592","mobileNumber":"1595936","operator":"移动神州行卡","province":"福建","zipCode":"361000"}
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
         * city : 厦门市
         * cityCode : 0592
         * mobileNumber : 1595936
         * operator : 移动神州行卡
         * province : 福建
         * zipCode : 361000
         */

        private String city;
        private String cityCode;
        private String mobileNumber;
        private String operator;
        private String province;
        private String zipCode;

        public String getCity() {
            return city == null ? "" : city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityCode() {
            return cityCode == null ? "" : cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getMobileNumber() {
            return mobileNumber == null ? "" : mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getOperator() {
            return operator == null ? "" : operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getProvince() {
            return province == null ? "" : province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getZipCode() {
            return zipCode == null ? "" : zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
