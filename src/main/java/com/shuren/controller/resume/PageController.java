package com.shuren.controller.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Page;
import com.shuren.service.resume.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private PageService pageService;

    //查询所有的页面模块
    @RequestMapping(value = "findAllByPage", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Page>> findAllByPage(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                     @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                                     @RequestParam(value = "json",required = false) String json){
        ListReturns<Page> pageListReturns = this.pageService.findByPageList(offset, limit,json);
        return ResponseEntity.ok(pageListReturns);
    }


}
