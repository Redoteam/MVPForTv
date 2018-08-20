package com.redoteam.tv.mvp.ui.activity;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import com.redoteam.R;
import com.redoteam.tv.common.activity.BaseVideoActivity;
import com.redoteam.tv.mvp.contract.MainContract;
import com.redoteam.tv.mvp.presenter.MainPresenter;
import com.open.androidtvwidget.bridge.EffectNoDrawBridge;
import com.open.androidtvwidget.view.MainUpView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseVideoActivity<MainContract.Presenter> implements MainContract.View
{

    @BindView(R.id.mainUpView)
    MainUpView mainUpView;
    @BindView(R.id.content)
    FrameLayout content;
    private View mOldFocus;

    @Override
    public int initView(@Nullable Bundle savedInstanceState)
    {
        return R.layout.activity_main;
    }

    @Override
    public MainContract.Presenter initPresenter()
    {
        return new MainPresenter(this);
    }


    @Override
    public void initData(@Nullable Bundle savedInstanceState)
    {
        super.initData(savedInstanceState);
        float density = getResources().getDisplayMetrics().density;
        RectF rectf = new RectF(getDimension(R.dimen.px_10) * density, getDimension(R.dimen.px_10) * density, getDimension(R.dimen.px_10) * density, getDimension(R.dimen.px_10) * density);
        EffectNoDrawBridge effectNoDrawBridge = new EffectNoDrawBridge();
        effectNoDrawBridge.setTranDurAnimTime(200);
        effectNoDrawBridge.setDrawUpRectPadding(rectf);
        mainUpView.setEffectBridge(effectNoDrawBridge); // 4.3以下版本边框移动.
        mainUpView.setUpRectResource(R.drawable.white_light_10); // 设置移动边框的图片.
        content.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener()
        {
            @Override
            public void onGlobalFocusChanged(final View oldFocus, final View newFocus)
            {
                if (newFocus != null)
                    newFocus.bringToFront(); // 防止放大的view被压在下面. (建议使用MainLayout)
                float scale = 1.15f;
                mainUpView.setFocusView(newFocus, mOldFocus, scale);
                mOldFocus = newFocus; // 4.3以下需要自己保存.
            }
        });
        mPresenter.login();
    }

    public float getDimension(int id)
    {
        return getResources().getDimension(id);
    }



    @OnClick(R.id.video_player)
    public void onViewClicked()
    {
        gotoFullVideo();
    }
}
