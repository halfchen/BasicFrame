package com.chen.base.bean.music;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chenbin
 * 2019-6-5
 **/
public class Music implements Parcelable {

    private String type; //歌曲类型 本地/网络
    private Long id; //数据库存储id
    private String mid; //歌曲id
    private String title; //音乐标题
    private String artist; //艺术家
    private String album; //专辑
    private String artistId; //专辑id
    private String albumId; //专辑id
    private int trackNumber; //专辑内歌曲个数
    private Long duration; //持续时间
    private Boolean isLove; //收藏
    private Boolean isOnline; //本地|网络
    private String uri; //音乐路径
    private String lyric; //[本地|网络] 音乐歌词地址
    private String coverUri; //[本地|网络]专辑封面路径
    private String coverBig; //[网络]专辑封面
    private String coverSmall; //[网络]small封面
    private String fileName; //文件名
    private Long fileSize; //文件大小
    private String year; //发行日期
    private Long date; //更新日期
    private Boolean isCp; //在线歌曲是否限制播放，false 可以播放
    private Boolean isDl; //在线歌曲是否付费歌曲，false 不能下载
    private String collectId; //收藏id
    private int quality = 128000; //音乐品质，默认标准模式
    //音乐品质选择
    private Boolean hq;
    private Boolean sq;
    private Boolean high;
    //是否有mv 0代表无，1代表有
    private int hasMv;

    protected Music(Parcel in) {
        type = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        mid = in.readString();
        title = in.readString();
        artist = in.readString();
        album = in.readString();
        artistId = in.readString();
        albumId = in.readString();
        trackNumber = in.readInt();
        if (in.readByte() == 0) {
            duration = null;
        } else {
            duration = in.readLong();
        }
        byte tmpIsLove = in.readByte();
        isLove = tmpIsLove == 0 ? null : tmpIsLove == 1;
        byte tmpIsOnline = in.readByte();
        isOnline = tmpIsOnline == 0 ? null : tmpIsOnline == 1;
        uri = in.readString();
        lyric = in.readString();
        coverUri = in.readString();
        coverBig = in.readString();
        coverSmall = in.readString();
        fileName = in.readString();
        if (in.readByte() == 0) {
            fileSize = null;
        } else {
            fileSize = in.readLong();
        }
        year = in.readString();
        if (in.readByte() == 0) {
            date = null;
        } else {
            date = in.readLong();
        }
        byte tmpIsCp = in.readByte();
        isCp = tmpIsCp == 0 ? null : tmpIsCp == 1;
        byte tmpIsDl = in.readByte();
        isDl = tmpIsDl == 0 ? null : tmpIsDl == 1;
        collectId = in.readString();
        quality = in.readInt();
        byte tmpHq = in.readByte();
        hq = tmpHq == 0 ? null : tmpHq == 1;
        byte tmpSq = in.readByte();
        sq = tmpSq == 0 ? null : tmpSq == 1;
        byte tmpHigh = in.readByte();
        high = tmpHigh == 0 ? null : tmpHigh == 1;
        hasMv = in.readInt();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMid() {
        return mid == null ? "" : mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist == null ? "" : artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album == null ? "" : album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtistId() {
        return artistId == null ? "" : artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getAlbumId() {
        return albumId == null ? "" : albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getLove() {
        return isLove;
    }

    public void setLove(Boolean love) {
        isLove = love;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getUri() {
        return uri == null ? "" : uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLyric() {
        return lyric == null ? "" : lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getCoverUri() {
        return coverUri == null ? "" : coverUri;
    }

    public void setCoverUri(String coverUri) {
        this.coverUri = coverUri;
    }

    public String getCoverBig() {
        return coverBig == null ? "" : coverBig;
    }

    public void setCoverBig(String coverBig) {
        this.coverBig = coverBig;
    }

    public String getCoverSmall() {
        return coverSmall == null ? "" : coverSmall;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public String getFileName() {
        return fileName == null ? "" : fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getYear() {
        return year == null ? "" : year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Boolean getCp() {
        return isCp;
    }

    public void setCp(Boolean cp) {
        isCp = cp;
    }

    public Boolean getDl() {
        return isDl;
    }

    public void setDl(Boolean dl) {
        isDl = dl;
    }

    public String getCollectId() {
        return collectId == null ? "" : collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Boolean getHq() {
        return hq;
    }

    public void setHq(Boolean hq) {
        this.hq = hq;
    }

    public Boolean getSq() {
        return sq;
    }

    public void setSq(Boolean sq) {
        this.sq = sq;
    }

    public Boolean getHigh() {
        return high;
    }

    public void setHigh(Boolean high) {
        this.high = high;
    }

    public int getHasMv() {
        return hasMv;
    }

    public void setHasMv(int hasMv) {
        this.hasMv = hasMv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p0, int flags) {
        p0.writeString(type);
        p0.writeLong(id);
        p0.writeString(mid);
        p0.writeString(title);
        p0.writeString(artist);
        p0.writeString(album);
        p0.writeString(artistId);
        p0.writeString(albumId);
        p0.writeInt(trackNumber);
        p0.writeLong(duration);
        if (isLove) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
        if (isOnline) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
        p0.writeString(uri);
        p0.writeString(lyric);
        p0.writeString(coverUri);
        p0.writeString(coverBig);
        p0.writeString(coverSmall);
        p0.writeString(fileName);
        p0.writeLong(fileSize);
        p0.writeString(year);
        p0.writeLong(date);
        if (isCp) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
        if (isDl) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
        p0.writeString(collectId);
        p0.writeInt(quality);
        if (hq) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
        if (sq) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
        if (high) {
            p0.writeByte((byte) 1);
        } else {
            p0.writeByte((byte) 0);
        }
    }
}
