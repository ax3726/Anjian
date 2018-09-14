package com.anjian.model.main;

/**
 * Created by Administrator on 2018/6/28.
 */

public class LoginModel {


    /**
     * code : 200
     * count : 0
     * data : {"placeId":null,"placeType":null,"areaId":"988438702663471106","userType":"1","areaName":"鲤城区","token":"25a5b143ee0c47150eeae0a14c34552e"}
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
         * placeId : null
         * placeType : null
         * areaId : 988438702663471106
         * userType : 1
         * areaName : 鲤城区
         * token : 25a5b143ee0c47150eeae0a14c34552e
         */

        private String placeId;
        private String placeType;
        private String areaId;
        private String userType;
        private String areaName;
        private String token;

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public String getPlaceType() {
            return placeType;
        }

        public void setPlaceType(String placeType) {
            this.placeType = placeType;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
