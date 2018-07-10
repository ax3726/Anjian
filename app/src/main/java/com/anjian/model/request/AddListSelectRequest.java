package com.anjian.model.request;

/**
 * Created by LiMing on 2018/7/1.
 */

public class AddListSelectRequest {

    private ConditionBean condition=new ConditionBean();

    public ConditionBean getCondition() {
        return condition;
    }

    public void setCondition(ConditionBean condition) {
        this.condition = condition;
    }

    public static class ConditionBean {
        /**
         * id : 1012329476849090561
         */

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
