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

import com.ghao.dto.Comment;
import com.ghao.service.CommentService;
import com.ghao.utils.ApiResultUtil;
import com.github.pagehelper.PageHelper;

@Controller
@Scope("prototype")
@RequestMapping(value = "/api/comment")
public class CommentAction {
	
	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", request.getParameter("userId"));
		map.put("articleId", request.getParameter("articleId"));
		map.put("toUserId", request.getParameter("toUserId") == null ? "" : request.getParameter("toUserId"));
		map.put("comment", request.getParameter("comment"));
		int result = commentService.add(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "评论添加成功");
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/wow")
	public String wow(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("commentId", request.getParameter("commentId"));
		boolean result = commentService.wow(map);
		String JsonStr;
		if (result) {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "点赞成功");
		} else {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.FAIL, "点赞失败");
		}
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/poo")
	public String poo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("commentId", request.getParameter("commentId"));
		boolean result = commentService.poo(map);
		String JsonStr;
		if (result) {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "举报成功");
		} else {
			JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.FAIL, "举报失败");
		}
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("commentId", request.getParameter("commentId"));
		boolean result = commentService.delete(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, "评论删除成功");
		return JsonStr;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public String list(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
        		int pageNum,
        	@RequestParam(name = "pageSize", required = false, defaultValue = "10")
        		int pageSize) {
		//开始分页
		PageHelper.startPage(pageNum,pageSize);
		Map<String, Object> commentListMap = commentService.list(pageNum, pageSize);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, commentListMap);
		return JsonStr;
	}
	
	@ResponseBody
	@GetMapping("/listByArticle")
	public String listByArticle(
    		@RequestParam(name = "articleId", required = true)
    			String articleId) {
		Map<String, Object> articleCommentListMap = commentService.getCommentsByArticle(articleId);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, articleCommentListMap);
		return JsonStr;
	}
	
	@ResponseBody
	@RequestMapping("/getCommentsByChat")
	public String getCommentsByChat(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleId", request.getParameter("articleId"));
		map.put("userId", request.getParameter("userId"));
		map.put("toUserId", request.getParameter("toUserId"));
		List<Comment> commentListMap = commentService.getCommentsByChat(map);
		String JsonStr = ApiResultUtil.getApiResult(ApiResultUtil.SUCCESS, commentListMap);
		return JsonStr;
	}
	
}
