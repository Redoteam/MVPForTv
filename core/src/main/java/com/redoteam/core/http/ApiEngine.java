package com.redoteam.core.http;

import android.app.Application;

import com.google.gson.Gson;
import com.redoteam.core.delegate.AppDelegate;
import com.redoteam.core.factory.OkHttpClientFactory;
import com.redoteam.core.factory.RetrofitFactory;
import com.redoteam.core.http.log.RequestInterceptor;
import com.redoteam.core.integration.GlobalConfigModule;
import com.redoteam.core.utils.Preconditions;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class ApiEngine {
    private volatile static ApiEngine apiEngine;

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private final OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public static void initialization() {
//        ApiEngine.mGlobalConfigModule = globalConfigModule;
        getInstance();
    }

    private static GlobalConfigModule mGlobalConfigModule;

    private ApiEngine() {

        //日志拦截器
        /*HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);*/


        //缓存
       /* int size = 1024 * 1024 * 100;
        File cacheFile = new File(App.getContext().getCacheDir(), "OkHttpCache");
        Cache cache = new Cache(cacheFile, size);*/

      /*  OkHttpClient client = new OkHttpClient.Builder().connectTimeout(12, TimeUnit.SECONDS).writeTimeout(12, TimeUnit.SECONDS).writeTimeout(12, TimeUnit.SECONDS).addNetworkInterceptor(requestInterceptor).addInterceptor(new Interceptor()
        {
            @Override
            public Response intercept(Chain chain) throws IOException
            {
                return chain.proceed(globalHttpHandler.onHttpRequestBefore(chain, chain.request()));
            }
        })
//                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder().baseUrl(ApiService.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();*/

        mGlobalConfigModule = AppDelegate.getInstance().getmGlobalConfigModule();
        mGlobalConfigModule = Preconditions.checkNotNull(mGlobalConfigModule, GlobalConfigModule.class.getCanonicalName() + "can not be null.");
        Application application = AppDelegate.getInstance().getmApplication();
        RequestInterceptor requestInterceptor = new RequestInterceptor(mGlobalConfigModule.provideGlobalHttpHandler(), mGlobalConfigModule.provideFormatPrinter(), mGlobalConfigModule.providePrintHttpLogLevel());
        okHttpClient = OkHttpClientFactory.provideClient(application, new OkHttpClient.Builder(), requestInterceptor, mGlobalConfigModule.provideInterceptors(), mGlobalConfigModule.provideGlobalHttpHandler());
        retrofit = RetrofitFactory.provideRetrofit(application, new Retrofit.Builder(), okHttpClient, mGlobalConfigModule.provideBaseUrl(), mGlobalConfigModule.provideGsonConverterFactory(), new Gson());
        mGlobalConfigModule = null;
    }


    public static ApiEngine getInstance() {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine();
                }
            }
        }
        return apiEngine;
    }

   /* public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }*/

    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service
     * @param <T>
     * @return
     */

    public synchronized <T> T obtainRetrofitService(Class<T> service) {
        return retrofit.create(service);
    }

}

