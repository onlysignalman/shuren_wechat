package com.shuren.controller.resume;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.pojo.resume.LanguageCapacity;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.LanguageCapacityService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/languageCapacity")
public class LanguageCapacityController {
	
	@Autowired
	private LanguageCapacityService languageCapacityService;
	
	@RequestMapping("/addLanguage")
	public ResponseEntity<BaseReturns> addLanguage(@ModelAttribute LanguageCapacity languageCapacity, HttpSession session){
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
		languageCapacity.setUserId(userId);
		returns = languageCapacityService.add(languageCapacity);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/updateLanguage")
	public ResponseEntity<BaseReturns> updateLanguage(@ModelAttribute LanguageCapacity languageCapacity, HttpSession session){
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
		languageCapacity.setUserId(userId);
		returns = languageCapacityService.update(languageCapacity);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/getLanguages")
	public ResponseEntity<ListReturns<LanguageCapacity>> getLanguages(@ModelAttribute LanguageCapacity languageCapacity, HttpSession session){
		ListReturns<LanguageCapacity> returns = new ListReturns<LanguageCapacity>();
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
		languageCapacity.setUserId(userId);
		returns = languageCapacityService.getLanguages(languageCapacity);
		return ResponseEntity.ok(returns);
		
	}
}
