package com.monitor.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.monitor.core.bean.entity.Role;
import com.monitor.core.dao.RoleDao;
import com.monitor.core.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public List<Role> getRoles(String depId) {
		Map<String, String> values = Maps.newHashMap();
		values.put("depId", depId);
		return roleDao.find("from Organ o where o.status = 1 and o.depId = :depId", values);
	}

}
