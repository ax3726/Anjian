package com.anjian.common;


import com.anjian.model.BaseBean;
import com.anjian.model.main.LoginModel;
import com.anjian.model.main.UserInfoModel;
import com.anjian.model.record.CompanyLisyModel;
import com.anjian.model.record.FenChengListModel;
import com.anjian.model.record.FengXianListModel;
import com.anjian.model.record.JiaoLiuListModel;
import com.anjian.model.record.QiYeCheckListModel;
import com.anjian.model.record.QiYeInfoModel;
import com.anjian.model.record.QiyeSelectListModel;
import com.anjian.model.record.SanXiaoCheckListModel;
import com.anjian.model.record.SanXiaoInfoModel;
import com.anjian.model.record.SanXiaoSelectModel;
import com.anjian.model.record.SearchModel;
import com.anjian.model.record.SearchSanXiaoModel;
import com.anjian.model.record.SysAreaModel;
import com.anjian.model.record.TeZhongListModel;
import com.anjian.model.record.WeiHuaListModel;
import com.anjian.model.record.XiaoFangListModel;
import com.anjian.model.record.YanLianListModel;
import com.anjian.model.record.YouXianListModel;

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
 * 人口密集场所是 /app/pdpInfo 开头的  出租屋是/app/letInfo开头的  其他场所是/app/otpInfo 开头的
 */

public interface ApiService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/login")
    Flowable<LoginModel> login(@Body RequestBody body);

    //行政规划
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/sysArea/parent/{id}")
    Flowable<SysAreaModel> sysArea(@Path("id") String id, @Query("token") String token);

    //获取用户信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/user/info")
    Flowable<UserInfoModel> getUserInfo(@Query("token") String token);

    //搜索
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/enterpriseInfo/vagueSearch")
    Flowable<SearchModel> qiYeSearch(@Query("token") String token, @Query("keyWord") String keyWord);

    //三小搜索
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/tspInfo/vagueSearch")
    Flowable<SearchSanXiaoModel> sanXiaoSearch(@Query("token") String token, @Query("keyWord") String keyWord);

    //人口密集场所
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/pdpInfo/vagueSearch")
    Flowable<SearchSanXiaoModel> renKouSearch(@Query("token") String token, @Query("keyWord") String keyWord);

    //出租屋
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/letInfo/vagueSearch")
    Flowable<SearchSanXiaoModel> chuZuSearch(@Query("token") String token, @Query("keyWord") String keyWord);

    //其他
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/otpInfo/vagueSearch")
    Flowable<SearchSanXiaoModel> otherSearch(@Query("token") String token, @Query("keyWord") String keyWord);

    //新增企业信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/add")
    Flowable<BaseBean> addQiYe(@Body RequestBody body, @Query("token") String token);

    //更新企业信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/update")
    Flowable<BaseBean> updateQiYe(@Body RequestBody body, @Query("token") String token);

    //新增人口密集信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/pdpInfo/add")
    Flowable<BaseBean> addPdp(@Body RequestBody body, @Query("token") String token);

    //更新人口密集信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/pdpInfo/update")
    Flowable<BaseBean> updatePdp(@Body RequestBody body, @Query("token") String token);


    //企业列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/enterprise")
    Flowable<CompanyLisyModel> qiYeList(@Body RequestBody body, @Query("token") String token);

    //企业信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/enterpriseInfo/info/{id}")
    Flowable<QiYeInfoModel> qiYeInfo(@Path("id") String id, @Query("token") String token);
    //人口密集信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/enterpriseInfo/info/{id}")
    Flowable<QiYeInfoModel> pdpInfo(@Path("id") String id, @Query("token") String token);

    //三小场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/tsp")
    Flowable<CompanyLisyModel> sanXiaoList(@Body RequestBody body, @Query("token") String token);

    //人口密集场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/pdp")
    Flowable<CompanyLisyModel> renKouList(@Body RequestBody body, @Query("token") String token);

    //出租屋信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/let")
    Flowable<CompanyLisyModel> letList(@Body RequestBody body, @Query("token") String token);

    //其他场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/geo/otp")
    Flowable<CompanyLisyModel> otherList(@Body RequestBody body, @Query("token") String token);


    //三小信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/tspInfo/info/{id}")
    Flowable<SanXiaoInfoModel> sanXiaoInfo(@Path("id") String id, @Query("token") String token);

    //出租屋信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/letInfo/info/{id}")
    Flowable<SanXiaoInfoModel> letInfo(@Path("id") String id, @Query("token") String token);

    //更新三小场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspInfo/update")
    Flowable<BaseBean> updateSanXiao(@Body RequestBody body, @Query("token") String token);

    //更新出租屋信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letInfo/update")

    Flowable<BaseBean> updateLet(@Body RequestBody body, @Query("token") String token);
    //新增三小场所信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspInfo/add")
    Flowable<BaseBean> addSanXiao(@Body RequestBody body, @Query("token") String token);

    //新增出租屋信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letInfo/add")
    Flowable<BaseBean> addLet(@Body RequestBody body, @Query("token") String token);

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


    //新增有限空间
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/limitSpace/add")
    Flowable<BaseBean> addYouXian(@Body RequestBody body, @Query("token") String token);


    //有限空间列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/limitSpace/list")
    Flowable<YouXianListModel> getYouXianList(@Body RequestBody body, @Query("token") String token);


    //新增粉尘涉爆
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dustExplosion/add")
    Flowable<BaseBean> addFenCheng(@Body RequestBody body, @Query("token") String token);


    //粉尘涉爆列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dustExplosion/list")
    Flowable<FenChengListModel> getFenChengList(@Body RequestBody body, @Query("token") String token);


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
    @POST("security-monitor/app/enterpriseInfo/update")
    Flowable<BaseBean> addXiaoFang(@Body RequestBody body, @Query("token") String token);

    //消防设施列表信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/fireDevice/list")
    Flowable<XiaoFangListModel> getXiaoFangList(@Body RequestBody body, @Query("token") String token);

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

    //新增培训演练
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letTeachAct/add")
    Flowable<BaseBean> addYanLian1(@Body RequestBody body, @Query("token") String token);

    //培训演练列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspTeachAct/list")
    Flowable<YanLianListModel> getYanLianList(@Body RequestBody body, @Query("token") String token);


    //培训演练列表1
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letTeachAct/list")
    Flowable<YanLianListModel> getYanLianList1(@Body RequestBody body, @Query("token") String token);


    //新增三小场所选项列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspOption/add")
    Flowable<SanXiaoSelectModel> addSanXiaoSelectList(@Body RequestBody body, @Query("token") String token);


    //新增出租屋选项列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letOption/add")
    Flowable<SanXiaoSelectModel> addLetSelectList(@Body RequestBody body, @Query("token") String token);

    //添加现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeExamine/add")
    Flowable<BaseBean> addQiYeCheck(@Body RequestBody body, @Query("token") String token);

    //更新现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeExamine/update")
    Flowable<BaseBean> updateQiYeCheck(@Body RequestBody body, @Query("token") String token);

    //现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeExamine/list")
    Flowable<QiYeCheckListModel> getQiYeCheckList(@Body RequestBody body, @Query("token") String token);

    //添加现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspLocaleExamine/add")
    Flowable<BaseBean> addSanXiaoCheck(@Body RequestBody body, @Query("token") String token);
    //添加现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letLocaleExamine/add")
    Flowable<BaseBean> addSanXiaoCheck1(@Body RequestBody body, @Query("token") String token);

    //现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspLocaleExamine/list")
    Flowable<SanXiaoCheckListModel> getSanXiaoCheckList(@Body RequestBody body, @Query("token") String token);

    //现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letLocaleExamine/list")
    Flowable<SanXiaoCheckListModel> getSanXiaoCheckList1(@Body RequestBody body, @Query("token") String token);

    //更新现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/tspLocaleExamine/update")
    Flowable<BaseBean> updateSanXiaoCheck(@Body RequestBody body, @Query("token") String token);


    //更新现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/letLocaleExamine/update")
    Flowable<BaseBean> updateSanXiaoCheck1(@Body RequestBody body, @Query("token") String token);

    //添加企业选项列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseOption/update")
    Flowable<BaseBean> updateQiYeSelectList(@Body RequestBody body, @Query("token") String token);

    //企业选项列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseOption/list")
    Flowable<QiyeSelectListModel> getQiYeSelectList(@Body RequestBody body, @Query("token") String token);

}
