package com.anjian.model.record;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 */

public class SearchSanXiaoModel {

    /**
     * code : 200
     * count : 4
     * data : [{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerLevel":null,"delFlag":null,"documentCode":null,"email":null,"employeeNum":null,"examineTime":null,"examineUser":null,"examineUserName":null,"id":"1","industry":null,"localeActImg":null,"localeSign":null,"localeTeachImg":null,"position":null,"tspDoorHeadImg":"/enterpriseInfo/2018/4/29/4993d0496fe14a7189a225154b53e38b.png","tspName":"测试","updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerLevel":null,"delFlag":null,"documentCode":null,"email":null,"employeeNum":null,"examineTime":null,"examineUser":null,"examineUserName":null,"id":"1013303239279353857","industry":null,"localeActImg":null,"localeSign":null,"localeTeachImg":null,"position":null,"tspDoorHeadImg":null,"tspName":"测试三小场11所","updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerLevel":null,"delFlag":null,"documentCode":null,"email":null,"employeeNum":null,"examineTime":null,"examineUser":null,"examineUserName":null,"id":"1013363647155511297","industry":null,"localeActImg":null,"localeSign":null,"localeTeachImg":null,"position":null,"tspDoorHeadImg":null,"tspName":"测试号啦咯啦咯啦咯","updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerLevel":null,"delFlag":null,"documentCode":null,"email":null,"employeeNum":null,"examineTime":null,"examineUser":null,"examineUserName":null,"id":"1013398702271733762","industry":null,"localeActImg":null,"localeSign":null,"localeTeachImg":null,"position":null,"tspDoorHeadImg":null,"tspName":"测试修改三场所","updateBy":null,"updateTime":null}]
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
         * areaId : null
         * areaName : null
         * areaRelation : null
         * businessLicenceCode : null
         * businessLicenceImg : null
         * contactName : null
         * contactPhone : null
         * createBy : null
         * createName : null
         * createTime : null
         * dangerLevel : null
         * delFlag : null
         * documentCode : null
         * email : null
         * employeeNum : null
         * examineTime : null
         * examineUser : null
         * examineUserName : null
         * id : 1
         * industry : null
         * localeActImg : null
         * localeSign : null
         * localeTeachImg : null
         * position : null
         * tspDoorHeadImg : /enterpriseInfo/2018/4/29/4993d0496fe14a7189a225154b53e38b.png
         * tspName : 测试
         * updateBy : null
         * updateTime : null
         */

        private String areaId;
        private String areaName;
        private String areaRelation;
        private String businessLicenceCode;
        private String businessLicenceImg;
        private String contactName;
        private String contactPhone;
        private String createBy;
        private String createName;
        private String createTime;
        private String dangerLevel;
        private String delFlag;
        private String documentCode;
        private String email;
        private String employeeNum;
        private String examineTime;
        private String examineUser;
        private String examineUserName;
        private String id;
        private String industry;
        private String localeActImg;
        private String localeSign;
        private String localeTeachImg;
        private String position;
        private String tspDoorHeadImg;
        private String tspName;
        private String updateBy;
        private String updateTime;

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

        public String getBusinessLicenceCode() {
            return businessLicenceCode;
        }

        public void setBusinessLicenceCode(String businessLicenceCode) {
            this.businessLicenceCode = businessLicenceCode;
        }

        public String getBusinessLicenceImg() {
            return businessLicenceImg;
        }

        public void setBusinessLicenceImg(String businessLicenceImg) {
            this.businessLicenceImg = businessLicenceImg;
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

        public String getDangerLevel() {
            return dangerLevel;
        }

        public void setDangerLevel(String dangerLevel) {
            this.dangerLevel = dangerLevel;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getDocumentCode() {
            return documentCode;
        }

        public void setDocumentCode(String documentCode) {
            this.documentCode = documentCode;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmployeeNum() {
            return employeeNum;
        }

        public void setEmployeeNum(String employeeNum) {
            this.employeeNum = employeeNum;
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

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getLocaleActImg() {
            return localeActImg;
        }

        public void setLocaleActImg(String localeActImg) {
            this.localeActImg = localeActImg;
        }

        public String getLocaleSign() {
            return localeSign;
        }

        public void setLocaleSign(String localeSign) {
            this.localeSign = localeSign;
        }

        public String getLocaleTeachImg() {
            return localeTeachImg;
        }

        public void setLocaleTeachImg(String localeTeachImg) {
            this.localeTeachImg = localeTeachImg;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getTspDoorHeadImg() {
            return tspDoorHeadImg;
        }

        public void setTspDoorHeadImg(String tspDoorHeadImg) {
            this.tspDoorHeadImg = tspDoorHeadImg;
        }

        public String getTspName() {
            return tspName;
        }

        public void setTspName(String tspName) {
            this.tspName = tspName;
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
