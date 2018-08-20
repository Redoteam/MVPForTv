package com.redoteam.tv.app;

import android.content.Context;

import com.redoteam.core.http.imageloader.glide.GlideImageLoaderStrategy;
import com.redoteam.core.http.log.RequestInterceptor;
import com.redoteam.core.integration.ConfigModule;
import com.redoteam.core.integration.GlobalConfigModule;
import com.redoteam.BuildConfig;
import com.redoteam.tv.http.gson.GsonConverterFactory;
import com.redoteam.tv.mvp.model.api.ApiService;


/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        if (!BuildConfig.LOG_DEBUG) { //Release 时,让框架不再打印 Http 请求和响应的信息
            // builder.printHttpLogLevel(RequestInterceptor.Level.NONE);
        }

        builder.baseurl(ApiService.APP_DOMAIN)
                .printHttpLogLevel(RequestInterceptor.Level.ALL)
                .imageLoaderStrategy(new GlideImageLoaderStrategy())
                .gsonConverterFactory(GsonConverterFactory.create())
                .globalHttpHandler(new GlobalHttpHandlerImpl(context));
    }
}
