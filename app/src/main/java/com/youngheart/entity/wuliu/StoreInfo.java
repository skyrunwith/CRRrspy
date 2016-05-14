package com.youngheart.entity.wuliu;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/25.
 */
public class StoreInfo implements Serializable{
    private String wearHouseName;
    private String traceCode;
    private String produceName;
    private String produceBatch;
    private String produceTime;
    private String room;
    private String inTime;
    private String outTime;
    private String temperature;
    private String account;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWearHouseName() {
        return wearHouseName;
    }

    public void setWearHouseName(String wearHouseName) {
        this.wearHouseName = wearHouseName;
    }

    public String getProduceBatch() {
        return produceBatch;
    }

    public void setProduceBatch(String produceBatch) {
        this.produceBatch = produceBatch;
    }

    public String getTraceCode() {
        return traceCode;
    }

    public void setTraceCode(String traceCode) {
        this.traceCode = traceCode;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
