package com.royao.bctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dcomplain;
import com.royao.model.Dorder;
import com.royao.model.Dstore;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DcomplainService;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DstoreService;


/**
 * 订单投诉
 * @author L
 *
 */
@Controller
@RequestMapping("/b/complain")
public class BComplainCtrl {
	private Logger loger  = Logger.getLogger(this.getClass());
	@Autowired
	private DcomplainService complainService;
	@Autowired
	private DorderService orderService;
	@Autowired
	private DstoreService storeService;
	
	@ResponseBody
	@RequestMapping("/index.htm")
	public String index(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        PageObject pageInfo = new PageObject();
        Map params = requestContent.getBody();
        if(params.get("pageNo") != null){
        	pageInfo.setPageNo(Integer.valueOf("" + params.get("pageNo")));
        }else{
        	pageInfo.setPageNo(1);
        }
        params.put("pageInfo", pageInfo);
        
        if(params.get("typeValue") != null){
        	params.put(params.get("typeName"), params.get("typeValue"));
        }
        if(params.get("begin") !=null || params.get("end") != null){
    		params.put(params.get("timeName"), "exist");
        }

        try {
			List<Map> complains = complainService.blistWithPageAndCondition(params);
			
			int total = complainService.bcountWithCondition(params);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", complains);
            returnMap.put("total", total);
	            
			
			if(complains != null && complains.size() > 0){
				responseContent = ResponseHandler.makeResponse(returnMap, true);
			}
		} catch (Exception e) {
			loger.info("ajax请求投诉列表失败", e);
		}
        
		return JSON.toJSONString(responseContent,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map params = requestContent.getBody();
        
        try {
        	Dcomplain complain = complainService.queryById(Long.valueOf(params.get("id") + "")) ;
			Dorder order = orderService.queryById(complain.getOrderId());
			Dstore store = storeService.queryById(order.getStoreId().longValue());
			Map map = new HashMap();
			map.put("complain", complain);
			map.put("order", order);
			map.put("store", store);
			responseContent = ResponseHandler.makeResponse(map, true);
		} catch (Exception e) {
			loger.info("ajax请求活动列表失败", e);
		}
		return JSONObject.toJSONString(responseContent);
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/update.htm")
	public String update(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		Map params = requestContent.getBody();
		Map map = new HashMap();
		
		try {
			Dcomplain complain = complainService.queryById(Long.valueOf(params.get("id") + "")) ;
			complain.setReply(params.get("reply") + "");
			
			int countX = complainService.update(complain);
			if(countX > 0){
				map.put("state", 1);
				map.put("message", "更新成功");
			}else{
				map.put("state", -1);
				map.put("message", "更新失败");
			}
			
			responseContent = ResponseHandler.makeResponse(map, true);
			
		} catch (Exception e) {
			loger.info("更新失败", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
}
