package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class WeiHuaListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"chemicalName":"啦啦啦啦啦啦啦","chemicalNum":1111,"chemicalUnit":null,"createBy":"988422934076903425","createName":null,"createTime":"2018-06-30 15:00:29","enterpriseId":"1012329476849090561","enterpriseName":null,"id":"1012954004524507137","localeImg":null,"remark":null,"updateBy":"988422934076903425","updateTime":"2018-06-30 15:00:29","workPosition":"啦啦啦啦啦啦啦"}]
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
         * chemicalName : 啦啦啦啦啦啦啦
         * chemicalNum : 1111.0
         * chemicalUnit : null
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-06-30 15:00:29
         * enterpriseId : 1012329476849090561
         * enterpriseName : null
         * id : 1012954004524507137
         * localeImg : null
         * remark : null
         * updateBy : 988422934076903425
         * updateTime : 2018-06-30 15:00:29
         * workPosition : 啦啦啦啦啦啦啦
         */

        private String chemicalName;
        private String chemicalNum;
        private String chemicalUnit;
        private String createBy;
        private String createName;
        private String createTime;
        private String enterpriseId;
        private String enterpriseName;
        private String id;
        private String localeImg;
        private String remark;
        private String updateBy;
        private String updateTime;
        private String workPosition;

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

        public String getChemicalUnit() {
            return chemicalUnit;
        }

        public void setChemicalUnit(String chemicalUnit) {
            this.chemicalUnit = chemicalUnit;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
