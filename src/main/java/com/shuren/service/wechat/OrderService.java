package com.shuren.service.wechat;

import com.shuren.pojo.wechat.Order;

/**
 * Created by 董帮辉 on 2017-6-6.
 */
public interface OrderService {
    //根据订单号查询订单信息
    Integer queryCountByOderId(String orderId);

    //插入订单信息
    Integer save(Order order);
}
