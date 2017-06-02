package com.shuren.service.resume;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.pojo.resume.UserExtendinfo;

public interface UserExtendinfoService {

	/**
	 * 新增（得考虑是否是修改信息）
	 * @param userExtandinfo
	 * @return
	 */
	BaseReturns add(UserExtendinfo userExtandinfo);

	/**
	 * 修改信息
	 * @param userExtandinfo
	 * @return
	 */
	BaseReturns update(UserExtendinfo userExtandinfo);

	/**
	 * 获取当前用户扩展信息
	 * @param userId
	 * @return
	 */
	ModelReturns<UserExtendinfo> getOne(Integer userId);

	
	
}
