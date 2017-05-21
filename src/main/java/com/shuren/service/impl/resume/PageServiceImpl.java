package com.shuren.service.impl.resume;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.PageMapper;
import com.shuren.pojo.resume.Page;
import com.shuren.service.resume.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("pageService")
public class PageServiceImpl implements PageService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private PageMapper pageMapper;


    @Override
    public ListReturns<Page> findByPageList(Integer offset, Integer limit, String json) {

        ListReturns<Page> pageListReturns = new ListReturns<>();

        //查询总条数
        Long count = this.pageMapper.queryCount();

        //分页查询数据
        List<Page> list = this.pageMapper.queryByPageList(offset, limit);

        pageListReturns.setError(ErrorInfos.PAGEDATASUCCESS.getError());
        pageListReturns.setStatus(ErrorInfos.PAGEDATASUCCESS.getStatus());
        pageListReturns.setCount(count);
        pageListReturns.setList(list);

        return pageListReturns;
    }
}
