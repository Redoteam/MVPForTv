package com.redoteam.tv.mvp.model;

import com.redoteam.tv.mvp.contract.MainContract;
import com.redoteam.tv.mvp.model.api.Api;
import com.redoteam.tv.mvp.model.entity.User;

import io.reactivex.Observable;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public class MainModel implements MainContract.Model {
    @Override
    public void onDestroy() {
    }

    @Override
    public Observable<User> login()
    {
        return Api.login();
    }

    @Override
    public Observable<String> getIndexVideo(){
        return Api.getIndexVideo();
    }

    @Override
    public Observable<String> getIndexNotice()
    {
        return Api.getIndexNotice();
    }
}
