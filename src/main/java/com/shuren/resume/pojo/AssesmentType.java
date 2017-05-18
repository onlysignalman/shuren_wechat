package com.shuren.resume.pojo;

/**
 * Created by dbh on 2017/5/18.
 */
public class AssesmentType {

    private Integer assTypeId;

    //测评种类名
    private String name;

    //创建人
    private Integer createUserId;

    //创建时间
    private Integer createTimeStamp;

    //修改时间
    private Integer lastUpdateTimeStamp;

    //修改人
    private Integer lastUpdateUserId;

    //排序
    private Integer range;

    //逻辑删除
    private Integer isDel;

    public Integer getAssTypeId() {
        return assTypeId;
    }

    public void setAssTypeId(Integer assTypeId) {
        this.assTypeId = assTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
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

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
