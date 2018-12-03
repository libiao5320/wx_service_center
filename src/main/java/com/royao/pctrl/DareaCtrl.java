package com.royao.pctrl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Darea;
import com.royao.services.inface.DareaService;


@Controller
@RequestMapping("/area")
public class DareaCtrl {

		@Autowired
		private DareaService areaService;
		
		
		@ResponseBody
		@RequestMapping("/area.htm")
		public String area(HttpServletRequest request ,HttpServletResponse response) throws Exception{
			
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<?,?> params = requestContent.getBody();
			
			if(null != params && params.size() > 0){
				String id = (String) params.get("id");
				List<Darea>  list = this.areaService.queryByAreaParentId(Integer.parseInt(id));
				
				responseContent = ResponseHandler.makeResponse(list, true);
			}
			return JSONObject.toJSONString(responseContent);
		}
}
