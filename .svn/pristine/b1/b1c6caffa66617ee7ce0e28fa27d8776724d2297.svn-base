package com.royao.pctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.yiwang.commons.utils.DateUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dreward;
import com.royao.model.Dtechie;
import com.royao.model.Order;
import com.royao.model.TechieClearing;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DrewardService;
import com.royao.services.inface.DtechieService;
import com.royao.services.inface.TechieClearingService;
import com.royao.util.JsonUtil;


@Controller
@RequestMapping("/techie")
public class DtchieCtrl {

	
		@Autowired
		private DtechieService tService;
		
		@Autowired
		private DrewardService rewardService;
		
		@Autowired
		private TechieClearingService clearingService;
		
		/***
		 * 
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/index.htm")
		public String index(HttpServletRequest request,HttpServletResponse response){
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
				List<Dtechie> row = this.tService.queryReward(or);
				result.put("rows", row);
				Long total = this.tService.queryRewardCount(or);
				
				result.put("total", total);
				
				responseContent = ResponseHandler.makeResponse(result, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return JSONObject.toJSONString(responseContent);
		}
		
		/**
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getById.htm")
		public String getById(HttpServletRequest request,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<?,?> params = requestContent.getBody();
			if(null != params){
				String id = params.get("id").toString();
				try {
					Dtechie  techie = this.tService.queryById(Long.parseLong(id));
					
					responseContent = ResponseHandler.makeResponse(techie, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return JSONObject.toJSONString(responseContent);
		}
		
		
		/**
		 * 
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/reward.htm")
		public String reward(HttpServletRequest request,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);
			Map<String,Object>  result = new HashMap<String, Object>();
			Map<?,?> params = requestContent.getBody();
			
			int page = Integer.parseInt(params.get("offset").toString());
			int size = 10;
			if(null != params.get("limit")){
				size = Integer.parseInt(params.get("limit").toString());
			}
			PageObject p = new PageObject();
			p.setPageNo(page);
			p.setPageSize(size);
			Dreward or = JSON.parseObject(JsonUtil.map2json(params), Dreward.class);
			or.setPageInfo(p);
			try {
				List<Dreward> row = this.rewardService.queryAll(or);
				result.put("rows", row);
				Long total = this.rewardService.queryAllByCount(or);
				result.put("total", total);
				
				responseContent = ResponseHandler.makeResponse(result, true);
			}catch(Exception e){
				e.printStackTrace();
			}
			return JSONObject.toJSONString(responseContent);
		}
		
		/**
		 * 结算
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/clearing.htm")
		public String clearing(HttpServletRequest request,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);
			Map<String,Object>  result = new HashMap<String, Object>();
			Map<?,?> params = requestContent.getBody();
			String msg="FAIL";
			if(null != params){
				Long id = Long.parseLong(params.get("id").toString());
				try {
					/**根据id查询健康师主表的数据*/
					Dtechie  techie = this.tService.queryById(id);
					long yjs = techie.getYjsAmount();
					long wjs = techie.getWjsAmount();
					
					/**向私人健康师结算清单表插入一条数据*/
					TechieClearing  clearing = new TechieClearing();
					clearing.setTechieId(techie.getTechieId());
					clearing.setTechieName(techie.getTechieName());
					clearing.setMoney(techie.getWjsAmount());
					clearing.setCreatedTime(DateUtil.current());
					clearing.setClearingName("admin");
					this.clearingService.insert(clearing);
					
					/**更改健康师收益表中的数为已结算*/
					Dreward  reward = new Dreward();
					reward.setIsClearing(1);
					reward.setClearingName("admin");
					reward.setClearingTime(DateUtil.current());
					reward.setTechieId(techie.getTechieId());
					this.rewardService.update(reward);
					
					/**修改健康师主表中的已结算和未结算字段数据*/
					techie.setYjsAmount(yjs+wjs);
					techie.setWjsAmount(0l);
					this.tService.update(techie);
					msg = "SUCCESS";
					result.put("msg", msg);
					responseContent = ResponseHandler.makeResponse(result, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return JSONObject.toJSONString(responseContent);
		}
		
		/**
		 * 健康师结算清单列表
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/clearingIndex.htm")
		public String clearingIndex(HttpServletRequest request,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);
			Map<String,Object>  result = new HashMap<String, Object>();
			Map<?,?> params = requestContent.getBody();
			
			int page = Integer.parseInt(params.get("offset").toString());
			int size = 10;
			if(null != params.get("limit")){
				size = Integer.parseInt(params.get("limit").toString());
			}
			PageObject p = new PageObject();
			p.setPageNo(page);
			p.setPageSize(size);
			TechieClearing or = JSON.parseObject(JsonUtil.map2json(params), TechieClearing.class);
			or.setPageInfo(p);
			
			try {
				List<TechieClearing> row = this.clearingService.queryAll(or);
				result.put("rows", row);
				Long total = this.clearingService.queryAllByCount(or);
				result.put("total", total);
				
				responseContent = ResponseHandler.makeResponse(result, true);
			}catch(Exception e){
				e.printStackTrace();
			}
			return JSONObject.toJSONString(responseContent);
		}
}
