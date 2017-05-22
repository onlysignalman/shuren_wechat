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
    Long queryCountByUserId(@Param("userId") Integer userId,@Param("type") Integer type);

    /**
     * 根据用户id查询简历信息
     * @param userId
     * @return
     */
    List<Resume> queryListByUserId(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("userId") Integer userId,@Param("type") Integer type);

    /**
     *
     * @param type
     * @return
     */
    Long queryCount(@Param("type") Integer type);

    /**
     * 查询所有记录
     * @param offset
     * @param limit
     * @param type
     * @return
     */
    List<Resume> queryList(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("type") int type);
}
