package com.ghao.service;

import java.util.List;
import java.util.Map;

import com.ghao.dto.Comment;

public interface CommentService {
	
	/**
	 * 添加评论
	 */
	int add(Map<String, String> map);
	
	/**
	 * 点赞评论
	 */
	boolean wow(Map<String, String> map);
	
	/**
	 * 点赞评论
	 */
	boolean poo(Map<String, String> map);
	
	/**
	 * 删除评论
	 */
	boolean delete(Map<String, String> map);
	
	/**
	 * 查询所有评论
	 */
	Map<String, Object> list(int pageNum, int pageSize);
	
	/**
	 * 查询单个评论
	 */
	Comment getCommentById(Map<String, String> map);
	
	/**
	 * 根据文章查询评论
	 */
	Map<String, Object> getCommentsByArticle(String articleId);
	
	/**
	 * 查看两个用户的对话
	 */
	List<Comment> getCommentsByChat(Map<String, String> map);

}
