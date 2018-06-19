package com.ghao.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ghao.dto.Article;
import com.ghao.service.ArticleService;
import com.ghao.utils.ApiResultUtil;
import com.github.pagehelper.PageHelper;

@Controller
@Scope("prototype")
@RequestMapping(value = "/api/article")
public class ArticleAction {
	
	@Autowired
	private ArticleService articleService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", request.getParameter("title"));
		map.put("author", request.getParameter("author"));
		map.put("info", request.getParameter("info"));
		map.put("text", request.getParameter("text"));
		map.put("tags", request.getParameter("tags"));
		int result = articleService.add(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "文章添加成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		boolean result = articleService.delete(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "文章删除成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		map.put("title", request.getParameter("title"));
		map.put("author", request.getParameter("author"));
		map.put("info", request.getParameter("info"));
		map.put("text", request.getParameter("text"));
		map.put("tags", request.getParameter("tags"));
		boolean result = articleService.update(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "文章更新成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/getArticleById")
	public String getArticleById(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		Article article = articleService.getArticleById(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, article);
		return JsonStr;
	}
	
	
	@ResponseBody
	@RequestMapping("/watch")
	public String watch(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		boolean result = articleService.watch(map);
		String JsonStr;
		if (result) {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "查看成功");
		} else {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.FAIL, "查看失败");
		}
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/star")
	public String star(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		boolean result = articleService.star(map);
		String JsonStr;
		if (result) {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "点赞成功");
		} else {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.FAIL, "点赞失败");
		}
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/keep")
	public String keep(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		map.put("userId", request.getParameter("userId"));
		boolean result = articleService.keep(map);
		String JsonStr;
		if (result) {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "收藏成功");
		} else {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.FAIL, "收藏失败");
		}
		return JsonStr;
	}
	
	@ResponseBody
    @GetMapping("/list")
	public String list(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
				int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10")
				int pageSize) {
		Map<String, Object> articleListMap = articleService.list(pageNum, pageSize);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, articleListMap);
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/listByTag")
	public String listByTag(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tagId", request.getParameter("tagId"));
		Map<String, Object> articleListMap = articleService.listByTag(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, articleListMap);
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/listByKeyword")
	public String listByKeyword(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", request.getParameter("keyword"));
		Map<String, Object> articleListMap = articleService.listByKeyword(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, articleListMap);
		return JsonStr;
	}
	
	@ResponseBody
    @GetMapping("/recommended")
	public String recommended() {
		Map<String, Object> articleListMap = articleService.recommended();
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, articleListMap);
		return JsonStr;
	}
	
	@ResponseBody
    @GetMapping("/index")
	public String index(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
				int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10")
				int pageSize) {
		Map<String, Object> articleListMap = articleService.index(pageNum, pageSize);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, articleListMap);
		return JsonStr;
	}
}
