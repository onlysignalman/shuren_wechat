package com.shuren.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shuren.bean.resume.UserThreadLocal;
import com.shuren.pojo.resume.UserBaseinfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录拦截器
 * @author join
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//获取当前登录的用户信息
		UserBaseinfo user = (UserBaseinfo) request.getSession().getAttribute("user");

		//判断用户是否登录
		if(user==null){
			//TODO
			// 没有登录，跳转登录页面
			return true;
		}else{
			//将用户信息存在ThreadLocal中
			UserThreadLocal.setUser(user);
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
