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
import com.ghao.dto.User;
import com.ghao.service.AdminService;
import com.ghao.service.UserService;
import com.ghao.utils.ApiResultUtil;
import com.github.pagehelper.PageHelper;

@Controller
@Scope("prototype")
@RequestMapping(value = "/api/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", request.getParameter("email"));
		map.put("password", request.getParameter("password"));
		map.put("profile", request.getParameter("profile"));
		map.put("nickname", request.getParameter("nickname"));
		int result = userService.add(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "网站用户添加成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", request.getParameter("userId"));
		boolean result = userService.delete(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "网站用户删除成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", request.getParameter("userId"));
		map.put("email", request.getParameter("email"));
		map.put("password", request.getParameter("password"));
		map.put("profile", request.getParameter("profile"));
		map.put("nickname", request.getParameter("nickname"));
		boolean result = userService.update(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "网站用户修改成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/getUserById")
	public String getAdminById(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", request.getParameter("userId"));
		User user = userService.getUserById(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, user);
		return JsonStr;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public String list(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
        		int pageNum,
        	@RequestParam(name = "pageSize", required = false, defaultValue = "10")
        		int pageSize) {
		Map<String, Object> userListMap = userService.list(pageNum, pageSize);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, userListMap);
		return JsonStr;
	}
}
