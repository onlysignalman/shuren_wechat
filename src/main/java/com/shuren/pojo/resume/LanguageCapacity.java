package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/17.
 * 语言能力
 */
@Data
public class LanguageCapacity {

    private Integer id;

    //用户Id
    private Integer userId;

    //语种
    private String language;

    //读写能力
    private String readAndWrite;

    //听说能力
    private String listenAndSpeak;

    //掌握的第几种语言
    private Integer index;
    
    //创建时间
    private Long createTimeStamp;
    
    //最新更新时间
    private Long lastUpdateTimeStamp;
    
    //删除标志 默认值0：未删除
    private Integer isDel;
}
