package com.monitor.core.service;

import java.util.List;
import com.monitor.core.bean.entity.Role;
import com.monitor.core.bean.rq.QueryRQ;

public interface RoleService {
	/**
	 * 根据部门查询角色
	 * @param orgId
	 * @return
	 */
	public List<Role> getRoles(QueryRQ rq);
	/**
	 * 根据roleId数组查询角色
	 * @param ids
	 * @return
	 */
	public List<Role> getRoles(String[] ids);
}
