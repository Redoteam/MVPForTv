package com.redoteam.tv.common.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.redoteam.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.redoteam.core.base.mvp.IPresenter;

import butterknife.BindView;


/**
 * Created by 寻水的鱼 on 2018/8/14.
 */
public abstract class BaseVideoActivity<P extends IPresenter> extends BaseFullActivity<P>
{
    public static final int FULLSCREEN_ID = com.shuyu.gsyvideoplayer.R.id.full_id;
    @BindView(R.id.video_player)
    public StandardGSYVideoPlayer gsyVideoPlayer;

    private OrientationUtils orientationUtils;

    @Override
    public int initView(@Nullable Bundle savedInstanceState)
    {

        return R.layout.activity_base_video;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState)
    {

    }

    public void initVideoSetting()
    {
        //注意，这是全局生效的
        GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_DEFAULT);
        //外部辅助的旋转，帮助全屏
        orientationUtils = new OrientationUtils(this, gsyVideoPlayer);
        orientationUtils.setRotateWithSystem(false);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);
        gsyVideoPlayer.setRotateViewAuto(true);
        gsyVideoPlayer.setLockLand(false);
        gsyVideoPlayer.setVideoAllCallBack(new GSYSampleCallBack()
        {
            @Override
            public void onPrepared(String url, Object... objects)
            {
                super.onPrepared(url, objects);
                orientationUtils.setEnable(true);
            }

            @Override
            public void onEnterFullscreen(String url, Object... objects)
            {
                super.onEnterFullscreen(url, objects);
                gsyVideoPlayer.getBackButton().setVisibility(View.VISIBLE);
                gsyVideoPlayer.getCurrentPlayer().getTitleTextView().setText((String) objects[0]);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects)
            {
                super.onQuitFullscreen(url, objects);
                gsyVideoPlayer.getBackButton().setVisibility(View.GONE);
            }
        });
    }


    public void playVideo(String playUrl)
    {
        gsyVideoPlayer.setUp(playUrl, false, "");
        gsyVideoPlayer.startPlayLogic();
    }

    @Override
    public void onResume()
    {
        initVideoSetting();
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onDestroy()
    {
        GSYVideoManager.releaseAllVideos();
        super.onDestroy();
    }

    @Override
    public void onBackPressed()
    {
        if (GSYVideoManager.backFromWindowFull(this))
        {
            return;
        }
        super.onBackPressed();
    }

    /**
     * 进入全屏播放
     *
     * @param actionBar 是否有actionBar，有的 true
     * @param statusBar 是否有状态bar，有的话需要隐藏 true , 没有 false
     */
    public void gotoFullVideo(boolean actionBar,boolean statusBar)
    {
        ViewGroup vp = (ViewGroup) (CommonUtil.scanForActivity(this)).findViewById(Window.ID_ANDROID_CONTENT);
        View oldF = vp.findViewById(FULLSCREEN_ID);
        if(oldF == null)
        {
            if (orientationUtils != null)
            {
                orientationUtils.backToProtVideo();
            }
            gsyVideoPlayer.startWindowFullscreen(this, actionBar, statusBar);
        }
    }

    /**
     * 进入全屏播放
     *
     */
    public void gotoFullVideo()
    {
        ViewGroup vp = (ViewGroup) (CommonUtil.scanForActivity(this)).findViewById(Window.ID_ANDROID_CONTENT);
        View oldF = vp.findViewById(FULLSCREEN_ID);
        if(oldF == null){
            if (orientationUtils != null)
            {
                orientationUtils.backToProtVideo();
            }
            gsyVideoPlayer.startWindowFullscreen(this, false, false);
        }

    }

}
