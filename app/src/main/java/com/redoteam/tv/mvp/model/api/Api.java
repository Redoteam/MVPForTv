package com.redoteam.tv.mvp.model.api;

import com.redoteam.tv.app.AppCache;
import com.redoteam.tv.mvp.model.entity.Consult;
import com.redoteam.tv.mvp.model.entity.Node;
import com.redoteam.tv.mvp.model.entity.TranscodingMonitor;
import com.redoteam.tv.mvp.model.entity.TranscodingVideo;
import com.redoteam.tv.mvp.model.entity.User;
import com.redoteam.core.http.ApiEngine;
import com.redoteam.core.http.RxSchedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by 寻水的鱼 on 2018/8/13.
 */
public class Api {
    private static final String TAG = "Api";
    private static final ApiService API_SERVICE = ApiEngine.getInstance().obtainRetrofitService(ApiService.class);



    /**
     * 登录
     *
     * @return
     */
    public static Observable<User> login() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("phoneNo", ApiService.LOGIN_USER_ACCOOUNT);
        params.put("userPwd", ApiService.LOGIN_USER_PWD);
        params.put("serialNo", ApiService.LOGIN_USER_SERIALNO);
        return API_SERVICE.login(params).compose(RxSchedulers.<User>io_main());
    }

    /**
     * 登录
     *
     * @return
     */
    public static Observable<Node> getNodeContents(String nodeId,String page) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("TOKEN", AppCache.getInstance().getToken());
        params.put("regionId",ApiService.REGION_ID);
        params.put("nodeCode", nodeId);
        params.put("pageSize", ApiService.PAGE_SIZE);
        params.put("page", page);
        return API_SERVICE.getNodeContents(params).compose(RxSchedulers.<Node>io_main());
    }

    /**
     * 获取首页视频
     * @return
     */
    public static Observable<String> getIndexVideo() {
        return API_SERVICE.getIndexVideo(AppCache.getInstance().getToken()).compose(RxSchedulers.<String>io_main());
    }


    /**
     * 获取投票结果
     * @param conId
     * @param consultId
     * @return
     */
    public static Observable<List<Consult>> getVoteResult(String conId, String consultId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("TOKEN", AppCache.getInstance().getToken());
        params.put("conId", conId);
        params.put("consultId", consultId);
        return API_SERVICE.getVoteResult(params).compose(RxSchedulers.<List<Consult>>io_main());
    }


    /**
     * 投票
     * @param conId
     * @param optId
     * @return
     */
    public static Observable<String> vote(String conId, String optId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("TOKEN", AppCache.getInstance().getToken());
        params.put("conId", conId);
        params.put("optId", optId);
        return API_SERVICE.vote(params).compose(RxSchedulers.<String>io_main());
    }

    /**
     * 获取监控播放地址
     * @param conId
     * @return
     */
    public static Observable<TranscodingMonitor> getMonitorPlayUrl(String conId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("TOKEN", AppCache.getInstance().getToken());
        params.put("contentId", conId);
        return API_SERVICE.getMonitorPlayUrl(params).compose(RxSchedulers.<TranscodingMonitor>io_main());
    }

    /**
     * 获取视频播放地址
     * @param conId
     * @return
     */
    public static Observable<TranscodingVideo> getVideoPlayUrl(String conId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("TOKEN", AppCache.getInstance().getToken());
        params.put("contentId", conId);
        return API_SERVICE.getVideoPlayUrl(params).compose(RxSchedulers.<TranscodingVideo>io_main());
    }

    /**
     * 获取首页滚动字幕
     *
     * @return
     */

    public static Observable<String> getIndexNotice(){
        return API_SERVICE.getIndexNotice(AppCache.getInstance().getToken()).compose(RxSchedulers.<String>io_main());
    }
}
