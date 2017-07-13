package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 试题
 */
@Data
public class Item {

    private Integer id;

    //试卷id
    private Integer assId;

    //创建时间
    private Long createTimeStamp;

    //最新更改时间
    private Long lastUpdateTimeStamp;

    //创建人
    private Integer createUserId;

    //最后更改人
    private Integer lastUpdateTimeUserId;

    //分数类型(1.4321;2.1234)
    private Integer scoreType;

    //A选项
    private String contentA;

    //B选项
    private String contentB;

    //c选项
    private String contentC;

    //D选项
    private String contentD;

    //A错误原因
    private String errorA;

    //B错误原因
    private String errorB;

    //C错误原因
    private String errorC;

    //D错误原因
    private String errorD;

    //题号
    private Integer num;

    //题干
    private String title;

    //逻辑删除
    private Integer isDel;

}
