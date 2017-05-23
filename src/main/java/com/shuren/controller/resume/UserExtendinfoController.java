package com.shuren.controller.resume;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.UserBaseinfoService;
import com.shuren.service.resume.UserExtendinfoService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userExtendinfo")
public class UserExtendinfoController extends BaseController{
	
	@Autowired
	private UserExtendinfoService userExtendinfoService;
	
	public ResponseEntity<Map<String, Object>> queryOne(){
		
		return null;
		
	}
	
}
