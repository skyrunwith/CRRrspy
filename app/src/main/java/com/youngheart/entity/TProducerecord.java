package com.youngheart.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/7.
 */

public class TProducerecord implements Serializable{

    
    private String productlotid;
    
    private String rawmilklotid;
    
    private String accessorylotid;
   
    private String packagelotid;
   
    private String processid;
    
    private String producedate;
   
    private String operatorid;
   
    private String workshop;
   
    private String image;
 
    private String status;
  
    private String amount;
 
    private String remark;

    private ProductInspect productInspect;

    private Employee employee;

    public ProductInspect getProductInspect() {
        return productInspect;
    }

    public void setProductInspect(ProductInspect productInspect) {
        this.productInspect = productInspect;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProductlotid() {
        return productlotid;
    }

    public void setProductlotid(String productlotid) {
        this.productlotid = productlotid;
    }

    public String getRawmilklotid() {
        return rawmilklotid;
    }

    public void setRawmilklotid(String rawmilklotid) {
        this.rawmilklotid = rawmilklotid;
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

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid;
    }

    public String getProducedate() {
        return producedate;
    }

    public void setProducedate(String producedate) {
        this.producedate = producedate;
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
