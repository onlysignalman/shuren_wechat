package com.shuren.service.resume;

import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Page;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface PageService {
    /**
     * 查询所有页面模块信息
     * @return
     */
    ListReturns<Page> findByPageList(Integer offset, Integer limit, String json);
}
