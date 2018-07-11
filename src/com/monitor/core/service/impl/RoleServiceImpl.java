package com.monitor.core.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.monitor.core.bean.entity.Role;
import com.monitor.core.bean.rq.QueryRQ;
import com.monitor.core.dao.RoleDao;
import com.monitor.core.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public List<Role> getRoles(QueryRQ rq) {
		Map<String, Object> values = rq.getQrq();
		String hql = rq.getHqlWithParam("from Role r where r.roleStatus = 1", false);
		return roleDao.find(hql, values);
	}
	@Override
	public List<Role> getRoles(String[] ids) {
		Map<String, String[]> values = Maps.newHashMap();
		values.put("roleIds", ids);
		return roleDao.find("from Role where roleId in (:roleIds)", values);
	}
}
