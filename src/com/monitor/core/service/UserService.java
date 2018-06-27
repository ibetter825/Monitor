package com.monitor.core.service;

import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.entity.UserInfo;

public interface UserService {
	public User getUser(Integer id);
	public void saveOrUpdate(User user, UserInfo info);
	/**
	 * 删除
	 * @param ids
	 */
	public int delete(Integer[] arr);
}
