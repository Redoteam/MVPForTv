package com.redoteam.tv.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.redoteam.tv.app.Constant;
import com.redoteam.tv.common.activity.PreviewImageActivity;
import com.redoteam.video.gsyvideo.utils.VideoJumpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 寻水的鱼 on 2018/8/14.
 */
public class JumpUtils
{
    /***
     * 全屏视频
     * @param mContext
     * @param path
     * @param loop 是否循环播放
     * @param time 指定开始播放的位置
     */
    public static void gotoFullVideo(Context mContext, String path, boolean loop, long time){
        VideoJumpUtils.gotoFullVideo(mContext,path,loop,time);
    }


    /**
     * 打开大图
     * @param context
     * @param images    图片集合
     * @param desc      图片对应的说明集合,可以传null
     * @param showIndex 要显示的Index
     */
    public static void gotoPreviewImageActivity(Context context, @NonNull List<String> images, @Nullable List<String> desc, int showIndex) {
        Intent intent = new Intent(context, PreviewImageActivity.class);
        intent.putStringArrayListExtra(Constant.KEY_BEAN, (ArrayList<String>) images);
        intent.putStringArrayListExtra(Constant.KEY_BEAN_2, (ArrayList<String>) desc);
        intent.putExtra(Constant.KEY_INT_1, showIndex);
        context.startActivity(intent);
    }
}
