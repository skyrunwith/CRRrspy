package com.youngheart.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/24.
 */
public class Package implements Serializable{
    private String packagelotid;
    private String name;
    private String supplierName;
    private String material;
    private String usefor;
    private String size;
    private String inspection;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackagelotid() {
        return packagelotid;
    }

    public void setPackagelotid(String packagelotid) {
        this.packagelotid = packagelotid;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getUsefor() {
        return usefor;
    }

    public void setUsefor(String usefor) {
        this.usefor = usefor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
