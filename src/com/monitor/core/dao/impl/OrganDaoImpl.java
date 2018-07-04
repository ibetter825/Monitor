package com.monitor.core.dao.impl;

import org.springframework.stereotype.Repository;
import com.monitor.core.bean.entity.Organ;
import com.monitor.core.dao.OrganDao;
import com.monitor.core.orm.hibernate.HibernateDao;

@Repository
public class OrganDaoImpl extends HibernateDao<Organ> implements OrganDao {

}
