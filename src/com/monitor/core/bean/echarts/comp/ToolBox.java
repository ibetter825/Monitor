package com.monitor.core.bean.echarts.comp;

public class ToolBox {
	private String id;
	private String show = "true";
	private String orient = "horizontal";
	private String itemSize = "15";
	private String itemGap = "10";
	private String showTitle = "true";
	private Feature feature;
	private IconStyle iconStyle = new IconStyle();
	private Emphasis emphasis = new Emphasis();
	private String zLevel = "0";
	private String z = "2";
	private String left = "auto";
	private String top = "auto";
	private String right = "auto";
	private String bottom = "auto";
	private String width = "auto";
	private String height = "auto";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getOrient() {
		return orient;
	}
	public void setOrient(String orient) {
		this.orient = orient;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemGap() {
		return itemGap;
	}
	public void setItemGap(String itemGap) {
		this.itemGap = itemGap;
	}
	public String getShowTitle() {
		return showTitle;
	}
	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	public IconStyle getIconStyle() {
		return iconStyle;
	}
	public void setIconStyle(IconStyle iconStyle) {
		this.iconStyle = iconStyle;
	}
	public Emphasis getEmphasis() {
		return emphasis;
	}
	public void setEmphasis(Emphasis emphasis) {
		this.emphasis = emphasis;
	}
	public String getzLevel() {
		return zLevel;
	}
	public void setzLevel(String zLevel) {
		this.zLevel = zLevel;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public String getBottom() {
		return bottom;
	}
	public void setBottom(String bottom) {
		this.bottom = bottom;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
}
