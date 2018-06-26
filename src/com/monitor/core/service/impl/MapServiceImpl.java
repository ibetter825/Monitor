package com.monitor.core.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitor.core.dao.MapDao;
import com.monitor.core.orm.Page;
import com.monitor.core.service.MapService;

@Service
public class MapServiceImpl implements MapService {
	@Autowired
	private MapDao mapDao;
	@Override
	public List<Map<?,?>> getPageList(Page<Map<?,?>> page, String hql, Map<String, ?> values) {
		mapDao.findPage(page, hql, values);
		return page.getResult();
	}
}
