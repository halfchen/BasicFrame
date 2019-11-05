package com.chen.base.bean.tools;

/**
 * 新华字典查询
 * Created by chenbin
 * 2019-7-17
 **/
public class DictionaryData {

    /**
     * msg : success
     * result : {"bihua":7,"bihuaWithBushou":5,"brief":"陈；（陳）；chén；排列，摆设：陈列。陈兵。；述说：陈述。","bushou":"阝","detail":"陈；陳；Chén；【名】；(形声。从阜,从木,申声。本义:地名。古宛丘地,春秋时陈国国都,在今河南","name":"陈","pinyin":"chén","wubi":"baiy"}
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
         * bihua : 7
         * bihuaWithBushou : 5
         * brief : 陈；（陳）；chén；排列，摆设：陈列。陈兵。；述说：陈述。
         * bushou : 阝
         * detail : 陈；陳；Chén；【名】；(形声。从阜,从木,申声。本义:地名。古宛丘地,春秋时陈国国都,在今河南
         * name : 陈
         * pinyin : chén
         * wubi : baiy
         */

        private String bihua;
        private String bihuaWithBushou;
        private String brief;
        private String bushou;
        private String detail;
        private String name;
        private String pinyin;
        private String wubi;

        public String getBihua() {
            return bihua == null ? "" : bihua;
        }

        public void setBihua(String bihua) {
            this.bihua = bihua;
        }

        public String getBihuaWithBushou() {
            return bihuaWithBushou == null ? "" : bihuaWithBushou;
        }

        public void setBihuaWithBushou(String bihuaWithBushou) {
            this.bihuaWithBushou = bihuaWithBushou;
        }

        public String getBrief() {
            return brief == null ? "" : brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getBushou() {
            return bushou == null ? "" : bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getDetail() {
            return detail == null ? "" : detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin() {
            return pinyin == null ? "" : pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getWubi() {
            return wubi == null ? "" : wubi;
        }

        public void setWubi(String wubi) {
            this.wubi = wubi;
        }
    }
}
