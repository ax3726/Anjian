package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/28.
 */

public class AddJiaoLiuRequest {
    private String enterpriseId;
    private String pdpId;
    private String meetingName;
    private String meetingUser;
    private String meetingContent;
    private String localeImg;
    private String selferSign;

    public String getPdpId() {
        return pdpId;
    }

    public void setPdpId(String pdpId) {
        this.pdpId = pdpId;
    }

    public String getSelferSign() {
        return selferSign;
    }

    public void setSelferSign(String selferSign) {
        this.selferSign = selferSign;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingUser() {
        return meetingUser;
    }

    public void setMeetingUser(String meetingUser) {
        this.meetingUser = meetingUser;
    }

    public String getMeetingContent() {
        return meetingContent;
    }

    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent;
    }

    public String getLocaleImg() {
        return localeImg;
    }

    public void setLocaleImg(String localeImg) {
        this.localeImg = localeImg;
    }
}
