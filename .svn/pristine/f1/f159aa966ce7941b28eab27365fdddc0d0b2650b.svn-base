package com.royao.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dcollect;
import com.royao.services.inface.DcollectService;

/**
 * 
 * ClassName: CollectCenterCtrl 
 * @Description: 用户收藏API
 * @author Liu Pinghui
 * @date 2016年1月13日
 */
@Controller
@RequestMapping("/collect")
public class CollectCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DcollectService collectService;
	
	/**
	 * 
	 * @Description: 收藏
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月13日
	 */
	@ResponseBody
	@RequestMapping("/collect.htm")
	public String collect(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
            	Dcollect collect = new Dcollect();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
            		collect.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("type"))){
            		collect.setType(requestContent.getBody().get("type"));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("id"))){
            		collect.setCommonId(Long.parseLong(requestContent.getBody().get("id")));
            	}
            	collect = this.collectService.insert(collect);
            	if(collect != null){
            		responseContent = ResponseHandler.makeResponse(collect, true);
            	}
            }
            
        } catch (Exception e) {
        	logger.info("收藏失败", e);
        }
        
        return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 取消收藏
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月13日
	 */
	@ResponseBody
	@RequestMapping("/uncollect.htm")
	public String uncollect(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			boolean status = false;
			if (null != requestContent.getBody()) {
				
				Integer isStatus = this.collectService.delete(Long.parseLong(requestContent.getBody().get("id")));
				
				if(isStatus == 1){
					status = true;
				}else{
					status = false;
				}
				responseContent = ResponseHandler.makeResponse(status, true);
			}
			
		} catch (Exception e) {
			logger.info("收藏失败", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 检测是否已经收藏
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月13日
	 */
	@ResponseBody
	@RequestMapping("/isCollect.htm")
	public String isCollect(HttpServletRequest request, HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
        
            if (null != requestContent.getBody()) {
            	Dcollect collect = new Dcollect();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
            		collect.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("type"))){
            		collect.setType(requestContent.getBody().get("type"));
            	}
            	if(StringUtils.isNotBlank(requestContent.getBody().get("commonId"))){
            		collect.setCommonId(Long.parseLong(requestContent.getBody().get("commonId")));
            	}
            	List<Dcollect> list = this.collectService.findList(collect);
            	if(list != null && list.size() > 0){
            		responseContent = ResponseHandler.makeResponse(list, true);
            	}
            }
            
        } catch (Exception e) {
        	logger.info("检测失败", e);
        }
		
		return JSONObject.toJSONString(responseContent);
	}
}
