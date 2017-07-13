package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/18.
 * 主页列表
 */
@Data
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
}
