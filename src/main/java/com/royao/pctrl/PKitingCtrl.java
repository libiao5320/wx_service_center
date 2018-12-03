package com.royao.pctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royao.model.DsystemSet;
import com.royao.services.inface.DsystemSetService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.royao.commons.enums.KitingStatus;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.DbalanceLogs;
import com.royao.model.Dkiting;
import com.royao.model.Dmember;
import com.royao.model.base.PageObject;
import com.royao.services.inface.DbalanceLogsService;
import com.royao.services.inface.DkitingService;
import com.royao.services.inface.DmemberService;

/**
 * 
 * ClassName: PKitingCtrl 
 * @Description: 提现管理
 * @author Liu Pinghui
 * @date 2016年1月23日
 */
@Controller
@RequestMapping("/pkiting")
public class PKitingCtrl {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DkitingService kitingService;
	
	@Autowired
	private DmemberService memberService; 
	
	@Autowired
	private DbalanceLogsService balanceLogsService;

	@Autowired
	private DsystemSetService dsystemSetService;
	/**
	 * 
	 * @Description: 提现列表
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月23日
	 */
	@ResponseBody
	@RequestMapping("/list.htm")
	public String list(HttpServletRequest request){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
        	Dkiting kiting = new Dkiting();
            if (null != requestContent.getBody()) {
            	
            	//顾客姓名
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberName"))){
            		kiting.setName(requestContent.getBody().get("memberName"));
            	}
            	//顾客ID
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
            		kiting.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
            	}
            	//顾客电话
            	if(StringUtils.isNotBlank(requestContent.getBody().get("memberMobile"))){
            		kiting.setPhone(requestContent.getBody().get("memberMobile"));
            	}
            	//审核状态
            	if(StringUtils.isNotBlank(requestContent.getBody().get("status"))){
            		if(requestContent.getBody().get("status").equals("HANDLE_OK")){
            			kiting.setStatus(KitingStatus.HANDLE_OK);
            		}else{
            			kiting.setStatus(KitingStatus.AUDIT);
            		}
            	}
            	
            	PageObject page = new PageObject();
            	//分页
            	if(StringUtils.isNotBlank(requestContent.getBody().get("pageNo"))){
            		page.setPageNo(Integer.parseInt(requestContent.getBody().get("pageNo")));
            	}else{
            		page.setPageNo(1);
            	}
            	
            	kiting.setPageInfo(page);
            }
        
        	List<Dkiting> list = this.kitingService.plistWithPage(kiting);
        	
        	Integer total = this.kitingService.plistWithPageCount(kiting);
        	
            Map<String,Object> returnMap = new HashMap<String, Object>();
            returnMap.put("rows", list);
            returnMap.put("total", total);
        	
        	if (list != null && list.size() > 0) {
                responseContent = ResponseHandler.makeResponse(returnMap, true);
            } 
            
        } catch (Exception e) {
        	logger.info("获取备注列表错误", e);
        }
        
        return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 获取提现详情
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月23日
	 */
	@ResponseBody
	@RequestMapping("/detail.htm")
	public String detail(HttpServletRequest request){
		
		ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        try {
        	
            if (null != requestContent.getBody()) {
            	
            	if(StringUtils.isNotBlank(requestContent.getBody().get("id"))){
            		Dkiting kiting = this.kitingService.queryById(Long.parseLong(requestContent.getBody().get("id")));
            		
            		if(kiting != null){
            			responseContent = ResponseHandler.makeResponse(kiting, true);
            		}
            	}
            }
        } catch (Exception e) {
        	logger.info("获取提现详细信息错误", e);
        }
        
        return JSONObject.toJSONString(responseContent);
	}
	
	/**
	 * 
	 * @Description: 处理提现申请
	 * @param @param request
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年1月23日
	 */
	@ResponseBody
	@RequestMapping("/dispose.htm")
	public String dispose(HttpServletRequest request){
		
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		try {
			
			if (null != requestContent.getBody()) {
				
				if(StringUtils.isNotBlank(requestContent.getBody().get("id"))){
					Dkiting kiting = this.kitingService.queryById(Long.parseLong(requestContent.getBody().get("id")));
					//判断是否存在该提现订单
					if(kiting != null){
						if(StringUtils.isNotBlank(requestContent.getBody().get("status"))){
							//提现成功，线下转账给顾客，先上更改状态
							if(requestContent.getBody().get("status").equals("HANDLE_OK")){
								//只有当状态是[未处理]和[提现失败]时才能操作
								if(KitingStatus.AUDIT.equals(kiting.getStatus()) || KitingStatus.FAIL.equals(kiting.getStatus())){
									DbalanceLogs logs = this.balanceLogsService.querySn(kiting.getId().toString());
									if(logs != null){
										logs.setState(2);
										this.balanceLogsService.update(logs);
									}
									
									kiting.setStatus(KitingStatus.HANDLE_OK);//提现成功
								}
							}else
							//提现拒绝，将用户申请的提现金额返还到用户账户中，更改提现状态
							if(requestContent.getBody().get("status").equals("REJECT")){
								//只有订单状态为[未处理]或[提现失败]时才能拒绝
								if(KitingStatus.AUDIT.equals(kiting.getStatus()) || KitingStatus.FAIL.equals(kiting.getStatus())){
									Dmember member = this.memberService.queryById(kiting.getMemberId());//查出用户信息
									
									if(member != null ){
										member.setAvailablePredeposit(member.getAvailablePredeposit()+kiting.getMoney());//将提现的钱还给顾客
										this.memberService.update(member);
									}
									
									kiting.setStatus(KitingStatus.REJECT);
								}
							}else
							//提现失败，用户余额不动，只更改提现状态
							if(requestContent.getBody().get("status").equals("FAIL")){
								//只有订单状态为[未处理]时才能拒绝
								if(KitingStatus.AUDIT.equals(kiting.getStatus())){
									kiting.setStatus(KitingStatus.FAIL);
								}
							}else
							//提现中-未了防止误操作，只写入实际提款金额、不进行状态更改，业务流程依然可以继续
							if(requestContent.getBody().get("status").equals("AUDIT")){
								//只有订单状态为[失败]时才能未处理
								if(KitingStatus.FAIL.equals(kiting.getStatus())){
									kiting.setStatus(KitingStatus.AUDIT);
								}
							}else{
								//都不满足，说明管理员在逗你玩，不理他
								return JSONObject.toJSONString(responseContent);
							}
							
							kiting.setActualMoneyDollar(requestContent.getBody().get("actualMoneyDollar"));//实际提现金额
							kiting.setUpdateTime(new Date());//提现成功实践
							kiting.setUpdateBy(requestContent.getBody().get("managerName"));
							
							Integer state = 0;
							state = this.kitingService.update(kiting);
							
							if(state == 1){
								responseContent = ResponseHandler.makeResponse(kiting, true);
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("获取提现详细信息错误", e);
		}
		
		return JSONObject.toJSONString(responseContent);
	}


	@ResponseBody
	@RequestMapping("/storeClearList.htm")
	public String storeClearList (HttpServletRequest request,HttpServletResponse response){


		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		Map params = requestContent.getBody();

		JSONObject  result = new JSONObject();

		Integer page = null ==  params.get("pageNo") ? 0 : Integer.valueOf(""+params.get("pageNo"));
		Integer pageSize = null ==  params.get("pageSize") ? 0 : Integer.valueOf(""+params.get("pageSize"));


		params.put("pageNo" , page );
		params.put("pageSize" , pageSize );


		if ( null != params.get("cycletime") && !"".equals(params.get("cycletime"))) {
			DsystemSet dsystemSet = dsystemSetService.queryByKey("billDay");


			try {
				Date  end  = new SimpleDateFormat("yyyy-MM-dd").parse((String) params.get("cycletime")+"-"+dsystemSet.getSvalue());

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(end);

				calendar.add(Calendar.MONTH,-1);//日期加3个月
				Date begin=calendar.getTime();


				String endStr =   new SimpleDateFormat("yyyy-MM-dd").format(end);
				String beginStr =new SimpleDateFormat("yyyy-MM-dd").format(begin);

				params.remove("cycletime");
				params.put("begin", beginStr);
				params.put("end", endStr);
//                Date  end  = new SimpleDateFormat("yyyy-MM-dd").parse((String) params.get("cycletime") + "-" + dsystemSet.getSvalue());




			} catch (ParseException e) {
				e.printStackTrace();
			}


		}
		try {

			List l = kitingService.queryClear( params );
			Integer count  = kitingService.queryClearCount(params);

			result.put("rows", l);
			result.put("total", count);
			responseContent = ResponseHandler.makeResponse(result, true);

		} catch (Exception e) {
			e.printStackTrace();
		}


		return JSONObject.toJSONString(responseContent);

	}


	@ResponseBody
	@RequestMapping("/storeClearDetail.htm")
	public String storeClearDetail (HttpServletRequest request,HttpServletResponse response){


		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		Map params = requestContent.getBody();

		JSONObject result = new JSONObject();




		Integer page = null ==  params.get("pageNo") ? 0 : Integer.valueOf(""+params.get("pageNo"));
		Integer pageSize = null ==  params.get("pageSize") ? 0 : Integer.valueOf(""+params.get("pageSize"));


		params.put("pageNo" , page );
		params.put("pageSize" , pageSize );
		try {

			List l = kitingService.queryClearDetailByStoreId(params);
			Long count = kitingService.queryClearDetailCountByStoreId(params);

			result.put("rows", l);
			result.put("total", count);

			responseContent = ResponseHandler.makeResponse(result, true);

		} catch (Exception e) {
			e.printStackTrace();
		}


		return JSONObject.toJSONString(responseContent);

	}







}
