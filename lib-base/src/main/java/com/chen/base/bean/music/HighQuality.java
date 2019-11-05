package com.chen.base.bean.music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-5-16
 **/
public class HighQuality {

    /**
     * playlists : [{"name":"『加州公路』皮卡夕阳与微风，生活不止苟且","id":560609382,"trackNumberUpdateTime":1554108077218,"status":0,"userId":136287087,"createTime":1483693384455,"updateTime":1557821594852,"subscribedCount":93958,"trackCount":59,"cloudTrackCount":0,"coverImgUrl":"http://p2.music.126.net/kzrUM6_p8N0wDXGW71GX3g==/18965476068109008.jpg","coverImgId":18965476068109010,"description":"总有一些穿高跟鞋走不到的路 总有一些喷着香水闻不到的空气 总有一些在写字楼里永远遇不见的人 背起行囊 去寻找你心中的那人那景 ······","tags":[],"playCount":4748509,"trackUpdateTime":1557887232512,"specialType":0,"totalDuration":0,"creator":{},"tracks":null,"subscribers":[{"defaultAvatar":false,"province":330000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/5KKcVUgrFtafHzaFz2BSbg==/109951163324571676.jpg","accountStatus":0,"gender":1,"city":330100,"birthday":-2209017600000,"userId":1472596328,"userType":0,"nickname":"lk1201","signature":"","description":"","detailDescription":"","avatarImgId":109951163324571680,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":10,"remarkName":null,"avatarImgIdStr":"109951163324571676","backgroundImgIdStr":"109951162868126486","avatarImgId_str":"109951163324571676"}],"subscribed":null,"commentThreadId":"A_PL_0_560609382","newImported":false,"adType":0,"highQuality":true,"privacy":0,"ordered":true,"anonimous":false,"shareCount":993,"coverImgId_str":"18965476068109008","commentCount":462,"copywriter":"欢迎来到66号公路，请跟随我来一场耳朵星球的旅行。","tag":"欧美"},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}]
     * code : 200
     * more : true
     * lasttime : 1543137165618
     * total : 276
     */

    private int code;
    private boolean more;
    private long lasttime;
    private int total;
    private List<PlaylistsBean> playlists;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public long getLasttime() {
        return lasttime;
    }

    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PlaylistsBean> getPlaylists() {
        if (playlists == null) {
            return new ArrayList<>();
        }
        return playlists;
    }

    public void setPlaylists(List<PlaylistsBean> playlists) {
        this.playlists = playlists;
    }

    public static class PlaylistsBean {
        /**
         * name : 『加州公路』皮卡夕阳与微风，生活不止苟且
         * id : 560609382
         * trackNumberUpdateTime : 1554108077218
         * status : 0
         * userId : 136287087
         * createTime : 1483693384455
         * updateTime : 1557821594852
         * subscribedCount : 93958
         * trackCount : 59
         * cloudTrackCount : 0
         * coverImgUrl : http://p2.music.126.net/kzrUM6_p8N0wDXGW71GX3g==/18965476068109008.jpg
         * coverImgId : 18965476068109010
         * description : 总有一些穿高跟鞋走不到的路 总有一些喷着香水闻不到的空气 总有一些在写字楼里永远遇不见的人 背起行囊 去寻找你心中的那人那景 ······
         * tags : []
         * playCount : 4748509
         * trackUpdateTime : 1557887232512
         * specialType : 0
         * totalDuration : 0
         * creator : {}
         * tracks : null
         * subscribers : [{"defaultAvatar":false,"province":330000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/5KKcVUgrFtafHzaFz2BSbg==/109951163324571676.jpg","accountStatus":0,"gender":1,"city":330100,"birthday":-2209017600000,"userId":1472596328,"userType":0,"nickname":"lk1201","signature":"","description":"","detailDescription":"","avatarImgId":109951163324571680,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":10,"remarkName":null,"avatarImgIdStr":"109951163324571676","backgroundImgIdStr":"109951162868126486","avatarImgId_str":"109951163324571676"}]
         * subscribed : null
         * commentThreadId : A_PL_0_560609382
         * newImported : false
         * adType : 0
         * highQuality : true
         * privacy : 0
         * ordered : true
         * anonimous : false
         * shareCount : 993
         * coverImgId_str : 18965476068109008
         * commentCount : 462
         * copywriter : 欢迎来到66号公路，请跟随我来一场耳朵星球的旅行。
         * tag : 欧美
         */

        private String name;
        private String id;
        private long trackNumberUpdateTime;
        private int status;
        private int userId;
        private long createTime;
        private long updateTime;
        private int subscribedCount;
        private int trackCount;
        private int cloudTrackCount;
        private String coverImgUrl;
        private long coverImgId;
        private String description;
        private int playCount;
        private long trackUpdateTime;
        private int specialType;
        private int totalDuration;
        private CreatorBean creator;
        private Object tracks;
        private Object subscribed;
        private String commentThreadId;
        private boolean newImported;
        private int adType;
        private boolean highQuality;
        private int privacy;
        private boolean ordered;
        private boolean anonimous;
        private int shareCount;
        private String coverImgId_str;
        private int commentCount;
        private String copywriter;
        private String tag;
        private String alg;
        private List<?> tags;
        private List<SubscribersBean> subscribers;

        public String getAlg() {
            return alg == null ? "" : alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id == null ? "" : id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public String getCoverImgUrl() {
            return coverImgUrl == null ? "" : coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public String getDescription() {
            return description == null ? "" : description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(int totalDuration) {
            this.totalDuration = totalDuration;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public Object getTracks() {
            return tracks;
        }

        public void setTracks(Object tracks) {
            this.tracks = tracks;
        }

        public Object getSubscribed() {
            return subscribed;
        }

        public void setSubscribed(Object subscribed) {
            this.subscribed = subscribed;
        }

        public String getCommentThreadId() {
            return commentThreadId == null ? "" : commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public boolean isAnonimous() {
            return anonimous;
        }

        public void setAnonimous(boolean anonimous) {
            this.anonimous = anonimous;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getCoverImgId_str() {
            return coverImgId_str == null ? "" : coverImgId_str;
        }

        public void setCoverImgId_str(String coverImgId_str) {
            this.coverImgId_str = coverImgId_str;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getCopywriter() {
            return copywriter == null ? "" : copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getTag() {
            return tag == null ? "" : tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public List<?> getTags() {
            if (tags == null) {
                return new ArrayList<>();
            }
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<SubscribersBean> getSubscribers() {
            if (subscribers == null) {
                return new ArrayList<>();
            }
            return subscribers;
        }

        public void setSubscribers(List<SubscribersBean> subscribers) {
            this.subscribers = subscribers;
        }

        public static class CreatorBean {

            private String backgroundUrl;

            public String getBackgroundUrl() {
                return backgroundUrl == null ? "" : backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }
        }

        public static class SubscribersBean {
            /**
             * defaultAvatar : false
             * province : 330000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/5KKcVUgrFtafHzaFz2BSbg==/109951163324571676.jpg
             * accountStatus : 0
             * gender : 1
             * city : 330100
             * birthday : -2209017600000
             * userId : 1472596328
             * userType : 0
             * nickname : lk1201
             * signature :
             * description :
             * detailDescription :
             * avatarImgId : 109951163324571680
             * backgroundImgId : 109951162868126480
             * backgroundUrl : http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 10
             * remarkName : null
             * avatarImgIdStr : 109951163324571676
             * backgroundImgIdStr : 109951162868126486
             * avatarImgId_str : 109951163324571676
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private String avatarImgId_str;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl == null ? "" : avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname == null ? "" : nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature == null ? "" : signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description == null ? "" : description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription == null ? "" : detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl == null ? "" : backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr == null ? "" : avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr == null ? "" : backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str == null ? "" : avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }
    }
}
