package com.monitor.core.bean.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "C_USER_INFO")
public class UserInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "pkGenerator", strategy = "foreign", parameters = {@Parameter(name = "property", value = "user")})
	@GeneratedValue(generator = "pkGenerator")
	private Integer userNo;
	@Length(max = 10, min = 1)
	private String nickName;
	private String userAvatar;
	private Long addTime;
	private Long updateTime;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userInfo")
	private User user;
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public Long getAddTime() {
		return addTime;
	}
	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}