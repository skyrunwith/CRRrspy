package com.youngheart.entity.bean;

public class TFeedingEntity {
    private String cowid;
    private String date;
    private String remark;
    private String farmName;
    private TFeedstuffEntity feedstuffEntity;
    private String EmployName;

    public String getCowid() {
        return cowid;
    }

    public void setCowid(String cowid) {
        this.cowid = cowid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public TFeedstuffEntity getFeedstuffEntity() {
        return feedstuffEntity;
    }

    public void setFeedstuffEntity(TFeedstuffEntity feedstuffEntity) {
        this.feedstuffEntity = feedstuffEntity;
    }

    public String getEmployName() {
        return EmployName;
    }

    public void setEmployName(String employName) {
        EmployName = employName;
    }
}
