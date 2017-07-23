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
@RequestMapping("/assessment")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    //分页查询我的测评（1职业倾向）
    @RequestMapping(value = "/findMyAssessmentList", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Assessment>> findMyAssessmentList(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                                        @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                                                        @RequestParam(value = "json",required = false, defaultValue = "1") Integer assTypeId,

                                                                        @RequestParam("userId") Integer userId){
        ListReturns<Assessment> listReturns = this.assessmentService.findMyAssessmentList(offset, limit,assTypeId,userId);
        return ResponseEntity.ok(listReturns);
    }

}
