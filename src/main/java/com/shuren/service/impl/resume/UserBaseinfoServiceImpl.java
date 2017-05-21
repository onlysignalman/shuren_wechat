package com.shuren.service.impl.resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.mapper.resume.UserBaseinfoMapper;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.MsgService;
import com.shuren.service.resume.UserBaseinfoService;
import com.shuren.utils.wechat.SecurityUtils;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("userBaseinfoService")
public class UserBaseinfoServiceImpl implements UserBaseinfoService {

	@Autowired
	private UserBaseinfoMapper userBaseinfoMapper;
	
	@Autowired
	private MsgService msgService;
	
	@Override
	public BaseReturns register(UserBaseinfo userBaseinfo) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		//1.判断是否已经注册
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", userBaseinfo.getMobile());
		if(userBaseinfoMapper.queryCount(params) != null &&
				userBaseinfoMapper.queryCount(params) > 0){
			returns.setError(ErrorInfos.GAISHOUJIHAOYIZHUCHE.getError());
			returns.setStatus(ErrorInfos.GAISHOUJIHAOYIZHUCHE.getStatus());
			return returns;
		}
		userBaseinfo.setPassword(SecurityUtils.MD5(userBaseinfo.getPassword()));
		userBaseinfoMapper.register(userBaseinfo);
		return returns;
	}

	@Override
	public ModelReturns<UserBaseinfo> login(UserBaseinfo userBaseinfo) {
		// TODO Auto-generated method stub
		ModelReturns<UserBaseinfo> returns = new ModelReturns<UserBaseinfo>();
		userBaseinfo.setPassword(SecurityUtils.MD5(userBaseinfo.getPassword()));
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", userBaseinfo.getMobile());
		params.put("password", userBaseinfo.getPassword());
		if(userBaseinfoMapper.queryCount(params) == null ||
				userBaseinfoMapper.queryCount(params) <= 0){
			returns.setError(ErrorInfos.SHOUJIHAOHUOMIMACUOWU.getError());
			returns.setStatus(ErrorInfos.SHOUJIHAOHUOMIMACUOWU.getStatus());
			return returns;
		}
		userBaseinfo = userBaseinfoMapper.login(userBaseinfo);
		return returns;
	}

	@Override
	public ListReturns<Map<String, Object>> queryList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		ListReturns<Map<String, Object>> returns = new ListReturns<>();
		Long count = userBaseinfoMapper.queryCount(params);
		List<Map<String, Object>> list = userBaseinfoMapper.queryList(params);
		returns.setCount(count);
		returns.setList(list);
		return returns;
	}

	@Override
	public BaseReturns forget(UserBaseinfo userBaseinfo, String validate) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		//1.从日志库查该手机号最后一条短信验证码信息
		ModelReturns<Map<String, Object>> msg = msgService.getLastMsg(userBaseinfo.getMobile());
		if(msg.getModel().get("msg") == null){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}
		//2.判断日志库最后一条验证码是否正确
		if(!validate.equals(msg.getModel().get("msg"))){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}
		//3.判断验证码是否已经超时失效
		if(System.currentTimeMillis() > (Long.valueOf(msg.getModel().get("createTimeStamp").toString()) + 1000*60*60)){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}
		userBaseinfo.setPassword(SecurityUtils.MD5(userBaseinfo.getPassword()));
		userBaseinfoMapper.forget(userBaseinfo);
		return returns;
	}
}
