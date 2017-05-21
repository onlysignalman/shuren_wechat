package com.shuren.controller.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.AssessmentResult;
import com.shuren.service.resume.AssessmentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 董帮辉 on 2017-5-18.
 * 测评报告
 */
@RequestMapping("/assessmentResult")
public class AssesmentResultController {

    @Autowired
    private AssessmentResultService assessmentResultService;

    //分页查询测评报告信息
    @RequestMapping(value = "findByPage", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<AssessmentResult>> findByPage(@RequestParam("pageNum") Integer pageNum,
                                                       @RequestParam("pageSize") Integer pageSize){

        PageInfo<AssessmentResult> pageInfo = this.assessmentResultService.findByPage(pageNum, pageSize);

        ListReturns<AssessmentResult> assessmentResultListReturns = new ListReturns<>(200,"请求成功",pageInfo.getTotal(), pageInfo.getList());

        return ResponseEntity.ok(assessmentResultListReturns);
    }

}
