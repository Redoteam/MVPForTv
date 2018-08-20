package com.redoteam.core.base.mvp;

import com.redoteam.core.http.RxManager;
import com.redoteam.core.http.RxSubscriber;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.Disposable;

/**
 * Created by 寻水的鱼 on 2018/8/1.
 */
public abstract class APresenter<V extends IView, M extends IModel> implements IPresenter {
    protected WeakReference<V> mView;
    protected M mModel;

    public RxManager getRxManager() {
        return mRxManager == null ? new RxManager() : mRxManager;
    }

    protected RxManager mRxManager;

    public APresenter(V view) {
        this.mView = new WeakReference<V>(view);
        mModel = initModel();
    }

    @Override
    public void onStart() {
    }

    protected abstract M initModel();

    @Override
    public void onDestroy() {
        unDispose();
        if (mView != null) {
            V v = mView.get();
            v = null;
        }
        mView = null;
        if (mModel != null) {
            mModel.onDestroy();
        }
        mModel = null;
    }


    public void addDispose(Disposable disposable) {
        if (mRxManager == null) {
            mRxManager = new RxManager();
        }
        mRxManager.add(disposable);//将所有 Disposable 放入集中处理
    }

    public void addDispose(RxSubscriber disposable) {
        if (mRxManager == null) {
            mRxManager = new RxManager();
        }
        mRxManager.add(disposable);//将所有 Disposable 放入集中处理
    }

    /**
     * 停止集合中正在执行的 RxJava 任务
     */
    public void unDispose() {
        if (mRxManager != null) {
            mRxManager.clear();//保证 Activity 结束时取消所有正在执行的订阅
        }
    }
}
