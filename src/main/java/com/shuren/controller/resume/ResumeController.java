package com.shuren.controller.resume;

import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Resume;
import com.shuren.service.resume.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 董帮辉 on 2017-5-21.
 * 简历
 */
@Controller
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    //查询我的简历
    @RequestMapping(value = "findMyResume", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Resume>> findMyResume(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                                            @RequestParam("userId") Integer userId ) {
        ListReturns<Resume> resumeListReturns = this.resumeService.findMyResume(offset, limit,userId);
        return ResponseEntity.ok(resumeListReturns);
    }

    //查询简历市场
    @RequestMapping(value = "findResumeList", method = RequestMethod.GET)
    public ResponseEntity<ListReturns<Resume>> findResumeList(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                              @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        ListReturns<Resume> resumeListReturns = this.resumeService.findResumeList(offset, limit);
        return ResponseEntity.ok(resumeListReturns);
    }
}
