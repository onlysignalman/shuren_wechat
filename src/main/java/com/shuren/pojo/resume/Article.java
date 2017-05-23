package com.shuren.pojo.resume;

/**
 * Created by 董帮辉 on 2017-5-23.
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImags() {
        return imags;
    }

    public void setImags(String imags) {
        this.imags = imags;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubtype() {
        return subtype;
    }

    public void setSubtype(Integer subtype) {
        this.subtype = subtype;
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
}
