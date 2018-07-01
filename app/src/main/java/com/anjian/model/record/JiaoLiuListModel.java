package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class JiaoLiuListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-06-28 21:53:06","enterpriseId":"1012329476849090561","enterpriseName":null,"id":"1012333064862253057","isDel":0,"localeImg":null,"meetingContent":"讨论下国家大事","meetingName":"大会","meetingUser":"就我一个","selferSign":null,"updateBy":"988422934076903425","updateTime":"2018-06-28 21:53:06"}]
     * message : 成功
     */

    private int code;
    private int count;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-06-28 21:53:06
         * enterpriseId : 1012329476849090561
         * enterpriseName : null
         * id : 1012333064862253057
         * isDel : 0
         * localeImg : null
         * meetingContent : 讨论下国家大事
         * meetingName : 大会
         * meetingUser : 就我一个
         * selferSign : null
         * updateBy : 988422934076903425
         * updateTime : 2018-06-28 21:53:06
         */

        private String createBy;
        private String createName;
        private String createTime;
        private String enterpriseId;
        private String enterpriseName;
        private String id;
        private int isDel;
        private String localeImg;
        private String meetingContent;
        private String meetingName;
        private String meetingUser;
        private String selferSign;
        private String updateBy;
        private String updateTime;

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }



        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsDel() {
            return isDel;
        }

        public void setIsDel(int isDel) {
            this.isDel = isDel;
        }

        public String getMeetingContent() {
            return meetingContent;
        }

        public void setMeetingContent(String meetingContent) {
            this.meetingContent = meetingContent;
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

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public String getLocaleImg() {
            return localeImg;
        }

        public void setLocaleImg(String localeImg) {
            this.localeImg = localeImg;
        }

        public String getSelferSign() {
            return selferSign;
        }

        public void setSelferSign(String selferSign) {
            this.selferSign = selferSign;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
