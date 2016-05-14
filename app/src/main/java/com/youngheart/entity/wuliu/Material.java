package com.youngheart.entity.wuliu;

import com.youngheart.entity.Package;
import com.youngheart.entity.bean.TMaterialEntity;
import com.youngheart.entity.bean.TMilkingEntity;
import com.youngheart.entity.bean.TOrderEntity;
import com.youngheart.entity.bean.TRawmilkEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Material implements Serializable{
    private TOrderEntity oder;
    private TRawmilkEntity rawMilk;
    private TMilkingEntity  milk;
    private List<TMaterialEntity> materials;
    private Package aPackage;

    public TOrderEntity getOder() {
        return oder;
    }

    public void setOder(TOrderEntity oder) {
        this.oder = oder;
    }

    public TRawmilkEntity getRawMilk() {
        return rawMilk;
    }

    public void setRawMilk(TRawmilkEntity rawMilk) {
        this.rawMilk = rawMilk;
    }

    public TMilkingEntity getMilk() {
        return milk;
    }

    public void setMilk(TMilkingEntity milk) {
        this.milk = milk;
    }

    public List<TMaterialEntity> getMaterials() {
        return materials;
    }

    public void setMaterials(List<TMaterialEntity> materials) {
        this.materials = materials;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }
}
