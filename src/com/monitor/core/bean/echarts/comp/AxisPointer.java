package com.monitor.core.bean.echarts.comp;

/**
 * 这是坐标轴指示器（axisPointer）的全局公用设置。
 * @author ibett
 *
 */
public class AxisPointer {
	private String type = "line";
	private String axis = "auto";
	private String snap;
	private String z;
	private Label label = new Label();
	private LineStyle lineStyle = new LineStyle();
	private ShadowStyle shadowStyle = new ShadowStyle();
	private CrossStyle crossStyle = new CrossStyle();
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}
	public String getSnap() {
		return snap;
	}
	public void setSnap(String snap) {
		this.snap = snap;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public LineStyle getLineStyle() {
		return lineStyle;
	}
	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
	}
	public ShadowStyle getShadowStyle() {
		return shadowStyle;
	}
	public void setShadowStyle(ShadowStyle shadowStyle) {
		this.shadowStyle = shadowStyle;
	}
	public CrossStyle getCrossStyle() {
		return crossStyle;
	}
	public void setCrossStyle(CrossStyle crossStyle) {
		this.crossStyle = crossStyle;
	}
}
