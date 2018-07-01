package com.anjian.model.record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiMing on 2018/7/1.
 */

public class SanXiaoSelectListModel {
    private String title;
    private List<DataBean> options=new ArrayList<>();
    public static class DataBean  {
        private String content;
        private boolean isselect;

        public DataBean(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isselect() {
            return isselect;
        }

        public void setIsselect(boolean isselect) {
            this.isselect = isselect;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataBean> getOptions() {
        return options;
    }

    public void setOptions(List<DataBean> options) {
        this.options = options;
    }
}
