package com.ghao.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ghao.dto.Admin;
import com.ghao.service.AdminService;
import com.ghao.utils.ApiResultUtil;
import com.github.pagehelper.PageHelper;

@Controller
@Scope("prototype")
@RequestMapping(value = "/api/admin")
public class AdminAction {
	
	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("account", request.getParameter("account"));
		map.put("password", request.getParameter("password"));
		map.put("adminName", request.getParameter("adminName"));
		int result = adminService.add(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "系统用户添加成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("account", request.getParameter("account"));
		map.put("password", request.getParameter("password"));
		Admin result = adminService.login(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, result);
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("adminId", request.getParameter("adminId"));
		boolean result = adminService.delete(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "系统用户删除成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("adminId", request.getParameter("adminId"));
		map.put("account", request.getParameter("account"));
		map.put("password", request.getParameter("password"));
		map.put("adminName", request.getParameter("adminName"));
		boolean result = adminService.update(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "系统用户修改成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/getAdminById")
	public String getAdminById(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("adminId", request.getParameter("adminId"));
		Admin admin = adminService.getAdminById(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, admin);
		return JsonStr;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public String list(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
        		int pageNum,
        	@RequestParam(name = "pageSize", required = false, defaultValue = "10")
        		int pageSize) {
		Map<String, Object> adminListMap = adminService.list(pageNum, pageSize);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, adminListMap);
		return JsonStr;
	}
}
