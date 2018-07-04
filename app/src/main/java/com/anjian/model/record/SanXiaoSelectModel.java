package com.anjian.model.record;

/**
 * Created by Administrator on 2018/7/4.
 */

public class SanXiaoSelectModel {

    /**
     * code : 200
     * count : 0
     * data : {"createBy":"988422934076903425","createName":null,"createTime":"2018-07-04 15:43:06","id":"1014414280692260865","isDel":null,"optionItems":"[{\"itemName\":\"场所内设置影响疏散逃生的防盗窗、铁栅栏\",\"typeName\":\"消防隐患\"},{\"itemName\":\"夹层未设置独立的直通室外的疏散通道\",\"typeName\":\"消防隐患\"}]","remark":null,"tspId":"1014030073084231682","tspName":null,"updateBy":"988422934076903425","updateTime":"2018-07-04 15:43:06"}
     * message : 成功
     */

    private int code;
    private int count;
    private DataBean data;
    private String message;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-04 15:43:06
         * id : 1014414280692260865
         * isDel : null
         * optionItems : [{"itemName":"场所内设置影响疏散逃生的防盗窗、铁栅栏","typeName":"消防隐患"},{"itemName":"夹层未设置独立的直通室外的疏散通道","typeName":"消防隐患"}]
         * remark : null
         * tspId : 1014030073084231682
         * tspName : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-04 15:43:06
         */

        private String createBy;
        private String createName;
        private String createTime;
        private String id;
        private String isDel;
        private String optionItems;
        private String remark;
        private String tspId;
        private String tspName;
        private String updateBy;
        private String updateTime;

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsDel() {
            return isDel;
        }

        public void setIsDel(String isDel) {
            this.isDel = isDel;
        }

        public String getOptionItems() {
            return optionItems;
        }

        public void setOptionItems(String optionItems) {
            this.optionItems = optionItems;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTspId() {
            return tspId;
        }

        public void setTspId(String tspId) {
            this.tspId = tspId;
        }

        public String getTspName() {
            return tspName;
        }

        public void setTspName(String tspName) {
            this.tspName = tspName;
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
