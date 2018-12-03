package com.royao.ctrl;

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
import com.royao.model.Devent;
import com.royao.model.DeventComment;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DeventCommentService;
import com.royao.services.inface.DeventService;
import com.royao.util.JsonUtil;

@Controller
@RequestMapping("/event")
public class EventCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
    @Autowired
    private DeventService eventService;
    
    @Autowired
    private DeventCommentService eventCommentService;

    /**
     * @param @return
     * @return String
     * @throws
     * @Description:查看所有商家活动
     * @author Liu Pinghui
     * @date 2016年1月4日
     */
    @ResponseBody
    @RequestMapping("/list.htm")
    public String index(HttpServletRequest request, HttpServletResponse response) {

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
            List<Devent> list = this.eventService.listWithPage(paramEvent);
            if (list != null && list.size() > 0) {
                responseContent = ResponseHandler.makeResponse(JSONArray.parseArray(JSONArray.toJSONString(list)), true);
            } 
        } catch (Exception e) {
            logger.info("ajax请求活动列表失败", e);
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
     * @author Liu Pinghui
     * @date 2016年1月13日
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
     * 
     * @Description: 获取活动所有评价
     * @param @param request
     * @param @param response
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月13日
     */
    @ResponseBody
    @RequestMapping("/commentlist.htm")
    public String commentlist(HttpServletRequest request, HttpServletResponse response) {
    	ResponseContent responseContent = new ResponseContent();
    	RequestContent requestContent = RequestHandler.execute(request);
    	try {
    		DeventComment comment = new DeventComment();
    		if (null != requestContent.getBody()) {
    			if(StringUtils.isNotBlank(requestContent.getBody().get("eventId"))){
    				comment.setEventId(Long.parseLong(requestContent.getBody().get("eventId")));
    			}
    			
    			PageObject pageInfo = new PageObject();
    			if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
    				pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
    			}else{
    				pageInfo.setPageNo(1);
    			}
    			
    			comment.setPageInfo(pageInfo);
    		}
    		
    		List<DeventComment> comlist = this.eventCommentService.listWithPage(comment);
    		
    		if(comlist != null && comlist.size() > 0){
    			responseContent = ResponseHandler.makeResponse(comlist, true);
    		}
    	} catch (Exception e) {
    		logger.info("活动详情获取失败", e);
    	}
    	return JSONObject.toJSONString(responseContent);
    }
    
    
}
