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
@RequestMapping("/b/store")
public class BStoreCtrl {
	private Logger loger  = Logger.getLogger(this.getClass());
	@Autowired
	private DcomplainService complainService;
	@Autowired
	private DorderService orderService;
	@Autowired
	private DstoreService storeService;
	
	@ResponseBody
	@RequestMapping("/getStoreDetailById.htm")
	public String getStoreDetailById(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map params = requestContent.getBody();
        
        try {
        	long storeId = Long.valueOf(params.get("storeId") + "");
			Map store = storeService.getStoreDetailById(storeId);
			long countSales = storeService.countSalesById(storeId);
			long countAccount = storeService.countAccountById(storeId);
			Map map = new HashMap();
			map.put("store", store);
			map.put("countSales", countSales);
			map.put("countAccount", countAccount);
			responseContent = ResponseHandler.makeResponse(map, true);
		} catch (Exception e) {
			loger.info("请求失败", e);
		}
		return JSONObject.toJSONString(responseContent);
	}
	
}
