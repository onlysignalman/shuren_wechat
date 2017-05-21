package com.shuren.bean.resume;


import com.shuren.pojo.resume.UserBaseinfo;

public class UserThreadLocal {

	//声明一个存放用户的ThreadLocal
	private static ThreadLocal<UserBaseinfo> threadLocal = new ThreadLocal<>();

	public static void setUser(UserBaseinfo user){
		threadLocal.set(user);
	}

	public static UserBaseinfo getUser(){
		UserBaseinfo user = threadLocal.get();
		return user;
	}

}
