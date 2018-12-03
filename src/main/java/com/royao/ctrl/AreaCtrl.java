package com.royao.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dstore;
import com.royao.services.inface.DareaService;

@Controller
@RequestMapping("/area")
public class AreaCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DareaService areaService;
	
	/**
	 * 
	 * @Description: B端获取地区信息
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月22日
	 */
	@ResponseBody
	@RequestMapping("/bGetList.htm")
	public String bGetList(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		List proviceList = null;
		List cityList = null;
		List areaList = null;
		
		Map<String,Object> returnMap   =  new HashMap<String,Object>();
		try {
			if(null != requestContent.getBody()){
				
				proviceList = this.areaService.queryByDeep(1);
				cityList  = this.areaService.queryByDeep(2);
				areaList  = this.areaService.queryByDeep(3);
				
				returnMap.put("proviceList", proviceList);
				returnMap.put("cityList",cityList);
				returnMap.put("areaList",areaList);
				
				responseContent = ResponseHandler.makeResponse(returnMap,true);
			}
		} catch (Exception e) {
			logger.info("商家注册异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
}
