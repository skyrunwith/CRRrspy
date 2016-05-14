package com.youngheart.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/24.
 */
public class Materil implements Serializable{
    private String materiallotid;
    private String name;
    private String supplierid;
    private String size;
    private String useness;
    private String status;

    public String getMateriallotid() {
        return materiallotid;
    }

    public void setMateriallotid(String materiallotid) {
        this.materiallotid = materiallotid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUseness() {
        return useness;
    }

    public void setUseness(String useness) {
        this.useness = useness;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
