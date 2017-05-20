package com.shuren.controller.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shuren.service.resume.UserBaseinfoService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/userBaseinfo")
public class UserBaseinfoController {
	
	@Autowired
	private UserBaseinfoService userBaseinfoService;
	
	
	@RequestMapping("/register")
	public void register(){
		
	}
	
	
	
	@RequestMapping("/login")
	public void login(){
		
		
		
	}
	
}
