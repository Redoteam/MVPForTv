package com.redoteam.tv.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.redoteam.core.base.mvp.IPresenter;
import com.redoteam.R;
import com.redoteam.tv.app.Constant;
import com.redoteam.tv.utils.JumpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 寻水的鱼 on 2018/8/14.
 */
public abstract class BaseWebActivity<P extends IPresenter> extends BaseFullActivity<P>
{
    @BindView(R.id.web)
    protected WebView mWebView;
    @Override
    public int initView(@Nullable Bundle savedInstanceState)
    {
        return R.layout.activity_base_web;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState)
    {
        initWebSetting();
    }

    protected void initWebSetting(){
        mWebView.setClickable(false);
        mWebView.setFocusable(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.addJavascriptInterface(BaseWebActivity.this, "imagelistener");
        WebSettings settings = mWebView.getSettings();
        settings.setDefaultFontSize(16);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setPluginState(WebSettings.PluginState.ON);
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img, String[] imageUrls, int position) {
        if (imageUrls == null) {
            return;
        }
        if (position >= imageUrls.length) {
            position = 0;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            list.add(imageUrls[i]);
        }
        JumpUtils.gotoPreviewImageActivity(this, list, null, position);
    }

    protected void setHtml(String content) {
        mWebView.loadDataWithBaseURL(null, Constant.HTML_START_WITH_CLICK + content + Constant.HTML_END, "text/html", "utf-8", null);
    }
}
