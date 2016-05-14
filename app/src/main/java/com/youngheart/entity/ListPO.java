package com.youngheart.entity;

import java.util.ArrayList;
import java.util.List;

public class ListPO<T> extends BaseCommon {
	private List<T> list;

	public ListPO() {
		list = new ArrayList<T>();
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
