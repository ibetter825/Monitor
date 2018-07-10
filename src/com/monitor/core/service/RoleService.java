package com.monitor.core.service;

import java.util.List;
import com.monitor.core.bean.entity.Role;

public interface RoleService {
	/**
	 * 根据部门查询角色
	 * @param orgId
	 * @return
	 */
	public List<Role> getRolesByDep(String depId);
}
