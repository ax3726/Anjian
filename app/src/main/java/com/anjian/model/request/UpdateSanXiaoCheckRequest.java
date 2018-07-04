package com.anjian.model.request;

/**
 * Created by Administrator on 2018/7/3.
 */

public class UpdateSanXiaoCheckRequest {
    private String id;
    private String tspId;
    private String optionId;
    private String saferSign;
    private String businesserSign;
    private String witherSign;
    private String modifyImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
