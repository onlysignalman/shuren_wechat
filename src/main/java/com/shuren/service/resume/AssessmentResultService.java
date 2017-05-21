package com.shuren.service.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.pojo.resume.AssessmentResult;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface AssessmentResultService {
    /**
     * 分页查询测评报告信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<AssessmentResult> findByPage(Integer pageNum, Integer pageSize);
}
