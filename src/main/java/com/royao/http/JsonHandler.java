package com.royao.http;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.royao.model.base.BaseEntity;

public class JsonHandler {

	/**
	 * 
	 * @Description
	 * @author jk
	 * @param result
	 * @param flag
	 * @return
	 * @throws Exception
	 * @return String
	 * @date 2016年2月18日
	 */
	public static String makeJson(Object result, boolean flag) throws Exception {
		JSON json = null;
		JsonContent content = new JsonContent();
		if (result instanceof List) {
			json = JSONArray.parseArray(JSONArray.toJSONString(result));
		} else if (result instanceof BaseEntity) {
			json = JSON.parseObject(JSONObject.toJSONString(result));
		} else if (result instanceof String || result instanceof Boolean
				|| result instanceof Integer || result instanceof Double
				|| result instanceof Float || result instanceof Long) {

			String jsonStr = "{result:" + result + "}";
		} else {
			json = JSON.parseObject(JSONObject.toJSONString(result));
		}
		content.setData(json);
		content.setInfo("");
		content.setMsg("");
		content.setCode(1);
		content.setStatus(1);
		return JSONObject.toJSONString(content);

	}

}
