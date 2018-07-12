package com.monitor.core.bean.echarts;

public class CrossStyle {
	private String color = "#555";
	private String width = "1";
	private String type = "dashed";
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
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
