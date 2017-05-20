package com.shuren.pojo.resume;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/**
 * Created by dbh on 2017/5/18.
 * 测评
 */
public class Assessment {

    private Integer assId;

    //测评类型(职业倾向,通用能力,职业潜能)
    private Integer assTypeId;

    //是否需要积分购买
    private Integer payType;

    //所需积分
    private Integer point;

    //创建时间
    private Integer createTimeStamp;

    //最新更新时间
    private Integer lastUpdateTimeStamp;

    //创建人
    private Integer createUserId;

    //最新更改人
    private Integer lastUpdateUserId;

    //逻辑删除
    private Integer isDel;

    public Integer getAssId() {
        return assId;
    }

    public void setAssId(Integer assId) {
        this.assId = assId;
    }

    public Integer getAssTypeId() {
        return assTypeId;
    }

    public void setAssTypeId(Integer assTypeId) {
        this.assTypeId = assTypeId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Integer createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Integer getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Integer lastUpdateTimeStamp) {
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
