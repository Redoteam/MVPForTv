package com.redoteam.tv.mvp.presenter;

import com.redoteam.tv.app.AppCache;
import com.redoteam.tv.mvp.contract.MainContract;
import com.redoteam.tv.mvp.model.MainModel;
import com.redoteam.tv.mvp.model.entity.User;
import com.redoteam.core.http.RxSubscriber;
import com.redoteam.core.utils.LogUtils;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class MainPresenter extends MainContract.Presenter {
    public MainPresenter(MainContract.View mView) {
        super(mView);
    }

    @Override
    protected MainContract.Model initModel() {
        return new MainModel();
    }

    public void login() {
        addDispose(new RxSubscriber<User>(mModel.login()) {

            @Override
            protected void _onNext(User user) {
//                user.saveUser();
                AppCache.getInstance().saveUser(user);
                AppCache.getInstance().saveToken(user.getToken());
                getIndexNotice();
                getIndexVideo();
            }

            @Override
            protected void _onError(String code, String msg) {
                LogUtils.errorInfo("MainPresenter", "_onError()");

                mView.get().showError(code, msg);
                super._onError(code, msg);
            }
        });
    }

    public void getIndexNotice(){
        addDispose(new RxSubscriber<String>(mModel.getIndexNotice())
        {
            @Override
            protected void _onNext(String notice)
            {

            }
        });
    }

    public void getIndexVideo(){
        addDispose(new RxSubscriber<String>(mModel.getIndexVideo())
        {
            @Override
            protected void _onNext(String videoPath)
            {
                String url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
                mView.get().playVideo(url);
            }
        });
    }
}
