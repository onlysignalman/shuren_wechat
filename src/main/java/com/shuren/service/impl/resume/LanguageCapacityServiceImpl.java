package com.shuren.service.impl.resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.LanguageCapacityMapper;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.pojo.resume.LanguageCapacity;
import com.shuren.service.resume.LanguageCapacityService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service
public class LanguageCapacityServiceImpl implements LanguageCapacityService {

	@Value("${splitString}")
	private String splitString;

	@Autowired
	private LanguageCapacityMapper languagecapacityMapper;
	
	@Override
	public BaseReturns add(LanguageCapacity languageCapacity) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		String language = languageCapacity.getLanguage();
		int length = language.split(splitString).length;
		if(length > 1) {
			for (int i = 0; i < length; i++) {
				LanguageCapacity languageCt = new LanguageCapacity();
				languageCt.setLanguage(languageCapacity.getLanguage().split(splitString)[i]);
				languageCt.setReadAndWrite(languageCapacity.getReadAndWrite().split(splitString)[i]);
				languageCt.setListenAndSpeak(languageCapacity.getListenAndSpeak().split(splitString)[i]);
				languagecapacityMapper.add(languageCt);
			}
		}else {
			//1.添加语言能力信息
			if(languageCapacity.getId() != null && languageCapacity.getId() > 0){
				update(languageCapacity);
			}
			languagecapacityMapper.add(languageCapacity);
			//2.可将语言能力信息放入用户扩展信息
		}
		return returns;
	}

	@Override
	public BaseReturns update(LanguageCapacity languageCapacity) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		languagecapacityMapper.update(languageCapacity);
		return returns;
	}

	@Override
	public ListReturns<LanguageCapacity> getLanguages(LanguageCapacity languageCapacity) {
		// TODO Auto-generated method stub
		ListReturns<LanguageCapacity> returns = new ListReturns<>();
		Map<String, String> map = new HashMap<>();
		map.put("userId", languageCapacity.getUserId().toString());
		Long count = languagecapacityMapper.getLanguagesCount(map);
		List<LanguageCapacity> jobExperiences = languagecapacityMapper.getLanguages(map);
		returns.setCount(count);
		returns.setList(jobExperiences);
		return returns;
	}
}
