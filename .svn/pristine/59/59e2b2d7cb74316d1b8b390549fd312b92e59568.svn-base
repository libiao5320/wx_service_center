package com.royao.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royao.services.inface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.yiwang.commons.utils.Validate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.royao.commons.enums.KitingStatus;
import com.royao.commons.enums.LogsMethod;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.DbalanceLogs;
import com.royao.model.Dkiting;
import com.royao.model.Dmember;
import com.royao.model.DsystemSet;
import com.royao.model.base.PageObject;
import com.royao.util.DateUtil;
import com.royao.util.JsonUtil;
import com.royao.util.MoneyUtil;


@Controller
@RequestMapping("/kiting")
public class KitingCtrl {
	
	
		@Autowired
		private DkitingService kitingService;
		
		@Autowired
		private DmemberService memberService;
		
		@Autowired
		private DsystemSetService systemSetService;
		
		@Autowired
		private DbalanceLogsService logsService;


		@Autowired
		private DorderService dorderService;
		
		/**
		 * 判断用户是否可以提现
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/judge.htm")
		public String index(HttpServletRequest request, HttpServletResponse response){
			Map<String,Object> maps = new HashMap<String, Object>();
			ResponseContent responseContent = new ResponseContent();
            RequestContent requestContent = RequestHandler.execute(request);
            Map<?, ?> params = requestContent.getBody();
            
            response.setCharacterEncoding("utf-8");
            
            String status = "N";
            if(null != params && params.size()>0){
            	String wxCode = params.get("wxCode").toString();
            	params.clear();
            	try {
					Dmember  user = this.memberService.queryByWxCode(wxCode);
					long money = user.getAvailablePredeposit();
					DsystemSet set = this.systemSetService.queryByKey("account_tx_value");
					long goal_money = 0l;
					if(null != set){
						if(!Validate.isEmpty(set.getSvalue())){
							goal_money = Long.parseLong(set.getSvalue());
						}
					}
					if(money > 0 && money <= goal_money){
						maps.put("money",money);
						status = "Y";
					}
					maps.put("status", status);
					responseContent = ResponseHandler.makeResponse(maps, true);
				}catch (Exception e) {
					e.printStackTrace();
				}
            }
            return JSONObject.toJSONString(responseContent);
		}
		
		
		/***
		 * 提现
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/save_kiting.htm")
		public String save_kiting(HttpServletRequest request, HttpServletResponse response){
			Map<String,Object> maps = new HashMap<String, Object>();
			ResponseContent responseContent = new ResponseContent();
            RequestContent requestContent = RequestHandler.execute(request);
            Map<?, ?> params = requestContent.getBody();
            
            response.setCharacterEncoding("utf-8");
            String status = "N",msg="";
            if(null != params && params.size() > 0){
            	Dkiting kiting = new Dkiting();
            	String wxCode = params.get("wxCode").toString();
            	Long money = MoneyUtil.getDollarToCent(params.get("money").toString());
            	
				try {
					Dmember user = this.memberService.queryByWxCode(wxCode);
					long _money = user.getAvailablePredeposit();
	            	
	            	kiting.setMemberId(user.getMemberId());
	            	kiting.setMoney(money);
	            	kiting.setBeforeMoney(_money);
	            	kiting.setAfterMoney(_money-money);
	            	kiting.setStatus(KitingStatus.AUDIT);
	            	kiting.setCreatedTime(DateUtil.current());
	            	kiting.setName(user.getMemberName());
	            	kiting.setPhone(user.getMemberMobile());
	            	try {
						this.kitingService.save(kiting);
						user.setAvailablePredeposit(_money-money);
		            	try {
							this.memberService.update(user);
							DbalanceLogs logs = new DbalanceLogs();
							logs.setMemberId(user.getMemberId());
							logs.setSn(kiting.getId()+"");
							logs.setAmount(kiting.getMoney());
							logs.setBalance(_money);
							logs.setExplain("余额提现");
							logs.setMethod(LogsMethod.KITING);
							logs.setState(1);
							logs.setCurrentBalance(user.getAvailablePredeposit());
							logs.setAddTime(DateUtil.current());
							logs.setAddBy(user.getMemberName());
							logs.setGreade(user.getVipRankId());
							try {
								this.logsService.save(logs);
								status = "Y";
							} catch (Exception e) {
								msg="插入用户流水失败！";
								e.printStackTrace();
							}
						} catch (Exception e) {
							msg="修改用户余额出现错误！";
							e.printStackTrace();
						}
					} catch (Exception e) {
						msg = "提现记录插入报错！";
						e.printStackTrace();
					}
				}catch (Exception e) {
					msg ="查询用户报错！";
					e.printStackTrace();
				}
            }
            maps.put("status", status);
            maps.put("msg", msg);
            
            try {
				responseContent = ResponseHandler.makeResponse(maps, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
            return JSONObject.toJSONString(responseContent);
		}
		
		/**
		 * 根据用户id查询用户余额处理记录，每页10条
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/kiting_record.htm")
		public Object record(HttpServletRequest request,HttpServletResponse response){
			
			ResponseContent responseContent = new ResponseContent();
            RequestContent requestContent = RequestHandler.execute(request);
            Map<?, ?> params = requestContent.getBody();
            
            if(null != params && params.size()>0){
            	String page = params.get("page").toString();
            	params.remove("page");
            	String wxCode = params.get("wxCode").toString();
            	try {
					Dmember user = this.memberService.queryByWxCode(wxCode);
					params.remove("wxCode");

	            	Dkiting kiting = JSON.parseObject(JsonUtil.map2json(params),Dkiting.class);
	            	kiting.setMemberId(user.getMemberId());
	            	PageObject pageInfo = new PageObject();
	            	pageInfo.setPageNo(Integer.parseInt(page));
	            	pageInfo.setPageSize(10);
	            	kiting.setPageInfo(pageInfo);
	            	try {
						List<Dkiting> kit = this.kitingService.listWithPage(kiting);
						if (kit != null && kit.size() > 0) {
							responseContent = ResponseHandler.makeResponse(JSONObject.parseArray(JSONArray.toJSONString(kit)), true);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
            
            return JSONObject.toJSONString(responseContent);
		}



}
