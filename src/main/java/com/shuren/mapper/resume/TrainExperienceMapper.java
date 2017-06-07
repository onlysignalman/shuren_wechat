package com.shuren.mapper.resume;

import java.util.List;
import java.util.Map;

import com.shuren.pojo.resume.TrainExperience;

public interface TrainExperienceMapper {

	Long add(TrainExperience trainExperience);

	void update(TrainExperience trainExperience);

	Long getExperiencesCount(Map<String, String> map);

	List<TrainExperience> getJobs(Map<String, String> map);
}
