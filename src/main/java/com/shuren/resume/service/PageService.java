package com.shuren.resume.service;

import com.github.pagehelper.PageInfo;
import com.shuren.resume.pojo.Page;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface PageService {
    /**
     * 查询所有页面模块信息
     * @return
     */
    PageInfo<Page> findAll(Integer pageNum, Integer pageSize);
}
