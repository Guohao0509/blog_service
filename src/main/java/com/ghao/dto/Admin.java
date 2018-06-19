package com.ghao.dto;

public class Admin {
	
	/**
	 * ADMIN_ID
	 * 后台管理员id
	 */
	private String adminId;
	
	/**
	 * ACCOUNT
	 * 后台管理员账号
	 */
	private String account;
	
	/**
	 * ADMIN_NAME
	 * 后台管理员name
	 */
	private String adminName;
	
	/**
	 * PASSWORD
	 * 后台管理密码
	 */
	private String password;

	// getter AND setter
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
