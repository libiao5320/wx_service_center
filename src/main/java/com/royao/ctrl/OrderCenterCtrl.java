package com.royao.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royao.model.Devaluate;
import com.royao.services.inface.DevaluateService;
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
import com.royao.model.Dmember;
import com.royao.model.Dorder;
import com.royao.model.Dstore;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DstoreService;

/**
 * 
 * ClassName: OrderCenterCtrl 
 * @Description: 处理订单详情
 * @author Liu Pinghui
 * @date 2016年1月15日
 */
@Controller
@RequestMapping("/order/detail")
public class OrderCenterCtrl {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DorderService orderService;
	
	@Autowired
	private DstoreService storeService;

	@Autowired
	private DevaluateService devaluateService;
	
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);


		JSONObject result = new JSONObject();
        try {
            if (null != requestContent.getBody()) {
            	Dorder order = this.orderService.queryById(Long.parseLong(requestContent.getBody().get("id").toString()));

				Devaluate eval = this.devaluateService.queryByOrderId(Integer.parseInt(requestContent.getBody().get("id").toString()));

                if (order != null) {

					result.put("order",order);
					result.put("eval",eval);

                    responseContent = ResponseHandler.makeResponse(result, true);
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
	
	@ResponseBody
	@RequestMapping("/b_detail.htm")
	public String detail_b(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			if (null != requestContent.getBody()) {
				Dorder order = this.orderService.queryByIdTob(Long.parseLong(requestContent.getBody().get("id").toString()));
				if (order != null) {
					responseContent = ResponseHandler.makeResponse(order, true);
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
	 * @Description: 根据消费券和商家ID查询
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月24日
	 */
	@ResponseBody
	@RequestMapping("/b_queryByConsumptionCode.htm")
	public String b_queryByConsumptionCode(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			if (null != requestContent.getBody()) {
				List<Dorder> list = this.orderService.queryByCondtion(requestContent.getBody());
				if (list != null && list.size() > 0) {
					responseContent = ResponseHandler.makeResponse(list.get(0), true);
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
     * @Description: B端获取订单列表
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月20日
     */
    @ResponseBody
    @RequestMapping("/list.htm")
    public String list(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);

        try{
        	Dorder order = new Dorder();
            if(null != requestContent.getBody()){
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
            		order.setStoreId(Integer.parseInt(requestContent.getBody().get("storeId")));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("mMobile"))){
            		order.setMMobile(requestContent.getBody().get("mMobile"));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("orderState"))){
            		order.setOrderState(Integer.parseInt(requestContent.getBody().get("orderState")));
            	}
            	
            	//排序标准
            	PageObject page = new PageObject();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
            		page.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
            	}else{
            		page.setPageNo(1);
            	}
            	
            	order.setPageInfo(page);
            }
            
            List<Dorder> list = this.orderService.listWithPage(order);
            
            Integer total = this.orderService.listWithPageCount(order);
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

    /**
     * 
     * @Description: 商家核销
     * @param @param request
     * @param @param response
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年2月24日
     */
    @ResponseBody
	@RequestMapping("/consume.htm")
	public String consume(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			
			boolean flag = false;
			if (null != requestContent.getBody()) {
				List<Dorder> list = this.orderService.queryByCondtion(requestContent.getBody());
				if (list != null && list.size() > 0) {
					Dorder order = list.get(0);
					
					//必须是未消费的订单
					if(order.getOrderState() != null && order.getOrderType() != null && order.getOrderState() == 2){
						
						if(order.getOrderType() == 1){//普通订单
							order.setOrderState(4);
						}else if(order.getOrderType() == 2){//预定订单
							order.setOrderState(3);
						}else if(order.getOrderType() == 3){//活动订单
							order.setOrderState(4);
						}else{
							order.setOrderState(null);
						}
						
						if(order.getOrderState() != null){
							Dstore store = this.storeService.queryById(Long.valueOf(order.getStoreId()));
							order.setVerifyConsumptionPerson(store.getStoreLoginPhone());
							order.setVerifyConsumptionTime(new Date());
							this.orderService.updateOrderStateByOrderId(order);
							
							flag = true;
						}
					}
				}
			}
			responseContent = ResponseHandler.makeResponse(flag, true);
			
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			logger.info("获取订单详情失败！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}

}
