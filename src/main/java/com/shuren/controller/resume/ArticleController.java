package com.shuren.controller.resume;

import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Article;
import com.shuren.service.resume.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 董帮辉 on 2017-5-23.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //分页查询所有文章
    @RequestMapping(value = "findAllByPage", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Article>> findAllByPage(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                              @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                                              @RequestParam(value = "type") Integer type,
                                                              @RequestParam("subtype") String subtype){
        ListReturns<Article> articleListReturns = articleService.findByTypeAndSubTypeList(offset, limit, type, subtype);
        return ResponseEntity.ok(articleListReturns);
    }


}
