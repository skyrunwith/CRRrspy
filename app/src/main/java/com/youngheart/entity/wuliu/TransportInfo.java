package com.youngheart.entity.wuliu;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/25.
 */
public class TransportInfo implements Serializable{
    private String producerName;
    private String productName;
    private String transportBatch;
    private String transportTime;
    private String transportCar;
    private String driver;
    private String temperature;
    private String salerName;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getTransportBatch() {
        return transportBatch;
    }

    public void setTransportBatch(String transportBatch) {
        this.transportBatch = transportBatch;
    }

    public String getTransportTime() {
        return transportTime;
    }

    public void setTransportTime(String transportTime) {
        this.transportTime = transportTime;
    }

    public String getTransportCar() {
        return transportCar;
    }

    public void setTransportCar(String transportCar) {
        this.transportCar = transportCar;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }
}
