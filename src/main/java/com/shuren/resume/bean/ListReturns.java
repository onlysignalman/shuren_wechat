package com.shuren.resume.bean;

import java.util.List;

public class ListReturns <T> extends BaseReturns {

	private int count;
    private List<T> list;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
