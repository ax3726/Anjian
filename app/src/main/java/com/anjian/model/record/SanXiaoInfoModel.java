package com.anjian.model.record;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */

public class SanXiaoInfoModel {

    /**
     * code : 200
     * count : 0
     * data : {"areaId":"1012255152452616193","areaName":null,"areaRelation":"988374448447025153","businessLicenceCode":"ghvh","businessLicenceImg":null,"contactName":"hjj","contactPhone":"15970060419","createBy":"988422934076903425","createName":null,"createTime":"2018-07-01 20:27:33","delFlag":0,"documentCode":null,"email":"vvbb","employeeNum":20,"examineTime":null,"examineUser":null,"examineUserName":null,"id":"1013398702271733762","industry":2,"localeActImg":null,"localeSign":null,"localeTeachImg":null,"position":"30.236844,120.240313","tspDoorHeadImg":null,"tspName":"测试三场所","updateBy":"988422934076903425","updateTime":"2018-07-01 20:27:33"}
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

    public static class DataBean implements Serializable {
        /**
         * areaId : 1012255152452616193
         * areaName : null
         * areaRelation : 988374448447025153
         * businessLicenceCode : ghvh
         * businessLicenceImg : null
         * contactName : hjj
         * contactPhone : 15970060419
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-01 20:27:33
         * delFlag : 0
         * documentCode : null
         * email : vvbb
         * employeeNum : 20
         * examineTime : null
         * examineUser : null
         * examineUserName : null
         * id : 1013398702271733762
         * industry : 2
         * localeActImg : null
         * localeSign : null
         * localeTeachImg : null
         * position : 30.236844,120.240313
         * tspDoorHeadImg : null
         * tspName : 测试三场所
         * updateBy : 988422934076903425
         * updateTime : 2018-07-01 20:27:33
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
        private int delFlag;
        private String documentCode;
        private String email;
        private int employeeNum;
        private String examineTime;
        private String examineUser;
        private String examineUserName;
        private String id;
        private int industry;
        private String localeActImg;
        private String localeSign;
        private String localeTeachImg;
        private String position;
        private String tspDoorHeadImg;
        private String tspName;
        private String letDoorHeadImg;
        private String letName;
        private String updateBy;
        private String updateTime;

        public String getLetDoorHeadImg() {
            return letDoorHeadImg;
        }

        public void setLetDoorHeadImg(String letDoorHeadImg) {
            this.letDoorHeadImg = letDoorHeadImg;
        }

        public String getLetName() {
            return letName;
        }

        public void setLetName(String letName) {
            this.letName = letName;
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

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
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

        public int getEmployeeNum() {
            return employeeNum;
        }

        public void setEmployeeNum(int employeeNum) {
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

        public int getIndustry() {
            return industry;
        }

        public void setIndustry(int industry) {
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
