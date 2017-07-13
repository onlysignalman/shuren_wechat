package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 工作经验
 */
@Data
public class JobExperience {

    private Integer id;

    //用户Id
    private Integer userId;

    //企业名称
    private String companyName;

    //企业性质
    private String companyType;

    //企业规模
    private String companyScale;

    //行业性质
    private String businessType;

    //职业名称
    private String jobName;

    //工作时间
    private String jobTime;

    //薪资水平
    private String salary;

    //工作内容
    private String jobContent;

    //第几份工作的索引
    private Integer index;

    //创建时间
    private Long createTimeStamp;

    //最新更新时间
    private Long lastUpdateStamp;

    //逻辑删除
    private Integer isDel;
}
