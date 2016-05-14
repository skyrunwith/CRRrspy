package com.youngheart.entity.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class TMilkingEntity {
    private String cowid;
    private String rawmilklotid;
    private String farmName;
    private String date;
    private String status;
    private String amount;

    public String getCowid() {
        return cowid;
    }

    public void setCowid(String cowid) {
        this.cowid = cowid;
    }

    public String getRawmilklotid() {
        return rawmilklotid;
    }

    public void setRawmilklotid(String rawmilklotid) {
        this.rawmilklotid = rawmilklotid;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
