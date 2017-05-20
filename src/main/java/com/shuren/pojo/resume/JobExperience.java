package com.shuren.pojo.resume;

/**
 * Created by dbh on 2017/5/18.
 * 工作经验
 */
public class JobExperience {

    private Integer id;

    //用户Id
    private Integer userId;

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

    //工作时间
    private String jobTime;

    //薪资水平
    private String salary;

    //工作内容
    private String jobContent;

    //第几份工作的索引
    private Integer index;

    //创建时间
    private Long createTimeStamp;

    //最新更新时间
    private Long lastUpdateStamp;

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

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Long getLastUpdateStamp() {
        return lastUpdateStamp;
    }

    public void setLastUpdateStamp(Long lastUpdateStamp) {
        this.lastUpdateStamp = lastUpdateStamp;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
