package com.shuren.resume.pojo;

/**
 * Created by dbh on 2017/5/18.
 * 积分规则
 */
public class CreditRule {

    private Integer id;

    //积分规则内容
    private String content;

    //创建时间
    private Long createTimeStamp;

    //最后一次更新时间
    private Long lastUpdateTimeStamp;

    //创建者
    private Integer createUserId;

    //最后修改人
    private Integer lastUpdateUserId;

    //逻辑删除
    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Long lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
