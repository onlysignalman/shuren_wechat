package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/17.
 * 短信日志
 */
@Data
public class MessageLog {

    private Integer id;

    //手机号
    private String mobile;

    //短信返回信息字符串
    private String results;

    //操作时间
    private Long timeStamp;
}
