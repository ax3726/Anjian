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
        private String enterpriseDoorHeadImg;
        private String enterpriseName;

        private String tspDoorHeadImg;
        private String tspName;

        private String pdpDoorHeadImg;
        private String pdpName;

        private String letDoorHeadImg;
        private String letName;

        private String otpImg;
        private String otpName;

        private String id;

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

        public String getPdpDoorHeadImg() {
            return pdpDoorHeadImg;
        }

        public void setPdpDoorHeadImg(String pdpDoorHeadImg) {
            this.pdpDoorHeadImg = pdpDoorHeadImg;
        }

        public String getPdpName() {
            return pdpName;
        }

        public void setPdpName(String pdpName) {
            this.pdpName = pdpName;
        }

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

        public String getOtpImg() {
            return otpImg;
        }

        public void setOtpImg(String otpImg) {
            this.otpImg = otpImg;
        }

        public String getOtpName() {
            return otpName;
        }

        public void setOtpName(String otpName) {
            this.otpName = otpName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
