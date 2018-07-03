package com.anjian.model.record;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */

public class QiYeInfoModel {

    /**
     * code : 200
     * count : 0
     * data : {"areaId":"1012255152452616193","areaName":null,"areaRelation":"988374448447025153","businessLicenceCode":"5568","businessLicenceImg":"/enterpriseInfo/2018/7/2/f4e6861138e344aba873a3c02bc65809.png","contactName":"来来来","contactPhone":"15170193726","createBy":"988422934076903425","createName":null,"createTime":"2018-07-02 19:03:43","dangerChemicalDesc":null,"delFlag":0,"detailAddress":"福建省泉州市丰泽区测试村","email":"ax3726@163.com","employeeNum":100,"enterpriseDoorHeadImg":"/enterpriseInfo/2018/7/2/c6b614f6077641b5b98ccd4036f5f99f.png","enterpriseName":"这个是企业信息","enterpriseScale":1,"examineTime":null,"examineUser":null,"fireDevice":null,"floorArea":500,"id":"1013739992192516097","industry":2,"position":"30.236669,120.240344","specialDevice":null,"updateBy":"988422934076903425","updateTime":"2018-07-02 19:03:43"}
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
         * areaId : 1012255152452616193
         * areaName : null
         * areaRelation : 988374448447025153
         * businessLicenceCode : 5568
         * businessLicenceImg : /enterpriseInfo/2018/7/2/f4e6861138e344aba873a3c02bc65809.png
         * contactName : 来来来
         * contactPhone : 15170193726
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-02 19:03:43
         * dangerChemicalDesc : null
         * delFlag : 0
         * detailAddress : 福建省泉州市丰泽区测试村
         * email : ax3726@163.com
         * employeeNum : 100
         * enterpriseDoorHeadImg : /enterpriseInfo/2018/7/2/c6b614f6077641b5b98ccd4036f5f99f.png
         * enterpriseName : 这个是企业信息
         * enterpriseScale : 1
         * examineTime : null
         * examineUser : null
         * fireDevice : null
         * floorArea : 500.0
         * id : 1013739992192516097
         * industry : 2
         * position : 30.236669,120.240344
         * specialDevice : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-02 19:03:43
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
        private int delFlag;
        private String detailAddress;
        private String email;
        private int employeeNum;
        private String enterpriseDoorHeadImg;
        private String enterpriseName;
        private int enterpriseScale;
        private String examineTime;
        private String examineUser;
        private String fireDevice;
        private double floorArea;
        private String id;
        private int industry;
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

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
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

        public int getEmployeeNum() {
            return employeeNum;
        }

        public void setEmployeeNum(int employeeNum) {
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

        public int getEnterpriseScale() {
            return enterpriseScale;
        }

        public void setEnterpriseScale(int enterpriseScale) {
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

        public double getFloorArea() {
            return floorArea;
        }

        public void setFloorArea(double floorArea) {
            this.floorArea = floorArea;
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
