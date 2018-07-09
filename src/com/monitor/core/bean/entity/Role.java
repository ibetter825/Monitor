package com.monitor.core.bean.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "C_ROLE")
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roleId;
	private String roleName;
	private String roleDesc;
	private String depId;
	private Short roleStatus;
	private Integer roleSeq;
	@JsonIgnore
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public Short getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(Short roleStatus) {
		this.roleStatus = roleStatus;
	}
	public Integer getRoleSeq() {
		return roleSeq;
	}
	public void setRoleSeq(Integer roleSeq) {
		this.roleSeq = roleSeq;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
