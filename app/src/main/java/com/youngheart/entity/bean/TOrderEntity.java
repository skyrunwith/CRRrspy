package com.youngheart.entity.bean;
/**
 * Created by Administrator on 2016/4/26.
 */
public class TOrderEntity {
    private String orderid;
    private String employeeName;
    private String date;
    private String status;
    private String remark;
    private String accessorylotid;
    private String packagelotid;
    private String rawmilklotid;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAccessorylotid() {
        return accessorylotid;
    }

    public void setAccessorylotid(String accessorylotid) {
        this.accessorylotid = accessorylotid;
    }

    public String getPackagelotid() {
        return packagelotid;
    }

    public void setPackagelotid(String packagelotid) {
        this.packagelotid = packagelotid;
    }

    public String getRawmilklotid() {
        return rawmilklotid;
    }

    public void setRawmilklotid(String rawmilklotid) {
        this.rawmilklotid = rawmilklotid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

