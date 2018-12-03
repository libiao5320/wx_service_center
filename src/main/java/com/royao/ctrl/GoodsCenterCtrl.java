package com.royao.ctrl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.royao.services.inface.DevaluateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.royao.commons.enums.RedpacketsStatus;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dgoods;
import com.royao.model.Dredpackets;
import com.royao.model.DredpacketsDistribute;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DgoodsService;
import com.royao.services.inface.DredpacketsDistributeService;
import com.royao.services.inface.DredpacketsService;

/**
 * 产品数据后端
 * @author yangx
 *
 * @className 
 * @date 2016年1月4日 下午5:31:30
 */
@Controller
@RequestMapping("/goods")
public class GoodsCenterCtrl {
	
	private Logger loger  = Logger.getLogger(this.getClass());
	
	@Autowired
	private  DgoodsService dgoodsService;	
		
	
	@Autowired
	private DredpacketsService redpacketsService;
	
	@Autowired
	private DredpacketsDistributeService redpacketsDistributeService;


	@Autowired
	private DevaluateService devaluateService;
	

	
	@ResponseBody
	@RequestMapping("/list.htm")
	public String index(HttpServletRequest request ,HttpServletResponse response){
		ResponseContent responseContent = null;
		try {
			
			loger.info("商品列表页list");
			responseContent = new ResponseContent();
			RequestContent  requestContent  = RequestHandler.execute(request);
			
			Map params = requestContent.getBody();

			PageObject pageObject = new PageObject();

			if( null == params.get("pageNo") )
			pageObject.setPageNo(1);
			else
			pageObject.setPageNo(Integer.valueOf("" + params.get("pageNo")));
			
			if(null != requestContent.getBody().get("classId") && "0".equals(requestContent.getBody().get("classId"))){
				//商家分类
				params.remove("classId");
			}
			
			params.put("begin",pageObject.getBegin());
			params.put("end",pageObject.getEnd());

			
	        response.setCharacterEncoding("utf-8");
	        //将json字符串 转换成 java bean
//	        Dgoods param = JSON.parseObject(JsonUtil.map2json(params), Dgoods.class);

	        PageObject pageInfo = new PageObject();
		        try {
		        	
		        	if(null != requestContent.getBody()){
						List<Dgoods> goodList= this.dgoodsService.listWithPageAndConditon(params);
						if(goodList != null){
							responseContent = ResponseHandler.makeResponse(goodList,true);
						}
					}
		        	
		        } catch (Exception e) {
		            loger.info("异常："+e.getMessage());
		        }
		} catch (Exception e) {
			   loger.info("异常："+e.getMessage());
		}
		 return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 商品详情
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request , HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);


        loger.info("goodsId:"+requestContent.getBody().get("goodsId"));
		try {
			if(null != requestContent.getBody()){
				Dgoods dgoods =null;
				List evalList = null;
				if(requestContent.getBody().get("goodsId")!=null || "".equals(requestContent.getBody().get("goodsId"))){
					dgoods = this.dgoodsService.queryById(Long.parseLong(requestContent.getBody().get("goodsId").toString()));
					 evalList =  this.devaluateService.queryByGoodId(Integer.valueOf(requestContent.getBody().get("goodsId").toString()));

				}else {
					loger.info("goodsId为空串");
					return null;
				}
					
				if(dgoods != null ){
					JSONObject  jsonObject  = new JSONObject();
					jsonObject.put("dgoods",dgoods);
					jsonObject.put("evalList",evalList);
					responseContent = ResponseHandler.makeResponse(jsonObject,true);
	             }else{
	         		loger.info("goodsId有误");
	            	 return null;
	             }
			}
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			loger.error("异常："+e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * 更多商品详情
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/gdDetail.htm")
	public String gdDetail(HttpServletRequest request , HttpServletResponse response){
		ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
        System.out.println("goodsId:"+requestContent.getBody().get("goodsId"));
		try {
			if(null != requestContent.getBody()){
				Dgoods dgoods =null;
				if(requestContent.getBody().get("goodsId")!=null || "".equals(requestContent.getBody().get("goodsId"))){
					//调用重新详细数据 
					dgoods = this.dgoodsService.queryByIdByDetail(Long.parseLong(requestContent.getBody().get("goodsId").toString()));
				}else {
				
					System.out.println("goodsId为空串");
					return null;
				}
					
				if(dgoods != null){
					responseContent = ResponseHandler.makeResponse(dgoods,true);
	             }else{
	                 System.out.println("goodsId有误");
	            	 return null;
	             }
			}
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 商品分类
	 * @param request
	 * @param response
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("/queryGoodsClass.htm")
//	public String queryAll(HttpServletRequest request,HttpServletResponse response){
//		 ResponseContent responseContent = new ResponseContent();   
//			RequestContent  requestContent  = RequestHandler.execute(request);
//	        response.setCharacterEncoding("utf-8");
//		        try {
//		        	if(null != requestContent.getBody()){
//		        		
//		        		 Map<?, ?> params = requestContent.getBody();
////		        		 DgroupbuyClass param = JSON.parseObject(JsonUtil.map2json(params), DgroupbuyClass.class);
//		        		 List<DgroupbuyClass> groupBuyClass=null;
//		        		if(requestContent.getBody().get("classParentId")!=null || "".equals(requestContent.getBody().get("classParentId"))){
//							//调用重新详细数据 
//		        			 groupBuyClass= this.groupBuyClassService.queryByCondtion(params);
//						}else {
//							System.out.println("goodsId为空串");
//							return null;
//						}
//						if(groupBuyClass != null){
//							responseContent = ResponseHandler.makeResponse(groupBuyClass,true);
//						}
//					}
//		        	
//		        } catch (Exception e) {
//		        	loger.info("异常："+e.getMessage());
//		        }
//		return JSONObject.toJSONString(responseContent);
//	}

	/**
	 * 
	 * @Description: 分享商品
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月18日
	 */
	@ResponseBody
	@RequestMapping("/share.htm")
	public String share(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			DredpacketsDistribute red = new DredpacketsDistribute();
			
			if(null != requestContent.getBody()){
				red.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
				red.setPurpose("fx");
				red = this.redpacketsDistributeService.queryIsShare(red);
				if(red == null){//有权获取一个分享红包
					/*******从大红包中获取一个可以用的并且是用作分享的红包**********/
					Dredpackets dred = new Dredpackets();
					dred.setPurpose("fx");
					dred.setType("quota");
					dred.setValidityTime(new Date());
					dred.setStatus("on");
					List<Dredpackets> dredList = this.redpacketsService.queryAvailable(dred);//查找可用红包
					
					if(dredList != null && dredList.size() > 0){
						
						dred = dredList.get(0);
						red = new DredpacketsDistribute();
						red.setRedpacketsId(dred.getId());//大红包ID
						if(dred.getType() == "quota")
							red.setMoney(dred.getSingleAmount());//红包金额
						else
						{
							Long amount = this.redpacketsService.getRandomAmount(dred);//红包金额
							red.setMoney(amount);
						}
						red.setValidTime(dred.getValidityTime());//红包过期时间
						red.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));//领取人
						red.setCreateTime(new Date());//领取时间
						red.setPurpose("fx");//分享所得
						red.setStatus(RedpacketsStatus.unuse);//未使用
						red.setName("分享有礼，系统红包");
						
						this.redpacketsDistributeService.save(red);
						
						dred.setReceive(dred.getReceive() + 1);//将大红包的领取次数＋1
						dred.setAmount(dred.getAmount()-red.getMoney());//重新计算红包总金额
						
						this.redpacketsService.update(dred);
					
						responseContent = ResponseHandler.makeResponse(red,true);
					}
				}
			}
		}catch(Exception e){
			loger.info("商品分享请求数据错误！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}

	@ResponseBody
	@RequestMapping (value = "/queryByClass.htm")
	public String queryByClass(HttpServletRequest request){
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		if( null != requestContent && null != requestContent.getBody().get("classId")) {
				Long classId = Long.valueOf(requestContent.getBody().get("classId"));
			try {
				List l  = dgoodsService.queryByClass(classId);
				if( null != l  && l.size() > 0 )
				responseContent = ResponseHandler.makeResponse(l,true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return JSONObject.toJSONString(responseContent);
	}





}
