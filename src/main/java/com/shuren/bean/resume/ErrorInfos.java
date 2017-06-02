package com.shuren.bean.resume;

public interface ErrorInfos {

	public final static BaseErrorInfo GAISHOUJIHAOYIZHUCHE = new BaseErrorInfo("该手机号已注册", -1);
	public final static BaseErrorInfo SHOUJIHAOHUOMIMACUOWU = new BaseErrorInfo("手机号或密码错误", -2);
	public final static BaseErrorInfo YANZHENGMACUOWU = new BaseErrorInfo("验证码错误", -3);
	public final static BaseErrorInfo YANZHENGMAGUOQI = new BaseErrorInfo("验证码过期", -4);
	public final static BaseErrorInfo YONGHUWEIDENGLU = new BaseErrorInfo("用户未登录", -5);
	public final static BaseErrorInfo LOGINSUCCESS = new BaseErrorInfo("登录成功", 0);

	public final static BaseErrorInfo PAGEDATASUCCESS = new BaseErrorInfo("请求成功", 0);

	public final static BaseErrorInfo RESUMEDATASUCCESS = new BaseErrorInfo("请求成功", 0);

	public final static BaseErrorInfo ARTICLEDATASUCCESS = new BaseErrorInfo("请求成功", 0);


}
