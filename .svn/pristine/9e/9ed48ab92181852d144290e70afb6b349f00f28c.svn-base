package com.royao.pctrl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.royao.model.DbalanceLogs;
import com.royao.model.Devaluate;
import com.royao.model.Dmember;
import com.royao.model.Dorder;
import com.royao.model.DredpacketsDistribute;
import com.royao.model.Order;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DbalanceLogsService;
import com.royao.services.inface.DevaluateService;
import com.royao.services.inface.DmemberService;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DredpacketsDistributeService;
import com.royao.util.JsonUtil;


@Controller
@RequestMapping("/pc_order")
public class PcOrderCtrl {
	
	@Autowired
	private DorderService dorderService;
	
	@Autowired
	private DevaluateService evaluateService;
	
	@Autowired
	private DmemberService userService;
	
	@Autowired
	private DbalanceLogsService logsService;
	
	@Autowired
	private DredpacketsDistributeService disService;
	
	/**
	 * p端订单管理
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/p_list.htm")
	public String p_list(HttpServletRequest request ,HttpServletResponse response){
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
		Order or = JSON.parseObject(JsonUtil.map2json(params), Order.class);
		or.setPageInfo(p);
		try {
			List<Dorder> ors = this.dorderService.queryAllOrderBy(or);
			result.put("rows", ors);
			Long total = this.dorderService.queryAllOrderByCount(or);
			result.put("total", total);
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
	 * 订单
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request ,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		Map<String,Object>  result = new HashMap<String, Object>();
		
		Map<?,?> params = requestContent.getBody();
		if(null != params && params.size() > 0){
			String id = params.get("id").toString();
			try {
				Dorder dod = this.dorderService.queryById(Long.parseLong(id));
				result.put("order", dod);
				if(null != dod.getRcbId()){
					DredpacketsDistribute  dis = this.disService.queryById(dod.getRcbId());
					result.put("dis", dis);
				}
				Dmember user = this.userService.queryById(dod.getMemberId());
				result.put("user", user);
				responseContent = ResponseHandler.makeResponse(result, true);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return JSONObject.toJSONString(responseContent);
	}
	
	
	/**
	 * 订单评价列表
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/evaluate.htm")
	public String evaluate(HttpServletRequest request ,HttpServletResponse response){
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
		Order or = JSON.parseObject(JsonUtil.map2json(params), Order.class);
		or.setPageInfo(p);
		
		try {
			List<Devaluate>  list = this.evaluateService.query(or);
			List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
			for (Devaluate ate : list) {
				Map<String,Object> map = new HashMap<String, Object>();
				if(null != ate.getOrder() && null != ate.getMember()){
					map.put("id", ate.getId());
					map.put("orderSn",ate.getOrder().getOrderSn());
					map.put("goodsName", ate.getOrder().getGoodsName());
					map.put("userName",ate.getMember().getMemberName());
					map.put("storeName",ate.getOrder().getStoreName());
					map.put("time", ate.getCreateTime());
					map.put("grade",ate.getGrade());
					map.put("text", ate.getDetail());
					map.put("isShow", ate.getIsShow());
					rs.add(map);
				}
			}
			Long total = this.evaluateService.queryCount(or);
			result.put("rows", rs);
			result.put("total", total);
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
	 * 评价拒绝
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateShow.htm")
	public String updateShow(HttpServletRequest request ,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);

		Map<String,Object>  result = new HashMap<String, Object>();
		
		Map<?,?> params = requestContent.getBody();
		
		String returnMsg="PARAMS_IS_NULL";
		
		if(null != params){
			try {
				Devaluate  evaluate = this.evaluateService.queryById(Long.parseLong(params.get("id").toString()));
				evaluate.setIsShow(params.get("show").toString());
				try {
					this.evaluateService.update(evaluate);
					returnMsg = "SUCCESS";
				} catch (Exception e) {
					e.printStackTrace();
					returnMsg = "UPDATE_EVALUATE_FAIL";
				}
			} catch (Exception e) {
				e.printStackTrace();
				returnMsg="QUERY_EVALUATE_FAIL";
			}
		}
		result.put("returnMsg", returnMsg);
		
		try {
			responseContent = ResponseHandler.makeResponse(result, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 顾客储值管理
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/savings.htm")
	public String savings(HttpServletRequest request ,HttpServletResponse response){
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
		Order or = JSON.parseObject(JsonUtil.map2json(params), Order.class);
		or.setPageInfo(p);
		
		try {
			List<Dmember> user = this.userService.queryBySaveings(or);
			Long total = this.userService.queryBySaveingsCount(or);
			result.put("rows", user);
			result.put("total", total);
			responseContent = ResponseHandler.makeResponse(result, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(responseContent);
	}
	
	
	/**
	 * 顾客储值明细
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/savings/detail.htm")
	public String savingsdetail(HttpServletRequest request ,HttpServletResponse response){
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
		Order or = JSON.parseObject(JsonUtil.map2json(params), Order.class);
		or.setPageInfo(p);
		
		try {
			List<DbalanceLogs> logs = this.logsService.queryLogs(or);
			Long total = this.logsService.queryLogsCount(or);
			result.put("rows", logs);
			result.put("total", total);
			responseContent = ResponseHandler.makeResponse(result, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(responseContent);
	}
	
	
	@ResponseBody
	@RequestMapping("/user.htm")
	public String user(HttpServletRequest request ,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);

		Map<String,Object>  result = new HashMap<String, Object>();
		
		Map<?,?> params = requestContent.getBody();
		String returnMsg = "PARAMS_IS_NULL";
		Dmember user = null;
		if(null != params && params.size() > 0){
			
			Long id = Long.parseLong(params.get("id").toString());
			
			try {
				user = this.userService.queryById(id);
				returnMsg = "SUCCESS";
			} catch (Exception e) {
				e.printStackTrace();
				returnMsg ="QUERY_USER_FAIL";
			}
		}
		result.put("returnMsg", returnMsg);
		result.put("user", user);
		
		try {
			responseContent = ResponseHandler.makeResponse(result, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(responseContent);
	}
	
	/***
	 * 修改订单数据
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update_order.htm")
	public String updateOrder(HttpServletRequest request ,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);

		Map<String,Object>  result = new HashMap<String, Object>();
		
		Map<?,?> params = requestContent.getBody();
		
		String returnMsg = "PARAMS_IS_NULL";
		
		if(null != params && params.size() > 0){
			Long id = Long.parseLong(params.get("id").toString());
			try {
				Dorder  or = this.dorderService.queryById(id);
				String remark = params.get("remark").toString();
				or.setRemark(remark);
				try {
					this.dorderService.update(or);
					returnMsg = "SUCCESS";
				} catch (Exception e) {
					returnMsg = "UPDATE_ORDER_FAIL";
					e.printStackTrace();
				}
			} catch (Exception e) {
				returnMsg = "QUERY_ORDER_FAIL";
				e.printStackTrace();
			}
		}
		result.put("returnMsg", returnMsg);
		try {
			responseContent = ResponseHandler.makeResponse(result, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(responseContent);
	}
}
