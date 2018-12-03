package com.royao.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royao.services.inface.DredpacketsDistributeService;

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
import com.royao.model.Dredpackets;
import com.royao.services.inface.DredpacketsService;

/**
 * ClassName: RedpacketsCenterCtrl
 *
 * @author Liu Pinghui
 * @Description: 红包
 * @date 2016年1月5日
 */
@Controller
@RequestMapping("/redpackets")
public class RedpacketsCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
    @Autowired
    private DredpacketsService redpacketsService;

    @Autowired
    private DredpacketsDistributeService dredpacketsDistributeService;

    /**
     * @param @param  request
     * @param @param  response
     * @param @return
     * @return String
     * @throws
     * @Description: 根据红包ID获取红包信息
     * @author Liu Pinghui
     * @date 2016年1月5日
     */
    @ResponseBody
    @RequestMapping("/getById.htm")
    public String getById(HttpServletRequest request, HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
            if (null != requestContent.getBody()) {
                Dredpackets redpackets = this.redpacketsService.queryById(Long.parseLong(requestContent.getBody().get("id").toString()));
                if (redpackets != null) {
                    responseContent = ResponseHandler.makeResponse(redpackets, true);
                }
            }
        } catch (Exception e) {
        	logger.info("获取红包信息失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }

    @ResponseBody
    @RequestMapping (value = "/shareRedPack.htm")
    public String  shareRedPack (HttpServletRequest request)
    {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);

        Long packId = 0l;
        try {
            if (null != requestContent.getBody()) {
                if( null != requestContent.getBody() && null != requestContent.getBody().get("packId") && !"".equals(requestContent.getBody().get("packId")))
                 packId = Long.parseLong(requestContent.getBody().get("packId"));
                 boolean flag = this.dredpacketsDistributeService.shareRedPack(packId);
                 responseContent = ResponseHandler.makeResponse(flag, true);

            }
            
        } catch (Exception e) {
        	logger.info("",e);
        }

        return JSONObject.toJSONString(responseContent);
    }
    
    /**
     * 
     * @Description: 获取红包列表
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年2月26日
     */
    @ResponseBody
    @RequestMapping (value = "/list.htm")
    public String  list (HttpServletRequest request)
    {
    	ResponseContent responseContent = new ResponseContent();
    	RequestContent requestContent = RequestHandler.execute(request);
    	
    	try {
    		if (null != requestContent.getBody()) {
    			Dredpackets redpackets = new Dredpackets();
    			
    			if(StringUtils.isNotBlank(requestContent.getBody().get("type"))){
    				redpackets.setType(requestContent.getBody().get("type"));
    			}
    			if(StringUtils.isNotBlank(requestContent.getBody().get("status"))){
    				redpackets.setStatus(requestContent.getBody().get("status"));
    			}
    			
    			List<Dredpackets> list = this.redpacketsService.listWithPage(redpackets);
    			
    			responseContent = ResponseHandler.makeResponse(list, true);
    		}
    	} catch (Exception e) {
    		logger.info("获取红包列表",e);
    	}
    	
    	return JSONObject.toJSONString(responseContent);
    }
}