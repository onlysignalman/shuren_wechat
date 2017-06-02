package com.shuren.service.resume;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.LanguageCapacity;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface LanguageCapacityService {

	/**
	 * 添加语言能力
	 * @param languageCapacity
	 * @return
	 */
	BaseReturns add(LanguageCapacity languageCapacity);

	/**
	 * 更新语言能力
	 * @param languageCapacity
	 * @return
	 */
	BaseReturns update(LanguageCapacity languageCapacity);

	/**
	 * 获取语言能力信息
	 * @param languageCapacity
	 * @return
	 */
	ListReturns<LanguageCapacity> getLanguages(LanguageCapacity languageCapacity);
}
