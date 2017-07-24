package com.shuren.service.resume;

import com.shuren.bean.resume.BaseReturns;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface CreditDetailService {
    /**
     * 积分购买简历
     * @param userId
     * @param resumeId
     * @return
     */
    BaseReturns purchaseAssesment(Integer userId, Integer resumeId);
}
