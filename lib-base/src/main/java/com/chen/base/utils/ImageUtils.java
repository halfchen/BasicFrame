package com.chen.base.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chen.base.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

public class ImageUtils {

    private static ImageUtils imageUtils;

    public static ImageUtils newInstance() {
        if (imageUtils == null) {
            imageUtils = new ImageUtils();
        }
        return imageUtils;
    }

    /**
     * 加载图片
     *
     * @param uri
     * @param imageView
     */
    public void load(Uri uri, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(uri)
                .error(R.mipmap.icon_error)
                .into(imageView);
    }

    public void load(Integer resId, ImageView imageView) {
        imageView.setImageResource(resId);
    }

    /**
     * 加载图片
     *
     * @param path
     * @param imageView
     */
    public void load(String path, ImageView imageView) {
        Glide.with(imageView.getContext())
                .asDrawable()
                .load(path)
                .error(R.mipmap.icon_error)
                .into(imageView);
    }

    /**
     * 宽高等比加载图片
     *
     * @param path
     * @param imageView
     * @param width
     */
    public void loadFit(String path, ImageView imageView, int width) {
        Glide.with(imageView.getContext())
                .load(path)
                .override(width, SIZE_ORIGINAL)
                .fitCenter()
                .into(imageView);
    }

    /**
     * 高斯模糊
     *
     * @param url
     * @param imageView
     */
    public void blurTransformation(String url, ImageView imageView) {
        // "50":模糊度；"8":图片缩放4倍后再进行模糊
        Glide.with(imageView.getContext())
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.mipmap.icon_error)
                .placeholder(R.drawable.shape_bg_loading)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .transform(new BlurTransformation(50, 8))
                .into(imageView);
    }

    /**
     * 高斯模糊
     *
     * @param url
     * @param imageView
     */
    public void blurTransformation(int url, ImageView imageView) {
        // "50":模糊度；"8":图片缩放4倍后再进行模糊
        Glide.with(imageView.getContext())
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.mipmap.icon_error)
                .placeholder(R.drawable.shape_bg_loading)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .transform(new BlurTransformation(50, 8))
                .into(imageView);
    }

    /**
     * 获取图片颜色
     *
     * @param url
     * @param imageView
     */
    public int[] loadPickColor(String url, ImageView imageView) {
        final int[] darkColor = new int[2];
        Glide.with(imageView.getContext()).asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                if (palette == null) return;
                                if (palette.getDarkVibrantColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    darkColor[0] = palette.getDarkVibrantColor(Color.TRANSPARENT);
                                    darkColor[1] = palette.getVibrantColor(Color.TRANSPARENT);
                                } else if (palette.getDarkMutedColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    darkColor[0] = palette.getDarkMutedColor(Color.TRANSPARENT);
                                    darkColor[1] = palette.getMutedColor(Color.TRANSPARENT);
                                } else {
                                    darkColor[0] = palette.getLightMutedColor(Color.TRANSPARENT);
                                    darkColor[1] = palette.getLightVibrantColor(Color.TRANSPARENT);
                                }
                            }
                        });
                    }
                });
        return darkColor;
    }

    //创建线性渐变背景色
    private void createLinearGradientBitmap(int darkColor, int color, ImageView ivBg) {
        int bgColors[] = new int[2];
        bgColors[0] = darkColor;
        bgColors[1] = darkColor;

        Bitmap bgBitmap = Bitmap.createBitmap(ivBg.getWidth(), ivBg.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        canvas.setBitmap(bgBitmap);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LinearGradient gradient = new LinearGradient(0, 0, 0, bgBitmap.getHeight(), bgColors[0], bgColors[1], Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
        canvas.drawRoundRect(rectF, 20, 20, paint);
        canvas.drawRect(rectF, paint);
        ivBg.setImageBitmap(bgBitmap);
    }

    /**
     * 加载圆角图,暂时用到显示头像
     */
    public void displayCircle(String imageUrl, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .error(R.mipmap.ic_avatar_default)
                .transform(new CircleCrop())
//                .apply(bitmapTransform(new CircleCrop()))
//                .transform(new GlideCircleTransform())
//                .transform(new RoundedCorners(20))
//                .transform(new CenterCrop(), new RoundedCorners(20))
                .into(imageView);
    }
}
