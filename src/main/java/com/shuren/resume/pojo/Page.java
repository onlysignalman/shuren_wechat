package com.shuren.resume.pojo;

/**
 * Created by dbh on 2017/5/18.
 * 主页列表
 */
public class Page {

    private Integer id;

    //标题
    private String title;

    //图片地址
    private String logo;

    //跳转url路径
    private String handleURL;

    //排序
    private Integer range;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHandleURL() {
        return handleURL;
    }

    public void setHandleURL(String handleURL) {
        this.handleURL = handleURL;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }
}
