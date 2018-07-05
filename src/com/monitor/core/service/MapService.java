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
	 * HQL分页查询
	 * @param page
	 * @param values
	 * @return
	 */
	public List<Map<?,?>> getPageList(Page<Map<?,?>> page, String hql, Map<String, ?> values);
	/**
	 * SQL分页查询
	 * @param page
	 * @param values
	 * @return
	 */
	public List<Map<?,?>> getPageListBySql(Page<Map<?,?>> page, String sql, Map<String, ?> values);
}
