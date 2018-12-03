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
import com.royao.model.Dclear;
import com.royao.model.Dorder;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DclearService;
import com.royao.services.inface.DorderService;

@Controller
@RequestMapping("/clear")
public class ClearCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DclearService clearService;
	
	@Autowired
	private DorderService orderService;
	
	@ResponseBody
    @RequestMapping("/list.htm")
    public String list(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);

        try{
        	Dclear clear = new Dclear();
            if(null != requestContent.getBody()){
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
            		clear.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("field"))){
            		clear.setField(requestContent.getBody().get("field"));
            		
            		if(requestContent.getBody().get("field").equals("clearTime")){//核算时间
            			if(StringUtils.isNotBlank(requestContent.getBody().get("startTime")) && StringUtils.isNotBlank(requestContent.getBody().get("endTime")))
                    	{
                    		clear.setStartTime(requestContent.getBody().get("startTime"));
                    		clear.setEndTime(requestContent.getBody().get("endTime"));
                    	}
            		}
            	}
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("clearState"))){
            		clear.setClearState(Integer.parseInt(requestContent.getBody().get("clearState")));
            	}
            	//排序标准
            	PageObject page = new PageObject();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
            		page.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
            	}else{
            		page.setPageNo(1);
            	}
            	
            	clear.setPageInfo(page);
            }
            
            List<Dclear> list = this.clearService.listWithPage(clear);
            
            Integer total = this.clearService.listWithPageCount(clear);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", list);
            returnMap.put("total", total);
            
            if(list != null && list.size() > 0){
            	responseContent = ResponseHandler.makeResponse(returnMap, true);
            }
        }catch(Exception e){
            logger.info("获取用户列表出错", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
	
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
            	Dclear clear = this.clearService.queryById(Long.parseLong(requestContent.getBody().get("id").toString()));
                if (clear != null) {
                    responseContent = ResponseHandler.makeResponse(clear, true);
                } else {
                    return null;
                }
            }
            return JSONObject.toJSONString(responseContent);
        } catch (Exception e) {
        	logger.info("获取订单详情失败！", e);
        }
        
        return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 商家处理核算
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月24日
	 */
	@ResponseBody
	@RequestMapping("/manage.htm")
	public String manage(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			boolean flag = false;
			if (null != requestContent.getBody()) {
				Dclear clear = new Dclear();
				
				if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
					clear.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("confirmUser"))){
					clear.setConfirmUser(requestContent.getBody().get("confirmUser"));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("clearId"))){
					clear.setId(Long.parseLong(requestContent.getBody().get("clearId")));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("clearState"))){
					clear.setClearState(Integer.parseInt(requestContent.getBody().get("clearState")));
				}

				if (clear.getId() != null) {
					this.clearService.update(clear);
					flag = true;
				} 
			}
			responseContent = ResponseHandler.makeResponse(flag, true);
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			logger.info("获取订单详情失败！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 与对账单相关的所有订单
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月24日
	 */
	@ResponseBody
    @RequestMapping("/orderByClearList.htm")
    public String orderByClearList(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);

        try{
        	Dclear clear = new Dclear();
            if(null != requestContent.getBody()){
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
            		clear.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
            	}
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("clearId"))){
            		clear.setId(Long.parseLong(requestContent.getBody().get("clearId")));
            	}
            	//排序标准
            	PageObject page = new PageObject();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
            		page.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
            	}else{
            		page.setPageNo(1);
            	}
            	
            	clear.setPageInfo(page);
            }
            
            List<Map<?,?>> list = this.orderService.orderByClearPage(clear);
            
            Integer total = this.orderService.orderByClearPageCount(clear);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", list);
            returnMap.put("total", total);
            
            if(list != null && list.size() > 0){
            	responseContent = ResponseHandler.makeResponse(returnMap, true);
            }
        }catch(Exception e){
            logger.info("获取用户列表出错", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
}
