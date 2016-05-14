package com.youngheart.entity;

import java.io.Serializable;

public class ResultPO <T> extends BaseCommon implements Serializable {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
