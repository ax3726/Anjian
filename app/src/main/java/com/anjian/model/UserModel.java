package com.anjian.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/28.
 */

public class UserModel implements Serializable{
    private String user;
    private String password;
    private String areaName;

    public UserModel(String user, String password, String areaName) {
        this.user = user;
        this.password = password;
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
