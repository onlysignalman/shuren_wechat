package com.shuren.service.impl.resume;

import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Resume;
import com.shuren.service.resume.ResumeService;
import org.springframework.stereotype.Service;

/**
 * Created by 董帮辉 on 2017-5-21.
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Override
    public ListReturns<Resume> findMyResume(Integer offset, Integer limit) {
        return null;
    }
}
