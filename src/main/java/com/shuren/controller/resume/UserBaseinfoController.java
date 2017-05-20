package com.shuren.controller.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuren.bean.resume.BaseReturns;
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
	
	@RequestMapping("/register")
	public void register(@ModelAttribute UserBaseinfo userBaseinfo){
		BaseReturns returns = userBaseinfoService.register(userBaseinfo);
		WriteJson(returns);
	}
	
	@RequestMapping("/login")
	public void login(@ModelAttribute UserBaseinfo userBaseinfo){
		ModelReturns<UserBaseinfo> returns = userBaseinfoService.login(userBaseinfo);
		WriteJson(returns);
	}
	
	@RequestMapping("/forget")
	public void forget(@ModelAttribute UserBaseinfo userBaseinfo,
			@RequestParam(value="validate", required=true)String validate){
		BaseReturns returns = userBaseinfoService.forget(userBaseinfo, validate);
		WriteJson(returns);
	}
}
