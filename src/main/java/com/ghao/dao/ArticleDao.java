package com.ghao.dao;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Article;

public interface ArticleDao {
	
	/**
	 * 添加文章
	 */
	int add(Map<String, String> map);
	
	/**
	 * 绑定标签
	 */
	int bindTag(Map<String, Object> map);
	
	/**
	 * 更新文章
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 删除文章
	 */
	boolean delete(String articleId);
	
	/**
	 * 删除文章对应的标签
	 */
	boolean unBindTag(String articleId);
	
	/**
	 * 获取文章列表
	 */
	List<Article> list();
	
	/**
	 * 根据文章id获取文章
	 */
	Article getArticleById(String articleId);

	/**
	 * 获取文章总数
	 */
	int total();

	/**
	 * 获取推荐文章列表
	 */
	List<Article> recommended();

	/**
	 * 获取简要文章列表
	 */
	List<Article> index();
	
	/**
	 * 获取文章查看数量，点赞数量，收藏数量
	 */
	Article info(Map<String, String> map);
	
	/**
	 * 更改文章查看数量，点赞数量，收藏数量
	 */
	boolean infoAdd(Article article);

	/**
	 * 更具标签获取文章列表
	 */
	List<Article> listByTag(Map<String, String> map);

	/**
	 * 更具关键字获取文章列表
	 */
	List<Article> listByKeyword(Map<String, String> map);
}
