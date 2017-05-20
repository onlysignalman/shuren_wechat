package com.shuren.mapper.resume;

import com.shuren.pojo.resume.Assessment;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-20.
 */
public interface AssessmentMapper {

    /**
     * 查询所有测评
     * @return
     */
    List<Assessment> selectAll();
}
