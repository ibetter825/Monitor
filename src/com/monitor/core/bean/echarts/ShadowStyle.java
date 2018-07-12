package com.monitor.core.bean.echarts;

public class ShadowStyle {
	private String color = "rgba(150,150,150,0.3)";
	private String shadowBlur;
	private String shadowColor;
	private String shadowOffsetX = "0";
	private String shadowOffsetY = "0";
	private String opacity;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getShadowBlur() {
		return shadowBlur;
	}
	public void setShadowBlur(String shadowBlur) {
		this.shadowBlur = shadowBlur;
	}
	public String getShadowColor() {
		return shadowColor;
	}
	public void setShadowColor(String shadowColor) {
		this.shadowColor = shadowColor;
	}
	public String getShadowOffsetX() {
		return shadowOffsetX;
	}
	public void setShadowOffsetX(String shadowOffsetX) {
		this.shadowOffsetX = shadowOffsetX;
	}
	public String getShadowOffsetY() {
		return shadowOffsetY;
	}
	public void setShadowOffsetY(String shadowOffsetY) {
		this.shadowOffsetY = shadowOffsetY;
	}
	public String getOpacity() {
		return opacity;
	}
	public void setOpacity(String opacity) {
		this.opacity = opacity;
	}
}
