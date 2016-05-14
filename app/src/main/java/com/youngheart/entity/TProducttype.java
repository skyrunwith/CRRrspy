package com.youngheart.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/7.
 */
public class TProducttype implements Serializable{
 
    private  String producttypeid;

    
    private  String name;

// 
    public String getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(String producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
