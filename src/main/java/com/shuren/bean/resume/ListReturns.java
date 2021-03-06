package com.shuren.bean.resume;

import java.util.List;

public class ListReturns <T> extends BaseReturns {

	private Long count;
    private List<T> list;



	public ListReturns(Integer status, String error,Long count, List<T> list) {

		this.count = count;
		this.list = list;
	}

	public ListReturns() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
