package com.royao.pctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.royao.model.DmemberRemark;
import com.royao.services.inface.DmemberRemarkService;

/**
 * 
 * ClassName: MemberRemarkCenterCtrl 
 * @Description: 用户备注
 * @author Liu Pinghui
 * @date 2016年1月21日
 */
@Controller
@RequestMapping("/pmemberremark")
public class PMemberRemarkCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DmemberRemarkService memberRemarkService;
	
	/**
	 * 
	 * @Description: 获取用户备注列表
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月21日
	 */
	@ResponseBody
	@RequestMapping("/list.htm")
	public String list(HttpServletRequest request){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
            	DmemberRemark remark = new DmemberRemark();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
	            	remark.setMemberId(Long.parseLong(requestContent.getBody().get("memberId").toString()));
	                List<DmemberRemark> list = this.memberRemarkService.findList(remark);
	                if (list != null && list.size() > 0) {
	                    responseContent = ResponseHandler.makeResponse(list, true);
	                } 
            	}
            }
            
        } catch (Exception e) {
        	logger.info("获取备注列表错误", e);
        }
        
        return JSONObject.toJSONString(responseContent);
        
	}
	
	/**
	 * 
	 * @Description: 备注
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月21日
	 */
	@ResponseBody
	@RequestMapping("/remark.htm")
	public String remark(HttpServletRequest request){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			if (null != requestContent.getBody()) {
				
				DmemberRemark remark = new DmemberRemark();
				
				if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
					remark.setMemberId(Long.parseLong(requestContent.getBody().get("memberId").toString()));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("managerId"))){
					remark.setManagerId(Long.parseLong(requestContent.getBody().get("managerId").toString()));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("manager"))){
					remark.setManager(requestContent.getBody().get("manager").toString());
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("content"))){
					remark.setContent(requestContent.getBody().get("content").toString());
				}
				
				remark.setCreateTime(new Date());
				
				Integer result = this.memberRemarkService.save(remark);
				boolean flag = false;
				
				if(result == 1){
					flag = true;
				}
				
				responseContent = ResponseHandler.makeResponse(flag, true);
			}
			
		} catch (Exception e) {
			logger.info("获取备注列表错误", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 删除备注信息
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月21日
	 */
	@ResponseBody
	@RequestMapping("/delete.htm")
	public String delete(HttpServletRequest request){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
            	if(StringUtils.isNotBlank(requestContent.getBody().get("id"))){
            		Integer state = this.memberRemarkService.delete(Long.parseLong(requestContent.getBody().get("id")));
            		boolean flag = false;
            		if(state == 1){
            			flag = true;
            		}
            		responseContent = ResponseHandler.makeResponse(flag, true);
            	}
            }
            
        } catch (Exception e) {
        	logger.info("获取备注列表错误", e);
        }
        
        return JSONObject.toJSONString(responseContent);
        
	}
}
