package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/30.
 */

public class AddTeZhongRequest {
    private String enterpriseId;
    private String pdpId;
    private String specialDeviceName;
    private String specialDeviceNum;
    private String specialDeviceUnit;
    private String workPosition;
    private String localeImg;
    private String remark;
    private String usePms;
    private int licensedWork;
    private String examineBeginDate;
    private String examineEndDate;

    public String getPdpId() {
        return pdpId;
    }

    public void setPdpId(String pdpId) {
        this.pdpId = pdpId;
    }

    public String getUsePms() {
        return usePms;
    }

    public void setUsePms(String usePms) {
        this.usePms = usePms;
    }

    public int getLicensedWork() {
        return licensedWork;
    }

    public void setLicensedWork(int licensedWork) {
        this.licensedWork = licensedWork;
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

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getSpecialDeviceName() {
        return specialDeviceName;
    }

    public void setSpecialDeviceName(String specialDeviceName) {
        this.specialDeviceName = specialDeviceName;
    }

    public String getSpecialDeviceNum() {
        return specialDeviceNum;
    }

    public void setSpecialDeviceNum(String specialDeviceNum) {
        this.specialDeviceNum = specialDeviceNum;
    }

    public String getSpecialDeviceUnit() {
        return specialDeviceUnit;
    }

    public void setSpecialDeviceUnit(String specialDeviceUnit) {
        this.specialDeviceUnit = specialDeviceUnit;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
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
}
