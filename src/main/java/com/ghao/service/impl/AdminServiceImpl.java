package com.ghao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghao.dao.AdminDao;
import com.ghao.dto.Admin;
import com.ghao.service.AdminService;
import com.ghao.utils.PrimaryKeyUtil;
import com.github.pagehelper.PageHelper;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public int add(Map<String, String> map) {
		// TODO Auto-generated method stub
		map.put("adminId", PrimaryKeyUtil.getUUID());
		return adminDao.add(map);
	}

	@Override
	public boolean delete(Map<String, String> map) {
		// TODO Auto-generated method stub
		return adminDao.delete(map.get("adminId"));
	}

	@Override
	public boolean update(Map<String, String> map) {
		// TODO Auto-generated method stub
		return adminDao.update(map);
	}

	@Override
	public Map<String, Object> list(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", adminDao.list());
		map.put("total", adminDao.total());
		return map;
	}

	@Override
	public Admin getAdminById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return adminDao.getAdminById(map.get("adminId"));
	}

	@Override
	public Admin login(Map<String, String> map) {
		// TODO Auto-generated method stub
//		int count = adminDao.checkUserExist(map.get("account"));
//		if (count > 0) {
			Admin admin = adminDao.login(map);
			if (map.get("account") == admin.getAccount() && map.get("password") == admin.getPassword()) {
				
			}
			return admin;
//		}
//		return null;
	}

}
