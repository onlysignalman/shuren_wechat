package com.shuren.mapper.resume;

import com.shuren.pojo.resume.AssessmentResult;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-21.
 */
public interface AssessmentResultMapper {
    /**
     * 查询所有测评信息
     * @return
     */
    List<AssessmentResult> selectAll();
}
