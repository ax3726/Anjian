package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/28.
 */

public class AddYouXianRequest {
    private String enterpriseId;
    private String spaceName;
    private String spaceNum;
    private String spaceUnit;
    private String workPosition;
    private String localeImg;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(String spaceNum) {
        this.spaceNum = spaceNum;
    }

    public String getSpaceUnit() {
        return spaceUnit;
    }

    public void setSpaceUnit(String spaceUnit) {
        this.spaceUnit = spaceUnit;
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
