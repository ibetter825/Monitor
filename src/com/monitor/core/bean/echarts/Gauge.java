package com.monitor.core.bean.echarts;

import java.util.ArrayList;
import java.util.List;
import com.monitor.core.bean.echarts.comp.SeriesGauge;
import com.monitor.core.bean.echarts.comp.ToolBox;
import com.monitor.core.bean.echarts.comp.ToolTip;

/**
 * 仪表盘
 * @author user
 *
 */
public class Gauge {
	private ToolTip toolTip = new ToolTip();
	private ToolBox toolBox = new ToolBox();
	private List<SeriesGauge> series = new ArrayList<SeriesGauge>();
	public ToolTip getToolTip() {
		return toolTip;
	}
	public void setToolTip(ToolTip toolTip) {
		this.toolTip = toolTip;
	}
	public ToolBox getToolBox() {
		return toolBox;
	}
	public void setToolBox(ToolBox toolBox) {
		this.toolBox = toolBox;
	}
	public List<SeriesGauge> getSeries() {
		return series;
	}
	public void setSeries(List<SeriesGauge> series) {
		this.series = series;
	}
}
