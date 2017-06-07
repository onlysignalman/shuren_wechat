package com.shuren.service.impl.resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.TrainExperienceMapper;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.pojo.resume.TrainExperience;
import com.shuren.service.resume.TrainExperienceService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service
public class TrainExperienceServiceImpl implements TrainExperienceService {
	
	@Autowired
	private TrainExperienceMapper trainExperienceMapper;
	
	@Override
	public BaseReturns add(TrainExperience trainExperience) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		//1.增加培训经验
		if(trainExperience.getId() != null && trainExperience.getId() > 0){
			update(trainExperience);
		}
		trainExperienceMapper.add(trainExperience);
		//2.可将信息放入用户扩展信息
		return returns;
	}

	@Override
	public BaseReturns update(TrainExperience trainExperience) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		trainExperienceMapper.update(trainExperience);
		return returns;
	}

	@Override
	public ListReturns<TrainExperience> getTrains(TrainExperience trainExperience) {
		// TODO Auto-generated method stub
		ListReturns<TrainExperience> returns = new ListReturns<>();
		Map<String, String> map = new HashMap<>();
		map.put("userId", trainExperience.getUserId().toString());
		Long count = trainExperienceMapper.getExperiencesCount(map);
		List<TrainExperience> trainExperiences = trainExperienceMapper.getJobs(map);
		returns.setCount(count);
		returns.setList(trainExperiences);
		return returns;
	}
	
}
