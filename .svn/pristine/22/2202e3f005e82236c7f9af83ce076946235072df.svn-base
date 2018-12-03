package com.royao.pctrl;

import java.text.SimpleDateFormat;
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
import com.royao.model.DrechargeCard;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DrechargeCardService;
import com.royao.util.KeyBuilder;


/**
 * 充值卡
 * @author L
 *
 */
@Controller
@RequestMapping("/rechargeCard")
public class PRechargeCardCtrl {
	private Logger loger  = Logger.getLogger(this.getClass());
	
	@Autowired
	private DrechargeCardService rechargeCardService;
	
	/**
	 *充值卡列表
	 */
	@ResponseBody
	@RequestMapping("/index.htm")
	public String index(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        PageObject pageInfo = new PageObject();
        Map params = requestContent.getBody();
        if(params.get("pageNo") != null){
        	pageInfo.setPageNo(Integer.valueOf("" + params.get("pageNo")));
        	pageInfo.setPageSize(Integer.valueOf("" + params.get("pageSize")));
        }else{
        	pageInfo.setPageNo(1);
        	pageInfo.setPageSize(Integer.valueOf("" + params.get("pageSize")));
        }
        params.put("pageInfo", pageInfo);
        
        if(params.get("typeValue") != null){
        	params.put(params.get("typeName"), params.get("typeValue"));
        }
        if(params.get("begin") !=null || params.get("end") != null){
    		params.put(params.get("timeName"), "exist");
        }

        try {
			List<DrechargeCard> rechargeCards = rechargeCardService.listWithPageAndCondition(params);
			
			int total = rechargeCardService.countWithCondition(params);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", rechargeCards);
            returnMap.put("total", total);
	            
			
			if(rechargeCards != null && rechargeCards.size() > 0){
				responseContent = ResponseHandler.makeResponse(returnMap, true);
			}
		} catch (Exception e) {
			loger.info("ajax请求充值卡列表失败", e);
		}
        
		return JSON.toJSONString(responseContent,SerializerFeature.DisableCircularReferenceDetect);
	}
	

	/**
	 *  获取充值卡的卡号
	 */
	public String getRechargeSn() {
		
		String rechargeSn = "";
		int count = 0;
		do{
			rechargeSn = KeyBuilder.createUidNew16();
			count = rechargeCardService.getCountByRechargeSn(rechargeSn);
		}while(count != 0);
		
		return rechargeSn;
	}

	/**
	 *  注销充值卡
	 */
	@ResponseBody
	@RequestMapping("/delete.htm")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		Map params = requestContent.getBody();
		params.put("status", "D");
		Map map = new HashMap();
		
		try {
			int count  = rechargeCardService.updateStatus(params);
			
			if(count > 0){
				map.put("state", 1);
				map.put("message", "注销成功");
			}else{
				map.put("state", -1);
				map.put("message", "注销失败");
			}
			
			responseContent = ResponseHandler.makeResponse(map, true);
			
		} catch (Exception e) {
			loger.info("注销失败", e);
			map.put("state", -1);
			map.put("message", "注销失败");
		}
		
		return JSON.toJSONString(responseContent,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 *生成充值卡
	 */
	@ResponseBody
	@RequestMapping("/create.htm")
	public String create(HttpServletRequest request,HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        PageObject pageInfo = new PageObject();
        Map params = requestContent.getBody();
        int num = Integer.valueOf(params.get("num").toString());//充值卡数量
        String sum = params.get("sum").toString();//充值卡金额
        Date createTime = new Date();
        Map map = new HashMap();
        
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Date deadline = sdf.parse(params.get("deadline").toString());
        	int count = 0;
			for(int i=0; i<num; i++){
				DrechargeCard rechargeCard = new DrechargeCard();
				String rechargeSn = getRechargeSn();
				rechargeCard.setRechargeSn(rechargeSn);
				rechargeCard.setCreateBy("曾建飞" + i);
				rechargeCard.setCreateTime(createTime);
				rechargeCard.setMoneyDollar(sum);
				rechargeCard.setStatus("N");
				rechargeCard.setDeadline(deadline);
				
				count += rechargeCardService.save(rechargeCard);
			}
			if(count == num){
				map.put("state", 1);
				map.put("message", "生成充值卡成功");
			}else{
				map.put("state", -1);
				map.put("message", "生成充值卡失败");
			}
			
			responseContent = ResponseHandler.makeResponse(map, true);
		} catch (Exception e) {
			loger.info("生成充值卡失败", e);
			map.put("state", -1);
			map.put("message", "生成充值卡失败");
		}
		return JSON.toJSONString(responseContent,SerializerFeature.DisableCircularReferenceDetect);
	}
}
