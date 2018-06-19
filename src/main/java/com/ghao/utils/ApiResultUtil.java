package com.ghao.utils;

import java.util.HashMap;
import java.util.Map;

public class ApiResultUtil {
	
	public static final int SUCCESS = 0;
	
	public static final int FAIL = -1;
	
	public static String getApiResult(int code, Object result) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", code);
		resultMap.put("data", result);
		return JacksonUtils.transEntityToJson(resultMap);
	}
}
