package com.redoteam.tv.mvp.contract;

import com.redoteam.core.base.mvp.APresenter;
import com.redoteam.core.base.mvp.IModel;
import com.redoteam.core.base.mvp.IView;
import com.redoteam.tv.mvp.model.entity.User;

import io.reactivex.Observable;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public interface MainContract {
    interface View extends IView {
        void playVideo(String playUrl);
    }

    interface Model extends IModel {
        Observable<User> login();
        Observable<String> getIndexVideo();
        Observable<String> getIndexNotice();
    }

    abstract class Presenter extends APresenter<View, Model> {

        public Presenter(View mView) {
            super(mView);
        }

        public abstract void login();
    }
}
