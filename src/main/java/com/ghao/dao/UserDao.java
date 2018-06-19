package com.ghao.dao;

import java.util.List;
import java.util.Map;

import com.ghao.dto.User;

public interface UserDao {
	
	/**
	 * 添加网站用户
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除网站用户
	 */
	boolean delete(String userId);
	
	/**
	 * 更新网站用户
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 查询用户列表
	 */
	List<User> list();
	
	/**
	 * 查询单个用户
	 */
	User getUserById(String userId);
	
	/**
	 * 查询用户总数
	 */
	int total();
}
