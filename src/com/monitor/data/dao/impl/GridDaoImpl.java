package com.monitor.data.dao.impl;

import org.springframework.stereotype.Repository;
import com.monitor.core.orm.hibernate.HibernateDao;
import com.monitor.data.bean.entity.Grid;
import com.monitor.data.dao.GridDao;

@Repository
public class GridDaoImpl extends HibernateDao<Grid> implements GridDao {

}
