package com.youngheart.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/9.
 */
public class Car implements Serializable{
   
    private String carid;

    private String type;
    
    private String temperature;

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
