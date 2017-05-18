package com.shuren.resume.pojo;

/**
 * Created by dbh on 2017/5/18.
 * 积分流水
 */
public class CreditDetail {

    private Integer id;

    //用户id
    private Integer userId;

    //购买项的id
    private Integer buyId;

    //积分消费类型(1.购买简历;2.购买测评)
    private Integer type;

    //购买测评类型(1.职业倾向;2.通用能力;3职业潜能)
    private Integer assTypeId;

    //购买测试题id
    private Integer assId;

    //购买时间
    private Long createTimeStamp;

    //逻辑删除
    private Integer isDel;

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

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
