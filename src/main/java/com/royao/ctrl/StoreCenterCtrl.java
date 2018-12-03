package com.royao.ctrl;

import java.util.Date;
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
import com.alibaba.fastjson.JSONObject;
import com.royao.commons.enums.RedpacketsStatus;
import com.royao.commons.enums.StoreStatus;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dclear;
import com.royao.model.Dcomplain;
import com.royao.model.Dgoods;
import com.royao.model.Dorder;
import com.royao.model.Dredpackets;
import com.royao.model.DredpacketsDistribute;
import com.royao.model.Dstore;
import com.royao.model.DstoreExtend;
import com.royao.model.DstoreManager;
import com.royao.model.DstoreText;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DclearService;
import com.royao.services.inface.DcomplainService;
import com.royao.services.inface.DgoodsService;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DredpacketsDistributeService;
import com.royao.services.inface.DredpacketsService;
import com.royao.services.inface.DstoreExtendService;
import com.royao.services.inface.DstoreManagerService;
import com.royao.services.inface.DstoreService;
import com.royao.services.inface.DstoreTextService;
import com.royao.util.JsonUtil;

/**
 * 
 * ClassName: StoreCenterCtrl 
 * @Description: 商家管理
 * @author Liu Pinghui
 * @date 2016年1月5日
 */
@Controller
@RequestMapping("/store")
public class StoreCenterCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DstoreService storeService;
	
	@Autowired
	private DgoodsService goodsService;
	
	@Autowired
	private DstoreTextService storeTextService;
	
	@Autowired
	private DredpacketsService redpacketsService;
	
	@Autowired
	private DredpacketsDistributeService redpacketsDistributeService;

	@Autowired
	private DstoreManagerService storeManagerService;
	
	@Autowired
	private DstoreExtendService storeExtendService;
	
	@Autowired
	private DorderService orderService;
	
	@Autowired
	private DcomplainService complainService;
	
	@Autowired
	private DclearService clearService;
	
	/**
	 * 
	 * @Description: 商家列表
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月5日
	 */
	@ResponseBody
	@RequestMapping("/list.htm")
	public String rank(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
		try {
			List<Dstore> list = null;
			Dstore store = new Dstore();
			PageObject pageInfo = new PageObject();
			if(null != requestContent.getBody()){
				//带条件查询
				/*******如果还有其他条件，可以在此处添加*******/
				if(null != requestContent.getBody().get("scId")){
					//商家分类
					store.setScId(Long.parseLong(requestContent.getBody().get("scId")));
				}
				if(null != requestContent.getBody().get("status")){
					//状态
					if(requestContent.getBody().get("status").equals(StoreStatus.normal.toString()))
						store.setStatus(StoreStatus.normal);
					
					if(requestContent.getBody().get("status").equals(StoreStatus.delete.toString()))
						store.setStatus(StoreStatus.delete);
				}
				
				if(null != requestContent.getBody().get("storeState")){
					store.setStoreState(Integer.parseInt(requestContent.getBody().get("storeState")));
				}
				
				if(StringUtils.isNotEmpty(requestContent.getBody().get("search"))){
					store.setSearch(requestContent.getBody().get("search"));
				}
				
				if(StringUtils.isNotEmpty(requestContent.getBody().get("pageNo"))){
					
		            pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
		            
				}else{//如果用户带参数，则默认显示第一页
					pageInfo.setPageNo(1);
				}
				
				store.setPageInfo(pageInfo);
				
			}
			
			list = this.storeService.listWithPage(store);
			
			if(list != null && list.size() > 0){
				responseContent = ResponseHandler.makeResponse(list,true);
            }
			return JSONObject.toJSONString(responseContent);
		} catch (Exception e) {
			logger.info("商家列表获取错误", e);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @Description: 商家详情
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月6日
	 */
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
		try {
			Dstore store = null;
			
			if(null != requestContent.getBody()){
				store = this.storeService.queryDetailById(Long.parseLong(requestContent.getBody().get("id")));
				if(store != null){
					responseContent = ResponseHandler.makeResponse(store,true);
				}
			}
		}catch(Exception e){
			logger.info("请求商家详情数据错误！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 商家下面的所有商品列表
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月7日
	 */
	@ResponseBody
	@RequestMapping("/goodslist.htm")
	public String goodslist(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
        
        Map<?, ?> params = requestContent.getBody();
        response.setCharacterEncoding("utf-8");

        Dgoods param = JSON.parseObject(JsonUtil.map2json(params), Dgoods.class);
        PageObject pageInfo = new PageObject();
        
		try {
			
			if(null != requestContent.getBody()){
				if(null != requestContent.getBody().get("pageNo")){
					//是否存在分页信息
					pageInfo.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
					param.setPageInfo(pageInfo);
				}
				
				if(null != requestContent.getBody().get("id")){
					param.setStoreId(Long.parseLong(requestContent.getBody().get("id")));
				}
				if(null != requestContent.getBody().get("goodsState")){
					param.setGoodsState(Integer.parseInt(requestContent.getBody().get("goodsState")));
				}
				
				List<Dgoods> goodList= this.goodsService.listWithPage(param);
				if(goodList != null){
					responseContent = ResponseHandler.makeResponse(goodList,true);
				}
			}
			
		}catch(Exception e){
			logger.info("商家下面的所有商品列表！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 组合条件查询
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月23日
	 */
	@ResponseBody
    @RequestMapping (value = "/nearby.htm")
    public String nearby( HttpServletRequest request , HttpServletResponse response)
    {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);


        Map<?, ?> params = requestContent.getBody();

        String x = (String) params.get("x");
        String y = (String) params.get("y");

        Integer pageNo = 1;
        if(params.get("pageNo") != null){
        	pageNo = Integer.parseInt(params.get("pageNo").toString());
        }
        
        if (null != params) {
            List<Dstore> list = null;
            try {
                list = this.storeService.getNearbyStore(Double.valueOf(x),Double.valueOf(y),params);
                response.setCharacterEncoding("utf-8");
                if (null != list)
                    responseContent = ResponseHandler.makeResponse(list, true);
                else
                    return null;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            return null;

        return JSONObject.toJSONString(responseContent);
    }
	
	/**
	 * 
	 * @Description: 商家图文详情
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月18日
	 */
	@ResponseBody
	@RequestMapping("/text.htm")
	public String text(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        
        try {
			DstoreText text = null;
			
			if(null != requestContent.getBody()){
				text = this.storeTextService.queryById(Long.parseLong(requestContent.getBody().get("id")));
				if(text != null){
					responseContent = ResponseHandler.makeResponse(text,true);
				}
			}
		}catch(Exception e){
			logger.info("请求商家详情数据错误！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 分享商家
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
					//dred.setType("quota");
					dred.setValidityTime(new Date());
					dred.setStatus("on");
					List<Dredpackets> dredList = this.redpacketsService.queryAvailable(dred);//查找可用红包
					
					if(dredList != null && dredList.size() > 0){
						
						dred = dredList.get(0);
						red = new DredpacketsDistribute();
						red.setRedpacketsId(dred.getId());//大红包ID
						if(dred.getType().equals("quota"))
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
						logger.info("得到一个分享红包ID"+dred.getId());
						responseContent = ResponseHandler.makeResponse(red,true);
					}
				}else{
					System.out.println("已经有一个分享红包了");
				}
			}
		}catch(Exception e){
			logger.info("请求商家详情数据错误！", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 商家登录
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月20日
	 */
	@ResponseBody
	@RequestMapping("/queryByLoginPhone.htm")
	public String login(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				if(StringUtils.isNotBlank(requestContent.getBody().get("phone"))){
					Dstore store = this.storeService.queryByLoginPhone(requestContent.getBody().get("phone"));
					
					if(null != store){
						responseContent = ResponseHandler.makeResponse(store,true);
					}
				}
			}
		} catch (Exception e) {
			logger.info("商家登录获取信息异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 商家注册
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月22日
	 */
	@ResponseBody
	@RequestMapping("/register.htm")
	public String register(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				Dstore store = new Dstore();
				if(StringUtils.isNotBlank(requestContent.getBody().get("phone"))){
					store.setStoreLoginPhone(requestContent.getBody().get("phone"));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("pwd"))){
					store.setStorePasswd(requestContent.getBody().get("pwd"));
				}
				if(StringUtils.isNotBlank(requestContent.getBody().get("secret"))){
					store.setStoreSecret(requestContent.getBody().get("secret"));
				}
				
				store.setStoreTime(new Date());
				store.setStoreState(3);//未初始化
				
				Long id = this.storeService.insert(store);
				
				if(null != store){
					responseContent = ResponseHandler.makeResponse(id,true);
				}
			}
		} catch (Exception e) {
			logger.info("商家注册异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 校验手机号是否已经注册
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月22日
	 */
	@ResponseBody
	@RequestMapping("/verify.htm")
	public String verify(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				boolean flag = false;
				if(StringUtils.isNotBlank(requestContent.getBody().get("phone"))){
					Dstore store = this.storeService.queryByLoginPhone(requestContent.getBody().get("phone"));
					
					if(null != store){
						flag = true;
					}
					
				}
				responseContent = ResponseHandler.makeResponse(flag,true);
			}
		} catch (Exception e) {
			logger.info("商家注册异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 保存商家信息
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月22日
	 */
	@ResponseBody
	@RequestMapping("/save.htm")
	public String save(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				boolean flag = false;
				
				if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
					//第一步保存商家信息
					this.storeService.updateByMap(requestContent.getBody());
					
					//第二部保存客户经理信息
					DstoreManager manager = new DstoreManager();
					if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
						manager.setSmStoreId(Integer.parseInt(requestContent.getBody().get("storeId")));
					}
					if(StringUtils.isNotBlank(requestContent.getBody().get("storeName"))){
						manager.setSmStoreName(requestContent.getBody().get("storeName"));
					}
					if(StringUtils.isNotBlank(requestContent.getBody().get("smName"))){
						manager.setSmName(requestContent.getBody().get("smName"));
					}
					if(StringUtils.isNotBlank(requestContent.getBody().get("smPhone"))){
						manager.setSmPhone(requestContent.getBody().get("smPhone"));
					}
					
					DstoreManager dm = this.storeManagerService.queryByStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
					
					if(dm == null){
						this.storeManagerService.save(manager);
					}else{
						manager.setSmId(dm.getSmId());
						this.storeManagerService.update(manager);
					}
					
					//第三步，保存银行账户信息
					DstoreExtend extend = new DstoreExtend();
					if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
						extend.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
					}
					if(StringUtils.isNotBlank(requestContent.getBody().get("accounts"))){
						extend.setAccounts(requestContent.getBody().get("accounts"));
					}
					if(StringUtils.isNotBlank(requestContent.getBody().get("accountsNo"))){
						extend.setAccountsNo(requestContent.getBody().get("accountsNo"));
					}
					if(StringUtils.isNotBlank(requestContent.getBody().get("accountHolder"))){
						extend.setAccountHolder(requestContent.getBody().get("accountHolder"));
					}
					
					DstoreExtend de = this.storeExtendService.queryByStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
					
					if(de == null){
						this.storeExtendService.save(extend);
					}else{
						extend.setId(de.getId());
						this.storeExtendService.update(extend);
					}
					
					flag = true;
				}
				
				responseContent = ResponseHandler.makeResponse(flag,true);
			}
		} catch (Exception e) {
			logger.info("商家注册异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 修改商家密码
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月23日
	 */
	@ResponseBody
	@RequestMapping("/updatepwd.htm")
	public String updatepwd(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				boolean flag = false;
				if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
					
					this.storeService.updateByMap(requestContent.getBody());
					flag = true;
				}
				responseContent = ResponseHandler.makeResponse(flag,true);
			}
		} catch (Exception e) {
			logger.info("修改密码异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: B端主页信息
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月25日
	 */
	@ResponseBody
	@RequestMapping("/b_index.htm")
	public String b_index(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				HashMap<String, Object> hmap = null;
				if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
					hmap = new HashMap<String, Object>();
					//统计新订单
					Dorder order = new Dorder();
					order.setStoreId(Integer.parseInt(requestContent.getBody().get("storeId")));
					order.setOrderState(1);//未消费的均为新订单
					
					Integer newConsume = this.orderService.countUnconsumeOrder(order);
					hmap.put("newConsume", newConsume);
					
					//统计新投诉
					Dcomplain complain = new Dcomplain();
					complain.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
					complain.setStatus("handling");
					
					Integer newComplain = this.complainService.countUnhandleComplain(complain);
					hmap.put("newComplain", newComplain);
					
					//统计新对账
					Dclear clear = new Dclear();
					clear.setStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
					clear.setClearState(-1);//商家未对账
					
					Integer newClear = this.clearService.countUnClear(clear);
					hmap.put("newClear", newClear);
					
				}
				responseContent = ResponseHandler.makeResponse(hmap,true);
			}
		} catch (Exception e) {
			logger.info("修改密码异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 获取商家的扩展信息
	 * @param @param request
	 * @param @param response
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月25日
	 */
	@ResponseBody
	@RequestMapping("/extendByStoreId.htm")
	public String extendByStoreId(HttpServletRequest request , HttpServletResponse response){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		try {
			if(null != requestContent.getBody()){
				
				if(StringUtils.isNotBlank(requestContent.getBody().get("storeId"))){
					
					DstoreExtend storeExtend = this.storeExtendService.queryByStoreId(Long.parseLong(requestContent.getBody().get("storeId")));
				
					responseContent = ResponseHandler.makeResponse(storeExtend,true);
				}
				
			}
		} catch (Exception e) {
			logger.info("修改密码异常", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}
}
