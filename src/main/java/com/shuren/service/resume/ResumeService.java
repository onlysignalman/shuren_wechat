package com.shuren.service.resume;

import com.shuren.bean.resume.ListReturns;
import com.shuren.pojo.resume.Resume;

/**
 * Created by 董帮辉 on 2017-5-21.
 */
public interface ResumeService {
    /**
     * 查询我的简历
     * @param offset
     * @param limit
     * @return
     */
    ListReturns<Resume> findMyResume(Integer offset, Integer limit);
}
