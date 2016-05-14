package com.youngheart.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/9.
 */
public class Transport implements Serializable{
 
    private String productlotid;

    private String transporttime;

    private String company;

    private String route;

    private String salerid;

    private String driverid;

    private String carid;

    private String image;

    private String remark;

    private Car car;
    
    private Employee employee;
    
    private Saler saler;
    
    private TProducerecord tProducerecord;
    
    
    
    
    public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Saler getSaler() {
		return saler;
	}

	public void setSaler(Saler saler) {
		this.saler = saler;
	}

	public TProducerecord gettProducerecord() {
		return tProducerecord;
	}

	public void settProducerecord(TProducerecord tProducerecord) {
		this.tProducerecord = tProducerecord;
	}

	public String getProductlotid() {
        return productlotid;
    }

    public void setProductlotid(String productlotid) {
        this.productlotid = productlotid;
    }

    public String getTransporttime() {
        return transporttime;
    }

    public void setTransporttime(String transporttime) {
        this.transporttime = transporttime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getSalerid() {
        return salerid;
    }

    public void setSalerid(String salerid) {
        this.salerid = salerid;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
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
}
