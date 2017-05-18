package com.shuren.resume.service;

import com.shuren.resume.pojo.Page;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface PageService {
    /**
     * 查询所有页面模块信息
     * @return
     */
    List<Page> findAll(Integer pageNum, Integer pageSize);
}
