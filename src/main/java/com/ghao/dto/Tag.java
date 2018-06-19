package com.ghao.dto;

public class Tag {
	
	/**
     * TAG_ID
     * 标签id
     */
	private String tagId;
	
	/**
	 * TAG_NAME
	 * 标签名称
	 */
	private String tagName;
	
	/**
	 * STYLES
	 * 标签样式
	 */
	private String styles;
	
	
	// getter AND setter
	
	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getStyles() {
		return styles;
	}

	public void setStyles(String styles) {
		this.styles = styles;
	}
	
}
