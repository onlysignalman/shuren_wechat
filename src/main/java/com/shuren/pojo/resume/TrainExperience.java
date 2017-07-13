package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/17.
 * 培训经历
 */
@Data
public class TrainExperience {

    private Integer id;

    //用户Id
    private Integer userId;

    //培训机构名称
    private String trainName;

    //培训地点
    private String trainLocation;

    //培训获得证书
    private String trainAwardName;

    //获得时间
    private Long trainAwardTime;

    //详细说明
    private String detail;

    //本人培训次数索引
    private String index;
    
    //创建时间
    private Long createTimeStamp;
    
    //最后更新时间
    private Long lastUpdateTimeStamp;
    
    //删除标志
    private Integer isDel;
}
