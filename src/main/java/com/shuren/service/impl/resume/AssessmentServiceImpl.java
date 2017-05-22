package com.shuren.service.impl.resume;

import com.shuren.bean.resume.Constant;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.AssessmentMapper;
import com.shuren.pojo.resume.Assessment;
import com.shuren.service.resume.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("assessmentService")
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentMapper assessmentMapper;


    @Override
    public ListReturns<Assessment> findMyAssessmentList(Integer offset, Integer limit) {

        ListReturns<Assessment> resumeListReturns = new ListReturns<>();

        //获取当前用户的登录信息
//        UserBaseinfo user = UserThreadLocal.getUser();


        //分页查询测评信息
        Long count = this.assessmentMapper.findMyAssessmentCount(1, Constant.ASSESSMENTTYPE);
        List<Assessment> assessmentList = this.assessmentMapper.findMyAssessmentList(offset, limit, 1, Constant.ASSESSMENTTYPE);

        resumeListReturns.setError(ErrorInfos.RESUMEDATASUCCESS.getError());
        resumeListReturns.setStatus(ErrorInfos.RESUMEDATASUCCESS.getStatus());
        resumeListReturns.setCount(count);
        resumeListReturns.setList(assessmentList);

        return resumeListReturns;
    }
}
