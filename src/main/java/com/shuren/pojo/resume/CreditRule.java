package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 积分规则
 */
@Data
public class CreditRule {

    private Integer id;

    //积分规则内容
    private String content;

    //创建时间
    private Long createTimeStamp;

    //最后一次更新时间
    private Long lastUpdateTimeStamp;

    //创建者
    private Integer createUserId;

    //最后修改人
    private Integer lastUpdateUserId;

    //逻辑删除
    private Integer isDel;
}
