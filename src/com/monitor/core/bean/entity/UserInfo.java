package com.monitor.core.bean.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "C_USER_INFO")
public class UserInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "pkGenerator", strategy = "foreign", parameters = {@Parameter(name = "property", value = "user")})
	@GeneratedValue(generator = "pkGenerator")
	private Integer userNo;
	private String nickName;
	private String userPhone;
	private String userEmail;
	private Short userStatus;
	private String userPwd;
	private String userSalt;
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
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Short getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Short userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserSalt() {
		return userSalt;
	}
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
