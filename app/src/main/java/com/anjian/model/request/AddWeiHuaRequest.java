package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/28.
 */

public class AddWeiHuaRequest {
    private String enterpriseId;
    private String chemicalName;
    private String chemicalNum;
    private String chemicalUnit;
    private String workPosition;
    private String localeImg;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getChemicalNum() {
        return chemicalNum;
    }

    public void setChemicalNum(String chemicalNum) {
        this.chemicalNum = chemicalNum;
    }

    public String getChemicalUnit() {
        return chemicalUnit;
    }

    public void setChemicalUnit(String chemicalUnit) {
        this.chemicalUnit = chemicalUnit;
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
