package com.chen.base.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.chen.base.Constants;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by chenbin
 * 2019-7-10
 **/
public class WxShareUtils {
    private static final int THUMB_SIZE = 120;

    /**
     * 分享网页类型至微信
     *
     * @param context     上下文
     * @param targetScene 朋友圈【SendMessageToWX.Req.WXSceneTimeline】&朋友对话【SendMessageToWX.Req.WXSceneSession】
     * @param webUrl      网页的url
     * @param title       网页标题
     * @param content     网页描述
     * @param bitmap      位图
     */
    public static void shareWeb(Context context, int targetScene, String webUrl, String title, String content, Bitmap bitmap) {
        // 通过appId得到IWXAPI这个对象
        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, Constants.WX_APPID);
        // 检查手机或者模拟器是否安装了微信
        if (!wxapi.isWXAppInstalled()) {
            ToastUtils.showShort("您还没有安装微信");
            return;
        }

        // 初始化一个WXWebpageObject对象
        WXWebpageObject webpageObject = new WXWebpageObject();
        // 填写网页的url
        webpageObject.webpageUrl = webUrl;

        // 用WXWebpageObject对象初始化一个WXMediaMessage对象
        WXMediaMessage msg = new WXMediaMessage(webpageObject);
        // 填写网页标题、描述、位图
        msg.title = title;
        msg.description = content;
        //压缩图片
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bitmap, THUMB_SIZE, THUMB_SIZE, true);
        bitmap.recycle();
        // 如果没有位图，可以传null，会显示默认的图片
        msg.setThumbImage(thumbBmp);

        // 构造一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        // transaction用于唯一标识一个请求（可自定义）
        req.transaction = "webpage";
        // 上文的WXMediaMessage对象
        req.message = msg;
        // SendMessageToWX.Req.WXSceneSession是分享到好友会话
        // SendMessageToWX.Req.WXSceneTimeline是分享到朋友圈
        req.scene = targetScene;

        // 向微信发送请求
        wxapi.sendReq(req);
    }

    /**
     * 分享音乐
     *
     * @param context
     * @param targetScene 朋友圈【SendMessageToWX.Req.WXSceneTimeline】&朋友对话【SendMessageToWX.Req.WXSceneSession】
     * @param url         音乐的url
     * @param title       音乐名
     * @param description 音乐描述
     * @param bmp         位图
     */
    public static void shareMusic(Context context, int targetScene, String url, String title, String description, Bitmap bmp) {
        // 通过appId得到IWXAPI这个对象
        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, Constants.WX_APPID);
        // 检查手机或者模拟器是否安装了微信
        if (!wxapi.isWXAppInstalled()) {
            ToastUtils.showShort("您还没有安装微信");
            return;
        }
        WXMusicObject music = new WXMusicObject();
        //music.musicUrl = "http://www.baidu.com";
        music.musicUrl = url;

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = music;
        msg.title = title;
        msg.description = description;

        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = Utils.bmpToByteArray(thumbBmp, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("music");
        req.message = msg;
        req.scene = targetScene;
        wxapi.sendReq(req);
    }

    /**
     * 分享视频
     *
     * @param context
     * @param targetScene 朋友圈【SendMessageToWX.Req.WXSceneTimeline】&朋友对话【SendMessageToWX.Req.WXSceneSession】
     * @param url         音乐的url
     * @param title       音乐名
     * @param description 音乐描述
     * @param bmp         位图
     */
    public static void shareVideo(Context context, int targetScene, String url, String title, String description, Bitmap bmp) {
        // 通过appId得到IWXAPI这个对象
        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, Constants.WX_APPID);
        // 检查手机或者模拟器是否安装了微信
        if (!wxapi.isWXAppInstalled()) {
            ToastUtils.showShort("您还没有安装微信");
            return;
        }
        WXVideoObject video = new WXVideoObject();
        video.videoUrl = url;

        WXMediaMessage msg = new WXMediaMessage(video);

        msg.title = title;
        msg.description = description;
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = Utils.bmpToByteArray(thumbBmp, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("video");
        req.message = msg;
        req.scene = targetScene;
        wxapi.sendReq(req);
    }

    private static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}
