package com.monitor.core.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.monitor.core.bean.echarts.Gauge;
import com.monitor.core.bean.echarts.comp.DataSeriesGauge;
import com.monitor.core.bean.echarts.comp.Detail;
import com.monitor.core.bean.echarts.comp.SeriesGauge;

@RestController
public class EchartsController extends BaseController {
	@RequestMapping("/echarts")
	public Gauge index() {
		Gauge gauge = new Gauge();
		SeriesGauge series = new SeriesGauge();
		series.setName("业务指标");
		gauge.getSeries().add(series);
		DataSeriesGauge data = new DataSeriesGauge("50", "完成率");
		series.getData().add(data);
		Detail detail = new Detail("{value}%");
		series.setDetail(detail);
		return gauge;
	}
}
