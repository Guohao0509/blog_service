package com.ghao.dao;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Tag;

public interface TagDao {
	
	/**
	 * 添加tag 
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除tag 
	 */
	boolean delete(String tagId);
	
	/**
	 * 更新tag
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 根据id获取tag
	 */
	Tag getTagById(String tagId);
	
	/**
	 * 获取tag列表
	 */
	List<Tag> list();
	
	/**
	 * 获取tag总数
	 */
	int total();

	List<Tag> all();
}
