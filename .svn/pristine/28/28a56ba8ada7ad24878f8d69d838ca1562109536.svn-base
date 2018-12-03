package com.royao.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.DbalanceLogs;
import com.royao.model.Dmember;
import com.royao.services.inface.DbalanceLogsService;
import com.royao.services.inface.DmemberService;
import com.royao.util.DateUtil;


@Controller
@RequestMapping("/wxpay")
public class WxPayCtrl {

	
		@Autowired
		private DmemberService memberService;
		
		@Autowired
		private DbalanceLogsService logsService;
		
		
		/**
		 * 根据商户订单号查询充值消费记录数据
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/refer.htm")
		public String refer(HttpServletRequest request,HttpServletResponse response){
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			ResponseContent responseContent = new ResponseContent();
	        RequestContent requestContent = RequestHandler.execute(request);
	        Map<?,?> params = requestContent.getBody();
	        
	        response.setCharacterEncoding("utf-8");
	        
	        if(null != params){
	        	String sn = params.get("sn").toString();
	        	try {
					DbalanceLogs logs = this.logsService.querySn(sn);
					map.put("money", logs.getAmount());
					map.put("state", logs.getState());
					Dmember member = this.memberService.queryById(logs.getMemberId());
					map.put("openid", member.getWxTokenId());
					
					responseContent = ResponseHandler.makeResponse(map, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	        return JSONObject.toJSONString(responseContent);
		}
		
		
		@ResponseBody
		@RequestMapping("/wx_update.htm")
		public String wx_update(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object> map = new HashMap<String, Object>();
			
			ResponseContent responseContent = new ResponseContent();
	        RequestContent requestContent = RequestHandler.execute(request);
	        Map<?,?> params = requestContent.getBody();
	        
	        response.setCharacterEncoding("utf-8");
	        
	        String state = "N";
	        
	        if(null != params){
	        	String sn = params.get("sn").toString();
	        	String wxpay_no = params.get("wxpay_no").toString();
	        	try {
					DbalanceLogs logs = this.logsService.querySn(sn);
					
					if(null != logs){
						Dmember user = this.memberService.queryById(logs.getMemberId());
						if(null != user){
							long money = user.getAvailablePredeposit();
							long moneya = user.getSavingsAmount()== null?0:user.getSavingsAmount();
							user.setAvailablePredeposit(money+logs.getAmount());
							user.setVipRankId(logs.getGreade());
							user.setSavingsAmount(moneya+logs.getAmount());
							logs.setState(2);
							logs.setTradeNo(wxpay_no);
							logs.setAddTime(DateUtil.current());
							this.logsService.update(logs);
							this.memberService.update(user);
							state = "Y";
						}
					}
					map.put("state", state);
					responseContent = ResponseHandler.makeResponse(map, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	        
	        return JSONObject.toJSONString(responseContent);
		}
}
