package com.shuren.service.impl.resume;

import com.shuren.bean.resume.Constant;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.ArticleMapper;
import com.shuren.pojo.resume.Article;
import com.shuren.service.resume.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-23.
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ListReturns<Article> findByTypeAndSubTypeList(Integer offset, Integer limit, Integer type, String subtype) {

        ListReturns<Article> listReturns = new ListReturns<Article>();

        //查询总记录
        Long count = this.articleMapper.queryByTypeAndSubTypeCount(offset, limit, type, subtype);
        //查询总条数
        List<Article> articleList = this.articleMapper.queryByTypeAndSubTypeList(offset, limit, type, subtype);
        listReturns.setStatus(ErrorInfos.ARTICLEDATASUCCESS.getStatus());
        listReturns.setError(ErrorInfos.ARTICLEDATASUCCESS.getError());
        listReturns.setCount(count);
        listReturns.setList(articleList);
        return listReturns;
    }
}
