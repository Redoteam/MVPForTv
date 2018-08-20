package com.redoteam.tv.common.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.redoteam.core.integration.AppManager;
import com.redoteam.R;
import com.redoteam.tv.app.Constant;
import com.redoteam.tv.common.adapter.BigImagePreviewAdapter;
import com.redoteam.tv.utils.JumpUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * 大图浏览页面，Use {@link JumpUtils#gotoPreviewImageActivity(Context, List, List, int)}
 */
public class PreviewImageActivity extends AppCompatActivity
{
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_preview_image);
        AppManager.getAppManager().addActivity(this);
        viewPager = findViewById(R.id.viewpage);
        initData();
    }

    private void initData()
    {
        Intent intent = getIntent();
        ArrayList<String> urls = intent.getStringArrayListExtra(Constant.KEY_BEAN);
        ArrayList<String> titls = intent.getStringArrayListExtra(Constant.KEY_BEAN_2);
        BigImagePreviewAdapter bigImagePreviewAdapter = new BigImagePreviewAdapter(this, titls, urls);
        viewPager.setAdapter(bigImagePreviewAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {

            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                if(state == 1){
                    Glide.with(PreviewImageActivity.this).pauseRequests();
                }else if(state == 2){
                    Glide.with(PreviewImageActivity.this).resumeRequests();
                }
            }
        });
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
    }
}
