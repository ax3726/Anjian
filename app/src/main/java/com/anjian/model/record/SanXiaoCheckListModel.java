package com.anjian.model.record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class SanXiaoCheckListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"businesserSign":"/tspLocaleExamine/2018/7/4/bc985297e8b74f79a09a289744f42bbe.png","createBy":"988422934076903425","createName":null,"createTime":"2018-07-04 16:00:09","dangerDesc":"模型可怜","id":"1014418570622197762","isDel":0,"lawReason":"caulk","localeImg":"/tspLocaleExamine/2018/7/4/b6e4a8cf7425407aae316d02962a7d17.png","modifyImg":null,"modifyStatus":0,"modifyStep":"萝莉控","modifyTime":null,"optionId":"1014418435674660866","saferSign":"/tspLocaleExamine/2018/7/4/dae930cfef104dd2babaafeb72b60ae3.png","tspId":"1014030073084231682","tspName":null,"updateBy":"988422934076903425","updateTime":"2018-07-04 16:00:09","witherSign":"/tspLocaleExamine/2018/7/4/fb46c7a0783047f38f22a27077178c0e.png"}]
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
         * businesserSign : /tspLocaleExamine/2018/7/4/bc985297e8b74f79a09a289744f42bbe.png
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-04 16:00:09
         * dangerDesc : 模型可怜
         * id : 1014418570622197762
         * isDel : 0
         * lawReason : caulk
         * localeImg : /tspLocaleExamine/2018/7/4/b6e4a8cf7425407aae316d02962a7d17.png
         * modifyImg : null
         * modifyStatus : 0
         * modifyStep : 萝莉控
         * modifyTime : null
         * optionId : 1014418435674660866
         * saferSign : /tspLocaleExamine/2018/7/4/dae930cfef104dd2babaafeb72b60ae3.png
         * tspId : 1014030073084231682
         * tspName : null
         * updateBy : 988422934076903425
         * updateTime : 2018-07-04 16:00:09
         * witherSign : /tspLocaleExamine/2018/7/4/fb46c7a0783047f38f22a27077178c0e.png
         */

        private String businesserSign;
        private String createBy;
        private String createName;
        private String createTime;
        private String dangerDesc;
        private String id;
        private int isDel;
        private String lawReason;
        private String localeImg;
        private String modifyImg;
        private int modifyStatus;
        private int modifyExpire;
        private String modifyStep;
        private String modifyTime;
        private String optionId;
        private String saferSign;
        private String tspId;
        private String tspName;
        private String letId;
        private String letName;
        private String otpId;
        private String otpName;
        private String updateBy;
        private String updateTime;
        private String witherSign;

        public String getLetId() {
            return letId;
        }

        public String getOtpId() {
            return otpId;
        }

        public void setOtpId(String otpId) {
            this.otpId = otpId;
        }

        public String getOtpName() {
            return otpName;
        }

        public void setOtpName(String otpName) {
            this.otpName = otpName;
        }

        public void setLetId(String letId) {
            this.letId = letId;
        }

        public String getLetName() {
            return letName;
        }

        public void setLetName(String letName) {
            this.letName = letName;
        }

        public int getModifyExpire() {
            return modifyExpire;
        }

        public void setModifyExpire(int modifyExpire) {
            this.modifyExpire = modifyExpire;
        }

        public String getBusinesserSign() {
            return businesserSign;
        }

        public void setBusinesserSign(String businesserSign) {
            this.businesserSign = businesserSign;
        }

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

        public String getDangerDesc() {
            return dangerDesc;
        }

        public void setDangerDesc(String dangerDesc) {
            this.dangerDesc = dangerDesc;
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

        public String getLawReason() {
            return lawReason;
        }

        public void setLawReason(String lawReason) {
            this.lawReason = lawReason;
        }

        public String getLocaleImg() {
            return localeImg;
        }

        public void setLocaleImg(String localeImg) {
            this.localeImg = localeImg;
        }

        public String getModifyImg() {
            return modifyImg;
        }

        public void setModifyImg(String modifyImg) {
            this.modifyImg = modifyImg;
        }

        public int getModifyStatus() {
            return modifyStatus;
        }

        public void setModifyStatus(int modifyStatus) {
            this.modifyStatus = modifyStatus;
        }

        public String getModifyStep() {
            return modifyStep;
        }

        public void setModifyStep(String modifyStep) {
            this.modifyStep = modifyStep;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public String getSaferSign() {
            return saferSign;
        }

        public void setSaferSign(String saferSign) {
            this.saferSign = saferSign;
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

        public String getWitherSign() {
            return witherSign;
        }

        public void setWitherSign(String witherSign) {
            this.witherSign = witherSign;
        }
    }
}
