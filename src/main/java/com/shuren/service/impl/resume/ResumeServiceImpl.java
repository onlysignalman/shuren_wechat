package com.shuren.service.impl.resume;

import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.bean.resume.UserThreadLocal;
import com.shuren.mapper.resume.ResumeMapper;
import com.shuren.pojo.resume.Resume;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.service.resume.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-21.
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public ListReturns<Resume> findMyResume(Integer offset, Integer limit) {

        ListReturns<Resume> resumeListReturns = new ListReturns<>();

        //获取当前用户的登录信息
//        UserBaseinfo user = UserThreadLocal.getUser();

        //根据当前登录的用户id查询用户拥有的简历信息
        Long count = this.resumeMapper.queryCountByUserId(1);
        List<Resume> resumeList = this.resumeMapper.queryListByUserId(1);

        resumeListReturns.setError(ErrorInfos.RESUMEDATASUCCESS.getError());
        resumeListReturns.setStatus(ErrorInfos.RESUMEDATASUCCESS.getStatus());
        resumeListReturns.setCount(count);
        resumeListReturns.setList(resumeList);

        return resumeListReturns;
    }
}
