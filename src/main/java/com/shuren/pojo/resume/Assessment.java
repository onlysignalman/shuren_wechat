package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 测评
 */
@Data
public class Assessment {

    private Integer assId;

    //测评标题
    private String title;

    //测评描述信息
    private String description;

    //测评的图片地址
    private String imgUrl;

    //测评类型(1职业倾向,2通用能力,3职业潜能)
    private Integer assTypeId;

    //是否需要积分购买,0不需要，1需要
    private Integer payType;

    //所需积分
    private Integer point;

    //创建时间
    private Long createTimeStamp;

    //最新更新时间
    private Long lastUpdateTimeStamp;

    //创建人
    private Integer createUserId;

    //最新更改人
    private Integer lastUpdateUserId;

    //逻辑删除
    private Integer isDel;
}
