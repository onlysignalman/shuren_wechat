package com.shuren.resume.bean;

public class ModelReturns <T> extends BaseReturns{

	private T model;

	public T getModel() {
        return model;
	}
	public void setModel(T model) {
		this.model = model;
	}
}
