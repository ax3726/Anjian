package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class YanLianListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":"988422934076903425","createName":null,"createTime":"2018-07-01 18:22:33","enterpriseName":null,"id":"1013367241862782978","localeActImg":null,"localeTeachImg":null,"remark":null,"selferSign":null,"title":"这个是标题","tspId":"1013363647155511297","updateBy":"988422934076903425","updateTime":"2018-07-01 18:22:33"}]
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
         * createTime : 2018-07-01 18:22:33
         * enterpriseName : null
         * id : 1013367241862782978
         * localeActImg : null
         * localeTeachImg : null
         * remark : null
         * selferSign : null
         * title : 这个是标题
         * tspId : 1013363647155511297
         * updateBy : 988422934076903425
         * updateTime : 2018-07-01 18:22:33
         */

        private String createBy;
        private String createName;
        private String createTime;
        private String enterpriseName;
        private String id;
        private String localeActImg;
        private String localeTeachImg;
        private String remark;
        private String selferSign;
        private String title;
        private String tspId;
        private String letId;
        private String updateBy;
        private String updateTime;

        public String getLetId() {
            return letId;
        }

        public void setLetId(String letId) {
            this.letId = letId;
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


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }




        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTspId() {
            return tspId;
        }

        public void setTspId(String tspId) {
            this.tspId = tspId;
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

        public String getLocaleActImg() {
            return localeActImg;
        }

        public void setLocaleActImg(String localeActImg) {
            this.localeActImg = localeActImg;
        }

        public String getLocaleTeachImg() {
            return localeTeachImg;
        }

        public void setLocaleTeachImg(String localeTeachImg) {
            this.localeTeachImg = localeTeachImg;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSelferSign() {
            return selferSign;
        }

        public void setSelferSign(String selferSign) {
            this.selferSign = selferSign;
        }
    }
}
