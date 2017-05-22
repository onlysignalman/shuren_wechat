package com.shuren.mapper.resume;

import com.shuren.pojo.resume.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dbh on 2017/5/22.
 */
public interface ResumeMapper {
    /**
     * 根据用户id查询总条数
     * @param userId
     * @return
     */
    Long queryCountByUserId(@Param("userId") Long userId);

    /**
     * 根据用户id查询简历信息
     * @param userId
     * @return
     */
    List<Resume> queryListByUserId(@Param("userId") Long userId);
}
