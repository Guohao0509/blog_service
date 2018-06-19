package com.ghao.dao;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Comment;

public interface CommentDao {
	
	/**
	 * 添加评论
	 */
	int add(Map<String, String> map);
	
	/**
	 * 查看点赞评论数量和喷屎评论数量
	 */
	Comment info(Map<String, String> map);
	
	/**
	 * 点赞评论喷屎评论
	 */
	boolean infoAdd(Comment comment);
	
	/**
	 * 删除评论
	 */
	boolean delete(String commentId);
	
	/**
	 * 修改评论
	 */
	boolean update(Map<String, String> map);
	
	/**
	 * 查询所有评论
	 */
	List<Comment> list();
	
	/**
	 * 查询单个评论
	 */
	Comment getCommentById(String commentId);
	
	/**
	 * 根据文章查询评论
	 */
	List<Comment> getCommentsByArticle(String articleId);
	
	/**
	 * 查看两个用户的对话
	 */
	List<Comment> getCommentsByChat(Map<String, String> map);

	/**
	 * 查询评论总数
	 */
	int total();
	
	/**
	 * 条件查询查询评论总数
	 */
	int count(Map<String, String> map);
}
