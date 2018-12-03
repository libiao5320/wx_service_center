package com.royao.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.royao.model.Devaluate;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DevaluateService;

/**
 * 
 * ClassName: EvaluateCenterCtrl 
 * @Description: 商品&&商家评论
 * @author Liu Pinghui
 * @date 2016年1月9日
 */
@Controller
@RequestMapping("evaluate")
public class EvaluateCenterCtrl {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DevaluateService evaluateService;
	/**
	 * 
	 * @Description: 评价列表
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月9日
	 */
	@ResponseBody
	@RequestMapping("list.htm")
	public String list(HttpServletRequest request, HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
        	Devaluate evaluate = new Devaluate();
            if (null != requestContent.getBody()) {
                //是否带有条件
            	if(null != requestContent.getBody().get("storeId")){
            		evaluate.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
            	}
            	
            	if(null != requestContent.getBody().get("isShow")){
            		evaluate.setIsShow(requestContent.getBody().get("isShow"));
            	}
            	
            	PageObject pageInfo = new PageObject();
            	if(null != requestContent.getBody().get("pageNo")){
            		pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
            	}else{
            		pageInfo.setPageNo(1);
            	}
            	
            	evaluate.setPageInfo(pageInfo);
            }
           	List<Devaluate> list = this.evaluateService.listWithPage(evaluate);
            if (list != null && list.size() > 0) {
                responseContent = ResponseHandler.makeResponse(list, true);
            } else {
                return null;
            }
            return JSONObject.toJSONString(responseContent);
        } catch (Exception e) {
            logger.info("获取评论列表错误", e);
        }
        
        return null;
	}
}
