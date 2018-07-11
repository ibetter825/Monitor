package com.monitor.core.service;

import java.util.List;
import java.util.Map;
import com.monitor.core.bean.entity.Role;
import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.entity.UserInfo;
import com.monitor.core.orm.Page;

public interface UserService {
	public User getUser(Integer id);
	public void saveOrUpdate(User user, UserInfo info);
	/**
	 * 删除
	 * @param ids
	 */
	public int delete(Integer[] arr);
	/**
	 * 分页查询
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<User> getPageList(Page<User> page, String hql, Map<String, ?> values);
	public List<Role> getRoles(Integer userId);
	
}
