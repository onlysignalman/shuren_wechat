package com.shuren.service.impl.resume;

import com.shuren.bean.resume.Constant;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.mapper.resume.ResumeMapper;
import com.shuren.pojo.resume.Resume;
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
    public ListReturns<Resume> findMyResume(Integer offset, Integer limit, Integer userId) {

        ListReturns<Resume> resumeListReturns = new ListReturns<>();

        //获取当前用户的登录信息
//        UserBaseinfo user = UserThreadLocal.getUser();

        //根据当前登录的用户id查询用户拥有的简历信息
        Long count = this.resumeMapper.queryCountByUserId(userId, Constant.RESUMETYPE);
        List<Resume> resumeList = this.resumeMapper.queryListByUserId(offset, limit,1, Constant.RESUMETYPE);

        resumeListReturns.setError(ErrorInfos.RESUMEDATASUCCESS.getError());
        resumeListReturns.setStatus(ErrorInfos.RESUMEDATASUCCESS.getStatus());
        resumeListReturns.setCount(count);
        resumeListReturns.setList(resumeList);

        return resumeListReturns;
    }

    @Override
    public ListReturns<Resume> findResumeList(Integer offset, Integer limit) {

        ListReturns<Resume> resumeListReturns = new ListReturns<>();

        //分页查询所有简历
        Long count = this.resumeMapper.queryCount(Constant.RESUMETYPE);
        List<Resume> resumeList = this.resumeMapper.queryList(offset,limit,Constant.RESUMETYPE);

        resumeListReturns.setError(ErrorInfos.RESUMEDATASUCCESS.getError());
        resumeListReturns.setStatus(ErrorInfos.RESUMEDATASUCCESS.getStatus());
        resumeListReturns.setCount(count);
        resumeListReturns.setList(resumeList);
        return resumeListReturns;
    }
}
