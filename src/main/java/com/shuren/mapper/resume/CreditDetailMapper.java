package com.shuren.mapper.resume;

import com.shuren.pojo.resume.CreditDetail;
import org.apache.ibatis.annotations.Param;

public interface CreditDetailMapper {
    /**
     * 插入积分明细信息
     * @param creditDetail
     */
    void insert(CreditDetail creditDetail);

    /**
     * 判断是否已经购买过的简历
     * @param userId
     * @param id
     * @param i
     * @return
     */
    Integer judgeIsPurchaseResum(@Param("userId") Integer userId,@Param("buyId") Long buyId, @Param("type") int type);
}
