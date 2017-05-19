package com.shuren.resume.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuren.resume.mapper.PageMapper;
import com.shuren.resume.pojo.Page;
import com.shuren.resume.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("pageService")
public class PageServiceImpl implements PageService {

    @Autowired
    private PageMapper pageMapper;

    @Override
    public PageInfo<Page> findAll(Integer pageNum, Integer pageSize) {

        //分页助手进行分页
        PageHelper.startPage(pageNum, pageSize);

        List<Page> pages = pageMapper.selectAll();

        PageInfo<Page> pagePageInfo = new PageInfo<>(pages);

        return pagePageInfo;
    }
}
