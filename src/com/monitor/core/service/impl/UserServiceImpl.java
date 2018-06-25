package com.monitor.core.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitor.core.bean.entity.User;
import com.monitor.core.dao.UserDao;
import com.monitor.core.orm.Page;
import com.monitor.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User getUser(Integer id) {
		return userDao.get(id, false);
	}
	@Override
	public List<User> getPageList(Page<User> page, String hql, Map<String, ?> values) {
		userDao.findPage(page, hql, values);
		return page.getResult();
	}
}
