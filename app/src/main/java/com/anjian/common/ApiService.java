package com.anjian.common;


import com.anjian.model.BaseBean;
import com.anjian.model.main.LoginModel;
import com.anjian.model.record.SysAreaModel;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by lm on 2017/11/22.
 * Description:
 */

public interface ApiService {
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("security-monitor/app/login")
    Flowable<LoginModel> login(@Body RequestBody body);

    //行政规划
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @GET("security-monitor/app/sysArea/parent/{id}")
    Flowable<SysAreaModel> sysArea(@Path("id") String id ,@Query("token") String token);


    //新增企业信息
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/add")
    Flowable<BaseBean> addQiYe(@Body RequestBody body,@Query("token") String token);


    //新增三小场所信息
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/add")
    Flowable<BaseBean> addSanXiao(@Body RequestBody body,@Query("token") String token);

    //新增现场交流信息
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("security-monitor/app/localeMeeting/add")
    Flowable<BaseBean> addJiaoLiu(@Body RequestBody body,@Query("token") String token);

    //新增现危化品信息
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("security-monitor/app/dangerChemical/add")
    Flowable<BaseBean> addWeiHua(@Body RequestBody body,@Query("token") String token);
}
