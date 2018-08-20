package com.redoteam.core.delegate;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.redoteam.core.http.ApiEngine;
import com.redoteam.core.integration.ConfigModule;
import com.redoteam.core.integration.GlobalConfigModule;
import com.redoteam.core.integration.ManifestParser;
import com.redoteam.core.utils.ImageManager;
import com.redoteam.core.utils.TimberUtil;

import java.util.List;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class AppDelegate implements AppLifecycles {
    private List<ConfigModule> mModules;
    private Application mApplication;
    private GlobalConfigModule mGlobalConfigModule;
    private static AppDelegate instance;

    private AppDelegate() {
    }

    public static AppDelegate getInstance() {
        if (instance == null) {
            instance = new AppDelegate();
        }
        return instance;
    }


    @Override
    public void attachBaseContext(@NonNull Context base) {
        this.mModules = new ManifestParser(base).parse();
    }

    @Override
    public void onCreate(@NonNull Application application) {
        // GlobalConfigModule 的优先级最高，必须第一个初始化
        mGlobalConfigModule = getGlobalConfigModule(application, mModules);
        //ApiEngine的初始化在 getGlobalConfigModule() 之后
        ApiEngine.initialization();
        ImageManager.initialization();
        //设置log自动在apk为debug版本时打开，在release版本时关闭
        TimberUtil.setLogAuto();
        //也可以设置log一直开
        //TimberUtil.setLogDebug();
        mApplication = application;
    }

    @Override
    public void onTerminate(@NonNull Application application) {
    }

    /**
     * 将app的全局配置信息封装进module(使用Dagger注入到需要配置信息的地方)
     * 需要在AndroidManifest中声明{@link ConfigModule}的实现类,和Glide的配置方式相似
     *
     * @return GlobalConfigModule
     */
    private GlobalConfigModule getGlobalConfigModule(Context context, List<ConfigModule> modules) {
        GlobalConfigModule.Builder builder = GlobalConfigModule.builder();
        //遍历 ConfigModule 集合, 给全局配置 GlobalConfigModule 添加参数
        for (ConfigModule module : modules) {
            module.applyOptions(context, builder);
        }
        return builder.build();
    }

    public Application getmApplication() {
        return mApplication;
    }

    public GlobalConfigModule getmGlobalConfigModule() {
        return mGlobalConfigModule;
    }
}
