package com.shuren.controller.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Assessment;
import com.shuren.service.resume.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 董帮辉 on 2017-5-18.
 * 测评
 */
@Controller
@RequestMapping("/assesment")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    //分页查询测评信息
    @RequestMapping(value = "findAllByPage", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Assessment>> findAllByPage(@RequestParam("pageNum") Integer pageNum,
                                                                 @RequestParam("pageSize") Integer pageSize){
        PageInfo<Assessment> pageInfo = this.assessmentService.findAllByPage(pageNum, pageSize);
        ListReturns<Assessment> pageListReturns = new ListReturns<>(200,"请求成功",pageInfo.getTotal(), pageInfo.getList());
        return ResponseEntity.ok(pageListReturns);
    }

}
