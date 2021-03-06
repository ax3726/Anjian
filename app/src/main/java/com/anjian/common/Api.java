package com.anjian.common;


import android.util.Log;

import com.anjian.net.DownloadResponseBody;
import com.anjian.net.GsonConverterFactory;
import com.anjian.net.LoggerInterceptor;
import com.anjian.utils.MD5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.anjian.common.Constant.NO_SIGN;


/**
 * Created by Administrator on 2017/9/21.
 */

public class Api {

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static ApiService apiService;


    public static ApiService getApi() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(Link.SEREVE)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }

    public static String getKeyStr(Map<String, String> params) {
        List<Map.Entry<String, String>> list =
                new ArrayList<Map.Entry<String, String>>(params.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getKey().compareTo(o2.getKey()));
            }
        });
        String signStr = "gzqnkj";
        for (Map.Entry<String, String> map : list) {
            signStr = signStr + map.getKey() + map.getValue();
        }
        signStr = signStr + "gzqnkj";
        return MD5.toMD5Sign(signStr);

    }
    /**
     * 从 {@link Request#header(String)} 中取出 NoSign
     *
     * @param request {@link Request}
     * @return NoSign
     */
    private static String obtainNoSignNameFromHeaders(Request request) {
        List<String> headers = request.headers(NO_SIGN);
        if (headers == null || headers.size() == 0)
            return null;
        if (headers.size() > 1)
            throw new IllegalArgumentException("Only one NoSign-Name in the headers");
        return request.header(NO_SIGN);
    }

    public static OkHttpClient getOkHttpClient(DownloadResponseBody.DownLoadListener... downLoadListener) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
               .addInterceptor(new LoggerInterceptor("msg", true))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS);
               /* .addInterceptor(chain -> {//添加公共信息
                    Request originalRequest = chain.request();
                    String canshu = obtainNoSignNameFromHeaders(originalRequest);
                    Log.e("eeee","不加密的参数有"+canshu);

                    HashMap<String, String> rootMap = new HashMap<>();
                    //获取到请求地址api
                    HttpUrl httpUrlurl = originalRequest.url();
                    //通过请求地址(最初始的请求地址)获取到参数列表
                    Set<String> parameterNames = httpUrlurl.queryParameterNames();
                    for (String key : parameterNames) {  //循环参数列表
                        if (!"CMD".equals(key))
                            rootMap.put(key, httpUrlurl.queryParameter(key));

                    }*/

                    /*//get请求的封装
                    if (originalRequest.method().equals("GET")) {
                        //获取到请求地址api
                        HttpUrl httpUrlurl = originalRequest.url();
                        //通过请求地址(最初始的请求地址)获取到参数列表
                        Set<String> parameterNames = httpUrlurl.queryParameterNames();
                        for (String key : parameterNames) {  //循环参数列表
                            if (!"CMD".equals(key))
                                rootMap.put(key, httpUrlurl.queryParameter(key));

                        }
                    } else {
                        if (originalRequest.body() instanceof FormBody) {
                            FormBody body = (FormBody) originalRequest.body();
                            for (int i = 0; i < body.size(); i++) {
                                rootMap.put(body.encodedName(i), body.encodedValue(i));
                            }
                        }
                    }*/
                    /*String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
                    rootMap.put("appKey", "gzqnkj");
                    rootMap.put("_timestamp", timestamp);
                    rootMap.put("appSecret", "gzqnkj123456");
                    // 添加新的参数
                    HttpUrl.Builder authorizedUrlBuilder = originalRequest.url()
                            .newBuilder()
                            .scheme(originalRequest.url().scheme())
                            .host(originalRequest.url().host())
                            .addQueryParameter("appKey", "gzqnkj")
                            .addQueryParameter("_timestamp", timestamp)
                            .addQueryParameter("_sign", getKeyStr(rootMap));


                    // 新的请求+请求头部
                    Request newRequest = originalRequest.newBuilder()
                            //  .header("Authorization", "token")

                            .method(originalRequest.method(), originalRequest.body())
                            .url(authorizedUrlBuilder.build())
                            .build();


                    return chain.proceed(newRequest);
                });*/
        if (downLoadListener.length > 0) {
            builder.addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    DownloadResponseBody downloadResponseBody = new DownloadResponseBody(originalResponse.body(), downLoadListener[0]);
                    return originalResponse.newBuilder().body(downloadResponseBody).build();
                }
            });
        }
        return builder.build();
    }

    public static ApiService getDownLoadApi(String url, final DownloadResponseBody.DownLoadListener downLoadListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOkHttpClient(downLoadListener))
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();

        return retrofit.create(ApiService.class);
    }
}
