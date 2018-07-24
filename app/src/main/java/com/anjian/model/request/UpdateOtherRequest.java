package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/28.
 */

public class UpdateOtherRequest {
    private String id;
    private String otpName;
    private String otpDoorHeadImg;
    private String areaId;
    private String areaName;
    private String areaRelation;
    private String position;
    private String contactName;
    private String contactPhone;
    private String Manager ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOtpName() {
        return otpName;
    }

    public void setOtpName(String otpName) {
        this.otpName = otpName;
    }

    public String getOtpDoorHeadImg() {
        return otpDoorHeadImg;
    }

    public void setOtpDoorHeadImg(String otpDoorHeadImg) {
        this.otpDoorHeadImg = otpDoorHeadImg;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaRelation() {
        return areaRelation;
    }

    public void setAreaRelation(String areaRelation) {
        this.areaRelation = areaRelation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }
}
