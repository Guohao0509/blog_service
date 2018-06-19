package com.ghao.dto;

public class User {
	
	/**
	 * USER_ID
	 * 网站用户id
	 */
	private String userId;
	
	/**
	 * EMAIL
	 * 网站用户邮箱
	 */
	private String email;
	
	/**
	 * PASSWORD
	 * 网站用户密码
	 */
	private String password;
	
	/**
	 * PROFILE
	 * 网站用户头像
	 */
	private String profile;
	
	/**
	 * NICKNAME
	 * 网站用户昵称
	 */
	private String nickname;

	// getter AND setter ...
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
