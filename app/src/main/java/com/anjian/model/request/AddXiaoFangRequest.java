package com.anjian.model.request;

/**
 * Created by LiMing on 2018/6/30.
 */

public class AddXiaoFangRequest {
    private String id;
    private String enterpriseName;
    private int controlStep;
    private int urgentDevice;
    private int controlStandBook;
    private String existProblem;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getControlStep() {
        return controlStep;
    }

    public void setControlStep(int controlStep) {
        this.controlStep = controlStep;
    }

    public int getUrgentDevice() {
        return urgentDevice;
    }

    public void setUrgentDevice(int urgentDevice) {
        this.urgentDevice = urgentDevice;
    }

    public int getControlStandBook() {
        return controlStandBook;
    }

    public void setControlStandBook(int controlStandBook) {
        this.controlStandBook = controlStandBook;
    }

    public String getExistProblem() {
        return existProblem;
    }

    public void setExistProblem(String existProblem) {
        this.existProblem = existProblem;
    }
}
