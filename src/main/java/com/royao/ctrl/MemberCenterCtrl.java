package com.royao.ctrl;

import cc.yiwang.commons.logger.SysLogger;
import cc.yiwang.commons.utils.Validate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.commons.enums.YN;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.*;
import com.royao.model.base.PageObject;
import com.royao.services.inface.*;
import com.royao.util.DateUtil;
import com.royao.util.JsonUtil;
import com.royao.util.MoneyUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by libia on 2016/1/5.
 */
@Controller
@RequestMapping(value ="/member")
public class MemberCenterCtrl {

	@Autowired
	private DmemberService dmemberService;
	@Autowired
	private DorderService dorderService;
	@Autowired
	private DconsumptionService dconsumptionService;
	@Autowired
	private DredpacketsDistributeService dredpacketsDistributeService;
	@Autowired
	private DcollectService dcollectService;
	@Autowired
	private DtopmanService dtopmanService;
	@Autowired
	private DbalanceLogsService dbalancelogsService;
    @Autowired
    private DvipService dvipService ;
    
    @Autowired
    private DmemberExtendService memberExtendService;
    
    @Autowired
    private DareaService areaService;

    @SysLogger
    Logger logger = Logger.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/ucCenter.htm")
    public String memberCenter(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();


        String wxCode  = "";
        if( null != params.get("wxCode"))
        wxCode = (String) params.get("wxCode");



        Map result = null;
        if( wxCode != null && !"".equals(wxCode) ) {
            try {


                Dmember dmember = dmemberService.queryByWxCode(wxCode);

                if (dmember != null) {
                    result = new HashMap();

                    Dvip  nextVip  =null;
                    Map differentTypeCountMap = dorderService.queryDifferentStatusOrderCountByUserId(dmember.getMemberId()); //用户不同状态订单数
                    Map collectCount = dcollectService.queryCountByUserId(dmember.getMemberId());
                    Integer consumptionCount = dconsumptionService.queryCountByUserId(dmember.getMemberId());
                    Integer redpackCount = dredpacketsDistributeService.queryCountByUserId(dmember.getMemberId());


                    result.put("memberInfo", dmember);
                    int gread = 0;
                    if( null != dmember.getDvip() ) {
                        gread = dmember.getDvip().getGreade();
                        gread ++;
                    }
                        else
                        gread = 1;

                    nextVip = dvipService.queryByGreade(gread);


                    result.put("differentTypeCountMap", differentTypeCountMap);
                    result.put("consumptionCount", consumptionCount);
                    result.put("redpackCount", redpackCount);
                    result.put("collectCount", collectCount);
                    result.put("nextVip", nextVip);
                }
                responseContent = ResponseHandler.makeResponse(result, true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return JSONObject.toJSONString(responseContent);

    }


    /**
     * 设置支付密码
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMyInfo.htm")
    public String myInfo(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        String wxCode = "owTHvt2FaEbAzjkBX-0k";
       if(null != params.get("wxCode")){
    	   wxCode = params.get("wxCode").toString();
       }
        try {
            // 根据微信id查询会员信息
            Dmember dmember = dmemberService.queryByWxCode(wxCode);
            responseContent = ResponseHandler.makeResponse(dmember, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(responseContent);

    }


    /**
     * 设置支付密码
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePayment.ajax")
    public String updatePayment(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
       // Integer pageNo = (Integer) params.get("pageNo");

        String wxCode = (String) params.get("wxCode");

        String  value = (String) params.get("memberPaypwd");
        String  memberPaysecret = (String) params.get("memberPaysecret");

        try {
            //根据微信id查询会员信息
            Dmember dmember = dmemberService.queryByWxCode(wxCode);
            //修改会员信息
            dmember.setMemberPaypwd(value);
            dmember.setMemberPaysecret(memberPaysecret);
            dmemberService.update(dmember);
            Map m = new HashMap();
            m.put("falg", "修改成功");
            responseContent = ResponseHandler.makeResponse(m, true);
//        String status = "";
//        PageObject pageObject = new PageObject();
//        pageObject.setPageNo(1);
//        if (null != params)
//            status = (String) params.get("status");
//
//        try {
//            Dmember dmember = dmemberService.queryByWxCode(wxCode);
//            Dorder dorder = new Dorder();
//            dorder.setOrderState(Integer.valueOf(status));
//            dorder.setPageInfo(pageObject);
//            List orderList = dorderService.queryByUser(dorder); // 用户订单列表
//            responseContent = ResponseHandler.makeResponse(orderList, true);
//
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(responseContent);

    }
 
    @ResponseBody
    @RequestMapping(value = "/orderlist.htm" )
    public String memberOrderList(HttpServletRequest request) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        Integer pageNo = 1;
        Long memberId = 0l;


        String status = "";

        if( null != params ) {
            status = (String) params.get("status");
            pageNo = Integer.valueOf(""+params.get("pageNo"));
            memberId = Long.valueOf(""+params.get("memberId"));
        }
        PageObject pageObject = new PageObject();
        pageObject.setPageNo(pageNo);

        try {
            Dorder  dorder =  new Dorder();
            dorder.setOrderState(Integer.valueOf(status));
            dorder.setPageInfo(pageObject);
            dorder.setMemberId(memberId);



            List orderList  = dorderService.queryByUser(dorder); //用户订单列表
            if(  null != status && status.equals("4") ) //  用户待评价的两种状态
            {
                dorder.setOrderState(3);
                orderList.addAll(dorderService.queryByUser(dorder));
            }


            responseContent = ResponseHandler.makeResponse(orderList, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);
    }



    @ResponseBody
    @RequestMapping(value = "/collectlist.htm" )
    public String memberCollectList(HttpServletRequest request) {


        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        String pageNo = (String) params.get("pageNo");
        String  wxCode = (String) params.get("wxCode");
        String  type = (String) params.get("type");

        PageObject pageObject = new PageObject();
        pageObject.setPageNo(Integer.valueOf(pageNo));


        try {
            Dmember dmember = dmemberService.queryByWxCode(wxCode);
            Dcollect dcollect = new Dcollect();




            dcollect.setMemberId(dmember.getMemberId());
            dcollect.setType(type);
            dcollect.setPageInfo(pageObject);

            Map result = new HashMap();
            dcollect.setPageInfo(pageObject);
            List collectList =  null;
            Map countMap = dcollectService.queryCountByUserId(dmember.getMemberId());
                if( null != type && type.equals("1") )
                collectList  = dcollectService.queryGoodCollByUserAndType(dcollect); //用户收藏
                else
                collectList  = dcollectService.queryStoreCollByUserAndType(dcollect); //用户收藏



            result.put("collectList", collectList);
            result.put("countMap", countMap);

            responseContent = ResponseHandler.makeResponse(result, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);
    }


    @ResponseBody
    @RequestMapping(value = "/consumptionlist.htm" )
    public String memberConsumptionList(HttpServletRequest request) {


        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        Integer pageNo = (Integer) params.get("pageNo");
        String wxCode = (String) params.get("wxCode");

        PageObject pageObject = new PageObject();
        pageObject.setPageNo(1);


        try {
            Dmember dmember = dmemberService.queryByWxCode(wxCode);

            Dconsumption dconsumption = new Dconsumption();
            dconsumption.setMemberId(dmember.getMemberId());
            dconsumption.setPageInfo(pageObject);
            List consumptionList  = dconsumptionService.listWithPage(dconsumption); //用户消费卷
            responseContent = ResponseHandler.makeResponse(consumptionList, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);
    }


    @ResponseBody
    @RequestMapping(value = "/redpacklist.htm" )
    public String memberRedPackList(HttpServletRequest request) {


        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        String pageNo = (String) params.get("pageNo");
        String wxCode = (String) params.get("wxCode");

        PageObject pageObject = new PageObject();
        pageObject.setPageNo(1);


        try {
            Dmember dmember = dmemberService.queryByWxCode(wxCode);
            dmember.setPageInfo(pageObject);
            List redpackList  = dredpacketsDistributeService.queryByUser(dmember); //用户红包
            responseContent = ResponseHandler.makeResponse(redpackList, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);
    }

    @ResponseBody
    @RequestMapping ( value = "register.htm")
    public String register( HttpServletRequest request ) throws Exception
    {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();

        Dmember dmember = JSONObject.parseObject(JsonUtil.map2json (params), Dmember.class);

        //区
        if(StringUtils.isNotBlank(params.get("areaName")+"")){
        	List<Integer> areaId = this.areaService.getByName(params.get("areaName").toString());
        	if(areaId != null && areaId.size() > 0){
        		dmember.setMemberAreaid(areaId.get(0));
        	}
        }
        //市
        if(StringUtils.isNotBlank(params.get("cityName")+"")){
        	List<Integer> cityId = this.areaService.getByName(params.get("cityName").toString());
        	if(cityId != null && cityId.size() > 0){
        		dmember.setMemberCityid(cityId.get(0));
        	}
        }
        //省
        if(StringUtils.isNotBlank(params.get("provinceName")+"")){
        	List<Integer> provinceId = this.areaService.getByName(params.get("provinceName").toString());
        	if(provinceId != null && provinceId.size() > 0){
        		dmember.setMemberProvinceid(provinceId.get(0));
        	}
        }
        //详细地址
        if(StringUtils.isNotBlank(params.get("areaInfo")+"")){
        	dmember.setMemberAreainfo(params.get("areaInfo").toString());
        }
        //        String wxCode = (String) params.get("wxCode");

        try {
            dmember.setMemberTime(DateUtil.formatDate(DateUtil.current()));
            boolean flag  = dmemberService.register(dmember);
            if( flag )
                responseContent = ResponseHandler.makeResponse(dmember, true);
            else
                responseContent = ResponseHandler.makeResponse(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);

    }

    @ResponseBody
    @RequestMapping(value = "/userInfo")
    public String userInfo ( HttpServletRequest request )
    {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        Map result = new HashMap();
        String wxCode = (String) params.get("wxCode");
        try {

            List    vipList   =  dvipService.queryAll();
            Dmember  dmember  = dmemberService.queryByWxCode(wxCode);
            result.put("vipList",vipList);
            result.put("memberInfo",dmember);
            responseContent = ResponseHandler.makeResponse(result, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);
    }

    @ResponseBody
    @RequestMapping(value = "/applyRoYao")
    public String applyRoYaoMan(HttpServletRequest request)
    {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        String wxCode = (String) params.get("wxCode");

        Dtopman  topMan = JSON.parseObject(JsonUtil.map2json(params), Dtopman.class);

        try {

            Dmember dmember = dmemberService.queryByWxCode(wxCode);
            topMan.setMemberId(Long.valueOf(dmember.getMemberId()));

            int result = dtopmanService.save(topMan);

            responseContent = ResponseHandler.makeResponse(topMan, true);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(responseContent);
    }

    // 余额明细查询
    @ResponseBody
    @RequestMapping(value = "/lanceList.htm")
    public String queryUserbalanceList(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map<?, ?> params = requestContent.getBody();
        Integer pageNo = (Integer) params.get("pageNo");

        PageObject pageObject = new PageObject();
        pageObject.setPageNo(1);
        try {
            DbalanceLogs logs = JSON.parseObject(JsonUtil.map2json(params), DbalanceLogs.class);
            pageObject.setPageSize(10);
            logs.setPageInfo(pageObject);
            List balanceList = dbalancelogsService.queryUserBalancelogs(logs);
            responseContent = ResponseHandler.makeResponse(balanceList, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(responseContent);
    }

    /**
     * 
     * @Description: 根据用户ID查询用户信息
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月12日
     */
    @ResponseBody
    @RequestMapping("/getById.htm")
    public String getById(HttpServletRequest request){
    	
    	ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);
        
        try{
        	if(null != requestContent.getBody()){
        		if(null != requestContent.getBody().get("memberId")){
        			Dmember member = this.dmemberService.queryById(Long.parseLong(requestContent.getBody().get("memberId")));
        			if(null != member){
        				responseContent = ResponseHandler.makeResponse(member, true);
        			}
        		}
        	}
        }catch(Exception e){
        	logger.info("获取用户信息出错", e);
        }
        
        return JSONObject.toJSONString(responseContent);
    }

    /**
     *
     * @Description: 根据用户Wxode查询用户信息
     * @param @param request
     * @param @return
     * @return String
     * @throws
     * @author liBiao
     * @date 2016年1月12日
     */
    @ResponseBody
    @RequestMapping("/getByWxCode.htm")
    public String getByWxCode(HttpServletRequest request){

        ResponseContent responseContent = new ResponseContent();
        RequestContent  requestContent  = RequestHandler.execute(request);

        try{
            if(null != requestContent.getBody()){
                if(null != requestContent.getBody().get("wxCode")){
                    Dmember member = this.dmemberService.queryByWxCode(requestContent.getBody().get("wxCode"));


//                    logger.info("============================================");
//                    logger.info("API GET MEMBER ID >>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getMemberId());
//                    logger.info("============================================");


                    if(null != member){

                        responseContent = ResponseHandler.makeResponse(member, true);
                    }
                    else
                    {
                        logger.info("============================================");
                        logger.info("API GETMEMBERBYWX IS >>>>>>>>>>>>>>>>>>>>>>>>>>> NULL" );
                        logger.info("============================================");
                    }
                }
                else
                {


                    logger.info("============================================");
                    logger.info("API GETMEMBERBYWX IS >>>>>>>>>>>>>>>>>>>>>>>>>>> NULL" );
                    logger.info("============================================");
                }
            }
        }catch(Exception e){
            logger.info("获取用户信息出错", e);
        }

        return JSONObject.toJSONString(responseContent);
    }

    /**
     * 
     * @Description: 活动详情分享有礼，是否'我知道了'
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月25日
     */
    @ResponseBody
    @RequestMapping("/eventIsKnow.htm")
    public String eventIsKnow(HttpServletRequest request){
    	
    	 ResponseContent responseContent = new ResponseContent();
         RequestContent  requestContent  = RequestHandler.execute(request);

         try{
             if(null != requestContent.getBody()){
            	 if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
            		 DmemberExtend extend = this.memberExtendService.queryById(Long.parseLong(requestContent.getBody().get("memberId")));
            		 if(extend != null){
            			 responseContent = ResponseHandler.makeResponse(extend, true);
            		 }
            	 }
             }
         }catch(Exception e){
             logger.info("获取用户信息出错", e);
         }
    	return JSONObject.toJSONString(responseContent);
    }
    /**
     * 
     * @Description: 活动详情分享有礼,我知道了'
     * @param @param request
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年1月25日
     */
    @ResponseBody
    @RequestMapping("/eventIknow.htm")
    public String eventIknow(HttpServletRequest request){
    	
    	ResponseContent responseContent = new ResponseContent();
    	RequestContent  requestContent  = RequestHandler.execute(request);
    	
    	try{
    		if(null != requestContent.getBody()){
    			if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
    				DmemberExtend extend = this.memberExtendService.queryById(Long.parseLong(requestContent.getBody().get("memberId")));
    				Integer status = 0;
    				boolean flag = false;
    				if(extend == null){
    					extend = new DmemberExtend();
    					extend.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
    					extend.setEventIsKnow(YN.Y.toString());
    					status = this.memberExtendService.save(extend);
    				}else{
    					extend.setEventIsKnow(YN.Y.toString());
    					status = this.memberExtendService.update(extend);
    				}
    				
    				if(status == 1){
    					flag = true;
    				}
    				
    				responseContent = ResponseHandler.makeResponse(flag, true);
    			}
    		}
    	}catch(Exception e){
    		logger.info("获取用户信息出错", e);
    	}
    	return JSONObject.toJSONString(responseContent);
    }

    /**
     * 
     * @Description: 更新容联子帐号信息
     * @param @return   
     * @return String  
     * @throws
     * @author Liu Pinghui
     * @date 2016年2月3日
     */
    @ResponseBody
    @RequestMapping("/updateRlById.htm")
    public String updateRlById(HttpServletRequest request){
    	ResponseContent responseContent = new ResponseContent();
    	RequestContent  requestContent  = RequestHandler.execute(request);
    	
    	try{
    		if(null != requestContent.getBody()){
    			Dmember member = new Dmember();
    			if(StringUtils.isNotBlank(requestContent.getBody().get("memberId"))){
    				member.setMemberId(Long.parseLong(requestContent.getBody().get("memberId")));
    			}
    			
    			if(StringUtils.isNotBlank(requestContent.getBody().get("subAccountSid"))){
    				member.setRlAcc(requestContent.getBody().get("subAccountSid"));
    			}
    			
    			if(StringUtils.isNotBlank(requestContent.getBody().get("subToken"))){
    				member.setRlAccPasswd(requestContent.getBody().get("subToken"));
    			}
    			
    			if(StringUtils.isNotBlank(requestContent.getBody().get("voipAccount"))){
    				member.setRlVoip(requestContent.getBody().get("voipAccount"));
    			}
    			
    			if(StringUtils.isNotBlank(requestContent.getBody().get("voipPwd"))){
    				member.setRlVoipPasswd(requestContent.getBody().get("voipPwd"));
    			}
    			
    			boolean flag = false;
    			
    			Integer state = this.dmemberService.update(member);
    			if(state == 1){
    				flag = true;
    			}
    			
    			responseContent = ResponseHandler.makeResponse(flag, true);
    		}
    	}catch(Exception e){
    		logger.info("跟新更新容联子帐号信息失败", e);
    	}
    	
    	return JSONObject.toJSONString(responseContent);
    }
}
