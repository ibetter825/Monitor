package com.monitor.core.bean.echarts.comp;
/**
 * 标题组件，包含主标题和副标题。
 * @author ibett
 *
 */
public class Title {
	private String id;
	private String show = "true";
	private String text;
	private String link;
	private String target = "blank";
	private TextStyle textStyle = new TextStyle();
	private String subtext;
	private String sublink;
	private String subtarget = "blank";
	private SubtextStyle subtextStyle = new SubtextStyle();
	private String padding = "5";
	private String itemGap = "10";
	private String zlevel = "0";
	private String z = "2";
	private String left = "auto";
	private String top = "auto";
	private String right = "auto";
	private String bottom = "auto";
	private String backgroundColor = "transparent";
	private String borderColor = "#ccc";
	private String borderWidth = "0";
	private String borderRadius = "0";
	private String shadowBlur;
	private String shadowColor;
	private String shadowOffsetX = "0";
	private String shadowOffsetY = "0";
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public TextStyle getTextStyle() {
		return textStyle;
	}
	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}
	public String getSubtext() {
		return subtext;
	}
	public void setSubtext(String subtext) {
		this.subtext = subtext;
	}
	public String getSublink() {
		return sublink;
	}
	public void setSublink(String sublink) {
		this.sublink = sublink;
	}
	public String getSubtarget() {
		return subtarget;
	}
	public void setSubtarget(String subtarget) {
		this.subtarget = subtarget;
	}
	public SubtextStyle getSubtextStyle() {
		return subtextStyle;
	}
	public void setSubtextStyle(SubtextStyle subtextStyle) {
		this.subtextStyle = subtextStyle;
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
}
