package com.shuren.service.impl.resume;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.mapper.resume.UserExtendinfoMapper;
import com.shuren.pojo.resume.UserExtendinfo;
import com.shuren.service.resume.UserExtendinfoService;

@Service
public class UserExtendinfoServiceImpl implements UserExtendinfoService {

	@Autowired
	private UserExtendinfoMapper userExtendinfoMapper;
	
	@Override
	public BaseReturns add(UserExtendinfo userExtandinfo) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		Map<String, String> map = new HashMap<>();
		map.put("userId", userExtandinfo.getUserId().toString());
		UserExtendinfo extandinfo = userExtendinfoMapper.getOne(map);
		if(extandinfo != null){
			update(userExtandinfo);
		}
		userExtendinfoMapper.add(userExtandinfo);
		return returns;
	}

	@Override
	public BaseReturns update(UserExtendinfo userExtandinfo) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		userExtendinfoMapper.update(userExtandinfo);
		return returns;
	}

	@Override
	public ModelReturns<UserExtendinfo> getOne(Integer userId) {
		// TODO Auto-generated method stub
		ModelReturns<UserExtendinfo> returns = new ModelReturns<UserExtendinfo>();
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId.toString());
		UserExtendinfo extandinfo = userExtendinfoMapper.getOne(map);
		returns.setModel(extandinfo);
		return returns;
	}

}
