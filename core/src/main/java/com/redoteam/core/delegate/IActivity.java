package com.redoteam.core.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.redoteam.core.base.mvp.IPresenter;


/**
 * ================================================
 * 框架要求框架中的每个 {@link Activity} 都需要实现此类,以满足规范
 * <p>
 * ================================================
 */
public interface IActivity {
    int initView(@Nullable Bundle savedInstanceState);
    void initData(@Nullable Bundle savedInstanceState);
    IPresenter initPresenter();
}
