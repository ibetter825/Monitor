package com.monitor.core.dao.impl;

import org.springframework.stereotype.Repository;
import com.monitor.core.bean.entity.Menu;
import com.monitor.core.dao.MenuDao;
import com.monitor.core.orm.hibernate.HibernateDao;

@Repository
public class MenuDaoImpl extends HibernateDao<Menu> implements MenuDao {

}
