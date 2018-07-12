package com.monitor.core.bean.echarts;

import java.util.ArrayList;
import java.util.List;

public class Legend {
	private String type;
	private String id;
	private String show = "true";
	private String zlevel = "0";
	private String z = "2";
	private String left = "auto";
	private String top = "auto";
	private String right = "auto";
	private String bottom = "auto";
	private String width = "auto";
	private String height = "auto";
	private String orient = "horizontal";
	private String align = "auto";
	private String padding = "5";
	private String itemGap = "10";
	private String itemWidth = "25";
	private String itemHeight = "14";
	private String symbolKeepAspect = "true";
	private String formatter = "null";
	private String selectedMode = "true";
	private String inactiveColor = "#ccc";
	private TextStyle textStyle = new TextStyle();
	private ToolTip toolTip = new ToolTip();
	private List<Data> data = new ArrayList<>();
	private String backgroundColor = "transparent";
	private String borderColor = "#ccc";
	private String borderWidth = "1";
	private String borderRadius = "0";
	private String shadowBlur = "...";
	private String shadowColor = "...";
	private String shadowOffsetX = "0";
	private String shadowOffsetY = "0";
	private String scrollDataIndex = "0";
	private String pageButtonItemGap = "5";
	private String pageButtonGap = "null";
	private String pageButtonPosition = "end";
	private String pageFormatter = "{current}/{total}";
	private PageIcons pageIcons = new PageIcons();
	private String pageIconColor = "#2f4554";
	private String pageIconInactiveColor = "#aaa";
	private String pageIconSize = "15";
	private TextStyle pageTextStyle = new TextStyle("#333", "12");
	private String animation;
	private String animationDurationUpdate;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public String getZlevel() {
		return zlevel;
	}
	public void setZlevel(String zlevel) {
		this.zlevel = zlevel;
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
	public String getOrient() {
		return orient;
	}
	public void setOrient(String orient) {
		this.orient = orient;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getPadding() {
		return padding;
	}
	public void setPadding(String padding) {
		this.padding = padding;
	}
	public String getItemGap() {
		return itemGap;
	}
	public void setItemGap(String itemGap) {
		this.itemGap = itemGap;
	}
	public String getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}
	public String getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}
	public String getSymbolKeepAspect() {
		return symbolKeepAspect;
	}
	public void setSymbolKeepAspect(String symbolKeepAspect) {
		this.symbolKeepAspect = symbolKeepAspect;
	}
	public String getFormatter() {
		return formatter;
	}
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	public String getSelectedMode() {
		return selectedMode;
	}
	public void setSelectedMode(String selectedMode) {
		this.selectedMode = selectedMode;
	}
	public String getInactiveColor() {
		return inactiveColor;
	}
	public void setInactiveColor(String inactiveColor) {
		this.inactiveColor = inactiveColor;
	}
	public TextStyle getTextStyle() {
		return textStyle;
	}
	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}
	public ToolTip getToolTip() {
		return toolTip;
	}
	public void setToolTip(ToolTip toolTip) {
		this.toolTip = toolTip;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
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
	public String getBorderRadius() {
		return borderRadius;
	}
	public void setBorderRadius(String borderRadius) {
		this.borderRadius = borderRadius;
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
	public String getScrollDataIndex() {
		return scrollDataIndex;
	}
	public void setScrollDataIndex(String scrollDataIndex) {
		this.scrollDataIndex = scrollDataIndex;
	}
	public String getPageButtonItemGap() {
		return pageButtonItemGap;
	}
	public void setPageButtonItemGap(String pageButtonItemGap) {
		this.pageButtonItemGap = pageButtonItemGap;
	}
	public String getPageButtonGap() {
		return pageButtonGap;
	}
	public void setPageButtonGap(String pageButtonGap) {
		this.pageButtonGap = pageButtonGap;
	}
	public String getPageButtonPosition() {
		return pageButtonPosition;
	}
	public void setPageButtonPosition(String pageButtonPosition) {
		this.pageButtonPosition = pageButtonPosition;
	}
	public String getPageFormatter() {
		return pageFormatter;
	}
	public void setPageFormatter(String pageFormatter) {
		this.pageFormatter = pageFormatter;
	}
	public PageIcons getPageIcons() {
		return pageIcons;
	}
	public void setPageIcons(PageIcons pageIcons) {
		this.pageIcons = pageIcons;
	}
	public String getPageIconColor() {
		return pageIconColor;
	}
	public void setPageIconColor(String pageIconColor) {
		this.pageIconColor = pageIconColor;
	}
	public String getPageIconInactiveColor() {
		return pageIconInactiveColor;
	}
	public void setPageIconInactiveColor(String pageIconInactiveColor) {
		this.pageIconInactiveColor = pageIconInactiveColor;
	}
	public String getPageIconSize() {
		return pageIconSize;
	}
	public void setPageIconSize(String pageIconSize) {
		this.pageIconSize = pageIconSize;
	}
	public TextStyle getPageTextStyle() {
		return pageTextStyle;
	}
	public void setPageTextStyle(TextStyle pageTextStyle) {
		this.pageTextStyle = pageTextStyle;
	}
	public String getAnimation() {
		return animation;
	}
	public void setAnimation(String animation) {
		this.animation = animation;
	}
	public String getAnimationDurationUpdate() {
		return animationDurationUpdate;
	}
	public void setAnimationDurationUpdate(String animationDurationUpdate) {
		this.animationDurationUpdate = animationDurationUpdate;
	}
}
