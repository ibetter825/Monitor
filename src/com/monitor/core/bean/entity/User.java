package com.monitor.core.bean.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "C_USER")
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NotEmpty
	private String userName;
	private String userPhone;
	@Email
	private String userEmail;
	@Column(updatable = false)
	private Short userStatus;
	@JsonIgnore
	@Column(updatable = false)
	private String userPwd;
	@JsonIgnore
	@Column(updatable = false)
	private String userSalt;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	@PrimaryKeyJoinColumn
	@Valid
	private UserInfo userInfo;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "c_user_organ",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="org_id")
	)
	private Set<Organ> organs = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "c_user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private Set<Role> roles = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "c_user_menu",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="menu_id")
	)
	private Set<Menu> menus = new HashSet<>();
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Set<Organ> getOrgans() {
		return organs;
	}
	public void setOrgans(Set<Organ> organs) {
		this.organs = organs;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
}
