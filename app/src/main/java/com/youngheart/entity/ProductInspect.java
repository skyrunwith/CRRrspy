package com.youngheart.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/24.
 */
//营养成分
public class ProductInspect implements Serializable{
    private String productlotid;
    private float protein;
    private float fat;
    private float vitamin;
    private float calcium;
    private float energy;
    private String disinfect;
    private String inspectorid;
    private String remark;

    public String getProductlotid() {
        return productlotid;
    }

    public void setProductlotid(String productlotid) {
        this.productlotid = productlotid;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getVitamin() {
        return vitamin;
    }

    public void setVitamin(float vitamin) {
        this.vitamin = vitamin;
    }

    public float getCalcium() {
        return calcium;
    }

    public void setCalcium(float calcium) {
        this.calcium = calcium;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public String getDisinfect() {
        return disinfect;
    }

    public void setDisinfect(String disinfect) {
        this.disinfect = disinfect;
    }

    public String getInspectorid() {
        return inspectorid;
    }

    public void setInspectorid(String inspectorid) {
        this.inspectorid = inspectorid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
