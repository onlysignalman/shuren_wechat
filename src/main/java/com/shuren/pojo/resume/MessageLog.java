package com.shuren.pojo.resume;

/**
 * Created by dbh on 2017/5/17.
 * 短信日志
 */
public class MessageLog {

    private Integer id;

    //手机号
    private String mobile;

    //短信返回信息字符串
    private String results;

    //操作时间
    private Long timeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
