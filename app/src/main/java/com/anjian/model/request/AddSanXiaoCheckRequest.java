package com.anjian.model.request;

/**
 * Created by Administrator on 2018/7/3.
 */

public class AddSanXiaoCheckRequest {
    private String tspId;
    private String optionId;
    private String dangerDesc;
    private String localeImg;
    private String modifyStep;
    private String lawReason;
    private String saferSign;
    private String businesserSign;
    private String witherSign;
    private String modifyImg;

    public String getTspId() {
        return tspId;
    }

    public void setTspId(String tspId) {
        this.tspId = tspId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getDangerDesc() {
        return dangerDesc;
    }

    public void setDangerDesc(String dangerDesc) {
        this.dangerDesc = dangerDesc;
    }

    public String getLocaleImg() {
        return localeImg;
    }

    public void setLocaleImg(String localeImg) {
        this.localeImg = localeImg;
    }

    public String getModifyStep() {
        return modifyStep;
    }

    public void setModifyStep(String modifyStep) {
        this.modifyStep = modifyStep;
    }

    public String getLawReason() {
        return lawReason;
    }

    public void setLawReason(String lawReason) {
        this.lawReason = lawReason;
    }

    public String getSaferSign() {
        return saferSign;
    }

    public void setSaferSign(String saferSign) {
        this.saferSign = saferSign;
    }

    public String getBusinesserSign() {
        return businesserSign;
    }

    public void setBusinesserSign(String businesserSign) {
        this.businesserSign = businesserSign;
    }

    public String getWitherSign() {
        return witherSign;
    }

    public void setWitherSign(String witherSign) {
        this.witherSign = witherSign;
    }

    public String getModifyImg() {
        return modifyImg;
    }

    public void setModifyImg(String modifyImg) {
        this.modifyImg = modifyImg;
    }
}