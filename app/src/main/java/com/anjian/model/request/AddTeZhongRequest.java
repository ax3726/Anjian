package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/30.
 */

public class AddTeZhongRequest {
    private String enterpriseId;
    private String specialDeviceName;
    private String specialDeviceNum;
    private String specialDeviceUnit;
    private String workPosition;
    private String localeImg;
    private String remark;

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
