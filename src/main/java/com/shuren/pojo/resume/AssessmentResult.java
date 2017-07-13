package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 测评报告
 */
@Data
public class AssessmentResult {

    private Integer id;

    //用户id
    private Integer userId;

    //创建时间
    private Long createTimeStamp;

    //总分
    private Integer totalPoint;

    //内容
    private String content;

    //逻辑删除
    private Integer isDel;

    //测评报告地址
    private String url;

    //测评类别id
    private Integer assTypeId;

    //测试卷id
    private Integer assId;
}
