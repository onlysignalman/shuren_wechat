package com.shuren.service.impl.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuren.mapper.resume.PageMapper;
import com.shuren.pojo.resume.Page;
import com.shuren.service.resume.PageService;

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
