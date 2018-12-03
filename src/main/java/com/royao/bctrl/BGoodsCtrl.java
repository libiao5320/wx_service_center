package com.royao.bctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.royao.commons.enums.YN;
import com.royao.http.*;
import com.royao.model.*;
import com.royao.services.inface.*;
import com.royao.util.ApiException;
import com.royao.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.model.base.PageObject;
import com.royao.util.JsonUtil;

/**
 * B端 产品数据API请求接口
 * @author 刘理
 * @Description
 * @date 2016年2月22日
 */
@Controller
@RequestMapping("/b/goods")
public class BGoodsCtrl {
	private Logger loger  = Logger.getLogger(this.getClass());
	@Autowired
	private  DgoodsService dgoodsService;	
	
	@Autowired
	private DredpacketsService redpacketsService;
	
	@Autowired
	private DtechieService techieService;
	
	@Autowired
	private DgoodsSetService dgoodsSetService;
	
	@Autowired
	private DredpacketsDistributeService redpacketsDistributeService;

	@Autowired
	private DareaService dareaService ;
	@Autowired
	private DgroupbuyClassService  dgroupbuyClassService;

	@Autowired
	private DstoreService dstoreService;

	@Autowired
	private DstoreExtendService dstoreExtendService;
	
	
	@ResponseBody
    @RequestMapping("/listQuery.htm")
    public String listQuery(HttpServletRequest request, HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        try {
        	Map params = requestContent.getBody();
        	PageObject pageInfo = new PageObject();
            response.setCharacterEncoding("utf-8");
        	if(null != requestContent.getBody()){
        		if(null == params.get("pageNo") ){
        			pageInfo.setPageNo(1);
        		}else{
        			pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
        		}
        		
        		if(null != requestContent.getBody().get("goodsState")){
    				params.put("goodsState",Integer.parseInt(requestContent.getBody().get("goodsState")));
    			}
            	if(null != requestContent.getBody().get("goodsName")){
    				params.put("goodsName",requestContent.getBody().get("goodsName"));
    			}
        	}
        	params.put("storeId",requestContent.getBody().get("storeId"));
        	params.put("begin",pageInfo.getBegin());
			params.put("end",pageInfo.getEnd());
			
			List<Map> goodList= this.dgoodsService.queryByStoreAnd(params);
			
			List<Map> resultList = new ArrayList<Map>();
			for(int i=0;i<goodList.size();i++){
				Map m = new HashMap<String, Object>();
				Map dgood = goodList.get(i);
				m.put("产品名称", dgood.get("goods_name"));
				m.put("协议价格", dgood.get("goods_price"));
				if(dgood.get("begin_time") != null && !String.valueOf(dgood.get("begin_time")).equals("")){
					m.put("上架时间", dgood.get("begin_time"));
				}else{
					m.put("上架时间", "");
				}
				if(dgood.get("end_time") != null && !String.valueOf(dgood.get("end_time")).equals("")){
					m.put("下架时间", dgood.get("end_time"));
				}else{
					m.put("下架时间", "");
				}
				if("1".equals(String.valueOf(dgood.get("goods_state")))){
					m.put("状态", "已下架");
				}else if("2".equals(String.valueOf(dgood.get("goods_state")))){
					m.put("状态", "已上架");
				}else{
					m.put("状态", "库存");
				}
				if(dgood.get("goods_salenum") != null && !String.valueOf(dgood.get("goods_salenum")).equals("")){
					m.put("购买", dgood.get("goods_salenum"));
				}else{
					m.put("购买", 0);
				}
				m.put("验证", dgood.get("orderCount"));
				m.put("平均评价", dgood.get("goodCount"));
				if(dgood.get("goods_storage") != null && !String.valueOf(dgood.get("goods_storage")).equals("")){
					m.put("库存", dgood.get("goods_storage"));
				}else{
					m.put("库存", "无限");
				}
				
				dgood.put("goodsDetail", m);
				resultList.add(dgood);
			}
            
            int total = this.dgoodsService.countByStoreAnd(params);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", goodList);
            returnMap.put("total", total);
            
            if (goodList != null && goodList.size() > 0) {
            	responseContent = ResponseHandler.makeResponse(returnMap,true);
            } 
        } catch (Exception e) {
        	loger.info("ajax请求活动列表失败", e);
        }
        return JSONObject.toJSONString(responseContent);
    }

}
