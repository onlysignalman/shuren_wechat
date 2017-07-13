package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 积分流水
 */
@Data
public class CreditDetail {

    private Integer id;

    //用户id
    private Integer userId;

    //购买项的id
    private Integer buyId;

    //积分消费类型(1.购买简历;2.购买测评)
    private Integer type;

    //购买测评类型(1.职业倾向;2.通用能力;3职业潜能)
    private Integer assTypeId;

    //购买测试题id
    private Integer assId;

    //购买时间
    private Long createTimeStamp;

    //逻辑删除
    private Integer isDel;
}
