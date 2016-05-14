package com.youngheart.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/9.
 */
public class Saler implements Serializable{
    private String salerid;

    private String name;

    private String production;

    private String address;

    private String corporation;

    private String telephone;

    private String postcode;

    private String remark;

    public String getSalerid() {
        return salerid;
    }

    public void setSalerid(String salerid) {
        this.salerid = salerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
