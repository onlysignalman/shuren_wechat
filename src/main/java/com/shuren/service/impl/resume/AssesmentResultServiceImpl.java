package com.shuren.service.impl.resume;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuren.mapper.resume.AssessmentResultMapper;
import com.shuren.pojo.resume.AssessmentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.service.resume.AssessmentResultService;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("asesmentResultService")
public class AssesmentResultServiceImpl implements AssessmentResultService {

    @Autowired
    private AssessmentResultMapper assessmentResultMapper;

    @Override
    public PageInfo<AssessmentResult> findByPage(Integer pageNum, Integer pageSize) {
        //分页助手进行分页
        PageHelper.startPage(pageNum, pageSize);

        List<AssessmentResult> assessmentResults = assessmentResultMapper.selectAll();

        PageInfo<AssessmentResult> pagePageInfo = new PageInfo<>(assessmentResults);

        return pagePageInfo;
    }
}
