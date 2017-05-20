package com.shuren.pojo.resume;

/**
 * Created by dbh on 2017/5/17.
 * 用户基础信息
 */
public class UserBaseinfo {

    private Integer id;

    //企业名称
    private String companyName;

    //企业性质
    private String companyType;

    //企业规模
    private String companyScale;

    //行业性质
    private String businessType;

    //职业名称
    private String jobName;

    //工作时间(存储的是毫秒值)
    private Long jobTime;

    //薪资水平
    private String salary;

    //工作内容
    private String text;

    //第几份工作的索引
    private Integer idnex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Long getJobTime() {
        return jobTime;
    }

    public void setJobTime(Long jobTime) {
        this.jobTime = jobTime;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIdnex() {
        return idnex;
    }

    public void setIdnex(Integer idnex) {
        this.idnex = idnex;
    }
}
