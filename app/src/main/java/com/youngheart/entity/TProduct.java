package com.youngheart.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */

public class TProduct implements Serializable{
   
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
    private String producedate;
    private String produceName;
    private String packageName;

    private ProductInspect productInspect;
    private List<ProductComment> comments;
    private List<Materil> materils;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ProductInspect getProductInspect() {
        return productInspect;
    }

    public void setProductInspect(ProductInspect productInspect) {
        this.productInspect = productInspect;
    }

    public List<ProductComment> getComments() {
        return comments;
    }

    public void setComments(List<ProductComment> comments) {
        this.comments = comments;
    }

    public List<Materil> getMaterils() {
        return materils;
    }

    public void setMaterils(List<Materil> materils) {
        this.materils = materils;
    }


    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

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

    public String getProducedate() {
        return producedate;
    }

    public void setProducedate(String producedate) {
        this.producedate = producedate;
    }
}
