package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/30.
 */

public class AddFengXianRequest {
    private String enterpriseId;
    private String pdpId;
    private String dangerName;
    private String detailPosition;
    private String localeImg;
    private String easyHappenCaseType;
    private String lossPrediction;
    private String dangerLevel;
    private String modifyStep;

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

    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public String getDetailPosition() {
        return detailPosition;
    }

    public void setDetailPosition(String detailPosition) {
        this.detailPosition = detailPosition;
    }

    public String getLocaleImg() {
        return localeImg;
    }

    public void setLocaleImg(String localeImg) {
        this.localeImg = localeImg;
    }

    public String getEasyHappenCaseType() {
        return easyHappenCaseType;
    }

    public void setEasyHappenCaseType(String easyHappenCaseType) {
        this.easyHappenCaseType = easyHappenCaseType;
    }

    public String getLossPrediction() {
        return lossPrediction;
    }

    public void setLossPrediction(String lossPrediction) {
        this.lossPrediction = lossPrediction;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public String getModifyStep() {
        return modifyStep;
    }

    public void setModifyStep(String modifyStep) {
        this.modifyStep = modifyStep;
    }
}
