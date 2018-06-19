package com.ghao.dto;

import java.util.Date;

public class Comment {
	
	/**
	 * COMMENT_ID
	 * 评论信息ID
	 */
	private String commentId;
	
	/**
	 * ARTICLE_ID
	 * 文章ID
	 */
	private String articleId;
	
	/**
	 * TITLE
	 * 文章的标题
	 */
	private String title;
	
	/**
	 * USER_ID
	 * 评论用户的ID
	 */
	private String userId;
	
	/**
	 * NICKNAME
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * PROFILE
	 * 头像
	 */
	private String profile;
	
	/**
	 * TO_USER_ID
	 * 回复某人的ID
	 */
	private String toUserId;
	
	/**
	 * TO_NICKNAME
	 * 昵称
	 */
	private String toNickname;
	
	/**
	 * TO_PROFILE
	 * 头像
	 */
	private String toProfile;
	
	/**
	 * COMMENT
	 * 网站用户邮箱
	 */
	private String comment;

	/**
	 * STARS
	 * 评论被点赞的数量
	 */
	private int stars;
	
	/**
	 * TIP_OFFS
	 * 评论被举报的数量
	 */
	private int tipOffs;
	
	/**
	 * CREATE_TIME
	 * 评论创建的时间
	 */
	private Date createTime;

	// getter AND setter ...
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getTipOffs() {
		return tipOffs;
	}

	public void setTipOffs(int tipOffs) {
		this.tipOffs = tipOffs;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getToNickname() {
		return toNickname;
	}

	public void setToNickname(String toNickname) {
		this.toNickname = toNickname;
	}

	public String getToProfile() {
		return toProfile;
	}

	public void setToProfile(String toProfile) {
		this.toProfile = toProfile;
	}
	
}
