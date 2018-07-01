package com.anjian.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/6/28.
 */

public class DemoUtils {
    /**
     * 将图片转换成Base64编码的字符串
     *
     * @param path
     * @return base64编码的字符串
     */
    public static String imageToBase64(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        InputStream is = null;
        byte[] data = null;
        String result = null;
        try {
            is = new FileInputStream(path);
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;

    }

    /**
     * 获取经纬度
     * @param context
     * @return
     */
    public static String getLatitudeAndLongitude(Context context)
    {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location != null) {
            return location.getLatitude()+","+location.getLongitude();
        } else {
            return "";
        }

    }
    /**
     * 获取经纬度
     * @param context
     * @return
     */
    public static Location getLocation(Context context)
    {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
       return location;

    }
    /**
     * 格式化时间
     * @param time
     * @return
     */
    public static String getTime(String time)
    {
        if (!TextUtils.isEmpty(time)) {
            String[] split = time.split(" ");
            if (split.length > 0) {
                return split[0];
            } else {
                return "未知时间";
            }
        } else {
            return "未知时间";
        }
    }
}
