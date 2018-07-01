package com.anjian.model.request;

/**
 * Created by LiMing on 2018/7/1.
 */

public class AddYanLianRequest {

    private String tspId;
    private String title;
    private String localeTeachImg;
    private String locale_act_img;
    private String selfer_sign;

    public String getTspId() {
        return tspId;
    }

    public void setTspId(String tspId) {
        this.tspId = tspId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocaleTeachImg() {
        return localeTeachImg;
    }

    public void setLocaleTeachImg(String localeTeachImg) {
        this.localeTeachImg = localeTeachImg;
    }

    public String getLocale_act_img() {
        return locale_act_img;
    }

    public void setLocale_act_img(String locale_act_img) {
        this.locale_act_img = locale_act_img;
    }

    public String getSelfer_sign() {
        return selfer_sign;
    }

    public void setSelfer_sign(String selfer_sign) {
        this.selfer_sign = selfer_sign;
    }
}
