package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by 董帮辉 on 2017-5-21.
 */
@Data
public class Resume {

    private Long id;

    //简历模板标题
    private String title;

    //图片地址
    private String pic;

    //文件路径
    private String filePath;

    //创建时间
    private Long createTimeStamp;

    //最后更新时间
    private Long lastUpdateTimeStamp;

    //创建人
    private Integer createUserId;

    //最后更新人
    private Integer lastUpdateUserId;

    //所需积分
    private Integer point;

    //是否需要付费
    private Integer payType;
}
