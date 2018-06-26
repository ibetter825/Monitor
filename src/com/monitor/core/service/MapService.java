package com.monitor.core.service;

import java.util.List;
import java.util.Map;
import com.monitor.core.orm.Page;

/**
 * 查询结果集为Map
 * @author user
 *
 */
public interface MapService {
	/**
	 * 分页查询
	 * @param page
	 * @param values
	 * @return
	 */
	public List<Map<?,?>> getPageList(Page<Map<?,?>> page, String hql, Map<String, ?> values);
}
