package com.shuren.resume.bean;

import java.util.Calendar;

public class BaseReturns {

	private int status;
    private String error;
	private long servertime = Calendar.getInstance().getTime().getTime();
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public long getServertime() {
		return servertime;
	}
	public void setServertime(long servertime) {
		this.servertime = servertime;
	}
}