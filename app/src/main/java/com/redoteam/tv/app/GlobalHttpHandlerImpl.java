package com.redoteam.tv.app;

import android.content.Context;

import com.redoteam.core.http.GlobalHttpHandler;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ================================================
 * 展示 {@link GlobalHttpHandler} 的用法
 * ================================================
 */
public class GlobalHttpHandlerImpl implements GlobalHttpHandler {
    private Context context;

    public GlobalHttpHandlerImpl(Context context) {
        this.context = context;
    }


    @Override
    public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
        return response;
    }

    @Override
    public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
        return request;
    }
}
