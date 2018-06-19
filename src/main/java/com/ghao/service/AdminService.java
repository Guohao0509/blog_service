package com.ghao.service;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Admin;

public interface AdminService {
	/**
	 * 添加系统用户
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除用户
	 */
	boolean delete(Map<String, String> map);
	
	/**
	 * 更新用户
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 查询所有用户
	 */
	Map<String, Object> list(int pageNum, int pageSize);
	
	/**
	 * 根据用户id查询用户
	 */
	Admin getAdminById(Map<String, String> map);

	/**
	 * 系统用户登陆
	 */
	Admin login(Map<String, String> map);
}
