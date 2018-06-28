package com.anjian.common;


import com.anjian.model.BaseBean;
import com.anjian.model.main.LoginModel;
import com.anjian.model.record.SysAreaModel;

import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

import static com.anjian.common.Constant.API_NO_SIGN;


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


}
