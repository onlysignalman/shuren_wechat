package com.shuren.mapper.resume;

import com.shuren.pojo.resume.Assessment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-20.
 */
public interface AssessmentMapper {

    /**
     * 查询我的测评条数
     * @param userId
     * @param type
     * @return
     */
    Long findMyAssessmentCount(@Param("userId") Integer userId,@Param("type") Integer type);

    /**
     * 查询我的测评
     * @param offset
     * @param limit
     * @param userId
     * @param type
     * @return
     */
    List<Assessment> findMyAssessmentList(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("userId") Integer userId,@Param("type") Integer type);
}
