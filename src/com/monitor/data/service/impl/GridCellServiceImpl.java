package com.monitor.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitor.data.bean.entity.GridCell;
import com.monitor.data.bean.entity.GridCellKey;
import com.monitor.data.dao.GridCellDao;
import com.monitor.data.service.GridCellService;

@Service
public class GridCellServiceImpl implements GridCellService {

	@Autowired
	private GridCellDao gridCellDao;

	//@Override
	@Override
	public GridCell getById(GridCellKey gridCellKey) {
		return gridCellDao.get(gridCellKey);
	}


}
