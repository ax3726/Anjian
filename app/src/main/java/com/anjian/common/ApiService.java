package com.anjian.common;


import com.anjian.model.BaseBean;
import com.anjian.model.main.LoginModel;
import com.anjian.model.record.FengXianListModel;
import com.anjian.model.record.JiaoLiuListModel;
import com.anjian.model.record.SearchModel;
import com.anjian.model.record.SysAreaModel;
import com.anjian.model.record.TeZhongListModel;
import com.anjian.model.record.WeiHuaListModel;
import com.anjian.model.record.XiaoFangListModel;
import com.anjian.model.record.YanLianListModel;

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
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/login")
    Flowable<LoginModel> login(@Body RequestBody body);

    //行政规划
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/sysArea/parent/{id}")
    Flowable<SysAreaModel> sysArea(@Path("id") String id, @Query("token") String token);

    //搜索
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/enterpriseInfo/vagueSearch")
    Flowable<SearchModel> search(@Query("token") String token, @Query("keyWord") String keyWord);

    //新增企业信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/add")
    Flowable<BaseBean> addQiYe(@Body RequestBody body, @Query("token") String token);

    //企业列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/enterprise")
    Flowable<BaseBean> qiYeList(@Body RequestBody body, @Query("token") String token);

    //三小场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/tsp")
    Flowable<BaseBean> sanXiaoList(@Body RequestBody body, @Query("token") String token);

    //新增三小场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspInfo/add")
    Flowable<BaseBean> addSanXiao(@Body RequestBody body, @Query("token") String token);

    //新增现场交流信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeMeeting/add")
    Flowable<BaseBean> addJiaoLiu(@Body RequestBody body, @Query("token") String token);

    //更新现场交流信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeMeeting/update")
    Flowable<BaseBean> updateJiaoLiu(@Body RequestBody body, @Query("token") String token);

    //现场交流列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeMeeting/list")
    Flowable<JiaoLiuListModel> getJiaoLiuList(@Body RequestBody body, @Query("token") String token);

    //新增现危化品信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dangerChemical/add")
    Flowable<BaseBean> addWeiHua(@Body RequestBody body, @Query("token") String token);


    //现危化品列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dangerChemical/list")
    Flowable<WeiHuaListModel> getWeiHuaList(@Body RequestBody body, @Query("token") String token);

    //新增特种设备信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/specialDevice/add")
    Flowable<BaseBean> addTeZhong(@Body RequestBody body, @Query("token") String token);

    //新增特种设备信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/specialDevice/list")
    Flowable<TeZhongListModel> getTeZhongList(@Body RequestBody body, @Query("token") String token);

    //新增消防设施信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/fireDevice/add")
    Flowable<BaseBean> addXiaoFang(@Body RequestBody body, @Query("token") String token);

    //消防设施列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/fireDevice/list")
    Flowable<XiaoFangListModel>getXiaoFangList(@Body RequestBody body, @Query("token") String token);

    //新增安全生产风险辨识信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dangerIdentification/add")
    Flowable<BaseBean> addFengXian(@Body RequestBody body, @Query("token") String token);


    //安全生产风险辨识列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dangerIdentification/list")
    Flowable<FengXianListModel> getFengXianList(@Body RequestBody body, @Query("token") String token);


    //新增培训演练
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspTeachAct/add")
    Flowable<BaseBean> addYanLian(@Body RequestBody body, @Query("token") String token);

    //培训演练列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspTeachAct/list")
    Flowable<YanLianListModel> getYanLianList(@Body RequestBody body, @Query("token") String token);


    //三小场所选项列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspOption/list")
    Flowable<BaseBean> getSanXiaoSelectList(@Body RequestBody body, @Query("token") String token);
}
