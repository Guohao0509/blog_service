package com.ghao.dao;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Admin;

public interface AdminDao {
	
	/**
	 * 添加系统用户
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除用户
	 */
	boolean delete(String adminId);
	
	/**
	 * 更新用户
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 查询所有用户
	 */
	List<Admin> list();
	
	/**
	 * 根据用户id查询用户
	 */
	Admin getAdminById(String adminId);
	
	/**
	 * 查询用户数量
	 */
	int total();
	
	/**
	 * 查询是否存在登陆用户
	 */
	int checkUserExist(String account);
	
	/**
	 * 登陆查询用户信息
	 */
	Admin login(Map<String, String> map);
}
