package com.monitor.core.bean.echarts.comp;

public class DataSeriesGauge {
	private String value;
	private String name;
	public DataSeriesGauge() {
		super();
	}
	public DataSeriesGauge(String value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
