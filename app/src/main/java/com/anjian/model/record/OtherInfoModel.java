package com.anjian.model.record;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/24.
 */

public class OtherInfoModel {

    /**
     * code : 200
     * count : 0
     * data : {"areaId":null,"areaName":null,"areaRelation":null,"contactName":null,"contactPhone":null,"createBy":"1","createName":null,"createTime":"2018-07-07 06:00:05","delFlag":0,"email":null,"examineTime":null,"examineUser":null,"examineUserName":null,"id":"1015354725031194625","manager":null,"otpName":"测试其他场所","position":null,"updateBy":"1","updateTime":"2018-07-07 06:00:05"}
     * message : 成功
     */

    private int code;
    private int count;
    private DataBean data;
    private String message;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean implements Serializable{
        /**
         * areaId : null
         * areaName : null
         * areaRelation : null
         * contactName : null
         * contactPhone : null
         * createBy : 1
         * createName : null
         * createTime : 2018-07-07 06:00:05
         * delFlag : 0
         * email : null
         * examineTime : null
         * examineUser : null
         * examineUserName : null
         * id : 1015354725031194625
         * manager : null
         * otpName : 测试其他场所
         * position : null
         * updateBy : 1
         * updateTime : 2018-07-07 06:00:05
         */

        private String areaId;
        private String areaName;
        private String areaRelation;
        private String contactName;
        private String contactPhone;
        private String createBy;
        private String createName;
        private String createTime;
        private int delFlag;
        private String email;
        private String examineTime;
        private String examineUser;
        private String examineUserName;
        private String id;
        private String manager;
        private String otpName;
        private String otpImg;
        private String position;
        private String updateBy;
        private String updateTime;

        public String getOtpImg() {
            return otpImg;
        }

        public void setOtpImg(String otpImg) {
            this.otpImg = otpImg;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getAreaRelation() {
            return areaRelation;
        }

        public void setAreaRelation(String areaRelation) {
            this.areaRelation = areaRelation;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getExamineTime() {
            return examineTime;
        }

        public void setExamineTime(String examineTime) {
            this.examineTime = examineTime;
        }

        public String getExamineUser() {
            return examineUser;
        }

        public void setExamineUser(String examineUser) {
            this.examineUser = examineUser;
        }

        public String getExamineUserName() {
            return examineUserName;
        }

        public void setExamineUserName(String examineUserName) {
            this.examineUserName = examineUserName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getManager() {
            return manager;
        }

        public void setManager(String manager) {
            this.manager = manager;
        }

        public String getOtpName() {
            return otpName;
        }

        public void setOtpName(String otpName) {
            this.otpName = otpName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
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
    }
}
