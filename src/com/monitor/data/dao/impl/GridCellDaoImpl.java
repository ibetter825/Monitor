package com.monitor.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.monitor.core.orm.hibernate.HibernateDao;
import com.monitor.data.bean.entity.GridCell;
import com.monitor.data.dao.GridCellDao;

@Repository
public class GridCellDaoImpl extends HibernateDao<GridCell> implements GridCellDao {
	
}
