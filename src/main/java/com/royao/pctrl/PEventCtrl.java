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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Darea;
import com.royao.model.Devent;
import com.royao.model.DeventImage;
import com.royao.model.Dstore;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DeventImageService;
import com.royao.services.inface.DeventService;
import com.royao.services.inface.DstoreService;
import com.royao.util.JsonUtil;

@Controller
@RequestMapping("/p/event")
public class PEventCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
    @Autowired
    private DeventService eventService;
    
    @Autowired
    private DstoreService storeService;
    
    @Autowired
    private DeventImageService eventImgService;

    /**
     * @param @return
     * @return String
     * @throws
     * @Description:条件查询商家活动
     * @author Liu Li
     * @date 2016年1月21日
     */
    @ResponseBody
    @RequestMapping("/query.htm")
    public String query(HttpServletRequest request, HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();


        response.setCharacterEncoding("utf-8");

        Devent paramEvent = JSON.parseObject(JsonUtil.map2json(params), Devent.class);
        PageObject pageInfo = new PageObject();

        try {
        	
        	if(null != requestContent.getBody()){
        		if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
        			pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
        		}else{
        			pageInfo.setPageNo(1);
        		}
        		
        	}else{
        		pageInfo.setPageNo(1);
        	}
        	
        	paramEvent.setPageInfo(pageInfo);
            List<Devent> list = this.eventService.pListWithPageAndCondition(paramEvent);
            
            long total = this.eventService.pCountWithPageAndCondition(paramEvent);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", list);
            returnMap.put("total", total);
            
            if (list != null && list.size() > 0) {
                responseContent = ResponseHandler.makeResponse(returnMap, true);
            } 
        } catch (Exception e) {
            logger.info("ajax请求活动列表失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 通过id删除活动
     * @param request
     * @param response
     * @return
     * @author Liu Li
     * @date 2016年1月21日
     */
    @ResponseBody
    @RequestMapping("/deleteEventById.htm")
    public String deleteEventById(HttpServletRequest request, HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();


        response.setCharacterEncoding("utf-8");

        Devent paramEvent = JSON.parseObject(JsonUtil.map2json(params), Devent.class);
        
        long id = paramEvent.getId();

        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            long count = this.eventService.delete(id);
           
            if(count > 0){
            	returnMap.put("state", 1);
            }else{
            	returnMap.put("state", -1);
            	returnMap.put("message", "删除活动失败！");
            }
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("删除活动失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    
    /**
     * 
     * @Description: 获取活动详情
     * @param @param request
     * @param @param response
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Li
     * @date 2016年1月21日
     */
    @ResponseBody
    @RequestMapping("/detail.htm")
    public String detail(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
                Devent devent = this.eventService.queryById(Long.parseLong(requestContent.getBody().get("id").toString()));
                if (devent != null) {
                    responseContent = ResponseHandler.makeResponse(devent, true);
                } 
            }
            
        } catch (Exception e) {
        	logger.info("活动详情获取失败", e);
        }
        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 更新活动
     * @param request
     * @param response
     * @return
     * @author Liu Li
     * @date 2016年1月22日
     */
    @ResponseBody
    @RequestMapping("/updateEventById.htm")
    public String updateEventById(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");

        Devent paramEvent = JSON.parseObject(JsonUtil.map2json(params), Devent.class);
        paramEvent.setUpdateTime(new Date());
        paramEvent.setUpdateBy("刘理");
        
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            long count = this.eventService.update(paramEvent);
           
            if(count > 0){
            	returnMap.put("state", 1);

            	eventImgService.deleteByEventId(paramEvent.getId());
            	
            	String imgPaths = (String) params.get("imgPaths");
            	if(imgPaths != null && !"".equals(imgPaths)){
            		List<Map> imgList = (List<Map>) JSONArray.parse(imgPaths);
            		for(int i=0;i<imgList.size();i++){
            			Map img = imgList.get(i);
            			DeventImage eventImage = new DeventImage();
            			eventImage.setEventId(paramEvent.getId());
            			eventImage.setImgPath((String) img.get("imagePath"));
            			eventImage.setIsEnter("N");
            			eventImage.setCreateTime(new Date());
            			eventImgService.save(eventImage);
            		}
            	}
            }else{
            	returnMap.put("state", -1);
            	returnMap.put("message", "更新活动失败！");
            }
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("更新活动失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 添加活动
     * @param request
     * @param response
     * @return
     * @author Liu Li
     * @date 2016年1月22日
     */
    @ResponseBody
    @RequestMapping("/saveEvent.htm")
    public String insertEvent(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");

        Devent paramEvent = JSON.parseObject(JsonUtil.map2json(params), Devent.class);
        paramEvent.setAreaid1((long) 18);
        paramEvent.setAreaid2((long) 275);
        paramEvent.setExamineStatus("passing");
        paramEvent.setEventKey("减");
        paramEvent.setIsDiyText("N");
        paramEvent.setIsPtRed("Y");
        paramEvent.setCreateBy("刘理");
        paramEvent.setCreateTime(new Date());
        paramEvent.setUpdateBy("刘理");
        paramEvent.setUpdateTime(new Date());
        
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            long count = this.eventService.save(paramEvent);
           
            if(count > 0){
            	returnMap.put("state", 1);
            	String imgPaths = (String) params.get("imgPaths");
            	if(imgPaths != null && !"".equals(imgPaths)){
            		List<Map> imgList = (List<Map>) JSONArray.parse(imgPaths);
            		for(int i=0;i<imgList.size();i++){
            			Map img = imgList.get(i);
            			DeventImage eventImage = new DeventImage();
            			eventImage.setEventId(paramEvent.getId());
            			eventImage.setImgPath((String) img.get("imagePath"));
            			eventImage.setIsEnter("N");
            			eventImage.setCreateTime(new Date());
            			eventImgService.save(eventImage);
            		}
            	}
            	
            }else{
            	returnMap.put("state", -1);
            	returnMap.put("message", "添加活动失败！");
            }
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("添加活动失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 自动补全举办商家
     * @param request
     * @param response
     * @return
     * @author Liu Li
     * @date 2016年1月22日
     */
    @ResponseBody
    @RequestMapping("/getStoreListByName.htm")
    public String getStoreListByName(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");

        Dstore paramEvent = JSON.parseObject(JsonUtil.map2json(params), Dstore.class);
        
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            List<Object> list = this.storeService.getStoreListByName(paramEvent);
           
            returnMap.put("data", list);
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("获取商家失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 通过名字获取举办商家
     * @param request
     * @param response
     * @return
     * @author Liu Li
     * @date 2016年1月22日
     */
    @ResponseBody
    @RequestMapping("/getStoreByName.htm")
    public String getStoreByName(HttpServletRequest request, HttpServletResponse response) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");

        Dstore paramEvent = JSON.parseObject(JsonUtil.map2json(params), Dstore.class);
        
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
            List<Object> list = this.storeService.getStoreByName(paramEvent);
           
            returnMap.put("count", list.size());
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("获取商家失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
}
