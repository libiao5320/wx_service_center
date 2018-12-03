package com.royao.pctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.royao.model.Devent;
import com.royao.model.DgroupbuyClass;
import com.royao.model.Dmember;
import com.royao.model.DmemberRemark;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DgroupbuyClassService;
import com.royao.util.JsonUtil;
/**
 * 产品分类信息
 * @author oubinbin
 *
 */
@Controller
@RequestMapping("/PGroupbuyClassCenterCtrl")
public class PGroupbuyClassCenterCtrl {
	Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DgroupbuyClassService groupbuyClassService;

	/**
	 * 
	 * @Description: 产品分类设置获取所有的分类信息
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author oubinbin
	 * @date 2016年1月22日
	 */
	@ResponseBody
	@RequestMapping("/queryAllGoodsClass.htm")
	public String queryAllGoodsClass(HttpServletRequest request, HttpServletResponse response){
		
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
					
				}else{
					pageObject.setPageNo(1);
				}
            	
            	groupbuy.setPageInfo(pageObject);
            }
//        	params.put("begin",pageObject.getBegin());
//			params.put("end",pageObject.getEnd());

            @SuppressWarnings("rawtypes")
			List  list = this.groupbuyClassService.queryAllGoodsClass(groupbuy);
            Integer total = this.groupbuyClassService.queryAllGoodsClassCount(groupbuy);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", list);
            returnMap.put("total", total);
            
            responseContent = ResponseHandler.makeResponse(returnMap, true);
            return JSONObject.toJSONString(responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping("/saveGoodsClass.htm")
	public String saveGoodsClass(HttpServletRequest request, HttpServletResponse response){
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");

        DgroupbuyClass groupbuy = JSON.parseObject(JsonUtil.map2json(params), DgroupbuyClass.class);
//        paramEvent.setAreaid1((long) 18);
//        paramEvent.setAreaid2((long) 275);
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            long count = this.groupbuyClassService.save(groupbuy);
            if(count > 0){
            	returnMap.put("state", 1);
            }else{
            	returnMap.put("state", -1);
            	returnMap.put("message", "添加产品类别信息失败！");
            }
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("添加产品类别信息失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
	/**
	 * 从查询页获取数据到添加二级分类页
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryFristClass.htm")
    public String queryFristClass(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
            	List<DgroupbuyClass> firstClass = groupbuyClassService.queryGoodClassOne();
                Map<String,Object> returnMap = new HashMap<String, Object>();
                returnMap.put("firstClass", firstClass);
            	if (firstClass != null) {
                    responseContent = ResponseHandler.makeResponse(returnMap, true);
                } 
            }
            
        } catch (Exception e) {
        	logger.info("产品类别信息获取失败", e);
        }
        return JSONObject.toJSONString(responseContent);
    }
	/**
	 * 从查询页获取数据到修改页
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryGoodsClassById.htm")
    public String detail(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
            	DgroupbuyClass dgroupbuyClass = this.groupbuyClassService.queryById(Long.parseLong(requestContent.getBody().get("id").toString()));
            	List<DgroupbuyClass> firstClass = groupbuyClassService.queryGoodClassOne();
            	Long parentId=dgroupbuyClass.getClassParentId();
            	DgroupbuyClass groupbuyClass =groupbuyClassService.queryById(parentId);//修改时查该条的父级目录
                Map<String,Object> returnMap = new HashMap<String, Object>();
                returnMap.put("dgroupbuyClass", dgroupbuyClass);
                returnMap.put("firstClass", firstClass);
                returnMap.put("groupbuyClass", groupbuyClass);
            	if (dgroupbuyClass != null) {
                    responseContent = ResponseHandler.makeResponse(returnMap, true);
                } 
            }
            
        } catch (Exception e) {
        	logger.info("产品类别信息获取失败", e);
        }
        return JSONObject.toJSONString(responseContent);
    }
	/**
	 *  修改产品类别信息
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/updateGoodsClass.htm")
    public String updateGoodsClass(HttpServletRequest request, HttpServletResponse response){
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");

        DgroupbuyClass dgroupbuyClass = JSON.parseObject(JsonUtil.map2json(params), DgroupbuyClass.class);
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            long count = this.groupbuyClassService.update(dgroupbuyClass);
           
            if(count > 0){
            	returnMap.put("state", 1);
            }else{
            	returnMap.put("state", -1);
            	returnMap.put("message", "更新产品类别信息失败！");
            }
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("更新产品类别信息失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
	/**
	 * 删除产品类别
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteGoodsClass.htm")
	public String deleteGoodsClass(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			boolean status = false;
			if (null != requestContent.getBody()) {
				
				Integer isStatus = this.groupbuyClassService.delete(Long.parseLong(requestContent.getBody().get("id")));
				
				if(isStatus == 1){
					status = true;
				}else{
					status = false;
				}
				responseContent = ResponseHandler.makeResponse(status, true);
			}
			
		} catch (Exception e) {
			logger.info("删除失败", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
}
