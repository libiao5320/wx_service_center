package com.royao.pctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.royao.commons.enums.YN;
import com.royao.http.*;
import com.royao.model.*;
import com.royao.services.inface.*;
import com.royao.util.ApiException;
import com.royao.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.model.base.PageObject;
import com.royao.util.JsonUtil;

/**
 * P端 产品数据API请求接口
 * @author jk
 * @Description
 * @date 2016年1月21日
 */
@Controller
@RequestMapping("/p/goods")
public class PGoodsCtrl {
	private Logger loger  = Logger.getLogger(this.getClass());
	@Autowired
	private  DgoodsService dgoodsService;	
	
	@Autowired
	private DredpacketsService redpacketsService;
	
	@Autowired
	private DtechieService techieService;
	
	@Autowired
	private DgoodsSetService dgoodsSetService;
	
	@Autowired
	private DredpacketsDistributeService redpacketsDistributeService;

	@Autowired
	private DareaService dareaService ;
	@Autowired
	private DgroupbuyClassService  dgroupbuyClassService;

	@Autowired
	private DstoreService dstoreService;

	@Autowired
	private DstoreExtendService dstoreExtendService;
	
	
	@ResponseBody
    @RequestMapping("/listQuery.htm")
    public String listQuery(HttpServletRequest request, HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        try {
        	Map params = requestContent.getBody();
        	PageObject pageInfo = new PageObject();
            response.setCharacterEncoding("utf-8");
        	if(null != requestContent.getBody()){
        		if(null == params.get("pageNo") ){
        			pageInfo.setPageNo(1);
        		}else{
        			pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
        		}
        		
        		if(null != requestContent.getBody().get("goodsState")){
    				params.put("goodsState",Integer.parseInt(requestContent.getBody().get("goodsState")));
    			}
            	if(null != requestContent.getBody().get("fieldValue")){
    				params.put(requestContent.getBody().get("fieldName"),requestContent.getBody().get("fieldValue"));
    			}
            	if(null != requestContent.getBody().get("sort")){
    				params.put(requestContent.getBody().get("sort"),requestContent.getBody().get("sort"));
    			}
        		
        	}
        	
        	params.put("begin",pageInfo.getBegin());
			params.put("end",pageInfo.getEnd());
			//Dgoods goods = JSON.parseObject(JsonUtil.map2json(params), Dgoods.class);
			//goods.setPageInfo(pageInfo);
			List<Dgoods> goodList= this.dgoodsService.listWithPageBy(params);
            
            int total = this.dgoodsService.queryCountBy(params);
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", goodList);
            returnMap.put("total", total);
            
            if (goodList != null && goodList.size() > 0) {
            	responseContent = ResponseHandler.makeResponse(returnMap,true);
            } 
        } catch (Exception e) {
        	loger.info("ajax请求活动列表失败", e);
        }
        return JSONObject.toJSONString(responseContent);
    }
	
	@ResponseBody
    @RequestMapping("/deleteGoods.htm")
    public String deleteGoods(HttpServletRequest request, HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        try {
        	long id = 0;
        	response.setCharacterEncoding("utf-8");
        	if(null != requestContent.getBody()){
        		if(null != requestContent.getBody().get("id")){
        			id = Long.parseLong(requestContent.getBody().get("id"));
    				
    			}
        		
        	}
        	int result = this.dgoodsService.delete(id);
        	Map<String,Object> returnMap = new HashMap<String, Object>();
            if(result > 0){
            	returnMap.put("state", 1);
            }else{
            	returnMap.put("state", 0);
            }
            responseContent = ResponseHandler.makeResponse(returnMap,true);
            
        } catch (Exception e) {
        	loger.info("ajax请求活动列表失败", e);
        }
        return JSONObject.toJSONString(responseContent);
    }


	@ResponseBody
	@RequestMapping ("/getAddGoodsParam.htm")
	public String getAddGoodsParam( HttpServletRequest request , HttpServletResponse response){

		List proviceList = null;
		List cityList = null;
		List areaList = null;

		List classOneList = null;
		List classTwoList = null;

		List storeList = null;
		
		List techie = null;

		Map returnMap   =  new HashMap();

		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);

		try {

			 proviceList  = dareaService.queryByDeep(1);
			 cityList  = dareaService.queryByDeep(2);
			 areaList  = dareaService.queryByDeep(3);


			classOneList = dgroupbuyClassService.queryGoodClassOne();
			classTwoList = dgroupbuyClassService.queryGoodClassTwo();

			techie = techieService.queryAll();
			storeList =  dstoreService.queryAll();

			returnMap.put("proviceList", proviceList);
			returnMap.put("cityList",cityList);
			returnMap.put("areaList",areaList);
			returnMap.put("classOneList",classOneList);
			returnMap.put("classTwoList",classTwoList);
			returnMap.put("storeList",storeList);
			returnMap.put("techie",techie);






			responseContent = ResponseHandler.makeResponse(returnMap,true);

		} catch (Exception e) {
			loger.info("ajax请求活动列表失败", e);
		}

		return JSONObject.toJSONString(responseContent);

	}


	@ResponseBody
	@RequestMapping ("/addGood.htm")
	public String addGood (HttpServletRequest request , HttpServletResponse response)
	{


		ResponseContent responseContent = new ResponseContent();
		ResponseHead responseHead = new ResponseHead();
		RequestContent requestContent = RequestHandler.execute(request);
		Map m  = requestContent.getBody() ;

		try {

			JSONObject goodInfo  = JSONObject.parseObject((String) m.get("goodInfo"));
			JSONArray  specList = JSONArray.parseArray((String) m.get("specList"));
			JSONArray  imgList = JSONArray.parseArray((String) m.get("imgList"));
			JSONObject goodSet  = JSONObject.parseObject((String) m.get("goodSet"));
			
			if ( null != goodInfo  )
			{
				Dgoods dgoods;
				List goodList;
				List imgs = new ArrayList();;

				DgoodsSet dgoodSet;


				List l = specList.subList(0,specList.size());
				try {
					dgoods = JSON.parseObject(JsonUtil.map2json(goodInfo), Dgoods.class);
					dgoodSet = JSON.parseObject(JsonUtil.map2json(goodSet), DgoodsSet.class);

					DstoreExtend dstoreExtend  = dstoreExtendService.queryByStoreId(dgoods.getStoreId());
					if(dstoreExtend != null && dstoreExtend.getServiceRatio() != null){
						dgoods.setServiceRatio(Long.valueOf(dstoreExtend.getServiceRatio()));
					}else{
						dgoods.setServiceRatio((long) 10);
					}
					goodList = convertToListOfGood(dgoods, l);
					imgs = imgList;
				}
				catch (Exception parseEx)
				{
					parseEx.printStackTrace();
					throw new ApiException("500" , "创建产品失败：参数转换错误!" );
				}


				for(int i = 0 ; i < goodList.size() ;i ++) {

						dgoods = (Dgoods) goodList .get(i);

					if (null == dgoods.getGoodsName() || "".equals(dgoods.getGoodsName()))
						throw new ApiException("500", "创建产品失败：产品名为空!");
					if (null == dgoods.getBuyKnow() || "".equals(dgoods.getBuyKnow()))
						throw new ApiException("500", "创建产品失败：产品购买须知为空!");
					if (null == dgoods.getGoodsIntroduce() || "".equals(dgoods.getGoodsIntroduce()))
						throw new ApiException("500", "创建产品失败：产品简介为空!");
					if (null == dgoods.getGcId1() || "".equals(dgoods.getGcId1()))
						throw new ApiException("500", "创建产品失败：产品一级类别为空!");
					if (null == dgoods.getGcId2() || "".equals(dgoods.getGcId2()))
						throw new ApiException("500", "创建产品失败：产品二级类别为空!");
					if (null == dgoods.getAreaid1() || "".equals(dgoods.getAreaid1()))
						throw new ApiException("500", "创建产品失败：产品一级区域为空!");
					if (null == dgoods.getAreaid2() || "".equals(dgoods.getAreaid2()))
						throw new ApiException("500", "创建产品失败：产品二级区域为空!");

					if (null == dgoods.getGoodsPrice() || "".equals(dgoods.getGoodsPrice()))
						throw new ApiException("500", "创建产品失败：产品基础价格为空!");
					if (null == dgoods.getGoodsVip0Price() || "".equals(dgoods.getGoodsVip0Price()))
						throw new ApiException("500", "创建产品失败：产品VIP0价格为空!");

					if (null == dgoods.getGoodsPrice() || "".equals(dgoods.getGoodsPrice()))
						throw new ApiException("500", "创建产品失败：产品基础价格为空!");
					if (null == dgoods.getGoodsVip0Price() || "".equals(dgoods.getGoodsVip0Price()))
						throw new ApiException("500", "创建产品失败：产品VIP0价格为空!");

					if (null == dgoods.getGoodsVip1Price() || "".equals(dgoods.getGoodsVip1Price()))
						throw new ApiException("500", "创建产品失败：产品VIP1价格为空!");
					if (null == dgoods.getGoodsVip2Price() || "".equals(dgoods.getGoodsVip2Price()))
						throw new ApiException("500", "创建产品失败：产品VIP2价格为空!");

					if (null == dgoods.getGoodsVip3Price() || "".equals(dgoods.getGoodsVip3Price()))
						throw new ApiException("500", "创建产品失败：产品VIP3价格为空!");
					if (null == dgoods.getGoodsVip4Price() || "".equals(dgoods.getGoodsVip4Price()))
						throw new ApiException("500", "创建产品失败：产品VIP4价格为空!");
					if (null == dgoods.getUnit() || "".equals(dgoods.getUnit()))
						throw new ApiException("500", "创建产品失败：产品价格单位为空!");
					if (null == dgoods.getMemberInterest() || "".equals(dgoods.getMemberInterest()))
						throw new ApiException("500", "创建产品失败：产品会员权益为空!");
					if (null == dgoods.getContentIntroduce() || "".equals(dgoods.getContentIntroduce()))
						throw new ApiException("500", "创建产品失败：产品内容介绍为空!");

					if (null == dgoods.getIsPtRed() || "".equals(dgoods.getIsPtRed()))
						dgoods.setIsPtRed("N");
					if (null == dgoods.getGoodsState() || "".equals(dgoods.getGoodsState()))
						dgoods.setGoodsState(3);

					if (null == dgoods.getMemberInterest() || "".equals(dgoods.getMemberInterest()))
						throw new ApiException("500", "创建产品失败：产品内容介绍为空!");


					if (null == dgoods.getIsBook() || "".equals(dgoods.getIsBook()))
						dgoods.setIsBook(1);
				}

				dgoodsService.batchAddGood( goodList ,imgs,dgoodSet );
				responseHead.setResultCode("200");
				responseHead.setDescription("创建产品成功");
				responseHead.setResponseTime(DateUtil.formatDate(DateUtil.current()));
				responseContent.setHead(responseHead);


			}
			else
				throw new ApiException("500" , "创建产品失败：参数为空!" );
		}
		catch(ApiException  ex)
		{
			ex.printStackTrace();
			loger.info("创建产品失败" + ex.getMessage());
			responseHead.setResultCode(ex.getCode());
			responseHead.setDescription("创建产品失败:" + ex.getMessage());
			responseHead.setResponseTime(DateUtil.formatDate(DateUtil.current()));
			responseContent.setHead(responseHead);
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			loger.info("创建产品失败" + e.getMessage());
			responseHead.setResultCode("500");
			responseHead.setDescription("创建产品失败:" + e.getMessage());
			responseHead.setResponseTime(DateUtil.formatDate(DateUtil.current()));
			responseContent.setHead(responseHead);
			return JSONObject.toJSONString(responseContent);
		}

		return JSONObject.toJSONString(responseContent);

	}
	
	
	
	@ResponseBody
	@RequestMapping ("editGood.htm")
	public String editGood (HttpServletRequest request , HttpServletResponse response)
	{


		ResponseContent responseContent = new ResponseContent();
		ResponseHead responseHead = new ResponseHead();
		RequestContent requestContent = RequestHandler.execute(request);
		Map m  = requestContent.getBody() ;





		try {

			Map goodInfo  = JSONObject.parseObject((String) m.get("goodInfo"));
			JSONArray  specList = JSONArray.parseArray((String) m.get("specList"));
			JSONArray  imgList = JSONArray.parseArray((String) m.get("imgList"));
			JSONObject goodSet  = JSONObject.parseObject((String) m.get("goodSet"));

			if ( null != goodInfo  )
			{
				Dgoods dgoods;
				List goodList;




				List l = specList.subList(0,specList.size());
				try {
					dgoods = JSON.parseObject(JsonUtil.map2json(goodInfo), Dgoods.class);

					Dgoods origoods = dgoodsService.queryById(Long.parseLong(String.valueOf(dgoods.getGoodsId())));
					
					goodList = convertToListOfOriGood(origoods, dgoods, l);



				}
				catch (Exception parseEx)
				{
					throw new ApiException("500" , "更新产品失败：参数转换错误!" );
				}
				long count = dgoodsService.updateGood(goodList);
				if(count > 0){
					Dgoods good = (Dgoods) goodList.get(0);
					
					DgoodsSet dgoodset = JSON.parseObject(JsonUtil.map2json(goodSet), DgoodsSet.class);
					if(dgoodset.getSetId() != null && !"".equals(dgoodset.getSetId())){
						dgoodset.setGoodsId(good.getGoodsId());
						dgoodset.setState(good.getGoodsState());
						dgoodsSetService.update(dgoodset);
					}
					
					dgoodsService.deleteImgByGoodId(good.getGoodsId());
					for(int j = 0 ; j < imgList.size();j++) {
	                	if(j % 3 == 0){
	                		String name = String.valueOf(imgList.get(j)) + String.valueOf(imgList.get(j+1)) + "." + String.valueOf(imgList.get(j+2));
	                		name = name.split("=")[1];
	                		String img = name.replaceAll(",", ".");
	                		
	                		GoodImg goodImg = new GoodImg();
	                		goodImg.setCreateDate(new Date().toString());
	                		goodImg.setImg(img);
	                		goodImg.setIsMain(YN.Y);
	                        goodImg.setGoodId(dgoods.getGoodsId());
	                        dgoodsService.addImg(goodImg);
	                	}else{
	                		continue;
	                	}
	                }
				}
				responseHead.setResultCode("200");
				responseHead.setDescription("更新产品成功");
				responseHead.setResponseTime(DateUtil.formatDate(DateUtil.current()));
				responseContent.setHead(responseHead);


			}
			else
				throw new ApiException("500" , "更新产品失败：参数为空!" );
		}
		catch(ApiException  ex)
		{
			loger.info("更新产品失败" + ex.getMessage());
			responseHead.setResultCode(ex.getCode());
			responseHead.setDescription("更新产品失败:" + ex.getMessage());
			responseHead.setResponseTime(DateUtil.formatDate(DateUtil.current()));
			responseContent.setHead(responseHead);
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
			loger.info("更新产品失败" + e.getMessage());
			responseHead.setResultCode("500");
			responseHead.setDescription("更新产品失败:" + e.getMessage());
			responseHead.setResponseTime(DateUtil.formatDate(DateUtil.current()));
			responseContent.setHead(responseHead);
			return JSONObject.toJSONString(responseContent);
		}

		return JSONObject.toJSONString(responseContent);

	}


	private List convertToListOfOriGood(Dgoods origoods, Dgoods dgoods, List<String> specList) {
		List result  =  new ArrayList();
		if( null != dgoods )
		{

			if( null != specList && specList.size() > 0) {

				for (String s : specList)
				{
					 String [] arr = s.split("\\|");
					 
					 if(dgoods.getGoodsName() != null && !"".equals(dgoods.getGoodsName())){
						 origoods.setGoodsName(dgoods.getGoodsName());
					 }
					 if(dgoods.getGoodsIntroduce() != null && !"".equals(dgoods.getGoodsIntroduce())){
						 origoods.setGoodsIntroduce(dgoods.getGoodsIntroduce());
					 }
					 if(dgoods.getMemberInterest() != null && !"".equals(dgoods.getMemberInterest())){
						 origoods.setMemberInterest(dgoods.getMemberInterest());
					 }
					 if(dgoods.getBuyKnow() != null && !"".equals(dgoods.getBuyKnow())){
						 origoods.setBuyKnow(dgoods.getBuyKnow());
					 }
					 if(dgoods.getContentIntroduce() != null && !"".equals(dgoods.getContentIntroduce())){
						 origoods.setContentIntroduce(dgoods.getContentIntroduce());
					 }
					 if(dgoods.getGcId1() != null && !"".equals(dgoods.getGcId1())){
						 origoods.setGcId1(dgoods.getGcId1());
					 }
					 if(dgoods.getGcId2() != null && !"".equals(dgoods.getGcId2())){
						 origoods.setGcId2(dgoods.getGcId2());
					 }
					 if(dgoods.getStoreId() != null && !"".equals(dgoods.getStoreId())){
						 origoods.setStoreId(dgoods.getStoreId());
					 }
					 if(dgoods.getStoreName() != null && !"".equals(dgoods.getStoreName())){
						 origoods.setStoreName(dgoods.getStoreName());
					 }
					 if(dgoods.getAreaid1() != null && !"".equals(dgoods.getAreaid1())){
						 origoods.setAreaid1(dgoods.getAreaid1());
					 }
					 if(dgoods.getAreaid2() != null && !"".equals(dgoods.getAreaid2())){
						 origoods.setAreaid2(dgoods.getAreaid2());
					 }
					 if(dgoods.getGoodsImage() != null && !"".equals(dgoods.getGoodsImage())){
						 origoods.setGoodsImage(dgoods.getGoodsImage());
					 }
					 if(dgoods.getShowPriority() != null && !"".equals(dgoods.getShowPriority())){
						 origoods.setShowPriority(dgoods.getShowPriority());
					 }
					 if(dgoods.getIsPtRed() != null && !"".equals(dgoods.getIsPtRed())){
						 origoods.setIsPtRed(dgoods.getIsPtRed());
					 }
					 if(dgoods.getGoodsState() != null && !"".equals(dgoods.getGoodsState())){
						 origoods.setGoodsState(dgoods.getGoodsState());
					 }
					 origoods.setProductCode(arr[0]);
					 origoods.setStandard(arr[1]);
					 origoods.setGoodsPrice(Long.valueOf(arr[2]));
					 origoods.setGoodsVip0Price(Long.valueOf(arr[3]));
					 origoods.setGoodsVip1Price(Long.valueOf(arr[4]));
					 origoods.setGoodsVip2Price(Long.valueOf(arr[5]));
					 origoods.setGoodsVip3Price(Long.valueOf(arr[6]));
					 origoods.setGoodsVip4Price(Long.valueOf(arr[7]));
					 origoods.setBookDownPayment(Long.valueOf(arr[8]));
					 origoods.setUnit(arr[9]);
					 origoods.setGoodsStorage(Integer.valueOf(arr[10]));
					 origoods.setGoodsVerify(1);
					
					 result.add(origoods);

				}
			}
		}
		return result;
	}

	private List convertToListOfGood(Dgoods dgoods ,List<String> specList)
	{

		List result  =  new ArrayList();
		if( null != dgoods )
		{

			if( null != specList && specList.size() > 0) {


				for (String s : specList)
				{

					 String [] arr = s.split("\\|");
					 Dgoods cloneGood =  new Dgoods();

					 cloneGood.setGoodsName(dgoods.getGoodsName());
					 cloneGood.setGoodsIntroduce(dgoods.getGoodsIntroduce());
					 cloneGood.setMemberInterest(dgoods.getMemberInterest());
					 cloneGood.setBuyKnow(dgoods.getBuyKnow());
					 cloneGood.setContentIntroduce(dgoods.getContentIntroduce());
					 cloneGood.setGcId1(dgoods.getGcId1());
					 cloneGood.setGcId2(dgoods.getGcId2());
					 cloneGood.setStoreId(dgoods.getStoreId());
					 cloneGood.setStoreName(dgoods.getStoreName());
					 cloneGood.setAreaid1(dgoods.getAreaid1());
					 cloneGood.setAreaid2(dgoods.getAreaid2());
					cloneGood.setGoodsImage(dgoods.getGoodsImage());
					 cloneGood.setProductCode(arr[0]);
					 cloneGood.setStandard(arr[1]);
					cloneGood.setGoodsPrice(Long.valueOf(arr[2]));
					cloneGood.setGoodsVip0Price(Long.valueOf(arr[3]));
					cloneGood.setGoodsVip1Price(Long.valueOf(arr[4]));
					cloneGood.setGoodsVip2Price(Long.valueOf(arr[5]));
					cloneGood.setGoodsVip3Price(Long.valueOf(arr[6]));
					cloneGood.setGoodsVip4Price(Long.valueOf(arr[7]));
					cloneGood.setBookDownPayment(Long.valueOf(arr[8]));
					 cloneGood.setUnit(arr[9]);
					 cloneGood.setGoodsVerify(1);

					 cloneGood.setGoodsAddtime(DateUtil.current());
					cloneGood.setServiceRatio(dgoods.getServiceRatio());
					 cloneGood.setGoodsStorage(Integer.valueOf(arr[10]));
					cloneGood.setShowPriority(dgoods.getShowPriority());
					 result.add(cloneGood);





				}


			}



		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping ("/getGoodsDetail.htm")
	public String getGoodsDetail( HttpServletRequest request , HttpServletResponse response){

		List proviceList = null;
		List cityList = null;
		List areaList = null;

		List classOneList = null;
		List classTwoList = null;

		List storeList = null;
		
		List dgoodImgs = null;

		DgoodsSet dgoodsSet = null;
		List techie = null;
		Dgoods dgood = null;

		Map returnMap   =  new HashMap();

		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		Map m  = requestContent.getBody() ;
		try {

			 proviceList  = dareaService.queryByDeep(1);
			 cityList  = dareaService.queryByDeep(2);
			 areaList  = dareaService.queryByDeep(3);
			 dgoodsSet = dgoodsSetService.queryByGoodId(Long.parseLong((String) m.get("id")));
			 techie = techieService.queryAll();

			classOneList = dgroupbuyClassService.queryGoodClassOne();
			classTwoList = dgroupbuyClassService.queryGoodClassTwo();
			dgood = dgoodsService.queryById(Long.parseLong((String) m.get("id")));
			
			dgoodImgs = dgoodsService.getImgsById(Long.parseLong((String) m.get("id")));

			storeList =  dstoreService.queryAll();

			returnMap.put("proviceList", proviceList);
			returnMap.put("cityList",cityList);
			returnMap.put("areaList",areaList);
			returnMap.put("classOneList",classOneList);
			returnMap.put("classTwoList",classTwoList);
			returnMap.put("storeList",storeList);
			returnMap.put("goods",dgood);
			returnMap.put("goodsImgs",dgoodImgs);
			returnMap.put("goodsSet",dgoodsSet);
			returnMap.put("techie",techie);

			
			responseContent = ResponseHandler.makeResponse(returnMap,true);

		} catch (Exception e) {
			loger.info("ajax请求活动列表失败", e);
		}

		return JSONObject.toJSONString(responseContent);

	}


}
