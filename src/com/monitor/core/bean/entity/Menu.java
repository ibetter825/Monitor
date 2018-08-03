package com.monitor.core.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "C_MENU")
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String menuId;
	private String menuName;
	private String menuDesc;
	private Integer menuSeq;
	private String menuPid;
	private String menuUrl;
	private Short menuStatus;
	private String menuType;
	private String menuIcon;
	private String menuParam;
	private String menuPids;
	private Short menuLevel;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	public Integer getMenuSeq() {
		return menuSeq;
	}
	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}
	public String getMenuPid() {
		return menuPid;
	}
	public void setMenuPid(String menuPid) {
		this.menuPid = menuPid;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Short getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(Short menuStatus) {
		this.menuStatus = menuStatus;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public String getMenuParam() {
		return menuParam;
	}
	public void setMenuParam(String menuParam) {
		this.menuParam = menuParam;
	}
	public String getMenuPids() {
		return menuPids;
	}
	public void setMenuPids(String menuPids) {
		this.menuPids = menuPids;
	}
	public Short getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Short menuLevel) {
		this.menuLevel = menuLevel;
	}
}
