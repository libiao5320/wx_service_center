package com.royao.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.http.RequestContent;
import com.royao.http.RequestHandler;
import com.royao.http.ResponseContent;
import com.royao.http.ResponseHandler;
import com.royao.model.Dorder;
import com.royao.model.Drefund;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DrefundService;
import com.royao.util.JsonUtil;

/**
 * 
 * @author yangx
 * @className  退款订单
 * @date 2016年1月27日下午3:58:31
 */
@Controller
@RequestMapping("/refund")
public class RefundOrderCenterCtrl {
	
	@Autowired
	private DorderService dorderService;
	
	@Autowired
	private
	DrefundService drefundService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 数据接口
	 * @Title: getOrderNum 
	 * @Description: TODO(支付订单)
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */

	@ResponseBody
	@RequestMapping("/submit.htm")
	public String pay(HttpServletRequest request, HttpServletResponse response) {
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		 Map<?, ?> params = requestContent.getBody();
		 Map<String, Object> m = new HashMap<String, Object>();
	    response.setCharacterEncoding("utf-8");
	    //将json字符串 转换成 java bean
	    Drefund dre= JSON.parseObject(JsonUtil.map2json(params), Drefund.class);

		/**进行修改订单状态操作**/
		try {
			Dorder order=dorderService.queryById(dre.getOrderId());
			if(order!=null && order.getOrderState()==2){
				order.setOrderState(7);//退款中状态
				dorderService.update(order);
			}else{
				logger.info("订单："+order.getOrderId()+" 状态不等于2 不能进行退款操作");
				m.put("status", "false");
				m.put("message", "状态不等于2 不能进行退款操作");
				responseContent = ResponseHandler.makeResponse(m,false);
				return JSONObject.toJSONString(responseContent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("修改订单状态成功");
	    dre.setId(null);
	    dre.setStatus("handling");//退款中状态
	    dre.setCreateTime(new Date());
		try {
			logger.info("完成支付的数据方法[] start");
			drefundService.save(dre);
			m.put("status", "true");
			m.put("message", "SUCCESS");
			responseContent = ResponseHandler.makeResponse(m, true);
			
		} catch (Exception e) {
			logger.info("保存退款信息："+e.getMessage());
			e.printStackTrace();
		}
		
		return JSONObject.toJSONString(responseContent);
	}

	/**
	 * 取消退款 数据接口
	 * @Title: getOrderNum 
	 * @Description: TODO(支付订单)
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */

	@ResponseBody
	@RequestMapping("/cancelRefund.htm")
	public String cancelRefund(HttpServletRequest request, HttpServletResponse response) {
		logger.info("取消退款数据端操作");
		ResponseContent responseContent = new ResponseContent();
		RequestContent requestContent = RequestHandler.execute(request);
		
		 Map<?, ?> params = requestContent.getBody();
		 Map<String, Object> m = new HashMap<String, Object>();
	    response.setCharacterEncoding("utf-8");
	    //将json字符串 转换成 java bean
	    Drefund dre= JSON.parseObject(JsonUtil.map2json(params), Drefund.class);
		logger.info("取消退款数据端操作[]订单号："+dre.getOrderId());
		
		/**进行修改订单状态操作**/
		try {
			Dorder order=dorderService.queryById(dre.getOrderId());
			if(order!=null && order.getOrderState()==7){
				order.setOrderState(2);//退款已取消
				dorderService.update(order);
				
				logger.info("订单："+order.getOrderId()+"修改订单状态成功");
				m.put("status", "true");
				m.put("message", "成功");
				responseContent = ResponseHandler.makeResponse(m,true);
				return JSONObject.toJSONString(responseContent);
				
			}else{
				logger.info("订单："+order.getOrderId()+" 状态不等于7 不能进行取消退款操作");
				m.put("status", "false");
				m.put("message", "状态不等于7 不能进行取消退款操作");
				responseContent = ResponseHandler.makeResponse(m,false);
				
				return JSONObject.toJSONString(responseContent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("修改订单状态成功");
		
		return JSONObject.toJSONString(responseContent);
	}
	

}
