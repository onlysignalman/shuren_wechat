package com.shuren.pojo.resume;

/**
 * Created by dbh on 2017/5/17.
 * 用户基础信息
 */
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
    
    //逻辑删
    private Integer isDel;
    
    //添加时间(存储的是毫秒值)
    private Long createTimeStamp;

    //最近修改时间
    private Long lastUpdateTimeStamp;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
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

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "UserBaseinfo [userId=" + userId + ", openId=" + openId + ", nickName=" + nickName + ", mobile=" + mobile
				+ ", email=" + email + ", password=" + password + ", score=" + score + ", credit=" + credit + ", logo="
				+ logo + ", isDel=" + isDel + ", createTimeStamp=" + createTimeStamp + ", lastUpdateTimeStamp="
				+ lastUpdateTimeStamp + "]";
	}

}
