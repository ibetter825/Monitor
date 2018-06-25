package com.monitor.core.service;

import java.util.List;
import java.util.Map;
import com.monitor.core.bean.entity.User;
import com.monitor.core.orm.Page;

public interface UserService {
	public User getUser(Integer id);
	public List<User> getPageList(Page<User> page, Map<String, ?> values);
}
