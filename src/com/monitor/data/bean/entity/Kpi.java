package com.monitor.data.bean.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "D_KPI")
public class Kpi extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	private String kpiCode;
	private String kpiName;
	private String kpiDesc;
	private String kpiFreq;
	private String kpiCurr;
	private Short kpiStatus;
	private String addUser;
	private String addTime;
	private String expireDt;
	public String getKpiCode() {
		return kpiCode;
	}
	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public String getKpiDesc() {
		return kpiDesc;
	}
	public void setKpiDesc(String kpiDesc) {
		this.kpiDesc = kpiDesc;
	}
	public String getKpiFreq() {
		return kpiFreq;
	}
	public void setKpiFreq(String kpiFreq) {
		this.kpiFreq = kpiFreq;
	}
	public String getKpiCurr() {
		return kpiCurr;
	}
	public void setKpiCurr(String kpiCurr) {
		this.kpiCurr = kpiCurr;
	}
	public Short getKpiStatus() {
		return kpiStatus;
	}
	public void setKpiStatus(Short kpiStatus) {
		this.kpiStatus = kpiStatus;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(String expireDt) {
		this.expireDt = expireDt;
	}
}
