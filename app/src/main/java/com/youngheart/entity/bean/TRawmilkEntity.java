package com.youngheart.entity.bean;
/**
 * Created by Administrator on 2016/4/26.
 */
public class TRawmilkEntity {
    private String rawmilklotid;
    private String name;
    private String tank;
    private String temperature;
    private String size;
    private String milkStationName;

    public String getRawmilklotid() {
        return rawmilklotid;
    }

    public void setRawmilklotid(String rawmilklotid) {
        this.rawmilklotid = rawmilklotid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMilkStationName() {
        return milkStationName;
    }

    public void setMilkStationName(String milkStationName) {
        this.milkStationName = milkStationName;
    }
}
