package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by dbh on 2017/5/17.
 * 用户基础信息
 */
@Data
public class UserBaseinfo {
	
	//自增id
    private Integer userId;

    //微信唯一Id
    private String openId;

    //用户昵称
    private String nickName;

    //用户手机号
    private String mobile;

    //用户邮箱
    private String email;

    //密文密码
    private String password;
    
    //建立分数
    private Integer score;
    
    //建立分数
    private Integer credit;

    //logo
    public String logo;
    
    //代投
    public Integer isSend;
    
    //逻辑删
    private Integer isDel;
    
    //添加时间(存储的是毫秒值)
    private Long createTimeStamp;

    //最近修改时间
    private Long lastUpdateTimeStamp;

}
