package com.monitor.core.bean.rq;

import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 查询条件对象
 * @author user
 *
 */
public class QueryRQ {
	/**
	 * 查询的参数封到rq中
	 */
	private Map<String, Object> qrq = Maps.newHashMap();
	/**
	 * 排序
	 * eg: menu_id desc, menu_seq desc
	 */
	private String order;
	
	public Map<String, Object> getQrq() {
		return qrq;
	}
	public void setQrq(Map<String, Object> qrq) {
		this.qrq = qrq;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	/**
	 * 获取带占位符的参数
	 * @param hql
	 * @param isNeedWhere
	 * 		       是否需要拼接where
	 * @return
	 */
	public String getHqlWithParam(String hql, boolean isNeedWhere) {
		String res = hql;
		StringBuffer buffer = new StringBuffer(hql);
		if(this.qrq != null){
			Iterator<String> it = qrq.keySet().iterator();
			if(isNeedWhere) {
				buffer.append(" where");
			}else
				buffer.append(" and ");
			String key = null;
			String[] arr = null;
			while (it.hasNext()) {
				key = it.next();
				if(key.startsWith("_")){//_u_userStatus
					arr = key.split("_");
					buffer.append(" ").append(arr[1]).append(".").append(arr[2]).append("=:").append(key).append(" and");
				}else
					buffer.append(" ").append(key).append("=:").append(key).append(" and");
			}
			res = buffer.substring(0, buffer.lastIndexOf("and")).toString();
		}
		return res;
	}
}
