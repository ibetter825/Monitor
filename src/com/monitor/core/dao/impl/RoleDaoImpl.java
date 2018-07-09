package com.monitor.core.dao.impl;

import org.springframework.stereotype.Repository;
import com.monitor.core.bean.entity.Role;
import com.monitor.core.dao.RoleDao;
import com.monitor.core.orm.hibernate.HibernateDao;

@Repository
public class RoleDaoImpl extends HibernateDao<Role> implements RoleDao {

}
