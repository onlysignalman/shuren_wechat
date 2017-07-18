package com.shuren.service.resume;

import java.util.Map;

import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.MessageLog;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface MsgService {

	/**
	 * 获取验证码
	 * @param mobile
	 * @return
	 */
	ModelReturns<Map<String, Object>> getMsg(String mobile);

	/**
	 * 获取日志库相应手机号最后一条短信
	 * @param mobile
	 * @return
	 */
	ModelReturns<MessageLog> getLastMsg(String mobile);
}
