package com.redoteam.core.utils;

import android.content.Context;

import com.redoteam.core.delegate.AppDelegate;
import com.redoteam.core.http.imageloader.ImageConfig;
import com.redoteam.core.http.imageloader.ImageLoader;

/**
 * Created by 寻水的鱼 on 2018/8/13.
 */
public class ImageManager {
    private static ImageManager INSTANCE;
    private ImageLoader mImageLoader;

    private ImageManager(ImageLoader imageLoader) {
        mImageLoader = Preconditions.checkNotNull(imageLoader, ImageLoader.class.getCanonicalName() + "can not be null.");
        mImageLoader.setLoadImgStrategy(AppDelegate.getInstance().getmGlobalConfigModule().provideImageLoaderStrategy());
    }


    public static void initialization() {
        getInstance();
    }

    public static ImageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImageManager(new ImageLoader());
        }
        return INSTANCE;
    }


    /**
     * 加载图片
     *
     * @param context
     * @param config
     * @param <T>
     */
    public <T extends ImageConfig> void loadImage(Context context, T config) {
        mImageLoader.loadImage(context, config);
    }

    /**
     * 停止加载或清理缓存
     *
     * @param context
     * @param config
     * @param <T>
     */
    public <T extends ImageConfig> void clear(Context context, T config) {
        mImageLoader.clear(context, config);
    }

}
