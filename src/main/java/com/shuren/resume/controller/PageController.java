package com.shuren.resume.controller;

import com.shuren.resume.pojo.Page;
import com.shuren.resume.service.PageService;
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
    public ResponseEntity<List<Page>> findAll(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        List<Page> list = this.pageService.findAll(pageNum, pageSize);
        return ResponseEntity.ok(list);
    }

}
