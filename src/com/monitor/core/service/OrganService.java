package com.monitor.core.service;

import java.util.List;

import com.monitor.core.bean.entity.Organ;

public interface OrganService {
	public Organ getOrgan(String id);
	/**
	 * 获取传入节点的所有子节点
	 * @param rootId
	 * @return
	 */
	public List<Organ> getSubOrgans(String rootId);
}
