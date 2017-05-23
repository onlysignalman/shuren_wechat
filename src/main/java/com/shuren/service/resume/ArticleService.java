package com.shuren.service.resume;

import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Article;

/**
 * Created by 董帮辉 on 2017-5-23.
 */
public interface ArticleService {
    /**
     * 分页查询列表
     * @param offset
     * @param limit
     * @param type
     * @param subtype
     * @return
     */
    ListReturns<Article> findByTypeAndSubTypeList(Integer offset, Integer limit, Integer type, String subtype);
}
