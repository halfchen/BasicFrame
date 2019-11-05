package com.chen.base.bean.music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbin
 * 2019-5-16
 **/
public class PlayListDetail {

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {

        private boolean subscribed;
        private CreatorBean creator;
        private Object artists;
        private boolean ordered;
        private int status;
        private boolean newImported;
        private int privacy;
        private long updateTime;
        private String commentThreadId;
        private long coverImgId;
        private int userId;
        private String coverImgUrl;
        private int playCount;
        private int trackCount;
        private int specialType;
        private boolean anonimous;
        private int totalDuration;
        private long trackUpdateTime;
        private String description;
        private int adType;
        private long createTime;
        private boolean highQuality;
        private long trackNumberUpdateTime;
        private int subscribedCount;
        private int cloudTrackCount;
        private String name;
        private String id;
        private int shareCount;
        private String coverImgId_str;
        private int commentCount;
        private List<?> subscribers;
        private List<TracksBean> tracks;
        private List<String> tags;

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public Object getArtists() {
            return artists;
        }

        public void setArtists(Object artists) {
            this.artists = artists;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getCommentThreadId() {
            return commentThreadId == null ? "" : commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getCoverImgUrl() {
            return coverImgUrl == null ? "" : coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public boolean isAnonimous() {
            return anonimous;
        }

        public void setAnonimous(boolean anonimous) {
            this.anonimous = anonimous;
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(int totalDuration) {
            this.totalDuration = totalDuration;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public String getDescription() {
            return description == null ? "" : description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
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

        public List<?> getSubscribers() {
            if (subscribers == null) {
                return new ArrayList<>();
            }
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public List<TracksBean> getTracks() {
            if (tracks == null) {
                return new ArrayList<>();
            }
            return tracks;
        }

        public void setTracks(List<TracksBean> tracks) {
            this.tracks = tracks;
        }

        public List<String> getTags() {
            if (tags == null) {
                return new ArrayList<>();
            }
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/sKnWvVM1txVvjrm5dUnOGQ==/109951163966564029.jpg
             * accountStatus : 0
             * gender : 2
             * city : 1007100
             * birthday : 774811298194
             * userId : 326053666
             * userType : 0
             * nickname : 大馬的媽媽
             * signature : 有一个人保护就不用自我保护。
             * description :
             * detailDescription :
             * avatarImgId : 109951163966564030
             * backgroundImgId : 109951163918962430
             * backgroundUrl : http://p1.music.126.net/FYPcq5bOfa00BihOfgeT4w==/109951163918962439.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * backgroundImgIdStr : 109951163918962439
             * avatarImgIdStr : 109951163966564029
             * avatarImgId_str : 109951163966564029
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
            private String backgroundImgIdStr;
            private String avatarImgIdStr;
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

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr == null ? "" : backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr == null ? "" : avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str == null ? "" : avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }

        public static class TracksBean {

            /**
             * name : 东西（Cover：林俊呈）
             * id : 1316460171
             * position : 1
             * alias : []
             * status : 0
             * fee : 0
             * copyrightId : 0
             * disc :
             * no : 1
             * artists : [{"name":"蓝心羽","id":30207301,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}]
             * album : {"name":"喜欢你呀","id":73814950,"type":"专辑","size":2,"picId":109951163600791100,"blurPicUrl":"http://p2.music.126.net/uyxr9DaQeMt2XHMcybl6fQ==/109951163600791104.jpg","companyId":0,"pic":109951163600791100,"picUrl":"http://p2.music.126.net/uyxr9DaQeMt2XHMcybl6fQ==/109951163600791104.jpg","publishTime":1538956800000,"description":"","tags":"","company":null,"briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0},"songs":[],"alias":[],"status":0,"copyrightId":0,"commentThreadId":"R_AL_3_73814950","artists":[{"name":"蓝心羽","id":30207301,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}],"subType":"现场版","transName":null,"picId_str":"109951163600791104"}
             * starred : false
             * popularity : 100
             * score : 100
             * starredNum : 0
             * duration : 163514
             * playedNum : 0
             * dayPlays : 0
             * hearTime : 0
             * ringtone : null
             * crbt : null
             * audition : null
             * copyFrom :
             * commentThreadId : R_SO_4_1316460171
             * rtUrl : null
             * ftype : 0
             * rtUrls : []
             * copyright : 2
             * transName : null
             * sign : null
             * hMusic : {"name":null,"id":3458951216,"size":6543195,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":163514,"volumeDelta":1109}
             * mMusic : {"name":null,"id":3458951217,"size":3925934,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":163514,"volumeDelta":3491}
             * lMusic : {"name":null,"id":3458951218,"size":2617304,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":163514,"volumeDelta":5965}
             * bMusic : {"name":null,"id":3458951218,"size":2617304,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":163514,"volumeDelta":5965}
             * rtype : 0
             * rurl : null
             * mvid : 0
             * mp3Url : null
             * transNames : ["If It Were U"]
             */

            private String name;
            private String id;
            private int position;
            private int status;
            private int fee;
            private int copyrightId;
            private String disc;
            private int no;
            private AlbumBean album;
            private boolean starred;
            private int popularity;
            private int score;
            private int starredNum;
            private long duration;
            private int playedNum;
            private int dayPlays;
            private int hearTime;
            private Object ringtone;
            private Object crbt;
            private Object audition;
            private String copyFrom;
            private String commentThreadId;
            private Object rtUrl;
            private int ftype;
            private int copyright;
            private Object transName;
            private Object sign;
            private HMusicBean hMusic;
            private MMusicBean mMusic;
            private LMusicBean lMusic;
            private BMusicBean bMusic;
            private int rtype;
            private Object rurl;
            private int mvid;
            private Object mp3Url;
            private List<?> alias;
            private List<ArtistsBeanX> artists;
            private List<?> rtUrls;
            private List<String> transNames;

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

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getDisc() {
                return disc == null ? "" : disc;
            }

            public void setDisc(String disc) {
                this.disc = disc;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public boolean isStarred() {
                return starred;
            }

            public void setStarred(boolean starred) {
                this.starred = starred;
            }

            public int getPopularity() {
                return popularity;
            }

            public void setPopularity(int popularity) {
                this.popularity = popularity;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getStarredNum() {
                return starredNum;
            }

            public void setStarredNum(int starredNum) {
                this.starredNum = starredNum;
            }

            public long getDuration() {
                return duration;
            }

            public void setDuration(long duration) {
                this.duration = duration;
            }

            public int getPlayedNum() {
                return playedNum;
            }

            public void setPlayedNum(int playedNum) {
                this.playedNum = playedNum;
            }

            public int getDayPlays() {
                return dayPlays;
            }

            public void setDayPlays(int dayPlays) {
                this.dayPlays = dayPlays;
            }

            public int getHearTime() {
                return hearTime;
            }

            public void setHearTime(int hearTime) {
                this.hearTime = hearTime;
            }

            public Object getRingtone() {
                return ringtone;
            }

            public void setRingtone(Object ringtone) {
                this.ringtone = ringtone;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public Object getAudition() {
                return audition;
            }

            public void setAudition(Object audition) {
                this.audition = audition;
            }

            public String getCopyFrom() {
                return copyFrom == null ? "" : copyFrom;
            }

            public void setCopyFrom(String copyFrom) {
                this.copyFrom = copyFrom;
            }

            public String getCommentThreadId() {
                return commentThreadId == null ? "" : commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getCopyright() {
                return copyright;
            }

            public void setCopyright(int copyright) {
                this.copyright = copyright;
            }

            public Object getTransName() {
                return transName;
            }

            public void setTransName(Object transName) {
                this.transName = transName;
            }

            public Object getSign() {
                return sign;
            }

            public void setSign(Object sign) {
                this.sign = sign;
            }

            public HMusicBean gethMusic() {
                return hMusic;
            }

            public void sethMusic(HMusicBean hMusic) {
                this.hMusic = hMusic;
            }

            public MMusicBean getmMusic() {
                return mMusic;
            }

            public void setmMusic(MMusicBean mMusic) {
                this.mMusic = mMusic;
            }

            public LMusicBean getlMusic() {
                return lMusic;
            }

            public void setlMusic(LMusicBean lMusic) {
                this.lMusic = lMusic;
            }

            public BMusicBean getbMusic() {
                return bMusic;
            }

            public void setbMusic(BMusicBean bMusic) {
                this.bMusic = bMusic;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public Object getMp3Url() {
                return mp3Url;
            }

            public void setMp3Url(Object mp3Url) {
                this.mp3Url = mp3Url;
            }

            public List<?> getAlias() {
                if (alias == null) {
                    return new ArrayList<>();
                }
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<ArtistsBeanX> getArtists() {
                if (artists == null) {
                    return new ArrayList<>();
                }
                return artists;
            }

            public void setArtists(List<ArtistsBeanX> artists) {
                this.artists = artists;
            }

            public List<?> getRtUrls() {
                if (rtUrls == null) {
                    return new ArrayList<>();
                }
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public List<String> getTransNames() {
                if (transNames == null) {
                    return new ArrayList<>();
                }
                return transNames;
            }

            public void setTransNames(List<String> transNames) {
                this.transNames = transNames;
            }

            public static class AlbumBean {
                /**
                 * name : 喜欢你呀
                 * id : 73814950
                 * type : 专辑
                 * size : 2
                 * picId : 109951163600791100
                 * blurPicUrl : http://p2.music.126.net/uyxr9DaQeMt2XHMcybl6fQ==/109951163600791104.jpg
                 * companyId : 0
                 * pic : 109951163600791100
                 * picUrl : http://p2.music.126.net/uyxr9DaQeMt2XHMcybl6fQ==/109951163600791104.jpg
                 * publishTime : 1538956800000
                 * description :
                 * tags :
                 * company : null
                 * briefDesc :
                 * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}
                 * songs : []
                 * alias : []
                 * status : 0
                 * copyrightId : 0
                 * commentThreadId : R_AL_3_73814950
                 * artists : [{"name":"蓝心羽","id":30207301,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}]
                 * subType : 现场版
                 * transName : null
                 * picId_str : 109951163600791104
                 */

                private String name;
                private int id;
                private String type;
                private int size;
                private long picId;
                private String blurPicUrl;
                private int companyId;
                private long pic;
                private String picUrl;
                private long publishTime;
                private String description;
                private String tags;
                private Object company;
                private String briefDesc;
                private ArtistBean artist;
                private int status;
                private int copyrightId;
                private String commentThreadId;
                private String subType;
                private Object transName;
                private String picId_str;
                private List<?> songs;
                private List<?> alias;
                private List<ArtistsBean> artists;

                public String getName() {
                    return name == null ? "" : name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getType() {
                    return type == null ? "" : type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public String getBlurPicUrl() {
                    return blurPicUrl == null ? "" : blurPicUrl;
                }

                public void setBlurPicUrl(String blurPicUrl) {
                    this.blurPicUrl = blurPicUrl;
                }

                public int getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(int companyId) {
                    this.companyId = companyId;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public String getPicUrl() {
                    return picUrl == null ? "" : picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public String getDescription() {
                    return description == null ? "" : description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTags() {
                    return tags == null ? "" : tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public Object getCompany() {
                    return company;
                }

                public void setCompany(Object company) {
                    this.company = company;
                }

                public String getBriefDesc() {
                    return briefDesc == null ? "" : briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public ArtistBean getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBean artist) {
                    this.artist = artist;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public String getCommentThreadId() {
                    return commentThreadId == null ? "" : commentThreadId;
                }

                public void setCommentThreadId(String commentThreadId) {
                    this.commentThreadId = commentThreadId;
                }

                public String getSubType() {
                    return subType == null ? "" : subType;
                }

                public void setSubType(String subType) {
                    this.subType = subType;
                }

                public Object getTransName() {
                    return transName;
                }

                public void setTransName(Object transName) {
                    this.transName = transName;
                }

                public String getPicId_str() {
                    return picId_str == null ? "" : picId_str;
                }

                public void setPicId_str(String picId_str) {
                    this.picId_str = picId_str;
                }

                public List<?> getSongs() {
                    if (songs == null) {
                        return new ArrayList<>();
                    }
                    return songs;
                }

                public void setSongs(List<?> songs) {
                    this.songs = songs;
                }

                public List<?> getAlias() {
                    if (alias == null) {
                        return new ArrayList<>();
                    }
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }

                public List<ArtistsBean> getArtists() {
                    if (artists == null) {
                        return new ArrayList<>();
                    }
                    return artists;
                }

                public void setArtists(List<ArtistsBean> artists) {
                    this.artists = artists;
                }

                public static class ArtistBean {
                    /**
                     * name :
                     * id : 0
                     * picId : 0
                     * img1v1Id : 0
                     * briefDesc :
                     * picUrl : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1Url : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * albumSize : 0
                     * alias : []
                     * trans :
                     * musicSize : 0
                     * topicPerson : 0
                     */

                    private String name;
                    private int id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private String trans;
                    private int musicSize;
                    private int topicPerson;
                    private List<?> alias;

                    public String getName() {
                        return name == null ? "" : name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc == null ? "" : briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl == null ? "" : picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url == null ? "" : img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getTrans() {
                        return trans == null ? "" : trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public int getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(int topicPerson) {
                        this.topicPerson = topicPerson;
                    }

                    public List<?> getAlias() {
                        if (alias == null) {
                            return new ArrayList<>();
                        }
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }

                public static class ArtistsBean {
                    /**
                     * name : 蓝心羽
                     * id : 30207301
                     * picId : 0
                     * img1v1Id : 0
                     * briefDesc :
                     * picUrl : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1Url : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * albumSize : 0
                     * alias : []
                     * trans :
                     * musicSize : 0
                     * topicPerson : 0
                     */

                    private String name;
                    private int id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private String trans;
                    private int musicSize;
                    private int topicPerson;
                    private List<?> alias;

                    public String getName() {
                        return name == null ? "" : name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc == null ? "" : briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl == null ? "" : picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url == null ? "" : img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getTrans() {
                        return trans == null ? "" : trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public int getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(int topicPerson) {
                        this.topicPerson = topicPerson;
                    }

                    public List<?> getAlias() {
                        if (alias == null) {
                            return new ArrayList<>();
                        }
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }
            }

            public static class HMusicBean {
                /**
                 * name : null
                 * id : 3458951216
                 * size : 6543195
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 320000
                 * playTime : 163514
                 * volumeDelta : 1109
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private String volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension == null ? "" : extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public String getVolumeDelta() {
                    return volumeDelta == null ? "" : volumeDelta;
                }

                public void setVolumeDelta(String volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class MMusicBean {
                /**
                 * name : null
                 * id : 3458951217
                 * size : 3925934
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 192000
                 * playTime : 163514
                 * volumeDelta : 3491
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private String volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension == null ? "" : extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public String getVolumeDelta() {
                    return volumeDelta == null ? "" : volumeDelta;
                }

                public void setVolumeDelta(String volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class LMusicBean {
                /**
                 * name : null
                 * id : 3458951218
                 * size : 2617304
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 128000
                 * playTime : 163514
                 * volumeDelta : 5965
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private String volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension == null ? "" : extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public String getVolumeDelta() {
                    return volumeDelta == null ? "" : volumeDelta;
                }

                public void setVolumeDelta(String volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class BMusicBean {
                /**
                 * name : null
                 * id : 3458951218
                 * size : 2617304
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 128000
                 * playTime : 163514
                 * volumeDelta : 5965
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private String volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension == null ? "" : extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public String getVolumeDelta() {
                    return volumeDelta == null ? "" : volumeDelta;
                }

                public void setVolumeDelta(String volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class ArtistsBeanX {
                /**
                 * name : 蓝心羽
                 * id : 30207301
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 * topicPerson : 0
                 */

                private String name;
                private int id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private int topicPerson;
                private List<?> alias;

                public String getName() {
                    return name == null ? "" : name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc == null ? "" : briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl == null ? "" : picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url == null ? "" : img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans == null ? "" : trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
                }

                public List<?> getAlias() {
                    if (alias == null) {
                        return new ArrayList<>();
                    }
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }
    }
}
