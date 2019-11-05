package com.chen.base.bean.video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-6-18
 **/
public class CategoriesBean {

    /**
     * itemList : [{"type":"squareCard","data":{"dataType":"SquareCard","id":-1,"title":"","image":"http://img.kaiyanapp.com/eaded016cfcb90a695661e37f2913a6b.jpeg?imageMogr2/quality/60","actionUrl":"eyepetizer://ranklist/","shade":false,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":0,"title":"","image":"http://img.kaiyanapp.com/d497d12ae02b6b173b7818a94b84a92b.jpeg?imageMogr2/quality/60","actionUrl":"eyepetizer://campaign/list/?title=%E4%B8%93%E9%A2%98","shade":false,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"rectangleCard","data":{"dataType":"RectangleCard","id":1,"title":"","image":"http://img.kaiyanapp.com/f6765ae9bcd4551ce40f10fe342b681c.jpeg?imageMogr2/quality/60","actionUrl":"eyepetizer://tag/658/?title=360%C2%B0%E5%85%A8%E6%99%AF","shade":false,"adTrack":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":14,"title":"#广告","image":"http://img.kaiyanapp.com/57472e13fd2b6c9655c8a600597daf4d.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":12,"title":"#剧情","image":"http://img.kaiyanapp.com/afa27b9c52d2ed2f5f8b5f8c12992fcf.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/12/?title=%E5%89%A7%E6%83%85","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":18,"title":"#运动","image":"http://img.kaiyanapp.com/4cf9360ae41d2350c3a793579f53bc29.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/18/?title=%E8%BF%90%E5%8A%A8","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":2,"title":"#创意","image":"http://img.kaiyanapp.com/727bd34a770ba32dd2b7fa225df0cd9b.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/2/?title=%E5%88%9B%E6%84%8F","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":6,"title":"#旅行","image":"http://img.kaiyanapp.com/0f3513fdfb72434b3a74ccb157406f54.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/6/?title=%E6%97%85%E8%A1%8C","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":8,"title":"#影视","image":"http://img.kaiyanapp.com/f4bf4df0e077ffa6e9c5f90ce40a6f53.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/8/?title=%E5%BD%B1%E8%A7%86","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":22,"title":"#记录","image":"http://img.kaiyanapp.com/936e0c299688eb88c5ba593a971c7abf.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/22/?title=%E8%AE%B0%E5%BD%95","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":20,"title":"#音乐","image":"http://img.kaiyanapp.com/33cc30cf40de3288a8862d12e7dbd674.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/20/?title=%E9%9F%B3%E4%B9%90","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":32,"title":"#科技","image":"http://img.kaiyanapp.com/1da6527c7300b7766def87a585952295.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/32/?title=%E7%A7%91%E6%8A%80","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":4,"title":"#开胃","image":"http://img.kaiyanapp.com/37301e88af9a789e41b89af35aaa77f2.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/4/?title=%E5%BC%80%E8%83%83","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":30,"title":"#游戏","image":"http://img.kaiyanapp.com/fd5691e646f9de718a817b8d202b1e1c.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/30/?title=%E6%B8%B8%E6%88%8F","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":10,"title":"#动画","image":"http://img.kaiyanapp.com/68fe1a141a27df721496c6711370b1cc.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/10/?title=%E5%8A%A8%E7%94%BB","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":28,"title":"#搞笑","image":"http://img.kaiyanapp.com/6da6ebd197c408a6d0193c58c00583f4.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/28/?title=%E6%90%9E%E7%AC%91","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/03bd4fa7429614df5a936f42c09e1275.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":36,"title":"#生活","image":"http://img.kaiyanapp.com/3f16bcf95917a4d659c23508b4de6bbf.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/36/?title=%E7%94%9F%E6%B4%BB","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":38,"title":"#综艺","image":"http://img.kaiyanapp.com/a17745312139694dc1f0c40984533328.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/38/?title=%E7%BB%BC%E8%89%BA","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1},{"type":"squareCard","data":{"dataType":"SquareCard","id":26,"title":"#萌宠","image":"http://img.kaiyanapp.com/d93e1ea7470008375ea4462ec752b5b7.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://category/26/?title=%E8%90%8C%E5%AE%A0","shade":true,"adTrack":null,"description":null},"tag":null,"id":0,"adIndex":-1}]
     * count : 20
     * total : 0
     * nextPageUrl : null
     * adExist : false
     */
    private List<ItemListBean> itemList;

    public List<ItemListBean> getItemList() {
        if (itemList == null) {
            return new ArrayList<>();
        }
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * type : squareCard
         * data : {"dataType":"SquareCard","id":-1,"title":"","image":"http://img.kaiyanapp.com/eaded016cfcb90a695661e37f2913a6b.jpeg?imageMogr2/quality/60","actionUrl":"eyepetizer://ranklist/","shade":false,"adTrack":null,"description":null}
         * tag : null
         * id : 0
         * adIndex : -1
         */
        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * dataType : SquareCard
             * id : -1
             * title :
             * image : http://img.kaiyanapp.com/eaded016cfcb90a695661e37f2913a6b.jpeg?imageMogr2/quality/60
             * actionUrl : eyepetizer://ranklist/
             * shade : false
             * adTrack : null
             * description : null
             */
            private String title;
            private String image;
            private String actionUrl;

            public String getTitle() {
                return title == null ? "" : title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image == null ? "" : image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getActionUrl() {
                return actionUrl == null ? "" : actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }
        }
    }
}
