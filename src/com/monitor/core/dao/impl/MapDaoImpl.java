package com.monitor.core.dao.impl;

import java.util.Map;
import org.springframework.stereotype.Repository;
import com.monitor.core.dao.MapDao;
import com.monitor.core.orm.hibernate.HibernateDao;

@Repository
public class MapDaoImpl extends HibernateDao<Map<?,?>> implements MapDao {

}
