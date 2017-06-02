package com.shuren.service.resume;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.JobExperience;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface JobExperienceService {

	/**
	 * 添加工作经历
	 * @param jobExperience
	 * @return
	 */
	BaseReturns add(JobExperience jobExperience);

	/**
	 * 更新工作经历
	 * @param jobExperience
	 * @return
	 */
	BaseReturns update(JobExperience jobExperience);

	/**
	 * 获取登录用户的工作经历
	 * @param jobExperience
	 * @return
	 */
	ListReturns<JobExperience> getJobs(JobExperience jobExperience);
}
