package com.royao.ctrl;

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
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dorder;
import com.royao.services.inface.DorderService;
import com.royao.util.JsonUtil;

/**
 * 
 * @author yangx
 * @className 订单查询数据接口 
 * @date 2016年1月27日上午10:41:25
 */
@Controller
@RequestMapping("/queryOrder")
public class QueryOrderCenterCtrl {

	@Autowired
	private DorderService dorderService;
	Logger logger = Logger.getLogger(this.getClass());
	
	@ResponseBody
	@RequestMapping("/queryOrderByOrderId.htm")
	public String queryOrderByPaySn(HttpServletRequest request ,HttpServletResponse response){
		
		ResponseContent responseContent = null;
		try {
			logger.info("订单id查询");
			responseContent = new ResponseContent();   
			RequestContent  requestContent  = RequestHandler.execute(request);
			
			 Map<?, ?> params = requestContent.getBody();
			
	        response.setCharacterEncoding("utf-8");
	        //将json字符串 转换成 java bean
	        Dorder dorder = JSON.parseObject(JsonUtil.map2json(params), Dorder.class);
		        try {
		        	
		        	if(null != requestContent.getBody()){
		        		
		        		Map<String,Object> remap=new HashMap<String, Object>();
		        		
		        		Long orderId=Long.parseLong(dorder.getOrderId()+"");
		        		remap.put("orderId", dorder.getOrderId());//订单id
		        		remap.put("orderState",dorder.getOrderState());//订单状态
		        		
						Dorder order= this.dorderService.queryById(orderId);
						
						if(order != null){
							responseContent = ResponseHandler.makeResponse(order,true);
						}
					}
		        	
		        } catch (Exception e) {
		        	logger.info("异常："+e.getMessage());
		        }
		        
		} catch (Exception e) {
			logger.info("异常："+e.getMessage());
		}
		 return JSONObject.toJSONString(responseContent);
	}
	

}
