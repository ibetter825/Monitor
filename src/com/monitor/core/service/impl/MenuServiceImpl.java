package com.monitor.core.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitor.core.bean.entity.Menu;
import com.monitor.core.dao.MenuDao;
import com.monitor.core.orm.Page;
import com.monitor.core.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<Menu> getPageList(Page<Menu> page, String hql, Map<String, ?> values) {
		menuDao.findPage(page, hql, values);
		return page.getResult();
	}
}
