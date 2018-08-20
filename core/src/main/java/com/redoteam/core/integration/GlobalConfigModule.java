
package com.redoteam.core.integration;

import android.app.Application;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.redoteam.core.http.BaseUrl;
import com.redoteam.core.http.GlobalHttpHandler;
import com.redoteam.core.http.imageloader.BaseImageLoaderStrategy;
import com.redoteam.core.http.log.DefaultFormatPrinter;
import com.redoteam.core.http.log.FormatPrinter;
import com.redoteam.core.http.log.RequestInterceptor;
import com.redoteam.core.utils.DataHelper;
import com.redoteam.core.utils.Preconditions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import retrofit2.Converter;

/**
 * ================================================
 * 建造者模式 ,可向框架中注入外部配置的自定义参数
 * <p>
 * ================================================
 */
public class GlobalConfigModule {
    private HttpUrl mApiUrl;
    private BaseUrl mBaseUrl;
    private BaseImageLoaderStrategy mLoaderStrategy;
    private GlobalHttpHandler mHandler;
    private List<Interceptor> mInterceptors;
    private Converter.Factory mGsonConverterFactory;
    //    private ResponseErrorListener mErrorListener;
    private File mCacheFile;
    //    private ClientModule.RetrofitConfiguration mRetrofitConfiguration;
//    private ClientModule.OkhttpConfiguration mOkhttpConfiguration;
//    private ClientModule.RxCacheConfiguration mRxCacheConfiguration;
//    private AppModule.GsonConfiguration mGsonConfiguration;
    private RequestInterceptor.Level mPrintHttpLogLevel;
    private FormatPrinter mFormatPrinter;
//    private Cache.Factory mCacheFactory;

    private GlobalConfigModule(Builder builder) {
        this.mApiUrl = builder.apiUrl;
        this.mBaseUrl = builder.baseUrl;
        this.mLoaderStrategy = builder.loaderStrategy;
        this.mHandler = builder.handler;
        this.mInterceptors = builder.interceptors;
        this.mGsonConverterFactory = builder.gsonConverterFactory;
//        this.mErrorListener = builder.responseErrorListener;
        this.mCacheFile = builder.cacheFile;
 /*       this.mRetrofitConfiguration = builder.retrofitConfiguration;
        this.mOkhttpConfiguration = builder.okhttpConfiguration;
        this.mRxCacheConfiguration = builder.rxCacheConfiguration;
        this.mGsonConfiguration = builder.gsonConfiguration;*/
        this.mPrintHttpLogLevel = builder.printHttpLogLevel;
        this.mFormatPrinter = builder.formatPrinter;
//        this.mCacheFactory = builder.cacheFactory;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Nullable
    public List<Interceptor> provideInterceptors() {
        return mInterceptors;
    }


    public Converter.Factory provideGsonConverterFactory() {
        return mGsonConverterFactory;
    }

    /**
     * 提供 BaseUrl,默认使用 <"https://api.github.com/">
     *
     * @return
     */

    public HttpUrl provideBaseUrl() {
        if (mBaseUrl != null) {
            HttpUrl httpUrl = mBaseUrl.url();
            if (httpUrl != null) {
                return httpUrl;
            }
        }
        return mApiUrl == null ? HttpUrl.parse("https://api.github.com/") : mApiUrl;
    }


    /**
     * 提供图片加载框架,默认使用 {@link Glide}
     *
     * @return
     */
    @Nullable
    public BaseImageLoaderStrategy provideImageLoaderStrategy() {
        return mLoaderStrategy;
    }


    /**
     * 提供处理 Http 请求和响应结果的处理类
     *
     * @return
     */

    @Nullable
    public GlobalHttpHandler provideGlobalHttpHandler() {
        return mHandler == null ? GlobalHttpHandler.EMPTY : mHandler;
    }


    /**
     * 提供缓存文件
     */

    public File provideCacheFile(Application application) {
        return mCacheFile == null ? DataHelper.getCacheFile(application) : mCacheFile;
    }


    /* */

    /**
     * 提供处理 RxJava 错误的管理器的回调
     *
     * @return
     *//*
    @Singleton
    @Provides
    ResponseErrorListener provideResponseErrorListener() {
        return mErrorListener == null ? ResponseErrorListener.EMPTY : mErrorListener;
    }*/


 /*   @Singleton
    @Provides
    @Nullable
    ClientModule.RetrofitConfiguration provideRetrofitConfiguration() {
        return mRetrofitConfiguration;
    }

    @Singleton
    @Provides
    @Nullable
    ClientModule.OkhttpConfiguration provideOkhttpConfiguration() {
        return mOkhttpConfiguration;
    }

    @Singleton
    @Provides
    @Nullable
    ClientModule.RxCacheConfiguration provideRxCacheConfiguration() {
        return mRxCacheConfiguration;
    }*/

   /* @Singleton
    @Provides
    @Nullable
    AppModule.GsonConfiguration provideGsonConfiguration() {
        return mGsonConfiguration;
    }*/
    public RequestInterceptor.Level providePrintHttpLogLevel() {
        return mPrintHttpLogLevel == null ? RequestInterceptor.Level.ALL : mPrintHttpLogLevel;
    }


    public FormatPrinter provideFormatPrinter() {
        return mFormatPrinter == null ? new DefaultFormatPrinter() : mFormatPrinter;
    }

    /*@Singleton
    @Provides
    Cache.Factory provideCacheFactory(Application application) {
        return mCacheFactory == null ? new Cache.Factory() {
            @NonNull
            @Override
            public Cache build(CacheType type) {
                //若想自定义 LruCache 的 size, 或者不想使用 LruCache, 想使用自己自定义的策略
                //使用 GlobalConfigModule.Builder#cacheFactory() 即可扩展
                switch (type.getCacheTypeId()){
                    //Activity、Fragment 以及 Extras 使用 IntelligentCache (具有 LruCache 和 可永久存储数据的 Map)
                    case CacheType.EXTRAS_TYPE_ID:
                    case CacheType.ACTIVITY_CACHE_TYPE_ID:
                    case CacheType.FRAGMENT_CACHE_TYPE_ID:
                        return new IntelligentCache(type.calculateCacheSize(application));
                    //其余使用 LruCache (当达到最大容量时可根据 LRU 算法抛弃不合规数据)
                    default:
                        return new LruCache(type.calculateCacheSize(application));
                }
            }
        } : mCacheFactory;
    }*/


    public static final class Builder {
        private HttpUrl apiUrl;
        private BaseUrl baseUrl;
        private BaseImageLoaderStrategy loaderStrategy;
        private GlobalHttpHandler handler;
        private List<Interceptor> interceptors;
        private Converter.Factory gsonConverterFactory;
        //        private ResponseErrorListener responseErrorListener;
        private File cacheFile;
        /* private ClientModule.RetrofitConfiguration retrofitConfiguration;
         private ClientModule.OkhttpConfiguration okhttpConfiguration;
         private ClientModule.RxCacheConfiguration rxCacheConfiguration;
         private AppModule.GsonConfiguration gsonConfiguration;*/
        private RequestInterceptor.Level printHttpLogLevel;
        private FormatPrinter formatPrinter;
//        private Cache.Factory cacheFactory;

        private Builder() {
        }

        public Builder baseurl(String baseUrl) {//基础url
            if (TextUtils.isEmpty(baseUrl)) {
                throw new NullPointerException("BaseUrl can not be empty");
            }
            this.apiUrl = HttpUrl.parse(baseUrl);
            return this;
        }

        public Builder baseurl(BaseUrl baseUrl) {
            this.baseUrl = Preconditions.checkNotNull(baseUrl, BaseUrl.class.getCanonicalName() + "can not be null.");
            return this;
        }

        public Builder imageLoaderStrategy(BaseImageLoaderStrategy loaderStrategy) {//用来请求网络图片
            this.loaderStrategy = loaderStrategy;
            return this;
        }

        public Builder globalHttpHandler(GlobalHttpHandler handler) {//用来处理http响应结果
            this.handler = handler;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {//动态添加任意个interceptor
            if (interceptors == null)
                interceptors = new ArrayList<>();
            this.interceptors.add(interceptor);
            return this;
        }

        public Builder gsonConverterFactory(Converter.Factory gsonConverterFactory) {
            this.gsonConverterFactory = gsonConverterFactory;
            return this;
        }


       /* public Builder responseErrorListener(ResponseErrorListener listener) {//处理所有RxJava的onError逻辑
            this.responseErrorListener = listener;
            return this;
        }*/


        public Builder cacheFile(File cacheFile) {
            this.cacheFile = cacheFile;
            return this;
        }

      /*  public Builder retrofitConfiguration(ClientModule.RetrofitConfiguration retrofitConfiguration) {
            this.retrofitConfiguration = retrofitConfiguration;
            return this;
        }

        public Builder okhttpConfiguration(ClientModule.OkhttpConfiguration okhttpConfiguration) {
            this.okhttpConfiguration = okhttpConfiguration;
            return this;
        }*/

      /*  public Builder rxCacheConfiguration(ClientModule.RxCacheConfiguration rxCacheConfiguration) {
            this.rxCacheConfiguration = rxCacheConfiguration;
            return this;
        }

        public Builder gsonConfiguration(AppModule.GsonConfiguration gsonConfiguration) {
            this.gsonConfiguration = gsonConfiguration;
            return this;
        }*/

        public Builder printHttpLogLevel(RequestInterceptor.Level printHttpLogLevel) {//是否让框架打印 Http 的请求和响应信息
            this.printHttpLogLevel = Preconditions.checkNotNull(printHttpLogLevel, "The printHttpLogLevel can not be null, use RequestInterceptor.Level.NONE instead.");
            return this;
        }

        public Builder formatPrinter(FormatPrinter formatPrinter) {
            this.formatPrinter = Preconditions.checkNotNull(formatPrinter, FormatPrinter.class.getCanonicalName() + "can not be null.");
            return this;
        }

       /* public Builder cacheFactory(Cache.Factory cacheFactory) {
            this.cacheFactory = cacheFactory;
            return this;
        }*/

        public GlobalConfigModule build() {
            return new GlobalConfigModule(this);
        }


    }


}
