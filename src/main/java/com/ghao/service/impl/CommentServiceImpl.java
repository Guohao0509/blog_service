package com.ghao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghao.dao.CommentDao;
import com.ghao.dto.Comment;
import com.ghao.service.CommentService;
import com.ghao.utils.PrimaryKeyUtil;
import com.github.pagehelper.PageHelper;

@Service(value = "commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public int add(Map<String, String> map) {
		map.put("commentId", PrimaryKeyUtil.getUUID());
		return commentDao.add(map);
	}

	@Override
	public boolean delete(Map<String, String> map) {
		// TODO Auto-generated method stub
		return commentDao.delete(map.get("commentId"));
	}

	@Override
	public Map<String, Object> list(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", commentDao.list());
		map.put("total", commentDao.total());
		return map;
	}

	@Override
	public Comment getCommentById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return commentDao.getCommentById(map.get("commentId"));
	}

	@Override
	public Map<String, Object> getCommentsByArticle(String articleId) {
	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", commentDao.getCommentsByArticle(articleId));
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", articleId);
		resultMap.put("total", commentDao.count(map));
		return resultMap;
	}

	@Override
	public List<Comment> getCommentsByChat(Map<String, String> map) {
		// TODO Auto-generated method stub
		return commentDao.getCommentsByChat(map);
	}

	@Override
	public boolean wow(Map<String, String> map) {
		Comment commentInfos = commentDao.info(map);
		int stars = commentInfos.getStars();
		stars ++;
		commentInfos.setStars(stars);
		commentDao.infoAdd(commentInfos);
		return commentDao.infoAdd(commentInfos);
	}

	@Override
	public boolean poo(Map<String, String> map) {
		Comment commentInfos = commentDao.info(map);
		int tipOffs = commentInfos.getStars();
		tipOffs ++;
		commentInfos.setTipOffs(tipOffs);
		commentDao.infoAdd(commentInfos);
		return commentDao.infoAdd(commentInfos);
	}
}
