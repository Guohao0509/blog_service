package com.ghao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghao.dao.ArticleDao;
import com.ghao.dto.Article;
import com.ghao.dto.Tag;
import com.ghao.service.ArticleService;
import com.ghao.utils.JacksonUtils;
import com.ghao.utils.PrimaryKeyUtil;
import com.github.pagehelper.PageHelper;

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
    private ArticleDao articleDao;
    
	@Override
	public Map<String, Object> list(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", articleDao.list());
		map.put("total", articleDao.total());
		return map;
	}

	@Override
	public Article getArticleById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return articleDao.getArticleById(map.get("articleId"));
	}

	@Override
	public int add(Map<String, String> map) {
		// TODO Auto-generated method stub
		// 生成文章主键ID
		String articleId = PrimaryKeyUtil.getUUID();
		Map<String, Object> a_t_map = new HashMap<String, Object>();
		JacksonUtils<Tag> jacksonUtils = new JacksonUtils<Tag>();
		List<Tag> tags = jacksonUtils.transJsonstrToList(map.get("tags"), Tag.class);
		map.put("articleId", articleId);
		// 插入文章
		int result = articleDao.add(map);
		// 插入文章对应的标签
		if (tags.size() > 0) {
			a_t_map.put("articleId", articleId);
			a_t_map.put("tags", tags);
			articleDao.bindTag(a_t_map);
		}
	
		return result;
	}
	
	@Override
	public boolean update(Map<String, String> map) {
		// TODO Auto-generated method stub
		String articleId = map.get("articleId");
		Map<String, Object> a_t_map = new HashMap<String, Object>();
		JacksonUtils<Tag> jacksonUtils = new JacksonUtils<Tag>();
		List<Tag> tags = jacksonUtils.transJsonstrToList(map.get("tags"), Tag.class);
		a_t_map.put("articleId", articleId);
		a_t_map.put("tags", tags);
		boolean result = articleDao.update(map);
		articleDao.unBindTag(articleId);
		articleDao.bindTag(a_t_map);
		return result;
	}

	@Override
	public boolean delete(Map<String, String> map) {
		// TODO Auto-generated method stub
		String articleId = map.get("articleId");
		// 删除文章
		boolean result = articleDao.delete(articleId);
		// 解绑文章对应的标签
		articleDao.unBindTag(articleId);
		return result;
	}

	@Override
	public Map<String, Object> recommended() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", articleDao.recommended());
		return map;
	}

	@Override
	public Map<String, Object> index(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
//		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", articleDao.index());
		return map;
	}
	
	
	
	@Override
	public boolean watch(Map<String, String> map) {
		Article articleInfo = articleDao.info(map);
		int visits = articleInfo.getVisits();
		visits ++;
		articleInfo.setVisits(visits);
		return articleDao.infoAdd(articleInfo);
	}

	@Override
	public boolean star(Map<String, String> map) {
		// TODO Auto-generated method stub
		Article articleInfo = articleDao.info(map);
		int stars = articleInfo.getStars();
		stars ++;
		int visits = articleInfo.getVisits();
		visits += 10;		
		articleInfo.setVisits(visits);
		articleInfo.setStars(stars);
		return articleDao.infoAdd(articleInfo);
	}

	@Override
	public boolean keep(Map<String, String> map) {
		// TODO Auto-generated method stub
		Article articleInfo = articleDao.info(map);
		int keeps = articleInfo.getKeeps();
		keeps ++;
		articleInfo.setStars(keeps);
		int visits = articleInfo.getVisits();
		visits += 100;		
		articleInfo.setVisits(visits);
		articleInfo.setKeeps(keeps);
		return articleDao.infoAdd(articleInfo);
	}

	@Override
	public Map<String, Object> listByTag(Map<String, String> map) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", articleDao.listByTag(map));
		return result;
	}

	@Override
	public Map<String, Object> listByKeyword(Map<String, String> map) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", articleDao.listByKeyword(map));
		return result;
	}

}
