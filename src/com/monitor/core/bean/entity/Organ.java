package com.monitor.core.bean.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import com.monitor.core.bean.entity.BaseEntity;
import com.monitor.core.bean.model.TreeModel;

@Entity
@Table(name = "C_ORGAN")
public class Organ extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String orgId;
	private String orgPid;
	private String orgName;
	private String orgDesc;
	private String orgStatus;
	private Integer orgSeq;
	private Short orgLevel;
	private String orgPids;
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	public String getOrgPid() {
		return orgPid;
	}
	public void setOrgPid(String orgPid) {
		this.orgPid = orgPid;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgDesc() {
		return orgDesc;
	}
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}
	public String getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}
	public Integer getOrgSeq() {
		return orgSeq;
	}
	public void setOrgSeq(Integer orgSeq) {
		this.orgSeq = orgSeq;
	}
	public Short getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(Short orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getOrgPids() {
		return orgPids;
	}
	public void setOrgPids(String orgPids) {
		this.orgPids = orgPids;
	}
	/**
	 * 获取机构的树形结构
	 * @param list
	 * @return
	 */
	public static List<TreeModel> getTreeModel(List<Organ> list, Organ organ){
		if(list == null) return null;
		List<TreeModel> res = new ArrayList<TreeModel>();
		TreeModel tree = null;
		for (Organ org : list) {
			if(organ == null){
				if(StringUtils.isNotEmpty(org.getOrgPid())){
					continue;
				}
			}else{
				if(!organ.getOrgId().equals(org.getOrgPid())){
					continue;
				}
			}
			tree = new TreeModel();
			tree.setId(org.getOrgId());
			tree.setText(org.getOrgName());
			tree.setChildren(getTreeModel(list, org));
			res.add(tree);
		}
		return res;
	}
}
