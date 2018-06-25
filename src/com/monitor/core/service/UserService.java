package com.monitor.core.service;

import java.util.List;
import java.util.Map;
import com.monitor.core.bean.entity.User;
import com.monitor.core.orm.Page;

public interface UserService {
	public User getUser(Integer id);
	/**
	 * 分页查询用户信息
	 * @param page
	 * @param values
	 * @return
	 */
	public List<User> getPageList(Page<User> page, String hql, Map<String, ?> values);
}
