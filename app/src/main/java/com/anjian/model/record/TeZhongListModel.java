package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class TeZhongListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-07-10 16:45:57","delFlag":0,"enterpriseId":"1013739992192516097","enterpriseName":null,"examineBeginDate":"2018-07-10 00:00:00","examineEndDate":"2018-07-15 00:00:00","id":"1016604425369559041","licensedWork":0,"localeImg":"/specialDevice/2018/7/10/a2413e32273f495fa721f91071474089.png","remark":null,"specialDeviceName":"来来来","specialDeviceNum":12,"specialDeviceUnit":null,"updateBy":"988422934076903425","updateTime":"2018-07-10 16:45:57","usePms":"/specialDevice/2018/7/10/9cfc4ee92f5a418cbd14f7840346de85.png","workPosition":"聊啦别"}]
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
         * createTime : 2018-07-10 16:45:57
         * delFlag : 0
         * enterpriseId : 1013739992192516097
         * enterpriseName : null
         * examineBeginDate : 2018-07-10 00:00:00
         * examineEndDate : 2018-07-15 00:00:00
         * id : 1016604425369559041
         * licensedWork : 0
         * localeImg : /specialDevice/2018/7/10/a2413e32273f495fa721f91071474089.png
         * remark : null
         * specialDeviceName : 来来来
         * specialDeviceNum : 12.0
         * specialDeviceUnit : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-10 16:45:57
         * usePms : /specialDevice/2018/7/10/9cfc4ee92f5a418cbd14f7840346de85.png
         * workPosition : 聊啦别
         */

        private String createBy;
        private String createName;
        private String createTime;
        private int delFlag;
        private String enterpriseId;
        private String enterpriseName;
        private String examineBeginDate;
        private String examineEndDate;
        private String id;
        private int licensedWork;
        private String localeImg;
        private String remark;
        private String specialDeviceName;
        private double specialDeviceNum;
        private String specialDeviceUnit;
        private String updateBy;
        private String updateTime;
        private String usePms;
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

        public String getExamineBeginDate() {
            return examineBeginDate;
        }

        public void setExamineBeginDate(String examineBeginDate) {
            this.examineBeginDate = examineBeginDate;
        }

        public String getExamineEndDate() {
            return examineEndDate;
        }

        public void setExamineEndDate(String examineEndDate) {
            this.examineEndDate = examineEndDate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getLicensedWork() {
            return licensedWork;
        }

        public void setLicensedWork(int licensedWork) {
            this.licensedWork = licensedWork;
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

        public String getSpecialDeviceName() {
            return specialDeviceName;
        }

        public void setSpecialDeviceName(String specialDeviceName) {
            this.specialDeviceName = specialDeviceName;
        }

        public double getSpecialDeviceNum() {
            return specialDeviceNum;
        }

        public void setSpecialDeviceNum(double specialDeviceNum) {
            this.specialDeviceNum = specialDeviceNum;
        }

        public String getSpecialDeviceUnit() {
            return specialDeviceUnit;
        }

        public void setSpecialDeviceUnit(String specialDeviceUnit) {
            this.specialDeviceUnit = specialDeviceUnit;
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

        public String getUsePms() {
            return usePms;
        }

        public void setUsePms(String usePms) {
            this.usePms = usePms;
        }

        public String getWorkPosition() {
            return workPosition;
        }

        public void setWorkPosition(String workPosition) {
            this.workPosition = workPosition;
        }
    }
}
