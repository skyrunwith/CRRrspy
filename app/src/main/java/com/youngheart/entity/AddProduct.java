package com.youngheart.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/1.
 */
public class AddProduct implements Serializable{
    private String productid;
    private String productlotid;
    private String producttypeid;
    private String introduction;
    private String tracecode;
    private String producerid;
    private String productname;
    private String size;
    private String expiration;
    private String image;
    private String remark;
    private Date premiereDate;
    private Date producedate;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductlotid() {
        return productlotid;
    }

    public void setProductlotid(String productlotid) {
        this.productlotid = productlotid;
    }

    public String getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(String producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTracecode() {
        return tracecode;
    }

    public void setTracecode(String tracecode) {
        this.tracecode = tracecode;
    }

    public String getProducerid() {
        return producerid;
    }

    public void setProducerid(String producerid) {
        this.producerid = producerid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public Date getProducedate() {
        return producedate;
    }

    public void setProducedate(Date producedate) {
        this.producedate = producedate;
    }
}
