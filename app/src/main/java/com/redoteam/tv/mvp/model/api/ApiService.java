package com.redoteam.tv.mvp.model.api;

import com.redoteam.tv.mvp.model.entity.Consult;
import com.redoteam.tv.mvp.model.entity.Node;
import com.redoteam.tv.mvp.model.entity.TranscodingMonitor;
import com.redoteam.tv.mvp.model.entity.TranscodingVideo;
import com.redoteam.tv.mvp.model.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 寻水的鱼 on 2018/8/12.
 */
public interface ApiService {
    String APP_DOMAIN = "http://www.baidu.com/";
    String RequestSuccess = "0";
    String LOGIN_USER_ACCOOUNT = "18212345678";
    String LOGIN_USER_PWD = "654321";
    String LOGIN_USER_SERIALNO = "808777664989482";
    String REGION_ID = "230281001000";
    String PAGE_SIZE = "20";


    /**
     * 登录
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/signin")
    Observable<User> login(@FieldMap Map<String, String> map);


    /**
     * 获取栏目内容
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/getNodeContents")
    Observable<Node> getNodeContents(@FieldMap Map<String, String> map);


    /**
     * 获取首页视频
     *
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/getIndexVideoPlus")
    Observable<String> getIndexVideo(@Field("TOKEN") String token);



    /**
     * 获取首页滚动字幕
     *
     * @return
     */

    @GET("/webRoot/230281000000/data/230281000000/230281000000_0.js")
    Observable<String> getIndexNotice(@Query("TOKEN") String token);





    /**
     * 获取投票结果
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/getVote")
    Observable<List<Consult>> getVoteResult(@FieldMap Map<String, String> map);


    /**
     * 投票
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/voteConsult")
    Observable<String> vote(@FieldMap Map<String, String> map);


    /**
     * 投票
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/getPlayUrl")
    Observable<TranscodingMonitor> getMonitorPlayUrl(@FieldMap Map<String, String> map);


    /**
     * 投票
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/wasuCMS/Interface/getPlayUrl")
    Observable<TranscodingVideo> getVideoPlayUrl(@FieldMap Map<String, String> map);
}
