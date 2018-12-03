package com.royao.pctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.royao.model.DgroupbuyClass;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DgroupbuyClassService;
import com.royao.util.JsonUtil;

/**
 * 产品分类
 * @author jk
 * @Description
 * @date 2016年1月25日
 */
@Controller
@RequestMapping("/p/class")
public class PGroupbuyClassCtrl {
	@Autowired
	private DgroupbuyClassService groupbuyClassService;
	
	@ResponseBody
	@RequestMapping("list.htm")
	public String queryGoodsClass(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        Map params = requestContent.getBody();
        try {
        	DgroupbuyClass groupbuy = JSON.parseObject(JsonUtil.map2json(params), DgroupbuyClass.class);
        	if (null != requestContent.getBody()) {
            	
            	if(StringUtils.isNotEmpty(requestContent.getBody().get("parentId"))){
            		groupbuy.setClassParentId(Long.parseLong(requestContent.getBody().get("parentId")));
            	}
            }
            
            List<DgroupbuyClass> list = this.groupbuyClassService.listGoodsClassBy(groupbuy);
            if(list!=null && list.size() > 0){
            	Map<String,Object> returnMap = new HashMap<String, Object>();
            	List<Map> pList = new ArrayList<Map>();
            	for(int i = 0; i < list.size() ; i ++ ){ 
            		if(list.get(i).getClassParentId() == 1){
            			List<Map> tList = new ArrayList<Map>();
            			for(int j = 0; j < list.size() ; j ++ ){
            				if(list.get(j).getClassParentId() == list.get(i).getClassId()){
            					Map<String,Object> tMap = new HashMap<String, Object>();
                    			tMap.put("n",list.get(j).getClassName());
                    			tMap.put("id",list.get(j).getClassId());
            					tList.add(tMap);
            				}
            			}
            			Map<String,Object> pMap = new HashMap<String, Object>();
            			pMap.put("p",list.get(i).getClassName());
            			pMap.put("id",list.get(i).getClassId());
            			pMap.put("c",tList);
            			pList.add(pMap);
            		}
            	}
            	returnMap.put("citylist",pList);
            	responseContent = ResponseHandler.makeResponse(returnMap, true);
            	return JSONObject.toJSONString(responseContent);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return null;
	}

}
