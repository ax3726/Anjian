package com.anjian.model.record;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */

public class QiYeInfoModel {


    /**
     * code : 200
     * count : 0
     * data : {"areaId":"1012255152452616193","areaName":null,"areaRelation":"988374448447025153","businessLicenceCode":"5568","businessLicenceImg":"/enterpriseInfo/2018/7/2/f4e6861138e344aba873a3c02bc65809.png","contactName":"来来来","contactPhone":"15170193726","controlStandBook":null,"controlStep":null,"createBy":"988422934076903425","createName":null,"createTime":"2018-07-02 19:03:43","dangerChemicalDesc":null,"dangerDistributeImg":null,"delFlag":0,"detailAddress":"福建省泉州市丰泽区测试村","email":"ax3726@163.com","employeeNum":100,"enterpriseDoorHeadImg":"/enterpriseInfo/2018/7/2/c6b614f6077641b5b98ccd4036f5f99f.png","enterpriseName":"这个是修改后的企业信息","enterpriseScale":1,"examineTime":"2018-07-03 14:14:40","examineUser":null,"existProblem":null,"fireDevice":null,"floorArea":500,"id":"1013739992192516097","industry":3,"position":"30.241596,120.241595","referType":null,"specialDevice":null,"updateBy":"988422934076903425","updateTime":"2018-07-03 14:14:40","urgentDevice":null}
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
         * controlStandBook : null
         * controlStep : null
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-02 19:03:43
         * dangerChemicalDesc : null
         * dangerDistributeImg : null
         * delFlag : 0
         * detailAddress : 福建省泉州市丰泽区测试村
         * email : ax3726@163.com
         * employeeNum : 100
         * enterpriseDoorHeadImg : /enterpriseInfo/2018/7/2/c6b614f6077641b5b98ccd4036f5f99f.png
         * enterpriseName : 这个是修改后的企业信息
         * enterpriseScale : 1
         * examineTime : 2018-07-03 14:14:40
         * examineUser : null
         * existProblem : null
         * fireDevice : null
         * floorArea : 500.0
         * id : 1013739992192516097
         * industry : 3
         * position : 30.241596,120.241595
         * referType : null
         * specialDevice : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-03 14:14:40
         * urgentDevice : null
         */

        private String areaId;
        private String areaName;
        private String areaRelation;
        private String businessLicenceCode;
        private String businessLicenceImg;
        private String contactName;
        private String contactPhone;
        private int controlStandBook=-1;
        private int controlStep=-1;
        private String createBy;
        private String createName;
        private String createTime;
        private String dangerChemicalDesc;
        private String dangerDistributeImg;
        private int delFlag;
        private String detailAddress;
        private String email;
        private int employeeNum;
        private String enterpriseDoorHeadImg;
        private String enterpriseName;
        private int enterpriseScale;
        private String examineTime;
        private String examineUser;
        private String existProblem;
        private String fireDevice;
        private double floorArea;
        private String id;
        private int industry;
        private String position;
        private String referType;
        private String specialDevice;
        private String updateBy;
        private String updateTime;
        private int urgentDevice=-1;

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

        public int getControlStandBook() {
            return controlStandBook;
        }

        public void setControlStandBook(int controlStandBook) {
            this.controlStandBook = controlStandBook;
        }

        public int getControlStep() {
            return controlStep;
        }

        public void setControlStep(int controlStep) {
            this.controlStep = controlStep;
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

        public String getDangerDistributeImg() {
            return dangerDistributeImg;
        }

        public void setDangerDistributeImg(String dangerDistributeImg) {
            this.dangerDistributeImg = dangerDistributeImg;
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

        public String getExistProblem() {
            return existProblem;
        }

        public void setExistProblem(String existProblem) {
            this.existProblem = existProblem;
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

        public String getReferType() {
            return referType;
        }

        public void setReferType(String referType) {
            this.referType = referType;
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

        public int getUrgentDevice() {
            return urgentDevice;
        }

        public void setUrgentDevice(int urgentDevice) {
            this.urgentDevice = urgentDevice;
        }
    }
}
