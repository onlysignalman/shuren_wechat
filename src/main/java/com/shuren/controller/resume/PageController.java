package com.shuren.controller.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Page;
import com.shuren.service.resume.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Page>> findAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        PageInfo<Page> pageInfo = this.pageService.findAll(pageNum, pageSize);
        ListReturns<Page> pageListReturns = new ListReturns<>(200,"请求成功",pageInfo.getTotal(), pageInfo.getList());
        return ResponseEntity.ok(pageListReturns);
    }


}