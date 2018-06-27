package com.monitor.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.entity.UserInfo;
import com.monitor.core.dao.UserDao;
import com.monitor.core.dao.UserInfoDao;
import com.monitor.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserInfoDao infoDao;
	@Override
	public User getUser(Integer id) {
		return userDao.get(id, false);
	}
	@Override
	public void saveOrUpdate(User user, UserInfo info) {
		if(user.getUserNo() == null){
			user.setUserInfo(info);
			info.setUser(user);
			userDao.save(user);
			info.setUserNo(user.getUserNo());
			infoDao.save(info);
		}else{
			
		}
	}
}
