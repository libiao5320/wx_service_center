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
import com.royao.commons.enums.YN;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dtechie;
import com.royao.model.DtechieEvaluate;
import com.royao.services.inface.DtechieEvaluateService;

/**
 * 
 * ClassName: TechieEvaluateCenterCtrl 
 * @Description: 私人健康师评价
 * @author Liu Pinghui
 * @date 2016年1月11日
 */
@Controller
@RequestMapping("/techieEvaluate")
public class TechieEvaluateCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DtechieEvaluateService techieEvaluateService;
	
	@ResponseBody
	@RequestMapping("list.htm")
	public String list(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
		try {
			DtechieEvaluate eva = new DtechieEvaluate();
			if(null != requestContent.getBody()){//是否带有参数
				if(StringUtils.isNotEmpty(requestContent.getBody().get("techieId"))){
					eva.setTechieId(Long.parseLong(requestContent.getBody().get("techieId")));
				}
				
				if(StringUtils.isNotEmpty(requestContent.getBody().get("isShow"))){
					if("Y".equals(requestContent.getBody().get("isShow"))){
						eva.setIsShow(YN.Y);
					}else{
						eva.setIsShow(YN.N);
					}
				}
			}
			
			List<DtechieEvaluate> list = this.techieEvaluateService.listWithPage(eva);
			if(list != null && list.size() > 0){
				responseContent = ResponseHandler.makeResponse(list,true);
			}
			
		}catch(Exception e){
			logger.info("获取健康师评论列表信息", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
}
