package com.royao.pctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.yiwang.commons.utils.DateUtil;
import cc.yiwang.commons.utils.Validate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.commons.enums.StoreStatus;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Darea;
import com.royao.model.DgroupbuyClass;
import com.royao.model.Dstore;
import com.royao.model.DstoreExtend;
import com.royao.model.DstoreManager;
import com.royao.model.DstoreText;
import com.royao.model.Order;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DareaService;
import com.royao.services.inface.DgroupbuyClassService;
import com.royao.services.inface.DstoreExtendService;
import com.royao.services.inface.DstoreManagerService;
import com.royao.services.inface.DstoreService;
import com.royao.services.inface.DstoreTextService;
import com.royao.util.JsonUtil;


@Controller
@RequestMapping("/store_pc")
public class DstoreCtrl {

	
		@Autowired
		private DstoreService storeService;
		
		@Autowired
		private DgroupbuyClassService classService;
		
		@Autowired
		private DareaService areaService;
		
		@Autowired
		private DstoreExtendService extendService;
		
		@Autowired
		private DstoreManagerService managerService;
		
		@Autowired
		private DstoreTextService textService;
		
		/**
		 * P端商户管理
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception 
		 */
		@ResponseBody
		@RequestMapping("/index.htm")
		public String index(HttpServletRequest request ,HttpServletResponse response) throws Exception{
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<String,Object>  result = new HashMap<String, Object>();
			
			Map<?,?> params = requestContent.getBody();
			
			int page = Integer.parseInt(params.get("page").toString());
			int size = 10;
			if(null != params.get("size")){
				size = Integer.parseInt(params.get("size").toString());
			}
			params.remove("page");
			params.remove("size");
			PageObject p = new PageObject();
			p.setPageNo(page);
			p.setPageSize(size);
			Order or = JSON.parseObject(JsonUtil.map2json(params), Order.class);
			or.setPageInfo(p);
			
			List<Map<?,?>> row = this.storeService.indexList(or);
			result.put("rows", row);
			Long total = this.storeService.queryCount();
			result.put("total", total);
			
			responseContent = ResponseHandler.makeResponse(result, true);
			
			return JSONObject.toJSONString(responseContent);
		}
		
		
		@SuppressWarnings("unchecked")
		@ResponseBody
		@RequestMapping("/add.htm")
		public String add(HttpServletRequest request ,HttpServletResponse response) throws Exception{
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<String,Object>  result = new HashMap<String, Object>();
			
			Map<?,?> params = requestContent.getBody();
			
			if(null != params && params.size() > 0 && null != params.get("storeId")){
				String store_id = (String) params.get("storeId");
				Dstore store = this.storeService.queryDetail(Long.parseLong(store_id));
				
				List<Darea> city = this.areaService.queryByAreaParentId(store.getProvinceId());
				result.put("city", city);
				
				List<Darea> county = this.areaService.queryByAreaParentId(store.getCityId());
				
				result.put("county", county);
				
				result.put("store", store);
			}
			
			List<DgroupbuyClass> g_class = this.classService.queryAll();
			result.put("g_class",g_class);
			List<Darea>  area = this.areaService.queryByDeep(1);
			result.put("area", area);
			
			responseContent = ResponseHandler.makeResponse(result, true);
			
			return JSONObject.toJSONString(responseContent);
		}
		
		
		@ResponseBody
		@RequestMapping("/save.htm")
		public String saveres(HttpServletRequest request){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<String,Object>  result = new HashMap<String, Object>();
			
			Map<?,?> params = requestContent.getBody();
			String msg="FAIL",state="N";
			if(null != params && params.size() > 0){
				try {
					Dstore or = JSON.parseObject(JsonUtil.map2json(params), Dstore.class);
					
					DstoreExtend  extend = JSON.parseObject(JsonUtil.map2json(params), DstoreExtend.class);
					
					DstoreText  text = JSON.parseObject(JsonUtil.map2json(params), DstoreText.class);
					
					DstoreManager manager = JSON.parseObject(JsonUtil.map2json(params), DstoreManager.class);
					if(null != or.getStoreId()){
						this.storeService.update(or);
						this.extendService.updateStoreId(extend);
						manager.setSmName(or.getStoreName());
						manager.setSmStoreId(Integer.parseInt(or.getStoreId()+""));
						this.managerService.updateManager(manager);
						text.setId(or.getStoreId());
						text.setText(params.get("storeDetail").toString());
						this.textService.update(text);
					}else{
						or.setStoreState(2);
						or.setStoreSort(or.getSort());
						or.setStatus(StoreStatus.normal);
						or.setStoreTime(DateUtil.current());
						this.storeService.save(or);
						extend.setStoreId(or.getStoreId());
						this.extendService.save(extend);
						manager.setSmName(or.getStoreName());
						manager.setSmStoreId(Integer.parseInt(or.getStoreId()+""));
						this.managerService.save(manager);
						text.setId(or.getStoreId());
						text.setText(params.get("storeDetail").toString());
						this.textService.insert(text);
					}
					msg="SUCCESS";state="Y";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			result.put("msg", msg);
			result.put("state",state);
			
			try {
				responseContent = ResponseHandler.makeResponse(result, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return JSONObject.toJSONString(responseContent);
		}
		
		/**
		 * 删除商家逻辑删除
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/delete.htm")
		public String delete(HttpServletRequest request ,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<String,Object>  result = new HashMap<String, Object>();
			
			Map<?,?> params = requestContent.getBody();
			String msg="FAIL",state="N";
			
			if(null != params && params.size() > 0){
				String store_id = params.get("id").toString();
				try {
					Long id = Long.parseLong(store_id);
					/*this.storeService.delete(id);
					this.extendService.deleteBystoreId(id);
					this.managerService.deleteBySmsStoreId(id);
					this.textService.delete(id);*/
					Dstore store = this.storeService.queryById(id);
					store.setStatus(StoreStatus.delete);
					this.storeService.update(store);
					msg="SUCCESS";state="Y";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			result.put("msg", msg);
			result.put("state",state);
			try {
				responseContent = ResponseHandler.makeResponse(result, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return JSONObject.toJSONString(responseContent);
		}
		
		
		/**
		 * 商家审核
		 * @param request
		 * @param response
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/queryAll.htm")
		public String queryAll(HttpServletRequest request ,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<String,Object>  result = new HashMap<String, Object>();
			Map<String,Object>  res = new HashMap<String, Object>();
			List<Integer>  list = new ArrayList<Integer>();
			
			Map<?,?> params = requestContent.getBody();
			
			int page = Integer.parseInt(params.get("page").toString());
			int size = 10;
			if(null != params.get("size")){
				size = Integer.parseInt(params.get("size").toString());
			}
			PageObject p = new PageObject();
			p.setPageNo(page);
			p.setPageSize(size);
			res.put("pageInfo", p);
			if(null != params && params.size() > 0){
				String state = "";
				if(null != params.get("state")){
					state = params.get("state").toString();
					if(!Validate.isEmpty(state)){
						list.add(Integer.parseInt(state));
					}else{
						list.add(2);
						list.add(4);
						list.add(5);
					}
				}else{
					list.add(2);
					list.add(4);
					list.add(5);
				}
				res.put("list", list);
				try {
					List<Dstore>  rows = this.storeService.queryAlls(res);
					result.put("rows", rows);
					Long total = this.storeService.queryAllsCount(res);
					result.put("total", total);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				responseContent = ResponseHandler.makeResponse(result, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return JSONObject.toJSONString(responseContent);
		}
		
		
		@ResponseBody
		@RequestMapping("/audit.htm")
		public String audit(HttpServletRequest request ,HttpServletResponse response){
			ResponseContent responseContent = new ResponseContent();
			RequestContent requestContent = RequestHandler.execute(request);

			Map<String,Object>  result = new HashMap<String, Object>();
			
			Map<?,?> params = requestContent.getBody();
			String msg="FAIL",state="N";
			
			if(null != params && params.size() > 0){
				String store_id = params.get("id").toString();
				String states = params.get("state").toString();
				try {
					Long id = Long.parseLong(store_id);
					Dstore store = this.storeService.queryById(id);
					store.setStoreState(Integer.parseInt(states));
					this.storeService.update(store);
					msg="SUCCESS";state="Y";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			result.put("msg", msg);
			result.put("state",state);
			try {
				responseContent = ResponseHandler.makeResponse(result, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return JSONObject.toJSONString(responseContent);
		}
}
