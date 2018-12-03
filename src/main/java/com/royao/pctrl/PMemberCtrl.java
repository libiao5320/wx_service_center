package com.royao.pctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.royao.model.Dmember;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DbalanceLogsService;
import com.royao.services.inface.DmemberService;
import com.royao.util.MoneyUtil;

@Controller
@RequestMapping("/pmember")
public class PMemberCtrl {
	
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DmemberService memberService;
	
	@Autowired
	private DbalanceLogsService balancelogsService;
	 /**
     * 
     * @Description: p端获取用户列表
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月20日
     */
    @ResponseBody
    @RequestMapping("/list.htm")
    public String list(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);

        try{
        	Dmember member = new Dmember();
            if(null != requestContent.getBody()){
            	//用户ID
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
            		member.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
            	}
            	//用户名
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberName"))){
            		member.setMemberName(requestContent.getBody().get("memberName"));
            	}
            	//用户手机
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberMobile"))){
            		member.setMemberMobile(requestContent.getBody().get("memberMobile"));
            	}
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("startTime")) && StringUtils.isNotBlank(requestContent.getBody().get("endTime"))){
            		//注册开始时间
            		member.setMemberStartTime(requestContent.getBody().get("startTime"));
            		//注册结束时间
            		member.setMemberEndTime(requestContent.getBody().get("endTime"));
            	}
            	//排序标准
            	if(StringUtils.isNotBlank(requestContent.getBody().get("orderBy"))){
            		member.setOrderBy(requestContent.getBody().get("orderBy"));
            	}
            	//排序标准
            	PageObject page = new PageObject();
            	if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
            		page.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
            	}else{
            		page.setPageNo(1);
            	}
            	
            	member.setPageInfo(page);
            }
            
            List<Dmember> list = this.memberService.listWithPage(member);
            
            int total = this.memberService.listWithPageCount(member);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", list);
            returnMap.put("total", total);
            
            if(list != null && list.size() > 0){
            	responseContent = ResponseHandler.makeResponse(returnMap, true);
            }
        }catch(Exception e){
            logger.info("获取用户列表出错", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 
     * @Description: 获取顾客详情
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月21日
     */
    @ResponseBody
    @RequestMapping("/detail.htm")
    public String detail(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
        
        try{
            if(null != requestContent.getBody()){
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
            		
            		Dmember member = this.memberService.queryDetailById(Long.parseLong(requestContent.getBody().get("memberId")));
            		
            		
            		if(member != null){
            			//获取储值金额
                		Long stored = this.balancelogsService.countStored();
                		member.setStoredDollar(MoneyUtil.getCentToDollar(stored));
            		}
            		
            		responseContent = ResponseHandler.makeResponse(member, true);
            	}
            }
            
        }catch(Exception e){
            logger.info("获取用户详细信息出错", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 
     * @Description: 修改荣耀达人状态
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月21日
     */
    @ResponseBody
    @RequestMapping("/updateTopManState.htm")
    public String updateTopManState(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
    	RequestContent  requestContent  = RequestHandler.execute(request);
    	
    	try{
    		if(null != requestContent.getBody()){
    			boolean flag = false;
    			if(StringUtils.isNotBlank(requestContent.getBody().get("topManState"))){
    				
    				Dmember member = new Dmember();
    				member.setMemberId(Long.parseLong(requestContent.getBody().get("id")));
    				member.setTopManState(Integer.parseInt(requestContent.getBody().get("topManState")));
    				
    				Integer result = this.memberService.update(member);

    				if(result == 1){
    					flag = true;
    				}
    				
    				responseContent = ResponseHandler.makeResponse(flag, true);
    			}
    		}
    		
    	}catch(Exception e){
    		logger.info("获取用户详细信息出错", e);
    	}
    	
    	return JSONObject.toJSONString(responseContent);
    }
}
