package com.ghao.dto;

import java.util.Date;
import java.util.List;

public class Article {
	
	/**
	 * ARTICLE_ID
	 * 文章id
	 */
	private String articleId;
	
	/**
	 * TITLE
	 * 文章标题
	 */
	private String title;
	
	/**
	 * AUTHOR
	 * 作者
	 */
	private String author;
	
	/**
	 * TEXT
	 * 正文
	 */
	private String info;
	
	/**
	 * TEXT
	 * 正文
	 */
	private String text;

	/**
	 * VISITS
	 * 访问量
	 */
	private int visits;
	
	/**
	 * STARS
	 * 点赞量
	 */
	private int stars;
	
	/**
	 * KEEPS
	 * 收藏量
	 */
	private int keeps;
	
	/**
	 * CREATE_TIME
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * UPDATE_TIME
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * List<Tag>
	 * 文章的标签
	 */
	private List<Tag> tags;

	// getter AND setter
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date ctrateTime) {
		this.createTime = ctrateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getKeeps() {
		return keeps;
	}

	public void setKeeps(int keeps) {
		this.keeps = keeps;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
