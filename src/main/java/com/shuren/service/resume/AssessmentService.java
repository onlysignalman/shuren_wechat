package com.shuren.service.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.pojo.resume.Assessment;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface AssessmentService {
    /**
     * 分页查询测评信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Assessment> findAllByPage(Integer pageNum, Integer pageSize);
}
