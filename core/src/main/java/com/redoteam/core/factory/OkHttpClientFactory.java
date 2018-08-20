package com.redoteam.core.factory;

import android.app.Application;
import android.support.annotation.Nullable;

import com.redoteam.core.http.GlobalHttpHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;


/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class OkHttpClientFactory {
    private static final int TIME_OUT = 10;

    public static OkHttpClient provideClient(Application application, OkHttpClient.Builder builder, Interceptor intercept
            , @Nullable List<Interceptor> interceptors, @Nullable final GlobalHttpHandler handler) {
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS).readTimeout(TIME_OUT, TimeUnit.SECONDS).addNetworkInterceptor(intercept);
        if (handler != null)
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(handler.onHttpRequestBefore(chain, chain.request()));
                }
            });
        if (interceptors != null) {
            //如果外部提供了interceptor的集合则遍历添加
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }
}
