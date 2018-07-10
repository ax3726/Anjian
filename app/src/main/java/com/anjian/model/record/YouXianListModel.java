package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/10.
 */

public class YouXianListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-07-10 11:13:31","delFlag":0,"enterpriseId":"1013739992192516097","enterpriseName":null,"id":"1016520766654390274","localeImg":"/limitSpace/2018/7/10/056a0fed0c3440048d380d1810f1f9b8.png","remark":null,"spaceName":"来来来","spaceNum":12,"spaceUnit":null,"updateBy":"988422934076903425","updateTime":"2018-07-10 11:13:31","workPosition":"啦啦啦啦啦啦啦"}]
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

    public static class DataBean implements Serializable {
        /**
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-10 11:13:31
         * delFlag : 0
         * enterpriseId : 1013739992192516097
         * enterpriseName : null
         * id : 1016520766654390274
         * localeImg : /limitSpace/2018/7/10/056a0fed0c3440048d380d1810f1f9b8.png
         * remark : null
         * spaceName : 来来来
         * spaceNum : 12.0
         * spaceUnit : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-10 11:13:31
         * workPosition : 啦啦啦啦啦啦啦
         */

        private String createBy;
        private String createName;
        private String createTime;
        private int delFlag;
        private String enterpriseId;
        private String enterpriseName;
        private String id;
        private String localeImg;
        private String remark;
        private String spaceName;
        private double spaceNum;
        private String spaceUnit;
        private String updateBy;
        private String updateTime;
        private String workPosition;

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getSpaceName() {
            return spaceName;
        }

        public void setSpaceName(String spaceName) {
            this.spaceName = spaceName;
        }

        public double getSpaceNum() {
            return spaceNum;
        }

        public void setSpaceNum(double spaceNum) {
            this.spaceNum = spaceNum;
        }

        public String getSpaceUnit() {
            return spaceUnit;
        }

        public void setSpaceUnit(String spaceUnit) {
            this.spaceUnit = spaceUnit;
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

        public String getWorkPosition() {
            return workPosition;
        }

        public void setWorkPosition(String workPosition) {
            this.workPosition = workPosition;
        }
    }
}
