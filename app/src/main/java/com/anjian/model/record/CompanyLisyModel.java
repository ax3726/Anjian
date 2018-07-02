package com.anjian.model.record;

import java.util.List;

/**
 * Created by LiMing on 2018/7/2.
 */

public class CompanyLisyModel {

    /**
     * code : 200
     * count : 0
     * data : [{"distance":0.0068,"doorHeadImg":null,"key":"1012966057301647361","name":"测试企业啦啦啦啦啦啦啦"},{"distance":0.0068,"doorHeadImg":null,"key":"1012966728197349378","name":"阿福卡KKK"},{"distance":0.0069,"doorHeadImg":null,"key":"1013450736006025217","name":"企业测试啊啦啦啦啦啦啦啦"},{"distance":0.0198,"doorHeadImg":null,"key":"1013398208656678914","name":"测试企业了哦哦"}]
     * message : 成功
     */

    private int code;
    private int count;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * distance : 0.0068
         * doorHeadImg : null
         * key : 1012966057301647361
         * name : 测试企业啦啦啦啦啦啦啦
         */

        private double distance;
        private String doorHeadImg;
        private String key;
        private String name;

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getDoorHeadImg() {
            return doorHeadImg;
        }

        public void setDoorHeadImg(String doorHeadImg) {
            this.doorHeadImg = doorHeadImg;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
