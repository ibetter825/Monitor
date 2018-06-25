package com.monitor.core.dao.impl;

import org.springframework.stereotype.Repository;
import com.monitor.core.bean.entity.User;
import com.monitor.core.dao.UserDao;
import com.monitor.core.orm.hibernate.HibernateDao;

@Repository
public class UserDaoImpl extends HibernateDao<User> implements UserDao {

}
