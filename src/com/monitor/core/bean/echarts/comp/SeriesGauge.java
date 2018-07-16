package com.monitor.core.bean.echarts.comp;

import java.util.ArrayList;
import java.util.List;

/**
 * 仪表盘
 * @author user
 *
 */
public class SeriesGauge extends Series {
	private String name;
	private List<DataSeriesGauge> data = new ArrayList<>();
	@Override
	public String getType() {
		return "gauge";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DataSeriesGauge> getData() {
		return data;
	}
	public void setData(List<DataSeriesGauge> data) {
		this.data = data;
	}
}
