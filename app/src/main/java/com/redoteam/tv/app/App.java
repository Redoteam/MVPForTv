package com.redoteam.tv.app;
import android.app.Application;
import android.content.Context;

import com.redoteam.core.delegate.AppDelegate;
import com.redoteam.video.gsyvideo.utils.VideoHelper;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class App extends Application {
    public AppDelegate getAppDelegate() {
        return appDelegate;
    }

    AppDelegate appDelegate;



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        appDelegate = AppDelegate.getInstance();
        appDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appDelegate.onCreate(this);
        AppCache.initialize(this);
        VideoHelper.initVideoOption(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        appDelegate.onTerminate(this);
    }

}
