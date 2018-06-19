package com.ghao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghao.dao.TagDao;
import com.ghao.dto.Tag;
import com.ghao.service.TagService;
import com.ghao.utils.PrimaryKeyUtil;
import com.github.pagehelper.PageHelper;

@Service(value = "tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
    private TagDao tagDao;
	
	@Override
	public int add(Map<String, String> map) {
		// TODO Auto-generated method stub
		map.put("tagId", PrimaryKeyUtil.getUUID());
		return tagDao.add(map);
	}

	@Override
	public Map<String, Object> list(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", tagDao.list());
		map.put("total", tagDao.total());
		return map;
	}

	@Override
	public boolean delete(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tagDao.delete(map.get("tagId"));
	}

	@Override
	public boolean update(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tagDao.update(map);
	}

	@Override
	public Tag getTagById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tagDao.getTagById(map.get("tagId"));
	}

	@Override
	public Map<String, Object> all() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", tagDao.list());
		return map;
	}
}
