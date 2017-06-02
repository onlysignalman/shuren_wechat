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
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.JobExperienceService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/jobExperience")
public class JobExperienceController {
	
	@Autowired
	private JobExperienceService jobExperienceService;
	
	@RequestMapping("/addJob")
	public ResponseEntity<BaseReturns> addJob(@ModelAttribute JobExperience jobExperience, HttpSession session){
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
		jobExperience.setUserId(userId);
		returns = jobExperienceService.add(jobExperience);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/updateJob")
	public ResponseEntity<BaseReturns> updateJob(@ModelAttribute JobExperience jobExperience, HttpSession session){
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
		jobExperience.setUserId(userId);
		returns = jobExperienceService.update(jobExperience);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/getJobs")
	public ResponseEntity<ListReturns<JobExperience>> getJobs(@ModelAttribute JobExperience jobExperience, HttpSession session){
		ListReturns<JobExperience> returns = new ListReturns<JobExperience>();
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
		jobExperience.setUserId(userId);
		returns = jobExperienceService.getJobs(jobExperience);
		return ResponseEntity.ok(returns);
		
	}
}
