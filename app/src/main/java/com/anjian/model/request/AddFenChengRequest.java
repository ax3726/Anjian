package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/28.
 */

public class AddFenChengRequest {
    private String enterpriseId;
    private String pdpId;
    private String dustName;
    private String dustNum;
    private String dustUnit;
    private String workPosition;
    private String localeImg;

    public String getPdpId() {
        return pdpId;
    }

    public void setPdpId(String pdpId) {
        this.pdpId = pdpId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getDustName() {
        return dustName;
    }

    public void setDustName(String dustName) {
        this.dustName = dustName;
    }

    public String getDustNum() {
        return dustNum;
    }

    public void setDustNum(String dustNum) {
        this.dustNum = dustNum;
    }

    public String getDustUnit() {
        return dustUnit;
    }

    public void setDustUnit(String dustUnit) {
        this.dustUnit = dustUnit;
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
}
