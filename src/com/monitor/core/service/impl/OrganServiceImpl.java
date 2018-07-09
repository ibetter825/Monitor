package com.monitor.core.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.monitor.core.bean.entity.Organ;
import com.monitor.core.dao.OrganDao;
import com.monitor.core.service.OrganService;

@Service
public class OrganServiceImpl implements OrganService {
	@Autowired
	private OrganDao organDao;

	@Override
	public Organ getOrgan(String id) {
		return organDao.get(id);
	}

	@Override
	public List<Organ> getSubOrgans(String rootId) {
		Map<String, String> values = Maps.newHashMap();
		values.put("id", "%/" + rootId + "/%");
		if(StringUtils.isNotEmpty(rootId))
			return organDao.find("from Organ o where o.orgPids like :id", values);
		else
			return null;
	}

	@Override
	public List<Organ> getOrgans(String[] organIds) {
		Map<String, String[]> values = Maps.newHashMap();
		values.put("organIds", organIds);
		return organDao.find("from Organ where orgId in (:organIds)", values);
	}
	
}
