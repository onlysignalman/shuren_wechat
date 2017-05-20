package com.shuren.service.impl.resume;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.shuren.bean.resume.ModelReturns;
import com.shuren.service.resume.MsgService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("MsgServiceImpl")
public class MsgServiceImpl implements MsgService {

	@Override
	public ModelReturns<Map<String, Object>> getMsg(String mobile) {
		// TODO Auto-generated method stub
		//1.第三方获取短信
		//2.短信发送成功入日志库
		return null;
	}

	@Override
	public ModelReturns<Map<String, Object>> getLastMsg(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}
}
