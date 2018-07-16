package com.monitor.core.bean.echarts.comp;

public class IconStyle {
	//private String color;
	private String borderColor = "#666";
	private String borderWidth = "1";
	private String borderType = "solid";
	private String shadowBlur;
	private String shadowColor;
	private String shadowOffsetX = "0";
	private String shadowOffsetY = "0";
	private String opacity;
	private String textPosition;
	private String textAlign;
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(String borderWidth) {
		this.borderWidth = borderWidth;
	}
	public String getBorderType() {
		return borderType;
	}
	public void setBorderType(String borderType) {
		this.borderType = borderType;
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
	public String getTextPosition() {
		return textPosition;
	}
	public void setTextPosition(String textPosition) {
		this.textPosition = textPosition;
	}
	public String getTextAlign() {
		return textAlign;
	}
	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}
}
