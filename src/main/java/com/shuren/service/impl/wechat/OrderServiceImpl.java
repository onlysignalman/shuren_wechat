package com.shuren.service.impl.wechat;

import com.shuren.mapper.wechat.OrderMapper;
import com.shuren.pojo.wechat.Order;
import com.shuren.service.wechat.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 董帮辉 on 2017-6-6.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer queryCountByOderId(String orderId) {
        Integer count = this.orderMapper.queryCountByOderId(orderId);
        return count;
    }

    @Override
    public Integer save(Order order) {
        Integer count = this.orderMapper.save(order);
        return count;
    }
}
