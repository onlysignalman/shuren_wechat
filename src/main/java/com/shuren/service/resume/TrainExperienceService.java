package com.shuren.service.resume;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.pojo.resume.TrainExperience;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface TrainExperienceService {
	
	/**
	 * 添加培训经历
	 * @param jobExperience
	 * @return
	 */
	BaseReturns add(TrainExperience trainExperience);

	/**
	 * 更新培训经历
	 * @param jobExperience
	 * @return
	 */
	BaseReturns update(TrainExperience trainExperience);

	/**
	 * 获取登录用户的培训经历
	 * @param jobExperience
	 * @return
	 */
	ListReturns<TrainExperience> getTrains(TrainExperience trainExperience);
	
}
