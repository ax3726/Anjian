package com.anjian.common;


import com.anjian.model.BaseBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    @GET("AppService.aspx?CMD=LoadProductType")
        //获取商品分类信息 、新增参数shopId
    Flowable<BaseBean> getProductType(@Query("shopId") String shopId); //便利架id;


}
