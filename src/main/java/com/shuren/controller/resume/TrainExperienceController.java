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
import com.shuren.pojo.resume.TrainExperience;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.TrainExperienceService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/trainExperience")
public class TrainExperienceController {
	
	@Autowired
	private TrainExperienceService trainExperienceService;
	
	@RequestMapping("/addTrain")
	public ResponseEntity<BaseReturns> addTrain(@ModelAttribute TrainExperience trainExperience, HttpSession session){
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
		trainExperience.setUserId(userId);
		returns = trainExperienceService.add(trainExperience);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/updateTrain")
	public ResponseEntity<BaseReturns> updateTrain(@ModelAttribute TrainExperience trainExperience, HttpSession session){
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
		trainExperience.setUserId(userId);
		returns = trainExperienceService.update(trainExperience);
		return ResponseEntity.ok(returns);
		
	}
	
	@RequestMapping("/getTrains")
	public ResponseEntity<ListReturns<TrainExperience>> getTrains(@ModelAttribute TrainExperience trainExperience, HttpSession session){
		ListReturns<TrainExperience> returns = new ListReturns<TrainExperience>();
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
		trainExperience.setUserId(userId);
		returns = trainExperienceService.getTrains(trainExperience);
		return ResponseEntity.ok(returns);
		
	}
	
}
