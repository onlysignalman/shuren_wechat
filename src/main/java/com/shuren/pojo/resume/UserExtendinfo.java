package com.shuren.pojo.resume;

import lombok.Data;

/**
 * Created by 董帮辉 on 2017-5-20.
 * 用户扩展信息
 */
@Data
public class UserExtendinfo {

    private Integer id;

    //用户的Id
    private Integer userId;

    //用户头像地址
    private String logo;

    //真实姓名
    private String realName;

    //性别
    private String sex;

    //出生日期时间戳
    private Long birthday;

    //身高
    private String tall;

    //体重kg
    private String weight;

    //民族
    private String nation;

    //政治面貌
    private String politics;

    //婚姻状况
    private String marry;

    //联系方式
    private String contactPhone;

    //联系邮箱
    private String contactEmail;

    //身份证号
    private String idCard;

    //户口所在地
    private String residence;

    //现住地
    private String location;

    //当前工作状态
    private String nowStatus;

    //期望工作性质
    private String wishType;

    //期望行业
    private String wishBusiness;

    //期望职业
    private String wishJob;

    //期望工作地点
    private String wishLocation;

    //期望薪资
    private String wishSalary;

    //学校名称
    private String collegeName;

    //专业名称
    private String specialities;

    //毕业时间
    private String graduationTime;

    //学校性质
    private String collegeType;

    //学历
    private String diplomas;

    //学位
    private String degree;

    //班级职务
    private String classDuty;

    //学生会职务
    private String studentDuty;

    //奖学金
    private String scholarship;

    //奖学金级别
    private String scholarshipRange;

    //奖项
    private String awards;

    //奖项级别
    private String awardsRange;

    //奖项描述
    private String awardsDes;

    //实习项目
    private String internProject;

    //实习时间
    private String internTime;

    //实习职务
    private String internDuty;

    //实习描述
    private String internDesc;

    //兴趣爱好
    private String hobby;

    //社会荣誉
    private String honor;

    //自我评价
    private String assessment;

    //创建时间
    private Long createTimeStamp;

    //最新更新时间
    private Long lastUpdateTimeStamp;

    //逻辑删除
    private Integer isDel;
}
