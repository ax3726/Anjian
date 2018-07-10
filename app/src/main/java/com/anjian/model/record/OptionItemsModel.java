package com.anjian.model.record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/10.
 */

public class OptionItemsModel {

    /**
     * typeName : 主体合法
     * itemList : [{"itemName":"证照齐全有效","status":"0"},{"itemName":"生产经营活动符合核准、许可范围。","status":1},{"itemName":"无违规转让、出租证照行为。","status":1}]
     * seq : 1
     */

    private String typeName;
    private int seq;
    private List<ItemListBean> itemList=new ArrayList<>();

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * itemName : 证照齐全有效
         * status : 0
         */

        private String itemName;
        private int status;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
