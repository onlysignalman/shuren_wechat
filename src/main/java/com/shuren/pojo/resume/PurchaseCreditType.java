package com.shuren.pojo.resume;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by 董帮辉 on 2017-5-18.
 * 积分购买
 */
@Data
public class PurchaseCreditType {

    private Integer id;

    //积分
    private Integer point;

    //金额
    private BigDecimal money;

    //创建时间
    private Long createTimeStamp;

    //最近更新时间
    private Long lastUpdateTimeStamp;

    //创建人
    private Integer createUserId;

    //最近修改人
    private Integer lastUpdateUserId;

    //逻辑删除
    private Integer isDel;
}
