package com.chen.base.bean.video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-5-29
 **/
public class AllRec {

    private List<ItemListBeanX> itemList;

    public List<ItemListBeanX> getItemList() {
        if (itemList == null) {
            return new ArrayList<>();
        }
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBeanX {

        private String type;
        private String text;
        private DataBeanXX data;

        public String getText() {
            return text == null ? "" : text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type == null ? "" : type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBeanXX getData() {
            return data;
        }

        public void setData(DataBeanXX data) {
            this.data = data;
        }

        public static class DataBeanXX {

            private String id;
            private String type;
            private String dataType;
            private HeaderBean header;
            private int duration;
            private String title;
            private String actionUrl;
            private String playUrl;
            private String text;
            private String rightText;
            private String description;
            private String category;
            private String icon;
            private String image;
            private DetailBean detail;
            private ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean cover;
            private ItemListBean.DataBeanX.ContentBean content;
            private ItemListBean.DataBeanX.ContentBean.DataBean.AuthorBean author;
            private List<ItemListBean> itemList;

            public String getId() {
                return id == null ? "" : id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public ItemListBean.DataBeanX.ContentBean.DataBean.AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(ItemListBean.DataBeanX.ContentBean.DataBean.AuthorBean author) {
                this.author = author;
            }

            public String getActionUrl() {
                return actionUrl == null ? "" : actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public String getPlayUrl() {
                return playUrl == null ? "" : playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public DetailBean getDetail() {
                return detail;
            }

            public void setDetail(DetailBean detail) {
                this.detail = detail;
            }

            public String getDescription() {
                return description == null ? "" : description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon == null ? "" : icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getType() {
                return type == null ? "" : type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean getCover() {
                return cover;
            }

            public void setCover(ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean cover) {
                this.cover = cover;
            }

            public ItemListBean.DataBeanX.ContentBean getContent() {
                return content;
            }

            public void setContent(ItemListBean.DataBeanX.ContentBean content) {
                this.content = content;
            }

            public String getCategory() {
                return category == null ? "" : category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getDataType() {
                return dataType == null ? "" : dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public String getTitle() {
                return title == null ? "" : title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getText() {
                return text == null ? "" : text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getRightText() {
                return rightText == null ? "" : rightText;
            }

            public void setRightText(String rightText) {
                this.rightText = rightText;
            }

            public String getImage() {
                return image == null ? "" : image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public List<ItemListBean> getItemList() {
                if (itemList == null) {
                    return new ArrayList<>();
                }
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }

            public static class DetailBean {

                private String icon;
                private String title;
                private String description;
                private String imageUrl;

                public String getIcon() {
                    return icon == null ? "" : icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getTitle() {
                    return title == null ? "" : title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDescription() {
                    return description == null ? "" : description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getImageUrl() {
                    return imageUrl == null ? "" : imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }
            }

            public static class HeaderBean {
                /**
                 * id : 5
                 * title : 开眼编辑精选
                 * font : bigBold
                 * subTitle : WEDNESDAY, MAY 29
                 * subTitleFont : lobster
                 * textAlign : left
                 * cover : null
                 * label : null
                 * actionUrl : eyepetizer://homepage/selected?tabIndex=2&newTabIndex=-3
                 * labelList : null
                 * rightText : 查看往期
                 */
                private String title;
                private String subTitle;
                private String rightText;

                public String getTitle() {
                    return title == null ? "" : title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getSubTitle() {
                    return subTitle == null ? "" : subTitle;
                }

                public void setSubTitle(String subTitle) {
                    this.subTitle = subTitle;
                }

                public String getRightText() {
                    return rightText == null ? "" : rightText;
                }

                public void setRightText(String rightText) {
                    this.rightText = rightText;
                }
            }

            public static class ItemListBean {

                private DataBeanX data;

                public DataBeanX getData() {
                    return data;
                }

                public void setData(DataBeanX data) {
                    this.data = data;
                }

                public static class DataBeanX {

                    private ContentBean content;
                    private String title;
                    private String image;

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

                    public ContentBean getContent() {
                        return content;
                    }

                    public void setContent(ContentBean content) {
                        this.content = content;
                    }

                    public static class ContentBean {

                        private DataBean data;

                        public DataBean getData() {
                            return data;
                        }

                        public void setData(DataBean data) {
                            this.data = data;
                        }

                        public static class DataBean {

                            private String id;
                            private String title;
                            private String description;
                            private String slogan;
                            private String category;
                            private AuthorBean author;
                            private CoverBean cover;
                            private String playUrl;
                            private int duration;
                            private OwnerBean owner;

                            public OwnerBean getOwner() {
                                return owner;
                            }

                            public void setOwner(OwnerBean owner) {
                                this.owner = owner;
                            }

                            public String getId() {
                                return id == null ? "" : id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getTitle() {
                                return title == null ? "" : title;
                            }

                            public void setTitle(String title) {
                                this.title = title;
                            }

                            public String getDescription() {
                                return description == null ? "" : description;
                            }

                            public void setDescription(String description) {
                                this.description = description;
                            }

                            public String getSlogan() {
                                return slogan == null ? "" : slogan;
                            }

                            public void setSlogan(String slogan) {
                                this.slogan = slogan;
                            }

                            public String getCategory() {
                                return category == null ? "" : category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public AuthorBean getAuthor() {
                                return author;
                            }

                            public void setAuthor(AuthorBean author) {
                                this.author = author;
                            }

                            public CoverBean getCover() {
                                return cover;
                            }

                            public void setCover(CoverBean cover) {
                                this.cover = cover;
                            }

                            public String getPlayUrl() {
                                return playUrl == null ? "" : playUrl;
                            }

                            public void setPlayUrl(String playUrl) {
                                this.playUrl = playUrl;
                            }

                            public int getDuration() {
                                return duration;
                            }

                            public void setDuration(int duration) {
                                this.duration = duration;
                            }

                            public static class OwnerBean {
                                private String nickname;
                                private String avatar;

                                public String getNickname() {
                                    return nickname == null ? "" : nickname;
                                }

                                public void setNickname(String nickname) {
                                    this.nickname = nickname;
                                }

                                public String getAvatar() {
                                    return avatar == null ? "" : avatar;
                                }

                                public void setAvatar(String avatar) {
                                    this.avatar = avatar;
                                }
                            }

                            public static class AuthorBean {
                                /**
                                 * id : 4485
                                 * icon : http://img.kaiyanapp.com/bc0e2735e3da488efa7fbab5492a168d.png?imageMogr2/quality/60/format/jpg
                                 * name : TheGaroStudios
                                 * description : 油管影视混剪博主
                                 * link : https://www.youtube.com/user/TheGaroStudios/videos
                                 * latestReleaseTime : 1559091601000
                                 * videoNum : 9
                                 * follow : {"itemType":"author","itemId":4485,"followed":false}
                                 * shield : {"itemType":"author","itemId":4485,"shielded":false}
                                 * approvedNotReadyVideoCount : 0
                                 * ifPgc : true
                                 * recSort : 0
                                 * expert : false
                                 */
                                private String icon;

                                public String getIcon() {
                                    return icon == null ? "" : icon;
                                }

                                public void setIcon(String icon) {
                                    this.icon = icon;
                                }
                            }

                            public static class CoverBean {
                                /**
                                 * feed : http://img.kaiyanapp.com/a324c1e8607a78871fd01ae14cad91b5.jpeg?imageMogr2/quality/60/format/jpg
                                 * detail : http://img.kaiyanapp.com/a324c1e8607a78871fd01ae14cad91b5.jpeg?imageMogr2/quality/60/format/jpg
                                 * blurred : http://img.kaiyanapp.com/5c8934d4d4b256b47651b8ae9ce592d9.jpeg?imageMogr2/quality/60/format/jpg
                                 * sharing : null
                                 * homepage : http://img.kaiyanapp.com/a324c1e8607a78871fd01ae14cad91b5.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                                 */
                                private String detail;

                                public String getDetail() {
                                    return detail == null ? "" : detail;
                                }

                                public void setDetail(String detail) {
                                    this.detail = detail;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
