package com.shuren.resume.pojo;

/**
 * Created by dbh on 2017/5/17.
 */
public class TrainExperience {

    private Integer id;

    //用户Id
    private Integer userId;

    //培训机构名称
    private String trainName;

    //培训地点
    private String trainLocation;

    //培训获得证书
    private String trainAwardName;

    //获得时间
    private Long trainAwardTime;

    //详细说明
    private String detail;

    //本人培训次数索引
    private String index;

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

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainLocation() {
        return trainLocation;
    }

    public void setTrainLocation(String trainLocation) {
        this.trainLocation = trainLocation;
    }

    public String getTrainAwardName() {
        return trainAwardName;
    }

    public void setTrainAwardName(String trainAwardName) {
        this.trainAwardName = trainAwardName;
    }

    public Long getTrainAwardTime() {
        return trainAwardTime;
    }

    public void setTrainAwardTime(Long trainAwardTime) {
        this.trainAwardTime = trainAwardTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
