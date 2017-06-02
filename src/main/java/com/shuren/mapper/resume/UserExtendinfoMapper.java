package com.shuren.mapper.resume;

import java.util.Map;

import com.shuren.pojo.resume.UserExtendinfo;

public interface UserExtendinfoMapper {

	UserExtendinfo getOne(Map<String, String> map);

	void add(UserExtendinfo userExtandinfo);

	void update(UserExtendinfo userExtandinfo);

}
