package com.youngheart.entity;

import com.youngheart.fragment.TouSuEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/7.
 */
public class risk implements Serializable{
    private TProduct tProduct;
    private List<TouSuEntity> touSuEntities;

    public TProduct gettProduct() {
        return tProduct;
    }

    public void settProduct(TProduct tProduct) {
        this.tProduct = tProduct;
    }

    public List<TouSuEntity> getTouSuEntities() {
        return touSuEntities;
    }

    public void setTouSuEntities(List<TouSuEntity> touSuEntities) {
        this.touSuEntities = touSuEntities;
    }

}
