package com.royao.pctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
import com.royao.model.DsystemSet;
import com.royao.model.Dtopman;
import com.royao.model.Dvip;
import com.royao.model.DwxBanner;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DsystemSetService;
import com.royao.services.inface.DtopmanService;
import com.royao.services.inface.DvipService;
import com.royao.util.JsonUtil;


/**
 * 储值设置与其他设置
 * @author oubinbin
 *
 */
@Controller
@RequestMapping("/PSettingsCenterCtrl")
public class PSettingsCenterCtrl{
	@Autowired
	private DsystemSetService systemSetService;
	
	@Autowired
	private DvipService vipService;
	
	Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 查询储存设置信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryStorageSetting.htm")
	public String queryStorageSetting(HttpServletRequest request,HttpServletResponse response){
		 ResponseContent responseContent = new ResponseContent();   
			RequestContent  requestContent  = RequestHandler.execute(request);
	        response.setCharacterEncoding("utf-8");
		        try {
		        	if(null != requestContent.getBody()){
		        		Map<String,Object> map = new HashMap<String, Object>();
		 		        map.put("type", "CCSET");
						List<DsystemSet> dsystemSets= this.systemSetService.queryByCondtion(map);
						List<Dvip> vips = this.vipService.queryAll();
						Map<String,Object> returnMap = new HashMap<String, Object>();
						if(dsystemSets != null && dsystemSets.size() != 0){
							returnMap.put("dsystemSets", dsystemSets);
							returnMap.put("vips", vips);
							responseContent = ResponseHandler.makeResponse(returnMap,true);
						}
					}
		        	
		        } catch (Exception e) {
		        	logger.info("异常："+e.getMessage());
		        }
		return JSONObject.toJSONString(responseContent);
	}
	/**
	 * 查询其他设置信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryotherSetting.htm")
	public String queryotherSetting(HttpServletRequest request,HttpServletResponse response){
		 ResponseContent responseContent = new ResponseContent();   
			RequestContent  requestContent  = RequestHandler.execute(request);
	        response.setCharacterEncoding("utf-8");
		        try {
		        	if(null != requestContent.getBody()){
		        		Map<String,Object> map = new HashMap<String, Object>();
		 		        map.put("type", "QTSET");
						List<DsystemSet> dsystemSets= this.systemSetService.queryByCondtion(map);
						if(dsystemSets != null){
							responseContent = ResponseHandler.makeResponse(dsystemSets,true);
						}
					}
		        	
		        } catch (Exception e) {
		        	logger.info("异常："+e.getMessage());
		        }
		return JSONObject.toJSONString(responseContent);
	}
	/**
	 *  修改设置信息(只修改值)
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/updateSetting.htm")
    public String updateSetting(HttpServletRequest request, HttpServletResponse response){
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        response.setCharacterEncoding("utf-8");
        
        Map<String,Object> returnMap = new HashMap<String, Object>();
        try {
        	int count = 0; //更新的记录数
        	int num = 0; //需要保存的记录数
        	//修改vip值
        	if(params.get("requires") != null){
        		JSONArray requires = JSONArray.parseArray(params.get("requires").toString());
                for(int i=0; i<requires.size(); i++){
                	JSONObject r =  JSON.parseObject(requires.get(i).toString());
                	Dvip vip = new Dvip();
                	vip.setId(r.getLong("id"));
                	vip.setRequire(r.getInteger("requireValue"));
                	count += vipService.updateRequireById(vip);
                }
                num += requires.size();
        	}
        	
            //修改各项设置值
            JSONArray sValues = JSONArray.parseArray(params.get("sValues").toString());
            for(int i=0; i<sValues.size(); i++){
            	JSONObject s =  JSON.parseObject(sValues.get(i).toString());
            	DsystemSet systemSet = new DsystemSet();
            	systemSet.setId(s.getLong("id"));
            	systemSet.setSvalue(s.getString("sValue"));
            	count += systemSetService.updateValue(systemSet);
            }
            num += sValues.size();
            
            if(count == num){
            	returnMap.put("state", 1);
            }else{
            	returnMap.put("state", -1);
            	returnMap.put("message", "更新设置信息失败！");
            }
            responseContent = ResponseHandler.makeResponse(returnMap, true);
        } catch (Exception e) {
            logger.info("更新设置信息失败", e);
        }

        return JSONObject.toJSONString(responseContent);
    }
}
