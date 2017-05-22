package com.shuren.service.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Assessment;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface AssessmentService {

    /**
     * 分页查询我的测评信息
     * @param offset
     * @param limit
     * @return
     */
    ListReturns<Assessment> findMyAssessmentList(Integer offset, Integer limit);
}
