package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/30.
 */

public class AddXiaoFangRequest {
    private String enterpriseId;
    private String fireDeviceName;
    private String fireDeviceNum;
    private String fireDeviceUnit;
    private String workPosition;
    private String localeImg;
    private String remark;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFireDeviceName() {
        return fireDeviceName;
    }

    public void setFireDeviceName(String fireDeviceName) {
        this.fireDeviceName = fireDeviceName;
    }

    public String getFireDeviceNum() {
        return fireDeviceNum;
    }

    public void setFireDeviceNum(String fireDeviceNum) {
        this.fireDeviceNum = fireDeviceNum;
    }

    public String getFireDeviceUnit() {
        return fireDeviceUnit;
    }

    public void setFireDeviceUnit(String fireDeviceUnit) {
        this.fireDeviceUnit = fireDeviceUnit;
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
