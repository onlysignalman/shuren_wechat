package com.shuren.controller.resume;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.UserBaseinfoService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/userBaseinfo")
public class UserBaseinfoController extends BaseController{
	
	@Autowired
	private UserBaseinfoService userBaseinfoService;
	
	/**
	 * 用户注册
	 * @param userBaseinfo
	 */
	@RequestMapping("/register")
	public ResponseEntity<BaseReturns> register(@ModelAttribute UserBaseinfo userBaseinfo,
			@RequestParam(value="msg", required=true)String msg){
		BaseReturns returns = userBaseinfoService.register(userBaseinfo, msg);
		return ResponseEntity.ok(returns);
	}
	
	/**
	 * 用户登录
	 * @param userBaseinfo
	 */
	@RequestMapping("/login")
	public ResponseEntity<ModelReturns<UserBaseinfo>> login(@ModelAttribute UserBaseinfo userBaseinfo, HttpSession session){
		ModelReturns<UserBaseinfo> returns = userBaseinfoService.login(userBaseinfo);
		//登录成功
		if (returns.getStatus()==0){
			session.setAttribute("user",returns.getModel());
		}
		return ResponseEntity.ok(returns);
	}
	
	/**
	 * 忘记密码,更新密码
	 * @param userBaseinfo
	 * @param validate
	 */
	@RequestMapping("/forget")
	public ResponseEntity<BaseReturns> forget(@ModelAttribute UserBaseinfo userBaseinfo,
			@RequestParam(value="msg", required=true)String msg){
		BaseReturns returns = userBaseinfoService.forget(userBaseinfo, msg);
		return ResponseEntity.ok(returns);
	}
	
	/**
	 * 获得分数
	 */
	@RequestMapping("/getScore")
	public ResponseEntity<ModelReturns<String>> getScore(HttpSession session){
		ModelReturns<String> returns = new ModelReturns<String>();
		//登录判断
		Integer userId = null;
		Object userBaseinfo = session.getAttribute("user");
		if (userBaseinfo != null && userBaseinfo instanceof UserBaseinfo){
			UserBaseinfo user = (UserBaseinfo)userBaseinfo;
			userId = user.getUserId();
		}
		if(userId == null || userId <= 0){
			returns.setError(ErrorInfos.YONGHUWEIDENGLU.getError());
			returns.setStatus(ErrorInfos.YONGHUWEIDENGLU.getStatus());
			return ResponseEntity.ok(returns);
		}
		returns = userBaseinfoService.getScore(userId);
		return ResponseEntity.ok(returns);
	}
}
