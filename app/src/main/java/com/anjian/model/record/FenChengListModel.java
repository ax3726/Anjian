package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/10.
 */

public class FenChengListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-07-10 11:21:34","delFlag":0,"dustName":"某些","dustNum":13,"dustUnit":null,"enterpriseId":"1013739992192516097","enterpriseName":null,"id":"1016522790896803842","localeImg":"/dustExplosion/2018/7/10/6253ba5ef8634510ad31dd75b04b271a.png","remark":null,"updateBy":"988422934076903425","updateTime":"2018-07-10 11:21:34","workPosition":"啦啦啦啦啦啦啦"}]
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
         * createTime : 2018-07-10 11:21:34
         * delFlag : 0
         * dustName : 某些
         * dustNum : 13.0
         * dustUnit : null
         * enterpriseId : 1013739992192516097
         * enterpriseName : null
         * id : 1016522790896803842
         * localeImg : /dustExplosion/2018/7/10/6253ba5ef8634510ad31dd75b04b271a.png
         * remark : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-10 11:21:34
         * workPosition : 啦啦啦啦啦啦啦
         */

        private String createBy;
        private String createName;
        private String createTime;
        private int delFlag;
        private String dustName;
        private double dustNum;
        private String dustUnit;
        private String enterpriseId;
        private String enterpriseName;
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

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public String getDustName() {
            return dustName;
        }

        public void setDustName(String dustName) {
            this.dustName = dustName;
        }

        public double getDustNum() {
            return dustNum;
        }

        public void setDustNum(double dustNum) {
            this.dustNum = dustNum;
        }

        public String getDustUnit() {
            return dustUnit;
        }

        public void setDustUnit(String dustUnit) {
            this.dustUnit = dustUnit;
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
