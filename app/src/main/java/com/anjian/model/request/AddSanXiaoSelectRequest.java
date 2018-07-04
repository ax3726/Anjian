package com.anjian.model.request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class AddSanXiaoSelectRequest {
    private String tspId;
    private List<DataBean> optionItems;

    public static class DataBean {

        private String typeName;
        private String itemName;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
    }

    public String getTspId() {
        return tspId;
    }

    public void setTspId(String tspId) {
        this.tspId = tspId;
    }

    public List<DataBean> getOptionItems() {
        return optionItems;
    }

    public void setOptionItems(List<DataBean> optionItems) {
        this.optionItems = optionItems;
    }
}
