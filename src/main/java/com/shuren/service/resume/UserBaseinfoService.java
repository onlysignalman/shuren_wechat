package com.shuren.service.resume;

import java.util.Map;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.UserBaseinfo;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface UserBaseinfoService {

	/**
	 * 注册用户
	 * @param userBaseinfo
	 * @return
	 */
	BaseReturns register(UserBaseinfo userBaseinfo, String msg);

	/**
	 * 用户登录
	 * @param userBaseinfo
	 * @return
	 */
	ModelReturns<UserBaseinfo> login(UserBaseinfo userBaseinfo);
	
	/**
	 * 根据条件查询用户
	 * @param params
	 * @return
	 */
	ListReturns<Map<String, Object>> queryList(Map<String, Object> params);

	/**
	 * 忘记密码
	 * @param userBaseinfo
	 * @param validate
	 * @return
	 */
	BaseReturns forget(UserBaseinfo userBaseinfo, String validate);
}
