package com.monitor.core.service;

import java.util.List;
import java.util.Map;
import com.monitor.core.bean.entity.Menu;
import com.monitor.core.orm.Page;

public interface MenuService {
	/**
	 * 分页查询
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<Menu> getPageList(Page<Menu> page, String hql, Map<String, ?> values);
}
