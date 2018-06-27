package com.monitor.core.dao.impl;

import org.springframework.stereotype.Repository;
import com.monitor.core.bean.entity.UserInfo;
import com.monitor.core.dao.UserInfoDao;
import com.monitor.core.orm.hibernate.HibernateDao;

@Repository
public class UserInfoDaoImpl extends HibernateDao<UserInfo> implements UserInfoDao {

}
