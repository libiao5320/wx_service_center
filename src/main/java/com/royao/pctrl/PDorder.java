package com.royao.pctrl;
import java.sql.SQLException;
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
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dmember;
import com.royao.model.Dorder;
import com.royao.model.Drefund;
import com.royao.model.Dstore;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DbalanceLogsService;
import com.royao.services.inface.DevaluateService;
import com.royao.services.inface.DmemberService;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DrefundService;
import com.royao.services.inface.DstoreService;
import com.royao.util.JsonUtil;

/**
 * @author wangya
 *
 */

@Controller
@RequestMapping("/p_Dorder")
public class PDorder {
//	private static final Map<?, ?> map = null;


	private Logger loger  = Logger.getLogger(this.getClass());
	
	
	@Autowired
	private DorderService dorderService;
	
	@Autowired
	private DevaluateService evaluateService;
	
	@Autowired
	private DmemberService userService;
	
	@Autowired
	private DbalanceLogsService logsService;
	
	@Autowired
	private DrefundService refundService;
	
	@Autowired
	private DstoreService storeService;
	
	@Autowired
	private DmemberService memberService;
	
	/**
	 * p端订单管理(未付余额管理)
	 * @param request
	 * @param response
	 * @return
	 */

	@ResponseBody
	@RequestMapping("/plist.htm")
	public String plist(HttpServletRequest request ,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);

		Map<String,Object>  result = new HashMap<String, Object>();
		
		Map<?,?> params = requestContent.getBody();
		
		int page = Integer.parseInt(params.get("page").toString());
		int size = 10;
		if(null != params.get("size")){
			size = Integer.parseInt(params.get("size").toString());
		}
		params.remove("page");
		params.remove("size");
		PageObject p = new PageObject();
		p.setPageNo(page);
		p.setPageSize(size);
		Dorder or = JSON.parseObject(JsonUtil.map2json(params), Dorder.class);
		or.setPageInfo(p);
		try {
			List<Dorder> ors = this.dorderService.DqueryAllOrderBy(or);
			result.put("rows", ors);
			Long total = this.dorderService.DqueryAllOrderByCount(or);
			result.put("total", total);
			/*result.put("rows", page);
			result.put("size",size);*/
			try {
				responseContent = ResponseHandler.makeResponse(result, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(responseContent);
	}

	
	/**
	 * 退款申请管理
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/plist1.htm")
	public String plist1(HttpServletRequest request ,HttpServletResponse response){
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
			List<Drefund> refunds = this.refundService.listWithPageAndCondition(params);
			int total = this.refundService.countWithCondition(params);
			Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", refunds);
            returnMap.put("total", total);
			
			
			responseContent = ResponseHandler.makeResponse(returnMap, true);
		}  catch (Exception e) {
			loger.info("ajax请求退款列表失败", e);
		}
		return JSONObject.toJSONString(responseContent);
	}


	
	
	/**
	 * 退款申请详情
	 *
	 */
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map params = requestContent.getBody();
        
        try {
        	Drefund refund = refundService.queryDetailByOrderId(Integer.valueOf(params.get("orderId").toString()));
        	Dstore store = storeService.queryById(refund.getOrder().getStoreId().longValue());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("refund", refund);
			//map.put("order", refund.getOrder());
			map.put("storePhone", store.getStorePhone());
			responseContent = ResponseHandler.makeResponse(map, true);
		} catch (Exception e) {
			loger.info("ajax请求活动列表失败", e);
		}
		return JSONObject.toJSONString(responseContent);
	}

	
	/**
	 * 更新处理退款请求
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update.htm")
	public String update(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
		Map params = requestContent.getBody();
		Map map = new HashMap();
		String refundStr = (String) params.get("refund");
		
        try {
        	Dorder order = dorderService.queryById(Long.valueOf(params.get("orderId").toString()));
        	Drefund refund = refundService.queryDetailByOrderId(Integer.valueOf(params.get("orderId").toString()));
        	if("refuse".equals(refundStr)){
        		order.setOrderState(2);//未消费
        		dorderService.update(order);
        		
        		refund.setStatus("unhande");
        		refundService.update(refund);
        	}else{
        		Date refundTime = new Date();
        		Dmember member = memberService.queryById(order.getMemberId());
        		Long refundValue = Long.valueOf(params.get("refundValue").toString());
        		order.setOrderState(8);//已退款
        		order.setRefundAmount(refundValue);
        		order.setRefundTime(refundTime);
        		dorderService.update(order);
        		
        		member.setSavingsAmount(member.getSavingsAmount() + refundValue);//退款至用户账户
        		memberService.update(member);
        		
        		refund.setStatus("handled");
        		refund.setUpdateTime(refundTime);
        		refundService.update(refund);
        	}
        	
			map.put("state", 1);
			map.put("message", "保存成功");
        	responseContent = ResponseHandler.makeResponse(map, true);
		} catch (Exception e) {
			loger.info("退款申请失败", e);
			map.put("state", -1);
			map.put("message", "保存成功");
		}
		return JSONObject.toJSONString(responseContent);
	}
	
	@ResponseBody
	@RequestMapping("/updateRemark.htm")
	public String updateRemark(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
		Map params = requestContent.getBody();
		Map map = new HashMap();
		
        try {
        	Drefund refund = refundService.queryDetailByOrderId(Integer.valueOf(params.get("orderId").toString()));
        	refund.setRemark(params.get("remark").toString());
        	refundService.update(refund);
        	
			map.put("state", 1);
			map.put("message", "保存成功");
        	responseContent = ResponseHandler.makeResponse(map, true);
		} catch (Exception e) {
			loger.info("退款申请失败", e);
			map.put("state", -1);
			map.put("message", "保存成功");
		}
		return JSONObject.toJSONString(responseContent);
	}
}
