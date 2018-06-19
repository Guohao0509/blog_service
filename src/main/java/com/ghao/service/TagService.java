package com.ghao.service;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Tag;

public interface TagService {
	
	/**
	 * 添加tag 
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除tag 
	 */
	boolean delete(Map<String, String> map);
	
	/**
	 * 更新tag
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 根据id获取tag
	 */
	Tag getTagById(Map<String, String> map);
	
	/**
	 * 查询tag列表
	 */
	Map<String, Object> list(int pageNum, int pageSize);

	Map<String, Object> all();

}
