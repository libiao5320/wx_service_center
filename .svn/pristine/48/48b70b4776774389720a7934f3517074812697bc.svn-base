package com.royao.pctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.royao.http.JsonHandler;
import com.royao.model.TuserConsult;
import com.royao.model.base.PageObject;
import com.royao.services.inface.ConsultService;
import com.royao.util.StringUtil;

@Controller
@RequestMapping("/consult")
public class AppConsultCtrl {
	private Logger loger = Logger.getLogger(this.getClass());
	@Autowired
	private ConsultService consultService;

	@ResponseBody
	@RequestMapping(value = "/show")
	public String get(HttpServletRequest request, HttpServletResponse response) {
		String id = "0";
		if (request.getParameter("id") != null && StringUtil.isDigit(id)) {
			id = request.getParameter("id").toString();
		}

		String content = "";
		try {
			TuserConsult consult = consultService.queryById(Long.valueOf(id));
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("consult_list", consult);
			content = JsonHandler.makeJson(returnMap, true);
		} catch (Exception e) {
			loger.info("consultService 错误", e);
		}
		return content;
	}

	@ResponseBody
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		String content = "";
		Map<String, Object> params = new HashMap<String, Object>();
		PageObject pageInfo = new PageObject();
		response.setCharacterEncoding("utf-8");

		//分页
		if (request.getParameter("p") != null
				&& StringUtil.isDigit(request.getParameter("p"))) {
			pageInfo.setPageNo(Integer.parseInt(request.getParameter("p")));
		} else {
			pageInfo.setPageNo(1);
		}
		
		//issolve=0 未解决 issolve=1 已解决咨询
		if (request.getParameter("issolve") != null && request.getParameter("issolve").equals("0")){
			params.put("issolve", "0");
			int[] ids = {0,1,2,12};
			params.put("iStatus", ids);
		}else if(request.getParameter("issolve") != null && request.getParameter("issolve") .equals("1")){
			int[] ids = {10,11};
			params.put("iStatus", ids);
		}else{
			int[] ids = {10,11};
			params.put("iStatus", ids);
		}
		
		//根据健康师ID或 用户ID 查询 咨询列表
		if (request.getParameter("v_doctor_id") != null){
			params.put("vdoctorId",request.getParameter("v_doctor_id"));
		}else if (request.getParameter("v_userid") != null){
			params.put("vuserid",request.getParameter("v_userid"));
		}else{
			//params.put("vdoctorId","0");
		}
		
		params.put("begin",pageInfo.getBegin());
		params.put("end",pageInfo.getEnd());
		
		try {
			List<TuserConsult> consultList = consultService.listWithPageBy(params);
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("consult_list", consultList);
			content = JsonHandler.makeJson(returnMap, true);
		} catch (Exception e) {
			loger.info("consultService 错误", e);
		}
		return content;
	}

}
