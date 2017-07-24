package com.shuren.controller.resume;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.service.resume.CreditDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Controller
@RequestMapping("/creditDetail")
public class CreditDetailController {

    @Autowired
    private CreditDetailService creditDetailService;

    //积分购买简历
    @GetMapping("purchaseAssesment")
    public ResponseEntity<BaseReturns> purchaseAssesment(@RequestParam("userId") Integer userId,
                                                         @RequestParam("resumeId") Integer resumeId){
        BaseReturns baseReturns = this.creditDetailService.purchaseAssesment(userId,resumeId);
        return ResponseEntity.ok(baseReturns);
    }
}
