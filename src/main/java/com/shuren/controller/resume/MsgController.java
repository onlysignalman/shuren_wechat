package com.shuren.controller.resume;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.MsgService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/msg")
public class MsgController extends BaseController{
	
	@Autowired
	private MsgService msgService;
	
	@RequestMapping("/getMsg")
	public void getMsg(@RequestParam(value="mobile", required=true) String mobile){
		ModelReturns<Map<String, Object>> returns = msgService.getMsg(mobile);
		WriteJson(returns);
	}
	
	@RequestMapping("/getLastMsg")
	public void getLastMsg(@RequestParam(value="mobile", required=true) String mobile){
		ModelReturns<Map<String, Object>> returns = msgService.getLastMsg(mobile);
		WriteJson(returns);
	}
}
