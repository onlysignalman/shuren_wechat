package com.shuren.mapper.resume;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shuren.pojo.resume.Page;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface PageMapper {
    /**
     * 查询所有页面模块
     * @return
     */
    List<Page> selectAll();

    /**
     * 查询总条数
     * @return
     */
    Long queryCount();

    /**
     * 分页查询数据
     * @param offset
     * @param limit
     * @return
     */
    List<Page> queryByPageList(@Param("offset") Integer offset,@Param("limit") Integer limit);
}
