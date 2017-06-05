package com.shuren.mapper.resume;

import java.util.List;
import java.util.Map;

import com.shuren.pojo.resume.UserBaseinfo;

public interface UserBaseinfoMapper {

	void register(UserBaseinfo userBaseinfo);

	UserBaseinfo login(UserBaseinfo userBaseinfo);

	Long queryCount(Map<String, Object> params);

	List<Map<String, Object>> queryList(Map<String, Object> params);
	
	void forget(UserBaseinfo userBaseinfo);

	void update(Map<String, String> map);
	
}
