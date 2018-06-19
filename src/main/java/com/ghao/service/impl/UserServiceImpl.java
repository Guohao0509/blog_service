package com.ghao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghao.dao.UserDao;
import com.ghao.dto.User;
import com.ghao.service.UserService;
import com.ghao.utils.PrimaryKeyUtil;
import com.github.pagehelper.PageHelper;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	@Override
	public int add(Map<String, String> map) {
		// TODO Auto-generated method stub
		map.put("userId", PrimaryKeyUtil.getUUID());
		return userDao.add(map);
	}

	@Override
	public boolean delete(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.delete(map.get("userId"));
	}

	@Override
	public boolean update(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.update(map);
	}

	@Override
	public Map<String, Object> list(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", userDao.list());
		map.put("total", userDao.total());
		return map;
	}

	@Override
	public User getUserById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.getUserById(map.get("userId"));
	}
	
}
