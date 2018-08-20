package com.redoteam.core.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.InflateException;
import android.widget.Toast;

import com.redoteam.core.base.mvp.IPresenter;
import com.redoteam.core.base.mvp.IView;
import com.redoteam.core.delegate.IActivity;
import com.redoteam.core.integration.AppManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView, IActivity {
    protected P mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        try {
            int layoutResID = initView(savedInstanceState);
            if (layoutResID != 0) {
                setContentView(layoutResID);
                mUnbinder = ButterKnife.bind(this);
            }
        } catch (Exception e) {
            if (e instanceof InflateException) throw e;
            e.printStackTrace();
        }
        mPresenter = initPresenter();
        initData(savedInstanceState);
    }


    @Override
    public abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
        if (mPresenter != null)
            mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        AppManager.getAppManager().removeActivity(this);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showError(String code, String messaege) {
        Toast.makeText(this, messaege, Toast.LENGTH_SHORT).show();
    }
}
