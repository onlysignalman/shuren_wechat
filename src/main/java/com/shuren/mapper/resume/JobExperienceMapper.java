package com.shuren.mapper.resume;

import java.util.List;
import java.util.Map;

import com.shuren.pojo.resume.JobExperience;

public interface JobExperienceMapper {

	Long add(JobExperience jobExperience);

	void update(JobExperience jobExperience);

	Long getJobsCount(Map<String, String> map);

	List<JobExperience> getJobs(Map<String, String> map);

}
