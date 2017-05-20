package com.shuren.pojo.resume;

/**
 * Created by dbh on 2017/5/18.
 * 测评报告
 */
public class AssesmentResult {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAssTypeId() {
        return assTypeId;
    }

    public void setAssTypeId(Integer assTypeId) {
        this.assTypeId = assTypeId;
    }

    public Integer getAssId() {
        return assId;
    }

    public void setAssId(Integer assId) {
        this.assId = assId;
    }
}
