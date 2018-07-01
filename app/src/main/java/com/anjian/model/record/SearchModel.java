package com.anjian.model.record;

import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class SearchModel {

    /**
     * code : 200
     * count : 33
     * data : [{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerChemicalDesc":null,"delFlag":null,"detailAddress":null,"email":null,"employeeNum":null,"enterpriseDoorHeadImg":null,"enterpriseName":"llll测试","enterpriseScale":null,"examineTime":null,"examineUser":null,"fireDevice":null,"floorArea":null,"id":"1012329476849090561","industry":null,"position":null,"specialDevice":null,"updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerChemicalDesc":null,"delFlag":null,"detailAddress":null,"email":null,"employeeNum":null,"enterpriseDoorHeadImg":null,"enterpriseName":"测试\n","enterpriseScale":null,"examineTime":null,"examineUser":null,"fireDevice":null,"floorArea":null,"id":"990511925261533185","industry":null,"position":null,"specialDevice":null,"updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerChemicalDesc":null,"delFlag":null,"detailAddress":null,"email":null,"employeeNum":null,"enterpriseDoorHeadImg":null,"enterpriseName":"测试","enterpriseScale":null,"examineTime":null,"examineUser":null,"fireDevice":null,"floorArea":null,"id":"989774021971271682","industry":null,"position":null,"specialDevice":null,"updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerChemicalDesc":null,"delFlag":null,"detailAddress":null,"email":null,"employeeNum":null,"enterpriseDoorHeadImg":null,"enterpriseName":"测试1","enterpriseScale":null,"examineTime":null,"examineUser":null,"fireDevice":null,"floorArea":null,"id":"989776670045102082","industry":null,"position":null,"specialDevice":null,"updateBy":null,"updateTime":null},{"areaId":null,"areaName":null,"areaRelation":null,"businessLicenceCode":null,"businessLicenceImg":null,"contactName":null,"contactPhone":null,"createBy":null,"createName":null,"createTime":null,"dangerChemicalDesc":null,"delFlag":null,"detailAddress":null,"email":null,"employeeNum":null,"enterpriseDoorHeadImg":null,"enterpriseName":"测试10","enterpriseScale":null,"examineTime":null,"examineUser":null,"fireDevice":null,"floorArea":null,"id":"990056901926465538","industry":null,"position":null,"specialDevice":null,"updateBy":null,"updateTime":null}]
     */

    private int code;
    private int count;
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
         * dangerChemicalDesc : null
         * delFlag : null
         * detailAddress : null
         * email : null
         * employeeNum : null
         * enterpriseDoorHeadImg : null
         * enterpriseName : llll测试
         * enterpriseScale : null
         * examineTime : null
         * examineUser : null
         * fireDevice : null
         * floorArea : null
         * id : 1012329476849090561
         * industry : null
         * position : null
         * specialDevice : null
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
        private String dangerChemicalDesc;
        private String delFlag;
        private String detailAddress;
        private String email;
        private String employeeNum;
        private String enterpriseDoorHeadImg;
        private String enterpriseName;
        private String enterpriseScale;
        private String examineTime;
        private String examineUser;
        private String fireDevice;
        private String floorArea;
        private String id;
        private String industry;
        private String position;
        private String specialDevice;
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

        public String getDangerChemicalDesc() {
            return dangerChemicalDesc;
        }

        public void setDangerChemicalDesc(String dangerChemicalDesc) {
            this.dangerChemicalDesc = dangerChemicalDesc;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public void setDetailAddress(String detailAddress) {
            this.detailAddress = detailAddress;
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

        public String getEnterpriseDoorHeadImg() {
            return enterpriseDoorHeadImg;
        }

        public void setEnterpriseDoorHeadImg(String enterpriseDoorHeadImg) {
            this.enterpriseDoorHeadImg = enterpriseDoorHeadImg;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public String getEnterpriseScale() {
            return enterpriseScale;
        }

        public void setEnterpriseScale(String enterpriseScale) {
            this.enterpriseScale = enterpriseScale;
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

        public String getFireDevice() {
            return fireDevice;
        }

        public void setFireDevice(String fireDevice) {
            this.fireDevice = fireDevice;
        }

        public String getFloorArea() {
            return floorArea;
        }

        public void setFloorArea(String floorArea) {
            this.floorArea = floorArea;
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

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getSpecialDevice() {
            return specialDevice;
        }

        public void setSpecialDevice(String specialDevice) {
            this.specialDevice = specialDevice;
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
