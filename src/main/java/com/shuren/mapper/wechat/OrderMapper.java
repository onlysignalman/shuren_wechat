package com.shuren.mapper.wechat;

import com.shuren.pojo.wechat.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 董帮辉 on 2017-6-6.
 */
public interface OrderMapper {
    //根据orderId查询条数
    Integer queryCountByOderId(@Param("orderId") String orderId);

    //保存订单信息
    Integer save(Order order);
}
