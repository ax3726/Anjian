package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class FengXianListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-06-30 14:54:42","dangerLevel":"B","dangerName":"测试了","detailPosition":"大厅","easyHappenCaseType":"啦啦啦啦啦啦啦","enterpriseId":"1012329476849090561","enterpriseName":null,"id":"1012952546882232322","isDel":0,"localeImg":null,"lossPrediction":"空军建军节","modifyStep":"啦咯啦咯啦咯","updateBy":"988422934076903425","updateTime":"2018-06-30 14:54:42"}]
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
         * createTime : 2018-06-30 14:54:42
         * dangerLevel : B
         * dangerName : 测试了
         * detailPosition : 大厅
         * easyHappenCaseType : 啦啦啦啦啦啦啦
         * enterpriseId : 1012329476849090561
         * enterpriseName : null
         * id : 1012952546882232322
         * isDel : 0
         * localeImg : null
         * lossPrediction : 空军建军节
         * modifyStep : 啦咯啦咯啦咯
         * updateBy : 988422934076903425
         * updateTime : 2018-06-30 14:54:42
         */

        private String createBy;
        private String createName;
        private String createTime;
        private String dangerLevel;
        private String dangerName;
        private String detailPosition;
        private String easyHappenCaseType;
        private String enterpriseId;
        private String enterpriseName;
        private String id;
        private int isDel;
        private String localeImg;
        private String lossPrediction;
        private String modifyStep;
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

        public String getDangerLevel() {
            return dangerLevel;
        }

        public void setDangerLevel(String dangerLevel) {
            this.dangerLevel = dangerLevel;
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

        public String getEasyHappenCaseType() {
            return easyHappenCaseType;
        }

        public void setEasyHappenCaseType(String easyHappenCaseType) {
            this.easyHappenCaseType = easyHappenCaseType;
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



        public String getLossPrediction() {
            return lossPrediction;
        }

        public void setLossPrediction(String lossPrediction) {
            this.lossPrediction = lossPrediction;
        }

        public String getModifyStep() {
            return modifyStep;
        }

        public void setModifyStep(String modifyStep) {
            this.modifyStep = modifyStep;
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
    }
}
