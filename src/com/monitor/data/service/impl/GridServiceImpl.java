package com.monitor.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.data.bean.entity.Grid;
import com.monitor.data.dao.GridDao;
import com.monitor.data.service.GridService;

@Service
public class GridServiceImpl implements GridService {

	@Autowired
	private GridDao gridDao;

	@Override
	public Grid getById(Integer id) {
		return gridDao.get(id);
	}

}
