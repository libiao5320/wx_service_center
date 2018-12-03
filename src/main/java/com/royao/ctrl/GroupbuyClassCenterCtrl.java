package com.royao.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dgoods;
import com.royao.model.DgroupbuyClass;
import com.royao.model.DwxBanner;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DgroupbuyClassService;
import com.royao.util.JsonUtil;

/**
 * 
 * ClassName: GroupbuyClassCtrl 
 * @Description: 分类信息
 * @author Liu Pinghui
 * @date 2016年1月8日
 */
@Controller
@RequestMapping("/groupbuy")
public class GroupbuyClassCenterCtrl {
	
	@Autowired
	private DgroupbuyClassService groupbuyClassService;
	
	/**
	 * 
	 * @Description: 获取所有的分类信息，包括子类信息
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月8日
	 */
	@ResponseBody
	@RequestMapping("list.htm")
	public String goodClass(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        PageObject pageObject = new PageObject();
        Map params = requestContent.getBody();
        try {
        	DgroupbuyClass groupbuy = JSON.parseObject(JsonUtil.map2json(params), DgroupbuyClass.class);
            if (null != requestContent.getBody()) {
            	if(null != requestContent.getBody().get("pageNo")){
					//是否存在分页信息
            		pageObject.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
					groupbuy.setPageInfo(pageObject);
				}
            	//是否带参
            	/*******可以通过多次判断添加从前台带过来的条件*******/
            	if(StringUtils.isNotEmpty(requestContent.getBody().get("id"))){
            		groupbuy.setClassId(Long.parseLong(requestContent.getBody().get("id")));
            	}
            	if(StringUtils.isNotEmpty(requestContent.getBody().get("parentId"))){
            		groupbuy.setClassParentId(Long.parseLong(requestContent.getBody().get("parentId")));
            	}
            }
            
            List<DgroupbuyClass> list = this.groupbuyClassService.findAll(groupbuy);
            responseContent = ResponseHandler.makeResponse(list, true);
            return JSONObject.toJSONString(responseContent);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return null;
	}
	/**
	 * 查询用户常用的产品分类
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryMostClass.htm")
	public String queryMostClass(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            	//是否带参
            	/*******可以通过多次判断添加从前台带过来的条件*******/
            	List queryMostClassMap = this.groupbuyClassService.queryMostClass(Long.parseLong(requestContent.getBody().get("memberId")));
	            responseContent = ResponseHandler.makeResponse(queryMostClassMap, true);
	            return JSONObject.toJSONString(responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}
}
