package com.shuren.service.impl.resume;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.mapper.resume.CreditDetailMapper;
import com.shuren.mapper.resume.ResumeMapper;
import com.shuren.mapper.resume.UserBaseinfoMapper;
import com.shuren.pojo.resume.CreditDetail;
import com.shuren.pojo.resume.Resume;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.CreditDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("creditDetailService")
public class CreditDetailServiceImpl implements CreditDetailService {

    @Autowired
    private UserBaseinfoMapper userBaseinfoMapper;

    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private CreditDetailMapper creditDetailMapper;

    @Override
    public BaseReturns purchaseAssesment(Integer userId, Integer resumeId) {

        //根据用户信息userId查询用户信息
        UserBaseinfo userBaseinfo = this.userBaseinfoMapper.queryById(userId);

        //根据简历模板id查询简历模板信息
        Resume resume = this.resumeMapper.queryById(resumeId);

        //TODO
        //判断用户是否已经购买过简历模板


        //判断用户积分是否大于简历模板所需积分
        BaseReturns baseReturns = null;
        if(userBaseinfo.getCredit()<resume.getPoint()){
            // 返回错误信息
            baseReturns = new BaseReturns();
            baseReturns.setError(ErrorInfos.CREDITNOTENOUGH.getError());
            baseReturns.setStatus(ErrorInfos.CREDITNOTENOUGH.getStatus());
        }

        //用户积分够用
        //1,向积分明细表中插入购买记录
        CreditDetail creditDetail = new CreditDetail();
        creditDetail.setUserId(userBaseinfo.getUserId());
        creditDetail.setBuyId(resumeId);
        creditDetail.setType(1);
        creditDetail.setAssTypeId(0);
        creditDetail.setIsDel(0);
        creditDetail.setAssId(0);
        this.creditDetailMapper.insert(creditDetail);
        //2,用户表中扣除对应积分
        Map<String, String> map = new HashMap<>();
        map.put("credit",String.valueOf(userBaseinfo.getCredit()-resume.getPoint()));
        map.put("userId",userId.toString());
        Integer count = this.userBaseinfoMapper.update(map);
        if(count>0){
            // 返回处理信息
            baseReturns = new BaseReturns();
            baseReturns.setError(ErrorInfos.CREDITPURCHASESUCCESS.getError());
            baseReturns.setStatus(ErrorInfos.CREDITPURCHASESUCCESS.getStatus());
            //TODO
            // 发送邮件

        }

        return baseReturns;
    }
}
