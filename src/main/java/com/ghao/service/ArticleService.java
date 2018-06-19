package com.ghao.service;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Article;

public interface ArticleService {
	
	/**
	 * 添加文章
	 */
	int add(Map<String, String> map);
	
	/**
	 * 删除文章
	 */
	boolean delete(Map<String, String> map);
	
	/**
	 * 更新文章
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 根据ID查询文章
	 * @param map {文章id};
	 */
	Article getArticleById(Map<String, String> map);
	
	/**
	 * 查询文章列表
	 */
	Map<String, Object> list(int pageNum, int pageSize);

	/**
	 * 根据标签查询文章列表
	 */
	Map<String, Object> listByTag(Map<String, String> map);
	
	/**
	 * 查询推荐文章列表
	 */
	Map<String, Object> recommended();

	/**
	 * 查询文章简要列表
	 */
	Map<String, Object> index(int pageNum, int pageSize);
	
	/**
	 * 查看文章成功
	 */
	boolean watch(Map<String, String> map);
	
	/**
	 * 点赞文章成功
	 */
	boolean star(Map<String, String> map);
	
	/**
	 * 收藏文章成功
	 */
	boolean keep(Map<String, String> map);

	Map<String, Object> listByKeyword(Map<String, String> map);

}
