package com.shuren.service.impl.resume;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuren.mapper.resume.AssessmentMapper;
import com.shuren.pojo.resume.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.service.resume.AssessmentService;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("assessmentService")
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentMapper assessmentMapper;

    @Override
    public PageInfo<Assessment> findAllByPage(Integer pageNum, Integer pageSize) {

        //分页助手进行分页
        PageHelper.startPage(pageNum, pageSize);

        List<Assessment> assessments = assessmentMapper.selectAll();

        PageInfo<Assessment> pagePageInfo = new PageInfo<>(assessments);

        return pagePageInfo;

    }
}
