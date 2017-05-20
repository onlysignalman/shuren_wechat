package com.shuren.mapper.resume;

import java.util.List;

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
}
