package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class XiaoFangListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-07-01 20:35:20","enterpriseId":"1012329476849090561","enterpriseName":null,"fireDeviceName":"测试名称","fireDeviceNum":11,"fireDeviceUnit":null,"id":"1013400660483219457","localeImg":null,"remark":null,"updateBy":"988422934076903425","updateTime":"2018-07-01 20:35:20","workPosition":"啦啦啦啦啦啦啦"}]
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

    public static class DataBean implements Serializable{
        /**
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-01 20:35:20
         * enterpriseId : 1012329476849090561
         * enterpriseName : null
         * fireDeviceName : 测试名称
         * fireDeviceNum : 11.0
         * fireDeviceUnit : null
         * id : 1013400660483219457
         * localeImg : null
         * remark : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-01 20:35:20
         * workPosition : 啦啦啦啦啦啦啦
         */

        private String createBy;
        private String createName;
        private String createTime;
        private String enterpriseId;
        private String enterpriseName;
        private String fireDeviceName;
        private String fireDeviceNum;
        private String fireDeviceUnit;
        private String id;
        private String localeImg;
        private String remark;
        private String updateBy;
        private String updateTime;
        private String workPosition;

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public String getFireDeviceName() {
            return fireDeviceName;
        }

        public void setFireDeviceName(String fireDeviceName) {
            this.fireDeviceName = fireDeviceName;
        }

        public String getFireDeviceNum() {
            return fireDeviceNum;
        }

        public void setFireDeviceNum(String fireDeviceNum) {
            this.fireDeviceNum = fireDeviceNum;
        }

        public String getFireDeviceUnit() {
            return fireDeviceUnit;
        }

        public void setFireDeviceUnit(String fireDeviceUnit) {
            this.fireDeviceUnit = fireDeviceUnit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocaleImg() {
            return localeImg;
        }

        public void setLocaleImg(String localeImg) {
            this.localeImg = localeImg;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWorkPosition() {
            return workPosition;
        }

        public void setWorkPosition(String workPosition) {
            this.workPosition = workPosition;
        }
    }
}
