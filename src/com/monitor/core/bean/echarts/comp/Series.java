package com.monitor.core.bean.echarts.comp;

public class Series {
	protected String type;
	protected Detail detail = new Detail();
	
	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
