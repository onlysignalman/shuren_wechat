package com.shuren.service.impl.resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.JobExperienceMapper;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.service.resume.JobExperienceService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service
public class JobExperienceServiceImpl implements JobExperienceService {

	@Autowired
	private JobExperienceMapper jobExperienceMapper;
	
	@Override
	public BaseReturns add(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		//1.增加工作经验
		if(jobExperience.getId() != null && jobExperience.getId() > 0){
			update(jobExperience);
		}
		jobExperienceMapper.add(jobExperience);
		//2.可将信息放入用户扩展信息
		return returns;
	}

	@Override
	public BaseReturns update(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		jobExperienceMapper.update(jobExperience);
		return returns;
	}

	@Override
	public ListReturns<JobExperience> getJobs(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		ListReturns<JobExperience> returns = new ListReturns<>();
		Map<String, String> map = new HashMap<>();
		map.put("userId", jobExperience.getUserId().toString());
		Long count = jobExperienceMapper.getJobsCount(map);
		List<JobExperience> jobExperiences = jobExperienceMapper.getJobs(map);
		returns.setCount(count);
		returns.setList(jobExperiences);
		return returns;
	}
}
