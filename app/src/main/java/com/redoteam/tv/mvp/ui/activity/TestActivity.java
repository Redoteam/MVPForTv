package com.redoteam.tv.mvp.ui.activity;

import android.os.Bundle;

import com.redoteam.core.base.mvp.IPresenter;
import com.redoteam.R;
import com.redoteam.tv.common.activity.BaseVideoActivity;

import butterknife.OnClick;

public class TestActivity extends BaseVideoActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView();
    }

   /* @Override
    public int initView(@Nullable Bundle savedInstanceState)
    {
        return R.layout.activity_test;
    }*/

    @Override
    public IPresenter initPresenter()
    {
        String url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
        playVideo(url);

        return null;
    }



    @OnClick(R.id.video_player)
    public void onClick(){
        gotoFullVideo();
    }
    public float getDimension(int id)
    {
        return getResources().getDimension(id);
    }

   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_ENTER||keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
            gotoFullVideo();
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
