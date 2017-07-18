package com.shuren.controller.resume;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.MessageLog;
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
	public ResponseEntity<ModelReturns<Map<String, Object>>> getMsg(@RequestParam(value="mobile", required=true) String mobile){
		ModelReturns<Map<String, Object>> returns = msgService.getMsg(mobile);
		return ResponseEntity.ok(returns);
	}
	
	@RequestMapping("/getLastMsg")
	public ResponseEntity<ModelReturns<MessageLog>> getLastMsg(@RequestParam(value="mobile", required=true) String mobile){
		ModelReturns<MessageLog> returns = msgService.getLastMsg(mobile);
		return ResponseEntity.ok(returns);
	}
}
