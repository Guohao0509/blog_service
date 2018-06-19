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

import com.ghao.dto.Tag;
import com.ghao.service.TagService;
import com.ghao.utils.ApiResultUtil;
import com.github.pagehelper.PageHelper;

@Controller
@Scope("prototype")
@RequestMapping(value = "/api/tag")
public class TagAction {
	
	@Autowired
	private TagService tagService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tagName", request.getParameter("tagName"));
		map.put("styles", request.getParameter("styles"));
		int result = tagService.add(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "标签添加成功");
        return JsonStr;
    }
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tagId", request.getParameter("tagId"));
		boolean relult = tagService.delete(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "标签删除成功");
        return JsonStr;
    }
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tagId", request.getParameter("tagId"));
		map.put("tagName", request.getParameter("tagName"));
		map.put("styles", request.getParameter("styles"));
		boolean relult = tagService.update(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "标签更新成功");
        return JsonStr;
    }
	
	@ResponseBody
	@RequestMapping("/getTagById")
	public String getTagById(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tagId", request.getParameter("tagId"));
		Tag tag = tagService.getTagById(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, tag);
        return JsonStr;
    }
	
	@ResponseBody
	@GetMapping("/list")
	public String list(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
        		int pageNum,
        	@RequestParam(name = "pageSize", required = false, defaultValue = "10")
        		int pageSize) {
		Map<String, Object> tagListMap = tagService.list(pageNum, pageSize);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, tagListMap);
		return JsonStr;
	}
	
	@ResponseBody
	@GetMapping("/all")
	public String all() {
		Map<String, Object> tagListMap = tagService.all();
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, tagListMap);
		return JsonStr;
	}
}
