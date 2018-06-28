package com.anjian.model.record;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */

public class SysAreaModel {


    /**
     * code : 200
     * count : 0
     * data : [{"areaCode":"36201101","createBy":"1","createTime":"2018-06-28 16:43:30","id":"1012255152452616193","isDel":0,"isParent":null,"layer":3,"name":"测试村","orderNum":0,"parentCode":"350001001","parentId":"988374448447025153","parentName":null,"remark":null,"size":null,"status":0,"updateBy":"1","updateTime":"2018-06-28 16:43:30"}]
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

    public static class DataBean {
        /**
         * areaCode : 36201101
         * createBy : 1
         * createTime : 2018-06-28 16:43:30
         * id : 1012255152452616193
         * isDel : 0
         * isParent : null
         * layer : 3
         * name : 测试村
         * orderNum : 0
         * parentCode : 350001001
         * parentId : 988374448447025153
         * parentName : null
         * remark : null
         * size : null
         * status : 0
         * updateBy : 1
         * updateTime : 2018-06-28 16:43:30
         */
        private String id;
        private String name;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
