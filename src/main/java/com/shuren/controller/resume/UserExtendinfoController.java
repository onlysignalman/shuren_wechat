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
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.pojo.resume.LanguageCapacity;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.pojo.resume.UserExtendinfo;
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
	
	@RequestMapping("/add")
	public ResponseEntity<BaseReturns> addUserExtendinfo(@ModelAttribute UserExtendinfo userExtendinfo, HttpSession session){
		BaseReturns returns = new BaseReturns();
		Integer userId = null;
		//登录判断
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
		userExtendinfo.setUserId(userId);
		returns = userExtendinfoService.add(userExtendinfo);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/update")
	public ResponseEntity<BaseReturns> updateUserExtendinfo(@ModelAttribute UserExtendinfo userExtendinfo, HttpSession session){
		BaseReturns returns = new BaseReturns();
		Integer userId = null;
		//登录判断
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
		userExtendinfo.setUserId(userId);
		returns = userExtendinfoService.update(userExtendinfo);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/getOne")
	public ResponseEntity<ModelReturns<UserExtendinfo>> getOne(HttpSession session){
		ModelReturns<UserExtendinfo> returns = new ModelReturns<UserExtendinfo>();
		Integer userId = null;
		//登录判断
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
		returns = userExtendinfoService.getOne(userId);
		return ResponseEntity.ok(returns);
	}
	
}
