package com.shuren.resume.mapper;

import com.shuren.resume.pojo.Page;

import java.util.List;

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
