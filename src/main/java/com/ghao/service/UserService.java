package com.ghao.service;

import java.util.List;
import java.util.Map;

import com.ghao.dto.User;

public interface UserService {
	/**
	 * 添加网站用户
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除网站用户
	 */
	boolean delete(Map<String, String> map);
	
	/**
	 * 更新网站用户
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 查询用户列表
	 * @param pageSize 
	 * @param pageNum 
	 */
	Map<String, Object> list(int pageNum, int pageSize);
	
	/**
	 * 查询单个用户
	 */
	User getUserById(Map<String, String> map);
}
