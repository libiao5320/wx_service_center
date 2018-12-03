package com.royao.ctrl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.royao.model.DredpacketsDistribute;
import com.royao.services.inface.DeventService;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DredpacketsDistributeService;

/**
 * 
 * ClassName: BatchCtrl 
 * @Description: 批处理控制类
 * @author Liu Pinghui
 * @date 2016年2月19日
 */

public class BatchCtrl {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DorderService orderService;
	
	@Autowired
	private DredpacketsDistributeService redpacketsDistributeService;
	
	@Autowired
	private DeventService eventService;
	/**
	 * 
	 * @Description: 订单过期
	 * @param    
	 * @return void  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月19日
	 */
	public void orderOverdue(){
		
		Integer overdueTime = 24;//过期时间
		
		try {
			this.orderService.orderOverdue(overdueTime);
		} catch (Exception e) {
			logger.info("订单过期跑批失败",e);
		}
	}
	
	/**
	 * 
	 * @Description: 红包过期
	 * @param    
	 * @return void  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月19日
	 */
	public void redPacketsOverdue(){
		
		try {
			this.redpacketsDistributeService.redPacketsOverdue();
		} catch (Exception e) {
			logger.info("红包过期跑批错误",e);
		}
	}
	
	/**
	 * 
	 * @Description: 活动过期
	 * @param    
	 * @return void  
	 * @throws
	 * @author Liu Pinghui
	 * @date 2016年2月19日
	 */
	public void eventOverdue(){
		
		try {
			this.eventService.eventOverdue();
		} catch (Exception e) {
			logger.info("活动过期跑批错误",e);
		}
	}
}
