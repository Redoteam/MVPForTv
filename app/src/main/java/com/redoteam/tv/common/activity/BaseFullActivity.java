package com.redoteam.tv.common.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.redoteam.core.base.activity.BaseActivity;
import com.redoteam.core.base.mvp.IPresenter;

/**
 * Created by 寻水的鱼 on 2018/8/15.
 */
public abstract class BaseFullActivity<P extends IPresenter> extends BaseActivity<P>
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }
}
