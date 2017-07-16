package com.shuren.mapper.resume;

import java.util.List;
import java.util.Map;

import com.shuren.pojo.resume.LanguageCapacity;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageCapacityMapper {

	Long add(LanguageCapacity languageCapacity);

	void update(LanguageCapacity languageCapacity);

	Long getLanguagesCount(Map<String, String> map);

	List<LanguageCapacity> getLanguages(Map<String, String> map);

}
