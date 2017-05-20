package com.shuren.pojo.resume;

public class BaseErrorInfo {
	
	private String error;
	private int status;
	
	public BaseErrorInfo(String error, int status) {
		// TODO Auto-generated constructor stub
		this.error = error;
		this.status = status;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
