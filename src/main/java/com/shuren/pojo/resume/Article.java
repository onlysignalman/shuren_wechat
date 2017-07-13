package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by 董帮辉 on 2017-5-23.
 */
@Data
public class Article {

    private Integer id;

    //标题
    private String title;

    //摘要
    private String descript;

    //内容
    private String content;

    //图片
    private String imags;

    //所属类型
    private Integer type;

    //所属子类型
    private Integer subtype;

    //创建时间
    private Long createTimeStamp;

    //最新更改时间
    private Long lastUpdateTimeStamp;

    //创建者
    private Integer createUserId;

    //最近修改人
    private Integer lastUpdateUserId;
}
